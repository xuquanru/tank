package cn.xqrcloud.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-15 23:39
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class TankFrame extends Frame {
    public static final int GAME_WIDTH=800;
    public static final int GAME_HEIGHT=800;

    List<Bullet> bullets= new ArrayList<>();
    List<Tank> tanks= new ArrayList<>();


    Tank mytank = new Tank(200, 400, Dir.DOWN,this);

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);//不可改变窗口的大小
        setTitle("tank war");//显示标题在窗口上
        setVisible(true);
        //监听窗口是否点击，点击的话就关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MykeyListener());
    }

    //*|--------现在内存一层定义一张图片
    //*|--------再把这张图片一次性的刷新到内存二层

    Image offScreanImage=null;

    @Override
    public void update(Graphics g) {
        if (offScreanImage==null) {
            offScreanImage= createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphicsScreen = offScreanImage.getGraphics();
        Color color = graphicsScreen.getColor();
        graphicsScreen.setColor(Color.black);
        graphicsScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        graphicsScreen.setColor(color);
        paint(graphicsScreen);
        g.drawImage(offScreanImage, 0, 0, null);//g是原生画笔
    }

    @Override
    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.white);
        graphics.drawString("子弹的数量"+bullets.size(), 10, 60);
        graphics.drawString("敌人的数量"+tanks.size(), 10, 80);
        graphics.setColor(color);
        mytank.paint(graphics);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(graphics);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(graphics);
        }

        //判断坦克是否碰撞

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

    }

    class MykeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    mytank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }
        private void setMainTankDir() {
            //|----四个按键都没按下
            if(!bL&&!bR&&!bU&&!bD){
                mytank.setMoving(false);
            }else {
                mytank.setMoving(true);
                if (bL) mytank.setDir(Dir.LEFT);
                if (bR) mytank.setDir(Dir.RIGHT);
                if (bU) mytank.setDir(Dir.UP);
                if (bD) mytank.setDir(Dir.DOWN);
            }


        }
    }

}
