package cn.xqrcloud.tank;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-22 17:00
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bX=tank.getX()+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=tank.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for (Dir temp : dirs){
            new Bullet(bX, bY, temp,tank.gamemodel,tank.group);
        }

    }
}
