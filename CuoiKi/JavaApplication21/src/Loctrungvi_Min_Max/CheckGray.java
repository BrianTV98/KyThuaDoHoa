package Loctrungvi_Min_Max;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author VAIO
 */
public class CheckGray {
    public boolean checkImage(BufferedImage img){
        for(int y =0; y<img.getWidth(); y++){
            for(int x=0; x<img.getHeight(); x++){
                Color c = new Color(img.getRGB(y, x));
                    
                if(c.getRed() != c.getGreen() || c.getBlue()!= c.getRed())
                    return false;
            }
        }
        return true;
    }
}
