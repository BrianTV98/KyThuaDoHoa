/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Mylov
 */
public class PixelListener extends MouseAdapter{
    private LuoiToaDo jpanel; // goc la ABC

    public PixelListener(LuoiToaDo jpanel) { //goc la ABC
        super();
        this.jpanel = jpanel;
    }

    PixelListener(luoiToaDo3D luoi3d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    @Override
    public void mouseClicked(MouseEvent e) {
        ChuyenToaDo a= new ChuyenToaDo(e.getX(), e.getY());
//        System.out.println(a.getX()+" : "+a.getY());
        jpanel.addPixel(new Pixel(a.toToaDoNguoiDung().getX(), a.toToaDoNguoiDung().getY()));//To change body of generated methods, choose Tools | Templates.
       
    }
    
    
}
