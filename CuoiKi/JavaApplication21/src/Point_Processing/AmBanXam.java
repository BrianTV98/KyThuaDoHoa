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
public class AmBanXam {

    public static BufferedImage AmBanXam(BufferedImage AnhXam) {
       BufferedImage ambanxam = new BufferedImage(AnhXam.getWidth(),AnhXam.getHeight(),AnhXam.getType());
        for (int i = 0; i < ambanxam.getWidth(); i++) {
            for (int j = 0; j < ambanxam.getHeight(); j++) {
                ambanxam.setRGB(i, j, AnhXam.getRGB(i,j));
            }
        }
        Vector<ValueRGB> xam = GetPixel.imagePixel(ambanxam);
        Vector<Color> amxam = new Vector();
        for (ValueRGB xam1 : xam) {            
            int iRed = 255 - xam1.getIred();
            int iGreen = iRed;
            int iBlue = iRed;
            Color color = new Color(iRed, iGreen, iBlue);
            amxam.add(color);
        }
        int dem = 0;
        for (int i = 0; i < ambanxam.getWidth(); i++) {
            for (int j = 0; j < ambanxam.getHeight(); j++) {
                ambanxam.setRGB(i, j, amxam.get(dem).getRGB());
                dem++;
            }
        }
        return ambanxam;
    }
}
