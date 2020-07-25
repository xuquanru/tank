package cn.xqrcloud.tank.abstractfactory;

import cn.xqrcloud.tank.*;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-23 23:27
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, Gamemodel gamemodel ) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, Gamemodel gamemodel) {
        return new Explode(x, y, gamemodel);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Gamemodel gamemodel) {
        return null;
    }
}
