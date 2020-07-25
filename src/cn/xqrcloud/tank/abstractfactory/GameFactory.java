package cn.xqrcloud.tank.abstractfactory;

import cn.xqrcloud.tank.Dir;
import cn.xqrcloud.tank.Gamemodel;
import cn.xqrcloud.tank.Group;
import cn.xqrcloud.tank.TankFrame;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-23 23:24
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public abstract class GameFactory {
    public abstract  BaseTank createTank(int x, int y, Dir dir, Group group, Gamemodel gamemodel);
    public abstract BaseExplode createExplode(int x, int y, Gamemodel gamemodel);
    public abstract  BaseBullet createBullet(int x, int y, Gamemodel gamemodel);
}
