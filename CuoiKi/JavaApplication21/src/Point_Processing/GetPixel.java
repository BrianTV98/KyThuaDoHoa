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
public class GetPixel {

    public static Vector imagePixel(BufferedImage input) {
        Vector<ValueRGB> vector = new Vector<>();
        for (int i = 0; i < input.getWidth(); i++) {
            for (int j = 0; j < input.getHeight(); j++) {
                int red = new Color(input.getRGB(i, j)).getRed();
                int green = new Color(input.getRGB(i, j)).getGreen();
                int blue = new Color(input.getRGB(i, j)).getBlue();
                ValueRGB valuePix = new ValueRGB(red, green, blue);
                vector.add(valuePix);
            }
        }
        return vector;
    }
}
