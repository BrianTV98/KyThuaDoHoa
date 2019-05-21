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
 * @author khoi
 */
public class SoMu {
    public static BufferedImage SoMu(BufferedImage image) {

        BufferedImage somu = new BufferedImage(image.getWidth(),image.getHeight(),image.getType() );
        for (int i = 0; i < somu.getWidth(); i++) {
            for (int j = 0; j < somu.getHeight(); j++) {
                somu.setRGB(i, j, image.getRGB(i,j));
            }
        }
        Vector<ValueRGB> anh = GetPixel.imagePixel(somu);
        Vector<Color> ammau = new Vector();
        for (ValueRGB anh1 : anh) {
            double iRed =anh1.getIred();
            double iGreen =anh1.getIgreen();
            double iBlue =anh1.getIblue();
            double mu=Float.valueOf(PointProcessing.jTextField5.getText());
            
            Double Red=(Math.pow((iRed/255),mu))*255;
            Double Green=(Math.pow((iGreen/255),mu))*255;
            Double Blue=(Math.pow((iBlue/255),mu))*255;
            int aRed=Red.intValue();            
            int aGreen=Green.intValue();            
            int aBlue=Blue.intValue();            
            Color color = new Color(aRed,aGreen,aBlue);
            ammau.add(color);
        }
        int dem = 0;
        for (int i = 0; i < somu.getWidth(); i++) {
            for (int j = 0; j < somu.getHeight(); j++) {
                somu.setRGB(i, j, ammau.get(dem).getRGB());
                dem++;
            }
        }
        return somu;
    }
}
