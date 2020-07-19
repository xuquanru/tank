package cn.xqrcloud.tank;

import java.awt.*;
import java.util.Random;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-16 22:37
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class Tank {
    private static final int SPEED = 3;
    private TankFrame tankFrame;//所在Frame
    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean living=true;
    Random random=new Random();
    Rectangle rectangle=new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Group group=Group.BAD;

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


    public static  int WIDTH=ResourceMgr.goodTankU.getWidth(),HEIGHT=ResourceMgr.goodTankU.getHeight();

    private boolean moving = true;

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

    public Tank(int x, int y, Dir dir,TankFrame tankFrame,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
        this.group=group;
        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics graphics) {

        if(!living) {
            tankFrame.tanks.remove(this);
        };



        switch (dir) {
            case LEFT:graphics.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL, x, y, null);
                break;
            case UP:graphics.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:graphics.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:graphics.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
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



        if(this.group==Group.BAD&&random.nextInt(100)>90) this.fire();
        if(this.group==Group.BAD&&random.nextInt(100)>95)
        randomDir();
        boundesCheck();
        rectangle.x=this.x;
        rectangle.y=this.y;
    }

    private void boundesCheck() {
        if(this.x<0)x=0;
        else if(this.y<30) y = 30;
        else if(this.x>TankFrame.GAME_WIDTH-Tank.WIDTH) x = TankFrame.GAME_WIDTH-Tank.WIDTH;
        else if(this.y>TankFrame.GAME_HEIGHT-Tank.HEIGHT) y = TankFrame.GAME_HEIGHT-Tank.HEIGHT;

    }

    private void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX=x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        tankFrame.bullets.add(new Bullet(bX, bY, this.dir,this.tankFrame,this.group));
    }

    public void die() {

        this.living = false;
    }
}
