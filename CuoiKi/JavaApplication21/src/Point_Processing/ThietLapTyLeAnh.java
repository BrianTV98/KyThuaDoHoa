/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Point_Processing;

/**
 *
 * @author Dell 5420
 */
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ThietLapTyLeAnh {

    public static void setTyLe(JLabel lbl, BufferedImage image) {
        Dimension lbl_size = lbl.getSize();
        int ix = image.getWidth();
        int iy = image.getHeight();
        int dx = 0, dy = 0;
        if (lbl_size.width / lbl_size.height > ix / iy) {
            dy = lbl_size.height;
            dx = dy * ix / iy;
        } else {
            dx = lbl_size.width;
            dy = dx * iy / ix;
        }
        ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
        lbl.setIcon(icon);
    }
}
