package cn.xqrcloud.tank;

import java.awt.*;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-16 23:23
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class Bullet {
    public static final int SPEED=10;
    public static  int WIDTH=ResourceMgr.bulletD.getWidth(),HEIGHT=ResourceMgr.bulletD.getHeight();



    private boolean living = true;
    private TankFrame tankFrame=null;

    private int x,y;
    private Dir dir;

    public Bullet(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
    }

    public void paint(Graphics graphics) {
        if(!living){
            tankFrame.bullets.remove(this);
        }

        switch (dir) {
            case LEFT:graphics.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:graphics.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:graphics.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:graphics.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:x-=SPEED;break;
            case RIGHT:x+=SPEED;break;
            case UP:y-=SPEED;break;
            case DOWN:y+=SPEED;break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public void collideWith(Tank tank) {
        Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
       if(rectangle1.intersects(rectangle2)){
           tank.die();
           this.die();
       }
    }

    private void die() {
        this.living=false;

    }
}
