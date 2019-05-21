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

   
    
    @Override
    public void mouseClicked(MouseEvent e) {
        ChuyenToaDo a= new ChuyenToaDo(e.getX(), e.getY());
        a.ToaDoLuoi();
        jpanel.addPixel(new Pixel(a.getX(), a.getY()));//To change body of generated methods, choose Tools | Templates.
        MainFrame.lbToaDoMT.setText  ("Tọa độ MT   :  "+ e.getX()+" : "+e.getY());
        a.ToaDoLuoi();
        MainFrame.lbToaDoLuoi.setText("Tọa độ lưới :  "+ a.getX()+ ":"+a.getY());
        a.ToaDoNguoiDung();
        MainFrame.lbToaDoNgD.setText ("Tọa độ NgD  :  "+ a.getX()+ ":"+a.getY());
    }
    
    
}
