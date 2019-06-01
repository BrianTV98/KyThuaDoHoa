/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mylov
 */
public class Zombie {
    Pixel tamnao;
    Eclip dau;
    Pixel matTrai;
    Pixel matPhai;
    Eclip minh;
    Line chantrai;
    Line chanPhai;
    Line taytrai;
    Line tayphai;

    
    public Pixel getTamnao() {
        return tamnao;
    }

    public void setTamnao(Pixel tamnao) {
        this.tamnao = tamnao;
    }

    public Eclip getDau() {
        return dau;
    }

    public void setDau(Eclip dau) {
        this.dau = dau;
    }

    public Pixel getMatTrai() {
        return matTrai;
    }

    public void setMatTrai(Pixel matTrai) {
        this.matTrai = matTrai;
    }

    public Pixel getMatPhai() {
        return matPhai;
    }

    public void setMatPhai(Pixel matPhai) {
        this.matPhai = matPhai;
    }

    public Eclip getMinh() {
        return minh;
    }

    public void setMinh(Eclip minh) {
        this.minh = minh;
    }

    public Line getChantrai() {
        return chantrai;
    }

    public void setChantrai(Line chantrai) {
        this.chantrai = chantrai;
    }

    public Line getChanPhai() {
        return chanPhai;
    }

    public void setChanPhai(Line chanPhai) {
        this.chanPhai = chanPhai;
    }

    public Line getTaytrai() {
        return taytrai;
    }

    public void setTaytrai(Line taytrai) {
        this.taytrai = taytrai;
    }

    public Line getTayphai() {
        return tayphai;
    }

    public void setTayphai(Line tayphai) {
        this.tayphai = tayphai;
    }

    public Zombie(Pixel tamnao, Eclip dau, Pixel matTrai, Pixel matPhai, Eclip minh, Line chantrai, Line chanPhai, Line taytrai, Line tayphai) {
        this.tamnao = tamnao;
        this.dau = dau;
        this.matTrai = matTrai;
        this.matPhai = matPhai;
        this.minh = minh;
        this.chantrai = chantrai;
        this.chanPhai = chanPhai;
        this.taytrai = taytrai;
        this.tayphai = tayphai;
    }
    
    public Zombie(Pixel tamnao) {
        this.tamnao = tamnao;
        dau= new Eclip(tamnao, 3, 4);
        matTrai= new Pixel(tamnao.getX(), tamnao.getY()+1);
        matPhai=new Pixel(tamnao.getX()+2, tamnao.getY()+1);
        minh=new Eclip(new Pixel(tamnao.getX(), tamnao.getY()-17), 6, 12);
        chantrai= new Line(new Pixel(tamnao.getX()-1, tamnao.getY()-29), new Pixel(tamnao.getX()-3, tamnao.getY()-40));
        chanPhai= new Line(new Pixel(tamnao.getX()+1, tamnao.getY()-29), new Pixel(tamnao.getX()+4, tamnao.getY()-40));
        taytrai= new Line(new Pixel(tamnao.getX()+4, tamnao.getY()-7), new Pixel(tamnao.getX()+15, tamnao.getY()-7));
        tayphai= new Line(new Pixel(tamnao.getX()+5, tamnao.getY()-9), new Pixel(tamnao.getX()+15, tamnao.getY()-9));
    }

    
    public Zombie TinhTien(int x,int y){
        return new Zombie(tamnao.TinhTien(x, y));
    }
    public Zombie DoiXungO(){
        return new Zombie(tamnao.DoiXungO(),
                dau.DoiXungO(),
                matTrai.DoiXungO(),
                matPhai.DoiXungO(),
                minh.DoiXungO(),
                chantrai.DoiXungO(),
                chanPhai.DoiXungO(), 
                taytrai.DoiXungO(),
                tayphai.DoiXungO());
    }
    public Zombie DoiXungQuaOx(){
        return new Zombie(tamnao.DoiXungOx(),
                dau.DoiXungOx(),
                matTrai.DoiXungOx(),
                matPhai.DoiXungOx(),
                minh.DoiXungOx(), 
                chantrai.DoiXungOx(), 
                chanPhai.DoiXungOx(), 
                taytrai.DoiXungOx(), 
                tayphai.DoiXungOx());
    }
    public Zombie DoiXungQuaOy(){
        return new Zombie(tamnao.DoiXungOy(),
                dau.DoiXungOy(),
                matTrai.DoiXungOy(), 
                matPhai.DoiXungOy(), 
                minh.DoiXungOy(), 
                chantrai.DoiXungOy(), 
                chanPhai.DoiXungOy(),
                taytrai.DoiXungOy(), 
                tayphai.DoiXungOy());
    }
    public void RungDau(Graphics g,int y){
        dau.TinhTien(0,-y).draweEllipseMidPoint(g, Color.yellow, false);
        matTrai.TinhTien(0, -y).draw(g, Color.gray);
        matPhai.TinhTien(0, -y).draw(g, Color.gray);
        
        //---show thong tin ---
        MainFrame.lbdauzom.setText("Đầu (Hình Eclip):  tam ("+ dau.TinhTien(0, -y).getTam().getX()+","+dau.TinhTien(0, -y).getTam().getY()+") ,"
        +"a ="+dau.TinhTien(0, -y).getA()+"  b="+dau.TinhTien(0, -y).getB());
        MainFrame.lbmattrai.setText("Mắt Trái (Điểm)  :      ("+ matTrai.TinhTien(0, -y).getX()+","+matTrai.TinhTien(0, -y).getY()+")");
        MainFrame.lbmatphai.setText("Mắt Phải (Điểm)  :      ("+ matPhai.TinhTien(0,-y).getX()+","+matPhai.TinhTien(0, -y).getY()+")");
        MainFrame.lbminhzom.setText("");
        MainFrame.lbtayphai.setText("");
        MainFrame.lbtaytrai.setText("");
        MainFrame.lbchanphai.setText("");
        MainFrame.lbchantrai.setText("");
    }
    public void draw(Graphics g){
        dau.draweEllipseMidPoint(g, Color.yellow, false);
        matTrai.draw(g, Color.red);
        matPhai.draw(g, Color.red);
        minh.draweEllipseMidPoint(g, Color.yellow, false);
        chantrai.Bresenham(g, Color.gray);
        chanPhai.Bresenham(g, Color.gray);
        taytrai.Bresenham(g, Color.gray);
        tayphai.Bresenham(g, Color.gray);
        ThongTinZombie();
    }
    public void ThongTinZombie(){
        MainFrame.lbname2.setText("ZOMBIE");
        MainFrame.lbdauzom.setText("Đầu (Hình Eclip):  tam ("+ dau.getTam().getX()+","+dau.getTam().getY()+") ,"
                        +"a ="+dau.getA()+"  b="+dau.getB());
        MainFrame.lbminhzom.setText("Mình (Hình Eclip):  tam ("+ minh.getTam().getX()+","+minh.getTam().getY()+") ,"
                        +"a ="+minh.getA()+"  b="+minh.getB());
        MainFrame.lbmattrai.setText("Mắt Trái (Điểm)  :      ("+ matTrai.getX()+","+matTrai.getY()+")");
        MainFrame.lbmatphai.setText("Mắt Phải (Điểm)  :      ("+ matPhai.getX()+","+matPhai.getY()+")");
        MainFrame.lbtayphai.setText("Tay Phải (Đường Thẳng) :("+ tayphai.getGoc1().getX()+","+tayphai.getGoc1().getY()+") ;("
                        +tayphai.getGoc2().getX()+","+tayphai.getGoc2().getY()+")");
        MainFrame.lbtaytrai.setText("Tay Trái (Đường Thẳng) :("+ taytrai.getGoc1().getX()+","+taytrai.getGoc1().getY()+") ;("
                        +taytrai.getGoc2().getX()+","+taytrai.getGoc2().getY()+")");
        MainFrame.lbchantrai.setText("Chân Trái (Đường Thẳng) :("+ chantrai.getGoc1().getX()+","+chantrai.getGoc1().getY()+") ;("
                        +chantrai.getGoc2().getX()+","+chantrai.getGoc2().getY()+")");
        MainFrame.lbchanphai.setText("Chân Phải (Đường Thẳng) :("+ chanPhai.getGoc1().getX()+","+chanPhai.getGoc1().getY()+") ;("
                        +chanPhai.getGoc2().getX()+","+chanPhai.getGoc2().getY()+")");
    }
    
    public void XoaThongTinZombie(){
        MainFrame.lbname2.setText("");
        MainFrame.lbdauzom.setText("");
        MainFrame.lbminhzom.setText("");
        MainFrame.lbmattrai.setText("");
        MainFrame.lbmatphai.setText("");
        MainFrame.lbtayphai.setText("");
        MainFrame.lbtaytrai.setText("");
        MainFrame.lbchantrai.setText("");
        MainFrame.lbchanphai.setText("");
    }
}
