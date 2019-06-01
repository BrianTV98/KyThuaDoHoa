/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author Mylov
 */
public class Point3D {
    private int x;
    private int y;
    private int z;
    private int h;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h=1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    public Pixel tranFormToPixel(){
        Point3D point= new Point3D(x, y, z);
        float phi = 45; //thay doi goc cua truc oz so voi truc ox
        float a=(float) 1;
    float []vector = new float[] {
        point.x,
        point.y,
        point.z,
        point.h
    };
    point.x= (int) Math.round(point.getX() - point.getZ()*Math.cos(45*PI/180.0));
    point.y= (int) Math.round(point.getY() - point.getZ()*Math.cos(45*PI/180.0));
//    float [][]transformMaxtrix = new float[][]{
//        { 1, 0,Math.round( -1*a*Math.cos(Math.toRadians(phi))), 0},
//        { 0, 1, Math.round(-1*a*Math.sin(Math.toRadians(phi))), 0},
//        { 0, 0, 0, 0},
//        { 0, 0, 0, 1}
//    };
//    point.x =   (int) (vector[0] * transformMaxtrix[0][0] +
//            vector[1] * transformMaxtrix[0][1] +
//            vector[2] * transformMaxtrix[0][2] +
//            vector[3] * transformMaxtrix[0][3]);
//    point.y =   (int) (vector[0] * transformMaxtrix[1][0] +
//            vector[1] * transformMaxtrix[1][1] +
//            vector[2] * transformMaxtrix[1][2] +
//            vector[3] * transformMaxtrix[1][3]);
//    point.z =   (int) (vector[0] * transformMaxtrix[2][0] +
//            vector[1] * transformMaxtrix[2][1] +
//            vector[2] * transformMaxtrix[2][2] );//+
////            vector[3] * transformMaxtrix[2][3]);
//    point.h =   (int) (vector[0] * transformMaxtrix[3][0] +
//            vector[1] * transformMaxtrix[3][1] +
//            vector[2] * transformMaxtrix[3][2] +
//            vector[3] * transformMaxtrix[3][3]);
     return new Pixel(point.x, point.y);
    }
    
    
    public Point3D TinhTien(int x1, int y1, int z1){
        return new Point3D(x+x1, y+y1, z+z1);
    }
    public Point3D Scaling(int x1, int y1,int z1){
        return new Point3D(x*x1, y*y1, z*z1);
    }
    public Point3D DoiXungOx(){
        return new Point3D(x, -y, -z);
    }
    public Point3D DoiXungOy(){
        return new Point3D(-x, y, -z);
    }
    public Point3D DoiXungQuaOz(){
        return new Point3D(-x, -y, z);
    }
    public Point3D DoiXungQuaOxy(){
        return new Point3D(x, y, -z);
    }
    public Point3D DoiXungQuaOxz(){
        return new Point3D(x, -y, z);
    }
    public Point3D DoiXungQuaOyz(){
        return new Point3D(-x, y, z);
    }
    private Point3D DoiXungQuaO(){
        return new Point3D(-x, -y, -z);
    }
    private Point3D QuayQuanhOx(float Do){
        float toRadian= Math.round(Math.toRadians(Do));
        return new Point3D(x, (int) Math.round(y*Math.cos(toRadian)-z*Math.sin(Do)), (int)Math.round(y*Math.cos(toRadian)+z*Math.sin(Do)));
    }
    private Point3D QuayQuanhOy(float Do){
        float toRadian= Math.round(Math.toRadians(Do));
        return new Point3D((int )Math.round(x*Math.cos(toRadian)-z*Math.sin(toRadian)), y, (int) Math.round(x*Math.sin(toRadian)+z*Math.cos(toRadian)));
    }
    private Point3D QuayQuanhOz(float Do){
        float toRadian= Math.round(Math.toRadians(Do));
        return new Point3D((int )Math.round(x*Math.cos(toRadian)-y*Math.sin(toRadian)), (int )Math.round(x*Math.cos(toRadian)+y*Math.sin(toRadian)), z);
    }
    private Point3D QuayQuanhTrucBatKi(Point3D p1, Point3D p2){
        return new Point3D(0, 0, 0);
    }

   
}
 