package Loctrungvi_Min_Max;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author VAIO
 */
public class SetSizeImage {
    
    public Image setSizeImageIcon(ImageIcon imageIcon,int Width,int Heigth){
        Image img = imageIcon.getImage().getScaledInstance(Width, Heigth, Image.SCALE_SMOOTH);
        return img;
    }
}
