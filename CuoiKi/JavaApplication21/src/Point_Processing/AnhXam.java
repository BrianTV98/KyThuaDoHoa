/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Point_Processing;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Dell 5420
 */
public class AnhXam {
    public static BufferedImage AnhXam(BufferedImage image2) {
        BufferedImage anhxam = new BufferedImage(image2.getWidth(),image2.getHeight(),image2.getType());
        for (int i = 0; i < anhxam.getWidth(); i++) {
            for (int j = 0; j < anhxam.getHeight(); j++) {
                anhxam.setRGB(i, j, image2.getRGB(i,j));
            }
        }
        
        Vector<ValueRGB> xam = GetPixel.imagePixel(anhxam);
        Vector<Color> igray = new Vector();
        for (ValueRGB xam1 : xam) {
            int iRed = xam1.getIred();
            int iGreen = xam1.getIgreen();
            int iBlue = xam1.getIblue();
            float d = (float) (iRed * 0.3 + iGreen * 0.59 + iBlue * 0.11);
            Integer tam = Math.round(d);
            Color color = new Color(tam, tam, tam);
            igray.add(color);
        }
        int dem = 0;
        for (int i = 0; i < anhxam.getWidth(); i++) {
            for (int j = 0; j < anhxam.getHeight(); j++) {
                anhxam.setRGB(i, j, igray.get(dem).getRGB());
                dem++;
            }
        }
        /*try {
            File f = new File("./src/xla/xam.png");
            ImageIO.write(anhxam, "png", f);
        } catch (IOException ex) {
            Logger.getLogger(AnhXam.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return anhxam;        
    }
}
