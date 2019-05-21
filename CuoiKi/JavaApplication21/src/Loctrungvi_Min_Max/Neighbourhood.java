package Loctrungvi_Min_Max;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author VAIO
 */
public class Neighbourhood {
    
    public BufferedImage CopyImage(BufferedImage img){
        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.SCALE_DEFAULT);
        
        for(int y =0; y<img.getWidth(); y++){
            for(int x=0; x<img.getHeight(); x++){
                Color c = new Color(img.getRGB(y, x));
                    
                image.setRGB(y, x, c.getRGB());
            }
        }
        
        return image;
    }
    
    public int[] FindValue(int x, int y, BufferedImage img){
        int[] value = new int[2];
        if(x<0){
            value[0] = 0;
        }
        if(x>img.getWidth()-1){
            value[0] = img.getWidth()-1;
        }
        if(x>0 && x<img.getWidth())
            value[0] = x;
        
        
        if(y<0){
            value[1] = 0;
        }
        if(y>img.getHeight()-1){
            value[1] = img.getHeight()-1;
        }
        if(y>0 && y<img.getHeight())
            value[1] = y;
        return value;
    }
    
    public BufferedImage MinFilter(BufferedImage img, int size){
        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.SCALE_DEFAULT);
        
        int s = size*size;
        int[] r = new int [s];
        int[] g = new int [s];
        int[] b = new int [s];
        
        int row = (size-1)/2;
        int col = (size-1)/2;
        int m, n;
        
        for(int x=0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int i=0;
                for(int fx =x-row; fx<x+row+1; fx++){
                    for(int fy=y-col; fy<y+col+1; fy++){
                        if(fx<0 || fy<0 || fx>=image.getWidth() || fy>=image.getHeight()){
                            int[] v = new int[2];
                            v = FindValue(fx, fy, img);
                            m = v[0];
                            n = v[1];
                        }else{
                            m = fx;
                            n = fy;
                        }
                        Color c = new Color(img.getRGB(m,n));
                        
                        r[i] = c.getRed();
                        g[i] = c.getGreen();
                        b[i] = c.getBlue();
                        
                        i++;
                        
                    }
                }
                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);
                
                Color ci = new Color(image.getRGB(x, y));
                
                Color cm = new Color(r[0], g[0], b[0], ci.getAlpha());
                image.setRGB(x, y, cm.getRGB());
            }
        }
        return image;
    }
    
    public BufferedImage MaxFilter(BufferedImage img, int size){
        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.SCALE_DEFAULT);
        
        int s = size*size;
        int[] r = new int [s];
        int[] g = new int [s];
        int[] b = new int [s];
        
        int row = (size-1)/2;
        int col = (size-1)/2;
        int m, n;
        
        for(int x=0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int i=0;
                for(int fx =x-row; fx<x+row+1; fx++){
                    for(int fy=y-col; fy<y+col+1; fy++){
                        if(fx<0 || fy<0 || fx>=img.getWidth() || fy>=img.getHeight()){
                            int[] v = new int[2];
                            v = FindValue(fx, fy, img);
                            m = v[0];
                            n = v[1];
                        }else{
                            m = fx;
                            n = fy;
                        }
                        Color c = new Color(img.getRGB(m,n));
                        
                        r[i] = c.getRed();
                        g[i] = c.getGreen();
                        b[i] = c.getBlue();
                        
                        i++;
                        
                    }
                }
                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);
                
                Color ci = new Color(image.getRGB(x, y));
                
                Color cm = new Color(r[s-1], g[s-1], b[s-1], ci.getAlpha());
                image.setRGB(x, y, cm.getRGB());
            }
        }
        return image;
    }
    
    public BufferedImage MedianFilter(BufferedImage img, int size){
        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.SCALE_DEFAULT);
        
        int s = size*size;
        int[] r = new int [s];
        int[] g = new int [s];
        int[] b = new int [s];
        
        int row = (size-1)/2;
        int col = (size-1)/2;
        int m, n;
        for(int x=0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int i=0;
                for(int fx =x-row; fx<x+row+1; fx++){
                    for(int fy=y-col; fy<y+col+1; fy++){
                        if(fx<0 || fy<0 || fx>=img.getWidth() || fy>=img.getHeight()){
                            int[] v = new int[2];
                            v = FindValue(fx, fy, img);
                            m = v[0];
                            n = v[1];
                        }else{
                            m = fx;
                            n = fy;
                        }
                        Color c = new Color(img.getRGB(m,n));
                        
                        r[i] = c.getRed();
                        g[i] = c.getGreen();
                        b[i] = c.getBlue();
                        
                        i++;
                    }
                }
                
                
                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);
                
                Color ci = new Color(image.getRGB(x, y));
                
                Color cm = new Color(r[s/2], g[s/2], b[s/2], ci.getAlpha());
                image.setRGB(x, y, cm.getRGB());
            }
        }
        return image;
    }
    
}
