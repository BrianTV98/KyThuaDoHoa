/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AddSaltPepper {
    public BufferedImage Add_saltpepper(BufferedImage img, float percent){
       BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.SCALE_DEFAULT);
       int width = img.getWidth();
       int height = img.getHeight();
       
       for(int y =0; y<width; y++){
                for(int x=0; x<height; x++){
                    Color c = new Color(img.getRGB(y, x));
                     
                    image.setRGB(y, x, c.getRGB());
                }
            }
       
       float amount = (width*height*percent)/1000;
       
       for(int i=0; i<amount; i++){
            int x = (int)(Math.random()*width);
            int y = (int)(Math.random()*height);
           
            Color c = new Color(image.getRGB(x, y));
            
            Color ca = new Color(0,0,0, c.getAlpha());
            image.setRGB(x, y, ca.getRGB());
       }
       
       for(int i=0; i<amount; i++){
            int x = (int)(Math.random()*width);
            int y = (int)(Math.random()*height);
           
            Color c = new Color(image.getRGB(x, y));
            
            Color ca = new Color(255,255,255, c.getAlpha());
            image.setRGB(x, y, ca.getRGB());
       }
       return image;
   }
}
