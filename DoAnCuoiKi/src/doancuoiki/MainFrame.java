/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mylov
 */
public class MainFrame {
    JFrame jFrame;
    LuoiToaDo luoi;
    static JLabel lbToaDoMT;
    static JLabel lbToaDoLuoi;
    static JLabel lbToaDoNgD;
    public MainFrame(){
        InitComponents();
    }

    private void InitComponents() {
        jFrame= new JFrame(); //To change body of generated methods, choose Tools | Templates.
        jFrame.setSize(1920, 1024);
        jFrame.setLayout(null);
        
        // tao khung toa do chinh
        luoi= new LuoiToaDo();
        luoi.setSize(1200, 800);
        luoi.setLocation(0, 0);
//        luoi.setBackground(Color.LIGHT_GRAY);
        
        jFrame.add(luoi);
        luoi.addMouseListener(new PixelListener(luoi));
        // tao khu vuc hien thi toa do May Tinh:
        
        lbToaDoMT= new JLabel();
        lbToaDoMT.setBackground(Color.BLUE);
        lbToaDoMT.setSize(300,30 );
        lbToaDoMT.setLocation(1300, 100);
        lbToaDoMT.setForeground(Color.red);
        lbToaDoMT.setText   ("Tọa độ MT   :  ");
        jFrame.add(lbToaDoMT);
        
        //ToaLuoi; 
        lbToaDoLuoi= new JLabel();
        lbToaDoLuoi.setText ("Tọa Độ Luoi :  ");
        lbToaDoLuoi.setSize(300, 30);
        lbToaDoLuoi.setLocation(1300, 130);
        lbToaDoLuoi.setForeground(Color.red);
        jFrame.add(lbToaDoLuoi);
        
        //ToaDoNguoiDung
        lbToaDoNgD= new JLabel();
        lbToaDoNgD.setText  ("Tọa Độ NgD :  ");
        lbToaDoNgD.setSize(300, 30);
        lbToaDoNgD.setLocation(1300, 160);
        lbToaDoNgD.setForeground(Color.red);
        jFrame.add(lbToaDoNgD);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }

    
}
