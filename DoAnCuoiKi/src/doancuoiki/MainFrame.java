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
import javax.swing.JTextField;

/**
 *
 * @author Mylov
 */
public class MainFrame {
    static JFrame jFrame;
    static  JPanel jhinhhop;
    LuoiToaDo luoi;
    luoiToaDo3D luoi3d;
    luoiToaDo3D1 luoi3d1;
    luoiToaDo3D2 luoi3d2;
    luoiToaDo3D3 luoi3d3;
    
    static JLabel infor;
    static JLabel developer1;
    static JLabel developer2;
    static JLabel developer3 ;
  
    static Button btn2D= new Button("2D");
    static Button btn3D =new Button("3D");
    static Button VeHinhHop = new Button("VeHinhHop");
    static Button VeLangTru = new Button("VeLangTru");
    static Button VeHinhChop = new Button("VeHinhChop");
    
    // Hinh Hop
    static JTextField HX, HY, HZ, dai, rong, cao;
    static JLabel TamHinhHop, ChieuDai, ChieuRong, ChieuCao;
    
    // Hinh Lang Tru
    static JTextField LX, LY, LZ, Lbk, Lcao;
    static JLabel TamLangTru, BanKinhL, ChieuCaoL;
    
    // Hinh Chop
    static JTextField CX, CY, CZ, Cdai, Crong, Ccao;
    static JLabel TamHinhCHop, CChieuDai, CChieuRong, CChieuCao;
    
    //Thong Tin Hinh Hop
    static  JLabel hhname, hhda, hhdb, hhdc, hhdd, hhde, hhdf, hhdg, hhdk;
    
     //Thong Tin Hinh Chop
    static  JLabel hcname, hcda, hcdb, hcdc, hcdd, hcde;
    
    //XoaThongTin
    static JLabel xoathongtin;
    static JLabel lbname11,lbsung1,lbdau1,lbminh1,lbcanhtren1,lbCanhDuoi1,lbBanhXe11,lbBanhXe21,
                    lua11, lua21, lua31, lua41,lua51,lua61;

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
        
//        jhinhhop= new JPanel();
//        jhinhhop.setSize(350, 600);
//        jhinhhop.setLocation(1300, 0);
//        jFrame.add(jhinhhop);
        
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
//        addThongTinMayBay();
//        ThongTinZombie();
        
        //--- khoi tao luoi 3d;
        luoi3d= new luoiToaDo3D();
        luoi3d.setSize(1200, 800);
        luoi3d.setLocation(0, 0);
        luoi3d.addMouseListener(new PixelListener(luoi));
        luoi3d.setVisible(true);
        
        // khoi tao hinh hop
        luoi3d1= new luoiToaDo3D1();
        luoi3d1.setSize(1200, 800);
        luoi3d1.setLocation(0, 0);
        luoi3d1.addMouseListener(new PixelListener(luoi));
        luoi3d1.setVisible(true);  
       // addThongTinHinhHop();
        // khoi tao hinh lang tru
        luoi3d2= new luoiToaDo3D2();
        luoi3d2.setSize(1200, 800);
        luoi3d2.setLocation(0, 0);
        luoi3d2.addMouseListener(new PixelListener(luoi));
        luoi3d2.setVisible(true);
        // khoi tao hinh chop
        luoi3d3= new luoiToaDo3D3();
        luoi3d3.setSize(1200, 800);
        luoi3d3.setLocation(0, 0);
        luoi3d3.addMouseListener(new PixelListener(luoi));
        luoi3d3.setVisible(true);
       
        
        ///---set Btn----
        btn2D.setLocation(1300, 600);
        btn2D.setLabel(" Phan 2D");
        btn2D.setSize(300, 30);
        btn2D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(luoi3d);
                jFrame.remove(luoi3d1);
                jFrame.remove(luoi3d2);
                jFrame.remove(luoi3d3);
                jFrame.repaint();
                addThongTinMayBay();
                ThongTinZombie();
                jFrame.add(luoi);
               jFrame.repaint();
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        jFrame.add(btn2D);
        //---set Btn3D---
        btn3D.setLabel("Phan 3D");
        btn3D.setSize(300, 30);
        btn3D.setLocation(1300, 650);
        jFrame.add(btn3D);
        btn3D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           DeleteThongTinMayBay();
               jFrame.remove(luoi); //To change body of generated methods, choose Tools | Templates.
               jFrame.remove(luoi3d1);
               jFrame.remove(luoi3d2);
               jFrame.remove(luoi3d3);
               //jFrame.remove();
               jFrame.repaint();
              
           // DeleteThongTinMayBay();
               jFrame.add(luoi3d);
              
        
               jFrame.repaint(); 
               
            }
        });
        
        //set VeHinhHop
        VeHinhHop.setLabel("Ve Hinh Hop");
        VeHinhHop.setSize(170, 30);
        VeHinhHop.setLocation(1300, 700);
        jFrame.add(VeHinhHop);
        VeHinhHop.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              jFrame.remove(luoi);
              jFrame.remove(luoi3d);
              jFrame.remove(luoi3d2);
              jFrame.remove(luoi3d3);
              jFrame.repaint();
              //XoaThongTin();
              jFrame.add(luoi3d1);
              jFrame.repaint();
           }
       });
        
        TamHinhHop= new JLabel();
        TamHinhHop.setText("Toa Do Ve");
        TamHinhHop.setForeground(Color.green);
       // TamHinhHop.setBackground(Color.PINK);
        TamHinhHop.setSize(200, 30);
        TamHinhHop.setLocation(1350, 730);
        jFrame.add(TamHinhHop);
        
        HX= new JTextField();
        HX.setText("0");
        HX.setLocation(1300, 760);
        HX.setSize(50, 30);
        jFrame.add(HX);
        
        HY= new JTextField();
        HY.setText("0");
        HY.setLocation(1360, 760);
        HY.setSize(50, 30);
        jFrame.add(HY);
        
        HZ= new JTextField();
        HZ.setText("0");
        HZ.setLocation(1420, 760);
        HZ.setSize(50, 30);
        jFrame.add(HZ);
        
        ChieuDai= new JLabel();
        ChieuDai.setText("Chieu Dai");
        ChieuDai.setForeground(Color.green);
       // TamHinhHop.setBackground(Color.PINK);
        ChieuDai.setSize(200, 30);
        ChieuDai.setLocation(1300, 790);
        jFrame.add(ChieuDai);
        
        dai= new JTextField();
        dai.setText("20");
        dai.setLocation(1300, 820);
        dai.setSize(50, 30);
        jFrame.add(dai);
        
        ChieuRong= new JLabel();
        ChieuRong.setText("Chieu Rong");
        ChieuRong.setForeground(Color.green);
       // TamHinhHop.setBackground(Color.PINK);
        ChieuRong.setSize(200, 30);
        ChieuRong.setLocation(1300, 850);
        jFrame.add(ChieuRong);
        
        rong= new JTextField();
         rong.setText("10");
        rong.setLocation(1300, 880);
        rong.setSize(50, 30);
        jFrame.add(rong);
        
        ChieuCao= new JLabel();
        ChieuCao.setText("Chieu Cao");
        ChieuCao.setForeground(Color.green);
       // TamHinhHop.setBackground(Color.PINK);
        ChieuCao.setSize(200, 30);
        ChieuCao.setLocation(1380, 790);
        jFrame.add(ChieuCao);
        
        cao= new JTextField();
        cao.setText("30");
        cao.setLocation(1380, 820);
        cao.setSize(50, 30);
        jFrame.add(cao);
        
        //set VeLangTru
        VeLangTru.setLabel("Ve Lang Tru");
        VeLangTru.setSize(170, 30);
        VeLangTru.setLocation(1470+5, 700);
        jFrame.add(VeLangTru);
        VeLangTru.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               jFrame.remove(luoi);
               jFrame.remove(luoi3d);
               jFrame.remove(luoi3d1);
               jFrame.remove(luoi3d3);
               jFrame.repaint();
               jFrame.add(luoi3d2);
               jFrame.repaint();
           }
       });
        TamLangTru= new JLabel();
        TamLangTru.setText("Tam Lang Tru");
        TamLangTru.setForeground(Color.yellow);
       // TamHinhHop.setBackground(Color.PINK);
        TamLangTru.setSize(200, 30);
        TamLangTru.setLocation(1470+5, 730);
        jFrame.add(TamLangTru);
        
        LX= new JTextField();
        LX.setText("50");
        LX.setLocation(1470+5, 760);
        LX.setSize(50, 30);
        jFrame.add(LX);
        
        LY= new JTextField();
        LY.setText("0");
        LY.setLocation(1530+5, 760);
        LY.setSize(50, 30);
        jFrame.add(LY);
        
        LZ= new JTextField();
        LZ.setText("50");
        LZ.setLocation(1590+5, 760);
        LZ.setSize(50, 30);
        jFrame.add(LZ);
        
        BanKinhL= new JLabel();
        BanKinhL.setText("Ban Kinh");
        BanKinhL.setForeground(Color.yellow);
       // TamHinhHop.setBackground(Color.PINK);
        BanKinhL.setSize(200, 30);
        BanKinhL.setLocation(1470+5, 790);
        jFrame.add(BanKinhL);
        
        Lbk= new JTextField();
        Lbk.setText("30");
        Lbk.setLocation(1470+5, 820);
        Lbk.setSize(50, 30);
        jFrame.add(Lbk);
        
        ChieuCaoL= new JLabel();
        ChieuCaoL.setText("Chieu Cao");
        ChieuCaoL.setForeground(Color.yellow);
       // TamHinhHop.setBackground(Color.PINK);
        ChieuCaoL.setSize(200, 30);
        ChieuCaoL.setLocation(1530+5, 790);
        jFrame.add(ChieuCaoL);
        
        Lcao= new JTextField();
        Lcao.setText("50");
        Lcao.setLocation(1530+5, 820);
        Lcao.setSize(50, 30);
        jFrame.add(Lcao);
        
        // Ve Hinh Chop
        VeHinhChop.setLabel("Ve Hinh CHop");
        VeHinhChop.setSize(170, 30);
        VeHinhChop.setLocation(1650, 700);
        jFrame.add(VeHinhChop);
        VeHinhChop.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              jFrame.remove(luoi);
              jFrame.remove(luoi3d);
              jFrame.remove(luoi3d1);
              jFrame.remove(luoi3d2);
              jFrame.repaint();
              jFrame.add(luoi3d3);
              jFrame.repaint();
           }
       });
        
        TamHinhCHop= new JLabel();
        TamHinhCHop.setText("Toa Do Ve");
        TamHinhCHop.setForeground(Color.red);
       // TamHinhHop.setBackground(Color.PINK);
        TamHinhCHop.setSize(200, 30);
        TamHinhCHop.setLocation(1350+300, 730);
        jFrame.add(TamHinhCHop);
        
        CX= new JTextField();
        CX.setText("10");
        CX.setLocation(1300+350, 760);
        CX.setSize(50, 30);
        jFrame.add(CX);
        
        CY= new JTextField();
        CY.setText("0");
        CY.setLocation(1360+350, 760);
        CY.setSize(50, 30);
        jFrame.add(CY);
        
        CZ= new JTextField();
        CZ.setText("10");
        CZ.setLocation(1420+350, 760);
        CZ.setSize(50, 30);
        jFrame.add(CZ);
        
        CChieuDai= new JLabel();
        CChieuDai.setText("Chieu Dai");
        CChieuDai.setForeground(Color.red);
       // TamHinhHop.setBackground(Color.PINK);
        CChieuDai.setSize(200, 30);
        CChieuDai.setLocation(1300+350, 790);
        jFrame.add(CChieuDai);
        
        Cdai= new JTextField();
        Cdai.setText("40");
        Cdai.setLocation(1300+350, 820);
        Cdai.setSize(50, 30);
        jFrame.add(Cdai);
        
        CChieuRong= new JLabel();
        CChieuRong.setText("Chieu Rong");
        CChieuRong.setForeground(Color.red);
       // TamHinhHop.setBackground(Color.PINK);
        CChieuRong.setSize(200, 30);
        CChieuRong.setLocation(1360+350, 790);
        jFrame.add(CChieuRong);
        
        Crong= new JTextField();
         Crong.setText("15");
        Crong.setLocation(1360+350, 820);
        Crong.setSize(50, 30);
        jFrame.add(Crong);
        
        CChieuCao= new JLabel();
        CChieuCao.setText("Chieu Cao");
        CChieuCao.setForeground(Color.red);
       // TamHinhHop.setBackground(Color.PINK);
        CChieuCao.setSize(200, 30);
        CChieuCao.setLocation(1430+350, 790);
        jFrame.add(CChieuCao);
        
        Ccao= new JTextField();
        Ccao.setText("50");
        Ccao.setLocation(1430+350, 820);
        Ccao.setSize(50, 30);
        jFrame.add(Ccao);
        
        //-----
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
    
    
    public  void XoaThongTin(){
//        xoathongtin= new JLabel();
//        xoathongtin.setText("  ");
//        xoathongtin.setSize(300, 600);
//        xoathongtin.setLocation(1300, 0);
        jFrame.add(jhinhhop);
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
    public  void DeleteThongTinMayBay(){
         lbname11= new JLabel();
        lbname11.setSize(300, 30);
        lbname11.setLocation(1300, 0);
        lbname11.setForeground(Color.gray);
        jFrame.add(lbname11);
        //dau
        lbdau1= new JLabel();
        lbdau1.setSize(300, 30);
        lbdau1.setLocation(1300, 20*2);
        lbdau1.setForeground(Color.gray);
        jFrame.add(lbdau1);
        //sung
        lbsung1= new JLabel();
        lbsung1.setSize(300, 30);
        lbsung1.setLocation(1300, 20);
        lbsung1.setForeground(Color.gray);
        jFrame.add(lbsung1);
        
        lbminh1= new JLabel();
        lbminh1.setSize(300, 30);
        lbminh1.setLocation(1300, 20*3);
        lbminh1.setForeground(Color.gray);
        jFrame.add(lbminh1);
        
        lbcanhtren1= new JLabel();
        lbcanhtren1.setSize(400, 30);
        lbcanhtren1.setLocation(1300, 20*4);
        lbcanhtren1.setForeground(Color.gray);
        jFrame.add(lbcanhtren1);
        
        lbCanhDuoi1= new JLabel();
        lbCanhDuoi1.setSize(400, 30);
        lbCanhDuoi1.setLocation(1300, 20*5);
        lbCanhDuoi1.setForeground(Color.gray);
        jFrame.add(lbCanhDuoi1);
        
        lbBanhXe11= new JLabel();
        lbBanhXe11.setSize(300, 30);
        lbBanhXe11.setLocation(1300, 20*6);
        lbBanhXe11.setForeground(Color.gray);
        jFrame.add(lbBanhXe11);
        
        lbBanhXe21= new JLabel();
        lbBanhXe21.setSize(300, 30);
        lbBanhXe21.setLocation(1300, 20*7);
        lbBanhXe21.setForeground(Color.gray);
        jFrame.add(lbBanhXe21);
        
        lua11= new JLabel();
        lua11.setSize(300, 30);
        lua11.setLocation(1300, 20*8);
        lua11.setForeground(Color.gray);
        jFrame.add(lua11);
        
        lua21= new JLabel();
        lua21.setSize(300, 30);
        lua21.setLocation(1300, 20*9);
        lua21.setForeground(Color.gray);
        jFrame.add(lua21);
        
        lua31= new JLabel();
        lua31.setSize(300, 30);
        lua31.setLocation(1300, 20*10);
        lua31.setForeground(Color.gray);
        jFrame.add(lua31);
        
        lua41= new JLabel();
        lua41.setSize(300, 30);
        lua41.setLocation(1300, 20*11);
        lua41.setForeground(Color.gray);
        jFrame.add(lua41);
        
        lua51= new JLabel();
        lua51.setSize(300, 30);
        lua51.setLocation(1300, 20*12);
        lua51.setForeground(Color.gray);
        jFrame.add(lua51);
        
        lua61= new JLabel();
        lua61.setSize(300, 30);
        lua61.setLocation(1300, 20*13);
        lua61.setForeground(Color.gray);
        jFrame.add(lua61);
        
    }
    
    public  void addThongTinHinhHop(){
        hhname= new JLabel();
        hhname.setSize(300, 30);
        hhname.setLocation(0, 800);
        hhname.setForeground(Color.green);
        jFrame.add(hhname);
        //dau
        hhda= new JLabel();
        hhda.setSize(200, 30);
        hhda.setLocation(0, 830);
        hhda.setForeground(Color.blue);
        jFrame.add(hhda);
    }
}


