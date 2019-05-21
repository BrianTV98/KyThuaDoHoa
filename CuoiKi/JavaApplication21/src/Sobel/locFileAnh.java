/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sobel;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Dao Trung Duyet
 */
public class locFileAnh extends FileFilter {
    
    public boolean accept(File f)
    {
        if(f.isDirectory())
        {
            return true;
        }
        return f.getName().endsWith(".jpg")||f.getName().endsWith(".png")||f.getName().endsWith(".bmp");
    }
    public String getDescription()
    {
        return "Image files (*.jpg,*.png,*.bmp)";
    }    
}