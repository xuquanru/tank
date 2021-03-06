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
    Gamemodel gamemodel=null;
    private int x,y;
    private Dir dir;
    private Group group=Group.BAD;
    Rectangle rectangle=new Rectangle();

    public Bullet(int x, int y, Dir dir,Gamemodel gamemodel,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.gamemodel=gamemodel;
        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        gamemodel.bullets.add(this);
    }

    public void paint(Graphics graphics) {
        if(!living){
            gamemodel.bullets.remove(this);
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
        rectangle.x = this.x;
        rectangle.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup())return;


       if(this.rectangle.intersects(tank.rectangle)){
           tank.die();
           this.die();
           int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
           int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
           gamemodel.explodes.add(new Explode(eX,eY,gamemodel));
       }
    }

    private void die() {
        this.living=false;

    }
}
