package cn.xqrcloud.tank;

import java.awt.*;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-16 22:37
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class Tank {
    private TankFrame tankFrame;//所在Frame
    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean living=true;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private static final int SPEED = 10;
    public static  int WIDTH=ResourceMgr.tankD.getWidth(),HEIGHT=ResourceMgr.tankD.getHeight();

    private boolean moving = false;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
    }

    public void paint(Graphics graphics) {

        if(!living) {
            tankFrame.tanks.remove(this);
        };

        switch (dir) {
            case LEFT:graphics.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:graphics.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:graphics.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:graphics.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        //是否是移动状态
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public void fire() {
        int bX=x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        tankFrame.bullets.add(new Bullet(bX, bY, this.dir,this.tankFrame));
    }

    public void die() {

        this.living = false;
    }
}
