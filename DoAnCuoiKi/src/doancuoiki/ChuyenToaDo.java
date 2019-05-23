/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

/**
 *
 * @author Mylov
 */
public class ChuyenToaDo  extends Pixel{
//    int x;
//    int y;
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    public ChuyenToaDo(int x, int y) {
        super(x, y);
//        this.x = x;
//        this.y = y;
    }
    public  void ToaDoLuoi(){
        super.setX((Math.round(super.getX()/5))*5);
        super.setY((Math.round(super.getY()/5))*5);
    }
    public void ToaDoNguoiDung(){
        //xac dinh toa do x;
        int tem1;
        if(this.getX()==600){
            this.setX(0);
        }
        else{
            if(this.getX()<600){
                tem1=Math.round(-(600-this.getX())/5);
                this.setX(tem1);
            }
            else {
                if(this.getX()>600){
                    tem1=Math.round((this.getX()-600)/5);
                    this.setX(tem1);
                }
            }
        }
        if(this.getY()==400){
            this.setY(0);
        }
        else{
            if(this.getY()>400){
                tem1=Math.round((400-this.getY())/5);
                this.setY(tem1);
            }
            else {
                if(this.getY()<400){
                    tem1=Math.round(-(this.getY()-400)/5);
                    this.setY(tem1);
                }
            }
        }
        
    }
    public  Pixel NguoiDung_to_May(){
        super.setX(600+super.getX()*5);
        super.setY(400-5*super.getY());
        Pixel pixel = new Pixel(super.getX(),super.getY());
        return pixel;
    }
}
