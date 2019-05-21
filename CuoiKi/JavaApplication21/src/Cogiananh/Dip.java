/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template maske, choose Tools | Templates
 * and open the template in the editor.
 */
package Cogiananh;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Arrays;

/**
 *
 * @author Tran Ngoc Tam
 */
public class Dip {

    public static boolean isFit(int[][] source, int[][] mask, int type) {
        boolean flag = true;
        for (int i = 0; i < mask.length && flag; i++) {
            for (int j = 0; j < mask[0].length; j++) {
               // System.out.println(mask[i][j] + " : " + source[i][j]);
                if (mask[i][j] == 255 && source[i][j] != mask[i][j]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static boolean isHit(int[][] source, int[][] mask, int type) {

        for (int i = 0; i < mask.length; i++) {
            for (int j = 0; j < mask[0].length; j++) {
                //System.out.println(mask[i][j] + " : " + source[i][j]);
                if (mask[i][j] == 255 && source[i][j] == mask[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Color[][] getColorTable(BufferedImage bi) {
        Color[][] colors = new Color[bi.getWidth()][bi.getHeight()];
        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 0; j < bi.getWidth(); j++) {

                Color color = new Color(bi.getRGB(j, i));
                //System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());
                colors[j][i] = color;
            }
        }
        return colors;
    }

    public static BufferedImage convertToGrayImage(BufferedImage bi){
        BufferedImage cloneBi = cloneBufferedImage(bi);
        int width = cloneBi.getWidth();
        int height = cloneBi.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(bi.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                int total = red + green + blue;
                Color newColor = new Color(total, total, total);
                cloneBi.setRGB(j, i, newColor.getRGB());

            }
        }
        return cloneBi;
    }
    public static BufferedImage convertToBinaryImage(BufferedImage bi, int threshold) {
        BufferedImage cloneBi = cloneBufferedImage(bi);
        int width = cloneBi.getWidth();
        int height = cloneBi.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(bi.getRGB(j, i));
                int red = c.getRed();
                if (red < threshold) {
                    red = 0;
                } else {
                    red = 255;
                }
                Color newColor = new Color(red, red, red);
                cloneBi.setRGB(j, i, newColor.getRGB());

            }
        }
        return cloneBi;
    }

    public static BufferedImage cloneBufferedImage(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlpha = bi.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
        BufferedImage image = new BufferedImage(cm, raster, isAlpha, null);
        return image;
    }

    public static int[][] getMatrix(Color[][] colorTable, int x, int y) {
        int[][] temp = new int[3][3];

        temp[0][0] = colorTable[x - 1][y - 1].getRed();
        temp[0][1] = colorTable[x][y - 1].getRed();
        temp[0][2] = colorTable[x + 1][y - 1].getRed();

        temp[1][0] = colorTable[x - 1][y].getRed();
        temp[1][1] = colorTable[x][y].getRed();
        temp[1][2] = colorTable[x + 1][y].getRed();

        temp[2][0] = colorTable[x - 1][y + 1].getRed();
        temp[2][1] = colorTable[x][y + 1].getRed();
        temp[2][2] = colorTable[x + 1][y + 1].getRed();
        return temp;
    }
    
    public static BufferedImage convertBlackToWhite(BufferedImage bi){
        BufferedImage cloneBi = cloneBufferedImage(bi);
        int width = cloneBi.getWidth();
        int height = cloneBi.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(bi.getRGB(j, i));
                Color newColor;
                if(c.getRed()==255){
                    newColor = new Color(0,0,0);
                }else{
                    newColor = new Color(255,255,255);
                }
                cloneBi.setRGB(j, i, newColor.getRGB());

            }
        }
        return cloneBi;
    }
}
