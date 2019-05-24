/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testNhe;

/**
 *
 * @author Mylov
 */
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

public class TimerDemo implements ActionListener {
  Timer t = new Timer(1000,this);

  TimerDemo() {
    t.start();
    }

  public static void main(String args[]) {
    TimerDemo td = new TimerDemo();
    // create a dummy frame to keep the JVM running
    //  (for demonstation purpose)
    java.awt.Frame dummy = new java.awt.Frame();
    dummy.setVisible(true);
    }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == t) {
      System.out.println 
        ("\007Being ticked " + Calendar.getInstance().getTime());
      }
    }
}
