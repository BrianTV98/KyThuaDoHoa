/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BilateralFilter;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;
/**
 *
 * @author VietHien
 */
public class Filter {
    private BufferedImage myImage, rsImage;
    private Bilateral b;
    private File myFile, rsFile; 
    private WritableRaster wr;
    private double sigmaS;
    private double sigmaR;
    private int range;
    private int nb;
    private boolean grayFlag;
    
//cac ham khoi tao
    public Filter(){};
    public Filter(File f, int r, int s, int rg){
        myFile = f;
        try{
             myImage = ImageIO.read(myFile);
        } catch(Exception ex){System.out.println("Error");}
        wr=myImage.getRaster(); 
        sigmaR = r;
        sigmaS = s;
        range = rg;
    }
    //doi anh sang ma tran pixel
    public Pixel[][] getData(){
        int temp[]= new int [nb];        
        Raster r = myImage.getRaster();
        Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
        for(int i=0;i<r.getHeight();i++){
            for(int j=0;j<r.getWidth();j++){
                temp = r.getPixel(j, i, temp);
                Pixel a=null;
                if(nb==4)
                    if(grayFlag == false)
                        a = new Pixel(temp[0],temp[1],temp[2],temp[3]);
                    else{
                        int tam = (int)((temp[0]+temp[1]+temp[2]+temp[3])/4);
                        a= new Pixel(tam,tam,tam,tam);
                        }
                if(getNb()==3)
                    if(grayFlag== false)
                        a = new Pixel(temp[0],temp[1],temp[2]);
                    else{
                        int tam = (int)((temp[0]+temp[1]+temp[2])/3);
                        a= new Pixel(tam,tam,tam);
                        }
                data[i][j] = a;
            }
        }
        return data;
    }
    //thay doi gia tri ma tran pixel cua anh
        public void setData(Pixel[][] data){
        wr=myImage.getRaster();
        int[] pixelValue = new int [nb]; 
        if(data.length != wr.getHeight() || data[0].length != wr.getWidth()) return;
        for(int i=0;i<wr.getHeight();i++){
            for(int j=0;j<wr.getWidth();j++){
                if(nb==4){
                    pixelValue[0] = data[i][j].getRed();
                    pixelValue[1] = data[i][j].getGreen();
                    pixelValue[2] = data[i][j].getBlue();
                    pixelValue[3] = data[i][j].getAlpha();
                    wr.setPixel(j, i, pixelValue);
                }
                if(nb==3){
                    pixelValue[0] = data[i][j].getRed();
                    pixelValue[1] = data[i][j].getGreen();
                    pixelValue[2] = data[i][j].getBlue();
                    wr.setPixel(j, i, pixelValue);
                }
            }
        }
    }
        
//doi mang pixel sang anh
    public BufferedImage displayImage(){
        if(nb==4)
            rsImage = new BufferedImage(wr.getWidth(), wr.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        if(nb==3)
            rsImage = new BufferedImage(wr.getWidth(), wr.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        rsImage.setData(wr);
        return rsImage;
    }
//xu ly loc ma tran pixel
    public void processBilateral(){
        b = new Bilateral(sigmaS, sigmaR, range, getData(),nb);
        b.calculate();
        setData(b.getResult());
    }  
    public BufferedImage getMyImage() {
        return myImage;
    }

    public void setMyImage(BufferedImage myImage) {
        this.myImage = myImage;
    
    }

    public BufferedImage getRsImage() {
        return rsImage;
    }

    public void setRsImage(BufferedImage rsImage) {
        this.rsImage = rsImage;
    }

    public Bilateral getB() {
        return b;
    }

    public void setB(Bilateral b) {
        this.b = b;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
        try{
            myImage = (ImageIO.read(myFile));
        } catch(Exception ex){System.out.println("Error");}
        wr = myImage.getRaster(); 
        nb = wr.getNumBands();
    }

    public WritableRaster getWr() {
        return wr;
    }

    public void setWr(WritableRaster wr) {
        this.wr = wr;
    }

    public double getSigmaS() {
        return sigmaS;
    }

    public void setSigmaS(double sigmaS) {
        this.sigmaS = sigmaS;
    }

    public double getSigmaR() {
        return sigmaR;
    }

    public void setSigmaR(double sigmaR) {
        this.sigmaR = sigmaR;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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

    public File getRsFile() {
        return rsFile;
    }

    public void setRsFile(File rsFile) {
        this.rsFile = rsFile;
        
    }
}
