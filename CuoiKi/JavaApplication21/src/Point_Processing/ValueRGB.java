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
public class ValueRGB {

    private int ired;
    private int igreen;
    private int iblue;

    public ValueRGB(int ired, int igreen, int iblue) {
        this.ired = ired;
        this.igreen = igreen;
        this.iblue = iblue;
    }

    public int getIred() {
        return ired;
    }

    public int getIgreen() {
        return igreen;
    }

    public int getIblue() {
        return iblue;
    }

    public void setIred(int ired) {
        this.ired = ired;
    }

    public void setIgreen(int igreen) {
        this.igreen = igreen;
    }

    public void setIblue(int iblue) {
        this.iblue = iblue;
    }
}
