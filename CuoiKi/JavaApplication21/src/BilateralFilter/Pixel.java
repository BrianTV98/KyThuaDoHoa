/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BilateralFilter;

/**
 *
 * @author VietHien
 */
public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int alpha;
    //cac phuong thuc khoi tao
    public Pixel(){
        red = 0;
        green = 0;
        blue = 0;
        alpha = 0;
    }
    public Pixel(int r, int g, int b){
        red = r;
        green = g;
        blue = b;
        alpha = 0;
    }
    public Pixel(int r, int g, int b, int a){
        red = r;
        green = g;
        blue = b;
        alpha = a;
    }
//set, get method
    /**
     * @return the red
     */
    public int getRed() {
        return red;
    }
    /**
     * @return the green
     */
    public int getGreen() {
        return green;
    }

    /**
     * @return the blue
     */
    public int getBlue() {
        return blue;
    }

    /**
     * @return the alpha
     */
    public int getAlpha() {
        return alpha;
    }

    /**
     * @param red the red to set
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * @param green the green to set
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * @param blue the blue to set
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     * @param alpha the alpha to set
     */
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }    
}
