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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.omg.CORBA.MARSHAL;

/**
 *
 * @author Mylov
 */
public class MainFrame {
    static JFrame jFrame;
    LuoiToaDo luoi;
    LuoiToaDoThuCong luoiThuCong= new LuoiToaDoThuCong();
    luoiToaDo3D luoi3d;
    luoiToaDo3D1 luoi3d1;
    luoiToaDo3D2 luoi3d2;
    luoiToaDo3D3 luoi3d3;
    
    static int dem;
    
    static JLabel infor;
    static JLabel developer1;
    static JLabel developer2;
    static JLabel developer3 ;
    static JLabel developer4;
  
    static JTextField X1= new JTextField();
    static JTextField Y1= new JTextField();
    static JTextField X2= new JTextField();
    static JTextField Y2= new JTextField();
    static JTextField txtDo = new JTextField();
    
    static Button btn2D= new Button("2D");
    static Button btn3D =new Button("3D");
    static Button btnVeHinhHop = new Button("btnVeHinhHop");
    static Button btnVeHinhLangTru = new Button("btnVeHinhLangTru");
    static Button btnVeHinhChop = new Button("btnVeHinhChop");
    
    //chuc nang tu dong va thu cong cua 2D 
    static  Button btn2DAutoMa= new Button();
    static  Button btn2DThuCong= new Button();
        // chuc băng Thủ Công
        static Button btnDXOx= new Button();
        static Button btnDXOy = new Button();
        static Button btnDXO= new Button();
        static Button btnDXDiem= new Button();
        static Button btnDXDT= new Button();
        static Button btnQuayO= new Button();
        static Button btnQuayDiem= new Button();
        static Button btnTinhTien= new Button();
        static Button btnScaling= new Button();
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
//    static JLabel lbname11,lbsung1,lbdau1,lbminh1,lbcanhtren1,lbCanhDuoi1,lbBanhXe11,lbBanhXe21,
//                    lua11, lua21, lua31, lua41,lua51,lua61;

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
        infor.setLocation(1680, 885);
        infor.setForeground(Color.MAGENTA);
        infor.setText("Develop by Group 3:" );
        jFrame.add(infor);
        
        //btn 2d tu dong
        
        
        developer1= new JLabel();
        developer1.setSize(500,30);
        developer1.setLocation(1700, 900);
        developer1.setForeground(Color.GREEN);
        developer1.setText("        Developer 1: Trần Văn Hiếu" );
        jFrame.add(developer1);
        
        developer2= new JLabel();
        developer2.setSize(500,30);
        developer2.setForeground(Color.GREEN);
        developer2.setLocation(1700, 915);
        developer2.setText("        Developer 2: Lê Tấn Đạt" );
        jFrame.add(developer2);
        
        developer3= new JLabel();
        developer3.setSize(500,30);
        developer3.setForeground(Color.GREEN);
        developer3.setLocation(1700, 930);
        developer3.setText("        Developer 3: Võ Tuấn An" );
        jFrame.add(developer3);
        //
        
        developer4= new JLabel();
        developer4.setSize(500,30);
        developer4.setLocation(1700, 945);
        developer4.setForeground(Color.GREEN);
        developer4.setText("        Developer 4: Lý Thiên Du" );
        jFrame.add(developer4);
        
        
        // tao khung toa do chinh
        luoi= new LuoiToaDo();
        luoi.setSize(1200, 800);
        luoi.setLocation(0, 0);
//        jFrame.add(luoi);
        luoi.addMouseListener(new PixelListener(luoi));
        luoi.setVisible(true);
//        ThongTinZombie();
//         luoiThuCong =new LuoiToaDoThuCong();
         luoiThuCong.setSize(1200, 800);
         luoiThuCong.setLocation(0, 0);
//         luoiThuCong.addMouseListener(new PixelListener(luoiThuCong));
         luoiThuCong.setVisible(true);
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
       
        
        ///---set Btn2D----
        btn2D.setLocation(1300, 500);
        btn2D.setLabel(" Phan 2D");
        btn2D.setSize(300, 30);
        jFrame.add(btn2D);
        //----set Btn2D tu dong;
        btn2DAutoMa.setLabel("Tu Dong");
        btn2DAutoMa.setSize(80, 30);
        btn2DAutoMa.setLocation(1300,550);
        jFrame.add(btn2DAutoMa);
        //--- set Btn2D thu cong
        btn2DThuCong.setLabel("Thu Cong");
        btn2DThuCong.setSize(80, 30);
        btn2DThuCong.setLocation(1400,550);
        jFrame.add(btn2DThuCong);
        //---set Btn3D---
        btn3D.setLabel("Phan 3D");
        btn3D.setSize(300, 30);
        btn3D.setLocation(1300, 650);
        jFrame.add(btn3D);
         
        
        //set btnVeHinhHop
        btnVeHinhHop.setLabel("Ve Hinh Hop");
        btnVeHinhHop.setSize(170, 30);
        btnVeHinhHop.setLocation(1300, 700);
        jFrame.add(btnVeHinhHop);
        
        
        TamHinhHop= new JLabel();
        TamHinhHop.setText("Toa Do A");
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
        
        //set btnVeHinhLangTru
        btnVeHinhLangTru.setLabel("Ve Lang Tru");
        btnVeHinhLangTru.setSize(170, 30);
        btnVeHinhLangTru.setLocation(1470+5, 700);
        jFrame.add(btnVeHinhLangTru);
        
        TamLangTru= new JLabel();
        TamLangTru.setText("Tam O Lang Tru");
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
        btnVeHinhChop.setLabel("Ve Hinh CHop");
        btnVeHinhChop.setSize(170, 30);
        btnVeHinhChop.setLocation(1650, 700);
        jFrame.add(btnVeHinhChop);
        
        
        TamHinhCHop= new JLabel();
        TamHinhCHop.setText("Toa Do A");
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
        btnNhapThuCong();
        addThongTinMayBay();
         ThongTinZombie();
       
        DisableHinhHop();
        DisableHinhLangTru();
        DisableHinhChop();
        DisEnable2D();
        ButtonNhap();
         //-----
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
    public void btnNhapThuCong(){
        txtDo.setText("45");
        txtDo.setSize(30, 30);
        txtDo.setLocation(1700, 650);
        jFrame.add(txtDo);
        
        X1.setText("-20");
        X1.setSize(30, 30);
        X1.setLocation(1400, 580);
        jFrame.add(X1);
        
        Y1.setText("-20");
        Y1.setSize(30, 30);
        Y1.setLocation(1450, 580);
        jFrame.add(Y1);
        
        X2.setText("-20");
        X2.setSize(30, 30);
        X2.setLocation(1400, 610);
        jFrame.add(X2);
        
        Y2.setText("-20");
        Y2.setSize(30, 30);
        Y2.setLocation(1450, 610);
        jFrame.add(Y2);
        
        btnDXOx.setLabel("DX Ox");
        btnDXOx.setSize(60, 30);
        btnDXOx.setLocation(1500,550);
        jFrame.add(btnDXOx);
        //dxung Oy
        
        btnDXOy.setLabel("DX Oy");
        btnDXOy.setSize(60, 30);
        btnDXOy.setLocation(1600,550);
        jFrame.add(btnDXOy);
        //doi xung O
        btnDXO.setLabel("DX O");
        btnDXO.setSize(60, 30);
        btnDXO.setLocation(1700,550);
        jFrame.add(btnDXO);
        
        btnDXDiem.setLabel("DX Diem");
        btnDXDiem.setSize(60, 30);
        btnDXDiem.setLocation(1500,600);
        jFrame.add(btnDXDiem);
        
        btnDXDT.setLabel("DX DT");
        btnDXDT.setSize(60, 30);
        btnDXDT.setLocation(1600,600);
        jFrame.add(btnDXDT);
        
        btnQuayO.setLabel("Quay O");
        btnQuayO.setSize(60, 30);
        btnQuayO.setLocation(1700,600);
        jFrame.add(btnQuayO);
        
        btnTinhTien.setLabel("Tinh Tien");
        btnTinhTien.setSize(60, 30);
        btnTinhTien.setLocation(1800,550);
        jFrame.add(btnTinhTien);
        
        btnScaling.setLabel("Scaling");
        btnScaling.setSize(60, 30);
        btnScaling.setLocation(1800,600);
        jFrame.add(btnScaling);
        
         btnQuayDiem.setLabel("Quay Quanh Diem");
        btnQuayDiem.setSize(100, 30);
        btnQuayDiem.setLocation(1780,650);
        jFrame.add(btnQuayDiem);
        
//        btnDXOx,btnDXOy,btnDXO,btnDXDiem,btnDXDT, btnQuayO,btnQuayDiem, btnTinhTien, btnScaling;
    }
    public void DisEnable2DThuCong(){
        btnDXOx.disable();
        btnDXOy.disable();
        btnDXO.disable();
        btnDXDiem.disable();
        btnDXDT.disable();
        btnQuayO.disable();
        btnQuayDiem.disable();
        btnTinhTien.disable();
        btnScaling.disable();
    }
    public void Enable2DThuCong(){
        btnDXOx.enable();
        btnDXOy.enable();
        btnDXO.enable();
        btnDXDiem.enable();
        btnDXDT.enable();
        btnQuayO.enable();
        btnQuayDiem.enable();
        btnTinhTien.enable();
        btnScaling.enable();
    }
    public  void DisEnable2D(){
        btn2DAutoMa.disable();
        btn2DThuCong.disable();
        btnDXOx.disable();
        btnDXOy.disable();
        btnDXO.disable();
        btnDXDiem.disable();
        btnDXDT.disable();
        btnQuayO.disable();
        btnQuayDiem.disable();
        btnTinhTien.disable();
        btnScaling.disable();
        X1.disable();
        Y1.disable();
        X2.disable();
        Y2.disable();
        txtDo.disable();
    }
    public  void Enable2D(){
        btn2DAutoMa.enable();
        btn2DThuCong.enable();
        btnDXOx.enable();
        btnDXOy.enable();
        btnDXO.enable();
        btnDXDiem.enable();
        btnDXDT.enable();
        btnQuayO.enable();
        btnQuayDiem.enable();
        btnTinhTien.enable();
        btnScaling.enable();
    }
    public void ButtonNhap(){
         btn2D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enable2D();
                DisableHinhHop();
                DisableHinhLangTru();
                DisEnable2DThuCong();
                DisableHinhChop();
                jFrame.remove(luoi3d);
                jFrame.remove(luoi3d1);
                jFrame.remove(luoi3d2);
                jFrame.remove(luoi3d3);
                jFrame.repaint();
//                jFrame.add(luoi);
//               jFrame.repaint();
                //To change body of generated methods, choose Tools | Templates.
            }
        });
         btn2DAutoMa.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
               DisEnable2DThuCong();
               jFrame.remove(luoiThuCong);
               jFrame.add(luoi);
               jFrame.repaint();
             }
         });
         btn2DThuCong.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 XoaThongTinZombie();
                 Enable2DThuCong();
                 jFrame.remove(luoi);
                 jFrame.add(luoiThuCong);
                 jFrame.repaint();
             }
         });
        btn3D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               DisEnable2D();
               XoaThongTinMayBay();
               XoaThongTinZombie();
               EnableHinhHop();
               EnableHinhLangTru();
               EnableHinhChop();
               jFrame.remove(luoiThuCong);
               jFrame.remove(luoi); //To change body of generated methods, choose Tools | Templates.
               jFrame.remove(luoi3d1);
               jFrame.remove(luoi3d2);
               jFrame.remove(luoi3d3);
               jFrame.repaint();      
               jFrame.add(luoi3d);
               jFrame.repaint(); 
               
            }
        });
        btnVeHinhChop.addActionListener(new ActionListener() {
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
        btnVeHinhHop.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             
               jFrame.remove(luoi);
              jFrame.remove(luoi3d);
              jFrame.remove(luoi3d2);
              jFrame.remove(luoi3d3);
              jFrame.repaint();
              jFrame.add(luoi3d1);
              jFrame.repaint();
           }
       });
        btnVeHinhLangTru.addActionListener(new ActionListener() {
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
        btnDXOx.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 DisableP1();
                 DisablePoint2();
                 txtDo.disable();
                 jFrame.repaint();
                 dem=1;
             }
         });
        btnDXOy.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 DisableP1();
                 DisablePoint2();
                 txtDo.disable();
                 jFrame.repaint();
                dem=2;
             }
         });
        btnDXO.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 DisableP1();
                 DisablePoint2();
                 txtDo.enable();
                 jFrame.repaint();
                dem=3;
             }
         });
        btnDXDiem.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 DisablePoint2();
                 EnablePoint1();
                 jFrame.repaint();
                 dem=4;
             }
         });
        btnDXDT.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jFrame.repaint();
                 EnablePoint2();
                 EnablePoint1();
                 txtDo.disable();
                 jFrame.repaint();
                dem=5;
             }
         });
        btnQuayO.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {//To change body of generated methods, choose Tools | Templates.
                 DisableP1();
                 DisablePoint2();
                 txtDo.enable();
                 jFrame.repaint();
                 dem=6;
             }
         });
        btnTinhTien.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                  EnablePoint1();
                  DisablePoint2();
                  txtDo.disable();
                  jFrame.repaint();
                  dem=7;
             }
         });
        btnScaling.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 EnablePoint1();
                  DisablePoint2();
                  txtDo.disable();
                  jFrame.repaint();
                  dem=8; //To change body of generated methods, choose Tools | Templates.
             }
         });
        btnQuayDiem.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                    EnablePoint1();
                  DisablePoint2();
                  txtDo.enable();
                  jFrame.repaint();
                  dem=9; //To change body of generated methods, choose Tools | Templates.
             }
         });
    }
    public void EnablePoint1(){
        X1.enable();//To change body of generated methods, choose Tools | Templates.
        Y1.enable();
    }
    public void DisableP1(){
        X1.disable();
        Y1.disable();
    }
    public void EnablePoint2(){
        X2.enable();
        Y2.enable();
    }
    public  void DisablePoint2(){
        X2.disable();
        Y2.disable();
    }
    public void DisableHinhLangTru(){
        btnVeHinhLangTru.disable();
        LX.disable();
        LY.disable();
        LZ.disable();
        Lbk.disable();
        Lcao.disable();
        TamLangTru.disable();
        BanKinhL.disable();
        ChieuCaoL.disable();
    }
     public void DisableHinhChop(){
        btnVeHinhChop.disable();
        CX.disable();
        CY.disable();
        CZ.disable();
        Cdai.disable();
        Crong.disable();
        Ccao.disable();
        TamHinhCHop.disable();
        CChieuDai.disable();
        CChieuRong.disable();
        CChieuCao.disable();
    }
     public void EnableHinhChop(){
        btnVeHinhChop.enable();
        CX.enable();
        CY.enable();
        CZ.enable();
        Cdai.enable();
        Crong.enable();
        Ccao.enable();
        TamHinhCHop.enable();
        CChieuDai.enable();
        CChieuRong.enable();
        CChieuCao.enable();
    }
    public void EnableHinhLangTru(){
        btnVeHinhLangTru.enable();
        LX.enable();
        LY.enable();
        LZ.enable();
        Lbk.enable();
        Lcao.enable();
        TamLangTru.enable();
        BanKinhL.enable();
        ChieuCaoL.enable();
    }
    public void DisableHinhHop(){
        btnVeHinhHop.disable();
        HX.disable();
        HY.disable();
        HZ.disable();
        dai.disable();
        rong.disable();
        cao.disable();
        TamHinhHop.disable();
        ChieuDai.disable();
        ChieuRong.disable();
        ChieuCao.disable();
         
    }
    public void EnableHinhHop(){
        btnVeHinhHop.enable();
        HX.enable();
        HY.enable();
        HZ.enable();
        dai.enable();
        rong.enable();
        cao.enable();
        TamHinhHop.enable();
        ChieuDai.enable();
        ChieuRong.enable();
        ChieuCao.enable();
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
    public void XoaThongTinMayBay(){
      lbname1.setText("");
       lbdau.setText ("");
      lbsung.setText("");
        lbminh.setText("");
        lbCanhDuoi.setText("");
        lbcanhtren.setText("");
      lbBanhXe1.setText("");
        lbBanhXe2.setText("");
        lua1.setText ("");
       lua2.setText ("");
        lua3.setText ("");
        lua4.setText ("");
        lua5.setText ("");
        lua6.setText ("");
            
    }
    public void XoaThongTinZombie(){
        lbname2.setText("");
        lbdauzom.setText("");
        lbminhzom.setText("");
        lbmattrai.setText("");
        lbmatphai.setText("");
        lbtayphai.setText("");
        lbtaytrai.setText("");
        lbchantrai.setText("");
        lbchanphai.setText("");
    }
    
}


