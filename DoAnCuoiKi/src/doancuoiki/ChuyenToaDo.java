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

    public ChuyenToaDo(int x, int y) {
        super(x, y);
    }
    public  Pixel toToaDoLuoi(){
        return new Pixel((Math.round(super.getX()/5))*5, (Math.round(super.getY()/5))*5);
    }
    public Pixel toToaDoNguoiDung(){
        //xac dinh toa do x;
        Pixel p=new Pixel(0, 0);
        int tem1;
        if(this.getX()==600){
            p.setX(0);
        }
        else{
            if(this.getX()<600){
                tem1=Math.round(-(600-this.getX())/5);
                p.setX(tem1);
            }
            else {
                if(this.getX()>600){
                    tem1=Math.round((this.getX()-600)/5);
                    p.setX(tem1);
                }
            }
        }
        if(this.getY()==400){
            p.setY(0);
        }
        else{
            if(this.getY()>400){
                tem1=Math.round((400-this.getY())/5);
                p.setY(tem1);
            }
            else {
                if(this.getY()<400){
                    tem1=Math.round(-(this.getY()-400)/5);
                    p.setY(tem1);
                }
            }
        }
        return p;
    }
    public  Pixel NguoiDung_to_May(){
        return new Pixel(600+super.getX()*5, 400-5*super.getY());
    }
}
