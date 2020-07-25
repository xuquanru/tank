package cn.xqrcloud.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.FileHandler;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: tank
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-15 23:18
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();



        while (true) {
            try {
                Thread.sleep(50);
                tankFrame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
