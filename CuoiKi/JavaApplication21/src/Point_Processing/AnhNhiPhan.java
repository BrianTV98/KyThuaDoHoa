/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Point_Processing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 *
 * @author Dell 5420
 */
public class AnhNhiPhan {

    public static BufferedImage AnhNhiPhan(BufferedImage AnhXam) {

     BufferedImage anhnhiphan = new BufferedImage(AnhXam.getWidth(),AnhXam.getHeight(),AnhXam.getType());
        for (int i = 0; i < anhnhiphan.getWidth(); i++) {
            for (int j = 0; j < anhnhiphan.getHeight(); j++) {
                anhnhiphan.setRGB(i, j, AnhXam.getRGB(i,j));
            }
        }
        Vector<ValueRGB> nhiphan = GetPixel.imagePixel(AnhXam);
        Vector<Color> iBinary = new Vector();
        for (ValueRGB nhiphan1 : nhiphan) {
            int iRed = nhiphan1.getIred();
            int iGreen = nhiphan1.getIgreen();
            int iBlue = nhiphan1.getIblue();
            int inp;
            if (Integer.parseInt(PointProcessing.jTextField1.getText()) < nhiphan1.getIred()) {
                inp = 255;
            } else {
                inp = 0;
            }
            Color color = new Color(inp, inp, inp);
            iBinary.add(color);
        }
        int dem = 0;
        for (int i = 0; i < anhnhiphan.getWidth(); i++) {
            for (int j = 0; j < anhnhiphan.getHeight(); j++) {
                anhnhiphan.setRGB(i, j, iBinary.get(dem).getRGB());
                dem++;
            }
        }
        return anhnhiphan;
    }
}
