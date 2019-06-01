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
public class DuongTron3D {

    private Point3D tam;
    private int bankinh;

        public Point3D getTam() {
            return tam;
        }

        public void setTam(Point3D tam) {
            this.tam = tam;
        }

        public int getBankinh() {
            return bankinh;
        }

        public void setBankinh(int bankinh) {
            this.bankinh = bankinh;
        }

        public DuongTron3D(Point3D tam, int bankinh) {
            this.tam = tam;
            this.bankinh = bankinh;
        }

   
    public void drawCircle( int x, int y,Graphics g,Color mau)
{       
        
        new Point3D(tam.getX() + x,tam.getY(), tam.getZ()+ y).tranFormToPixel().draw(g,mau);
        new Point3D(tam.getX() - x,tam.getY(), tam.getZ() + y).tranFormToPixel().draw(g,mau);
        new Point3D(tam.getX() + x,tam.getY(), tam.getZ() - y).tranFormToPixel().draw(g,mau);
        new Point3D(tam.getX() - x,tam.getY(), tam.getZ() - y).tranFormToPixel().draw(g,mau);
        new Point3D(tam.getX() + y,tam.getY(), tam.getZ() + x).tranFormToPixel().draw(g,mau);
        new Point3D(tam.getX() - y,tam.getY(), tam.getZ() + x).tranFormToPixel().draw(g,mau);
        new Point3D(tam.getX() + y,tam.getY(), tam.getZ() - x).tranFormToPixel().draw(g,mau);
        new Point3D(tam.getX() - y,tam.getY(), tam.getZ() - x).tranFormToPixel().draw(g,mau);
}
    
    public void bresenhamCircle( Graphics g,Color color)
    {
        new Point3D(tam.getX(),tam.getY(), tam.getZ()).tranFormToPixel().draw(g,color);
        int x = 0;
        int y = bankinh;
        int p =  (3 - 2 * bankinh);
        drawCircle( x, y,g,color);
        while (y >= x)
        {
            x++;
            if (p > 0)
            {
                y--;
                p = p + 4 * (x - y) + 10;
            }
            else
                p = p + 4 * x + 6;
                drawCircle( x, y,g,color);
            }
    }
    
}
