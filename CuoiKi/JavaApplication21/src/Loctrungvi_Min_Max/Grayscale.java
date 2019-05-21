package Loctrungvi_Min_Max;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author VAIO
 */
public class Grayscale {
    
    public BufferedImage GrayImage(BufferedImage img){
        
        BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.SCALE_DEFAULT);
        
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int x =0; x<width; x++){
            for(int y=0; y<height; y++){
                Color c = new Color(img.getRGB(x, y));
                
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();
                
                int avg = (r+g+b)/3;
                
                Color gc = new Color(avg, avg, avg,a);
                gray.setRGB(x, y, gc.getRGB());
            }
        }
        return gray;
    }
}
