package cn.xqrcloud.tank;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-22 16:29
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class DefaultFireFStrategy implements  FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bX=tank.getX()+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=tank.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        new Bullet(bX, bY, tank.dir,tank.gamemodel,tank.group);
    }
}
