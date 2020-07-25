package cn.xqrcloud.tank;

import cn.xqrcloud.tank.abstractfactory.BaseExplode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-25 16:45
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class Gamemodel {

    java.util.List<BaseExplode> explodes=new ArrayList<>();
    java.util.List<Bullet> bullets= new ArrayList<>();
    List<Tank> tanks= new ArrayList<>();
    Tank mytank = new Tank(200, 400, Dir.DOWN,this,Group.GOOD);

    public Gamemodel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50+i*80,200, Dir.DOWN,this,Group.BAD));
        }

    }

    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.white);
        graphics.drawString("子弹的数量"+bullets.size(), 10, 60);
        graphics.drawString("敌人的数量"+tanks.size(), 10, 80);
        graphics.drawString("爆炸的数量"+explodes.size(), 10, 100);
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

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(graphics);
        }


    }

    public Tank getMainTank() {
        return mytank;
    }
}
