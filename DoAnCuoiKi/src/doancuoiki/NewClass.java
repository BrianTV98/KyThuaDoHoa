/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Mylov
 */
public class NewClass {
    public static void main(String[] args) {
        JFrame jFrame= new JFrame();
        jFrame.setSize(1500, 1000);
        jFrame.setLayout(null);
        ABC abc= new ABC();
        abc.setSize(1200, 800);
        abc.setBackground(Color.gray);
        jFrame.add(abc);
//        abc.addMouseListener(new PixelListener(abc));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
