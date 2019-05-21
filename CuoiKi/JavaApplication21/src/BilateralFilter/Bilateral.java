/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BilateralFilter;

/**
 *
 * @author VietHien
 */
public class Bilateral {
    
    private double sigmarS;// ti so khoang cach trong khong gian
    private double sigmarR;// ti so do lech cuong do
    private int range;//kich thuoc bo loc
    private Pixel result[][];//ma tran da loc
    private int gray[][];
    private Pixel data[][];//ma tran chua duong vien
    private double E = Math.E;// hang so e
    private int nb;// so kenh mau
    private boolean grayFlag = false;//co phan biet anh xam
    
    //cac ham khoi tao
    public Bilateral(){};

    public Bilateral(double sigmarS, double sigmarR, int range, Pixel[][] d,int nb){
        this.nb = nb;
        this.sigmarR = sigmarR;
        this.sigmarS = sigmarS;
        this.range = range;
        this.result = d;
        this.data = new Pixel[d.length+((int)range/2)*2][d[0].length+((int)range/2)*2];
        //Tạo viền cho ảnh
        for(int i = 0;i<data.length;i++){
            for(int j = 0;j<data[0].length;j++){
                if(i-(int)range/2<0 || j-(int)range/2<0 || i-(int)range/2>=d.length || j-(int)range/2>=d[0].length){
                    //duong vien mau den
                    data[i][j] = new Pixel();
                }
                else{
                    //gan gia tri cho diem anh
                    data[i][j] = new Pixel();
                    data[i][j].setAlpha(d[i-(int)range/2][j-(int)range/2].getAlpha());
                    data[i][j].setRed(d[i-(int)range/2][j-(int)range/2].getRed());
                    data[i][j].setGreen(d[i-(int)range/2][j-(int)range/2].getGreen());
                    data[i][j].setBlue(d[i-(int)range/2][j-(int)range/2].getBlue());
                }
            }
        }
    }
    //tinh gia tri cuong do I cua 1 pixel
     public Pixel calc1pixel(int i,int j){
        Pixel b = new Pixel();
        double sumWeightR = 0;
        double accumulationR = 0;
        double sumWeightG = 0;
        double accumulationG = 0;
        double sumWeightB = 0;
        double accumulationB = 0;
        double sumWeightA = 0;
        double accumulationA = 0;
        //Quét các pixel xung quanh tru duong vien
        for(int y=i-(int)(range/2);y<=i+(int)(range/2);y++){
            for(int x=j-(int)(range/2);x<=j+(int)(range/2);x++){
                //Tính khoảng cách euclide
                double imageDist = Math.sqrt((x-j)*(x-j)+(y-i)*(y-i));
                //Tinh khoảng chênh giá trị màu
                double colorDistR = Math.sqrt((data[y][x].getRed()-data[i][j].getRed())*(data[y][x].getRed()-data[i][j].getRed()));
                double colorDistG = Math.sqrt((data[y][x].getGreen()-data[i][j].getGreen())*(data[y][x].getGreen()-data[i][j].getGreen()));
                double colorDistB = Math.sqrt((data[y][x].getBlue()-data[i][j].getBlue())*(data[y][x].getBlue()-data[i][j].getBlue()));
                //Tính từng giá trị mũ
                double currWeightR = (1/(Math.pow(E, (imageDist/sigmarS)*(imageDist/sigmarS)*0.5)*
                        Math.pow(E,(colorDistR/sigmarR)*(colorDistR/sigmarR)*0.5)));
                double currWeightG = (1/(Math.pow(E, (imageDist/sigmarS)*(imageDist/sigmarS)*0.5)*
                        Math.pow(E,(colorDistG/sigmarR)*(colorDistG/sigmarR)*0.5)));
                double currWeightB = (1/(Math.pow(E, (imageDist/sigmarS)*(imageDist/sigmarS)*0.5)*
                        Math.pow(E,(colorDistB/sigmarR)*(colorDistB/sigmarR)*0.5)));
                //Tính tổng mẫu và tử của công thức
                sumWeightR += currWeightR;
                accumulationR += currWeightR*data[y][x].getRed();
                sumWeightG += currWeightG;
                accumulationG += currWeightG*data[y][x].getGreen();
                sumWeightB += currWeightB;
                accumulationB += currWeightB*data[y][x].getBlue();
                //anh RGBA thi tinh them kenh alpha
                if(nb == 4){
                    double colorDistA = Math.sqrt((data[y][x].getAlpha()-data[i][j].getAlpha())*(data[y][x].getAlpha()-data[i][j].getAlpha()));
                    double currWeightA = (1/(Math.pow(E, (imageDist/sigmarS)*(imageDist/sigmarS)*0.5)*
                            Math.pow(E,(colorDistA/sigmarR)*(colorDistA/sigmarR)*0.5)));
                    sumWeightA += currWeightA;
                    accumulationA += currWeightA*data[y][x].getAlpha();
                }
            }
        }
        //cuong do diem anh bang accumulation sau khi tinh
        accumulationR /= sumWeightR;
        accumulationG /= sumWeightG;
        accumulationB /= sumWeightB;
        //anh RGBA tinh them cho kenh alpha
        if(nb == 4){
            accumulationA /= sumWeightA;
            b.setAlpha((int)(Math.floor(accumulationA)));
        }
        b.setRed((int)(Math.floor(accumulationR)));
        b.setGreen((int)(Math.floor(accumulationG)));
        b.setBlue((int)(Math.floor(accumulationB)));

        return b;
     }
     //tinh gia tri cuong do cho toan anh
    public void calculate(){
        //Quét toàn ảnh (trừ phần viến thêm vào
        for(int i=(int)(range/2);i<data.length-(int)(range/2);i++){
            for(int j=(int)(range/2);j<data[0].length-(int)(range/2);j++){
                result[i-(int)(range/2)][j-(int)(range/2)]=calc1pixel(i,j);
            }
        }       
    }
//cac ham get va set   
    public double getSigmarS() {
        return sigmarS;
    }

    public void setSigmarS(double sigmarS) {
        this.sigmarS = sigmarS;
    }

    public double getSigmarR() {
        return sigmarR;
    }

    public void setSigmarR(double sigmarR) {
        this.sigmarR = sigmarR;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Pixel[][] getResult() {
        return result;
    }

    public void setResult(Pixel[][] result) {
        this.result = result;
    }

    public int[][] getGray() {
        return gray;
    }

    public void setGray(int[][] gray) {
        this.gray = gray;
    }

    public Pixel[][] getData() {
        return data;
    }

    public void setData(Pixel[][] data) {
        this.data = data;
    }

    public double getE() {
        return E;
    }

    public void setE(double E) {
        this.E = E;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public boolean isGrayFlag() {
        return grayFlag;
    }

    public void setGrayFlag(boolean grayFlag) {
        this.grayFlag = grayFlag;
    }
}

