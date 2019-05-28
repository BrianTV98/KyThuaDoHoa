/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import com.sun.prism.j2d.J2DPipeline;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mylov
 */
public class MainFrame {
    static JFrame jFrame;
    LuoiToaDo luoi;
    luoiToaDo3D luoi3d;
    static JLabel infor;
    static JLabel developer1;
    static JLabel developer2;
    static JLabel developer3 ;
    static Button btn2D= new Button("2D");
    static Button btn3D =new Button("3D");
    //may bay
    static JLabel lbname1,lbsung,lbdau,lbminh,lbcanhtren,lbCanhDuoi,lbBanhXe1,lbBanhXe2,
                    lua1, lua2, lua3, lua4,lua5,lua6;
    static JLabel lbname2,lbdauzom, lbmattrai,lbmatphai,lbminhzom,lbtaytrai,lbtayphai,lbchantrai,lbchanphai;
    public MainFrame(){
        InitComponents();
    }

    private void InitComponents() {
        jFrame= new JFrame("BÁO CÁO ĐỀ TÀI MÔN KỸ THUẬT ĐỒ HỌA"); //To change body of generated methods, choose Tools | Templates.
        jFrame.setSize(1920, 1024);
        jFrame.setLayout(null);
        //--- add thong tin Developer ---
        infor= new JLabel();
        infor.setSize(500,30);
        infor.setLocation(1680, 900);
        infor.setForeground(Color.MAGENTA);
        infor.setText("Develop by Group 3:" );
        jFrame.add(infor);
        
        developer1= new JLabel();
        developer1.setSize(500,30);
        developer1.setLocation(1700, 915);
        developer1.setForeground(Color.GREEN);
        developer1.setText("        Developer 1: Trần Văn Hiếu" );
        jFrame.add(developer1);
        
        developer2= new JLabel();
        developer2.setSize(500,30);
        developer2.setForeground(Color.GREEN);
        developer2.setLocation(1700, 930);
        developer2.setText("        Developer 2: Lê Tấn Đạt" );
        jFrame.add(developer2);
        
        developer3= new JLabel();
        developer3.setSize(500,30);
        developer3.setForeground(Color.GREEN);
        developer3.setLocation(1700, 945);
        developer3.setText("        Developer 3: Võ Tuấn An" );
        jFrame.add(developer3);
        // tao khung toa do chinh
        luoi= new LuoiToaDo();
        luoi.setSize(1200, 800);
        luoi.setLocation(0, 0);
//        jFrame.add(luoi);
        luoi.addMouseListener(new PixelListener(luoi));
        luoi.setVisible(true);
        
        
        //--- khoi tao luoi 3d;
        luoi3d= new luoiToaDo3D();
        luoi3d.setSize(1200, 800);
        luoi3d.setLocation(0, 0);
        luoi3d.addMouseListener(new PixelListener(luoi));
        luoi3d.setVisible(true);
        addThongTinMayBay();
        ThongTinZombie();
        
        ///---set Btn----
        btn2D.setLocation(1300, 800);
        btn2D.setLabel(" Phan 2D");
        btn2D.setSize(300, 30);
        btn2D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(luoi3d);
                jFrame.repaint();
                jFrame.add(luoi);
                jFrame.repaint();
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        jFrame.add(btn2D);
        //---set Btn3D---
        btn3D.setLabel("Phan 3D");
        btn3D.setSize(300, 30);
        btn3D.setLocation(1300, 850);
        jFrame.add(btn3D);
        btn3D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jFrame.remove(luoi); //To change body of generated methods, choose Tools | Templates.
               jFrame.add(luoi3d);
               jFrame.repaint(); 
            }
        });
        
        //-----
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }

    public  void addThongTinMayBay(){
         lbname1= new JLabel();
        lbname1.setSize(300, 30);
        lbname1.setLocation(1300, 0);
        lbname1.setForeground(Color.red);
        jFrame.add(lbname1);
        //dau
        lbdau= new JLabel();
        lbdau.setSize(300, 30);
        lbdau.setLocation(1300, 20*2);
        lbdau.setForeground(Color.blue);
        jFrame.add(lbdau);
        //sung
        lbsung= new JLabel();
        lbsung.setSize(300, 30);
        lbsung.setLocation(1300, 20);
        lbsung.setForeground(Color.blue);
        jFrame.add(lbsung);
        
        lbminh= new JLabel();
        lbminh.setSize(300, 30);
        lbminh.setLocation(1300, 20*3);
        lbminh.setForeground(Color.blue);
        jFrame.add(lbminh);
        
        lbcanhtren= new JLabel();
        lbcanhtren.setSize(400, 30);
        lbcanhtren.setLocation(1300, 20*4);
        lbcanhtren.setForeground(Color.blue);
        jFrame.add(lbcanhtren);
        
        lbCanhDuoi= new JLabel();
        lbCanhDuoi.setSize(400, 30);
        lbCanhDuoi.setLocation(1300, 20*5);
        lbCanhDuoi.setForeground(Color.blue);
        jFrame.add(lbCanhDuoi);
        
        lbBanhXe1= new JLabel();
        lbBanhXe1.setSize(300, 30);
        lbBanhXe1.setLocation(1300, 20*6);
        lbBanhXe1.setForeground(Color.blue);
        jFrame.add(lbBanhXe1);
        
        lbBanhXe2= new JLabel();
        lbBanhXe2.setSize(300, 30);
        lbBanhXe2.setLocation(1300, 20*7);
        lbBanhXe2.setForeground(Color.blue);
        jFrame.add(lbBanhXe2);
        
        lua1= new JLabel();
        lua1.setSize(300, 30);
        lua1.setLocation(1300, 20*8);
        lua1.setForeground(Color.blue);
        jFrame.add(lua1);
        
        lua2= new JLabel();
        lua2.setSize(300, 30);
        lua2.setLocation(1300, 20*9);
        lua2.setForeground(Color.blue);
        jFrame.add(lua2);
        
        lua3= new JLabel();
        lua3.setSize(300, 30);
        lua3.setLocation(1300, 20*10);
        lua3.setForeground(Color.blue);
        jFrame.add(lua3);
        
        lua4= new JLabel();
        lua4.setSize(300, 30);
        lua4.setLocation(1300, 20*11);
        lua4.setForeground(Color.blue);
        jFrame.add(lua4);
        
        lua5= new JLabel();
        lua5.setSize(300, 30);
        lua5.setLocation(1300, 20*12);
        lua5.setForeground(Color.blue);
        jFrame.add(lua5);
        
        lua6= new JLabel();
        lua6.setSize(300, 30);
        lua6.setLocation(1300, 20*13);
        lua6.setForeground(Color.blue);
        jFrame.add(lua6);
        
    }
    public void ThongTinZombie(){
        
        lbname2= new JLabel();
        lbname2.setSize(300, 30);
        lbname2.setLocation(1300, 20*14);
        lbname2.setForeground(Color.red);
        jFrame.add(lbname2);
        
        lbdauzom= new JLabel();
        lbdauzom.setSize(300, 30);
        lbdauzom.setLocation(1300, 20*15);
        lbdauzom.setForeground(Color.blue);
        jFrame.add(lbdauzom);
        
        lbmattrai= new JLabel();
        lbmattrai.setSize(300, 30);
        lbmattrai.setLocation(1300, 20*16);
        lbmattrai.setForeground(Color.blue);
        jFrame.add(lbmattrai);
        
        lbmatphai= new JLabel();
        lbmatphai.setSize(300, 30);
        lbmatphai.setLocation(1300, 20*17);
        lbmatphai.setForeground(Color.blue);
        jFrame.add(lbmatphai);
        
        lbminhzom= new JLabel();
        lbminhzom.setSize(300, 30);
        lbminhzom.setLocation(1300, 20*18);
        lbminhzom.setForeground(Color.blue);
        jFrame.add(lbminhzom);
        
        lbtaytrai= new JLabel();
        lbtaytrai.setSize(300, 30);
        lbtaytrai.setLocation(1300, 20*19);
        lbtaytrai.setForeground(Color.blue);
        jFrame.add(lbtaytrai);
        
        lbtayphai= new JLabel();
        lbtayphai.setSize(300, 30);
        lbtayphai.setLocation(1300, 20*20);
        lbtayphai.setForeground(Color.blue);
        jFrame.add(lbtayphai);
        
        lbchantrai= new JLabel();
        lbchantrai.setSize(300, 30);
        lbchantrai.setLocation(1300, 20*21);
        lbchantrai.setForeground(Color.blue);
        jFrame.add(lbchantrai);
        
        lbchanphai= new JLabel();
        lbchanphai.setSize(300, 30);
        lbchanphai.setLocation(1300, 20*22);
        lbchanphai.setForeground(Color.blue);
        jFrame.add(lbchanphai);
        
    }
}


