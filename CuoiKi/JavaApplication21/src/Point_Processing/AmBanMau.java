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
public class AmBanMau {

    public static BufferedImage AmBanMau(BufferedImage image) {

        BufferedImage ambanmau = new BufferedImage(image.getWidth(),image.getHeight(),image.getType() );
        for (int i = 0; i < ambanmau.getWidth(); i++) {
            for (int j = 0; j < ambanmau.getHeight(); j++) {
                ambanmau.setRGB(i, j, image.getRGB(i,j));
            }
        }
        Vector<ValueRGB> mau = GetPixel.imagePixel(ambanmau);
        Vector<Color> ammau = new Vector();
        for (ValueRGB mau1 : mau) {
            int iRed = 255 - mau1.getIred();
            int iGreen = 255 - mau1.getIgreen();
            int iBlue = 255 - mau1.getIblue();
            
            Color color = new Color(iRed, iGreen, iBlue);
            ammau.add(color);
        }
        int dem = 0;
        for (int i = 0; i < ambanmau.getWidth(); i++) {
            for (int j = 0; j < ambanmau.getHeight(); j++) {
                ambanmau.setRGB(i, j, ammau.get(dem).getRGB());
                dem++;
            }
        }
        return ambanmau;
    }
}
