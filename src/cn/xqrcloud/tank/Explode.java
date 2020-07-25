package cn.xqrcloud.tank;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-17 23:07
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/

import cn.xqrcloud.tank.abstractfactory.BaseExplode;

import java.awt.*;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-16 23:23
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class Explode extends BaseExplode {
    public static int WIDTH=ResourceMgr.explods[0].getWidth();
    public static int HEIGHT=ResourceMgr.explods[0].getHeight();

    private boolean living = true;
    private Gamemodel gamemodel=null;
    private int x,y;
    private int step=0;



    public Explode(int x, int y, Gamemodel gamemodel) {
        this.x = x;
        this.y = y;
        this.gamemodel=gamemodel;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(ResourceMgr.explods[step++], x, y, null);
        if (step >= ResourceMgr.explods.length) {
            gamemodel.explodes.remove(this);
        }
    }

}

