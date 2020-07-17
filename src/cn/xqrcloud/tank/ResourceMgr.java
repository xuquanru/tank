package cn.xqrcloud.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-17 15:17
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class ResourceMgr {
    public static  BufferedImage tankL,tankR,tankU,tankD;
    public static  BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static  BufferedImage[] explods=new BufferedImage[16];
    static {

        try {

         tankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankL=ImageUtil.rotateImage(tankU, -90);
            tankR=ImageUtil.rotateImage(tankU, 90);
            tankD=ImageUtil.rotateImage(tankU, 180);



            bulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletL=ImageUtil.rotateImage(bulletU, -90);
            bulletR=ImageUtil.rotateImage(bulletU, 90);
            bulletD=ImageUtil.rotateImage(bulletU, 180);

            for (int i = 0; i < 16; i++) {

                explods[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
