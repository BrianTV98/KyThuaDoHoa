package Loctrungvi_Min_Max;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author VAIO
 */
public class FrameMain extends javax.swing.JFrame {

    private String url;
    private String url1;
    BufferedImage image, _image, img;
    private int _sp = 0; 
    private JFileChooser fileChooser;
    private void setOriginalImage(){
        ImageIcon imageIcon = new ImageIcon(_image);
        SetSizeImage ss = new SetSizeImage();
        Image img = ss.setSizeImageIcon(imageIcon, 217, 217);
        imageIcon = new ImageIcon(img);
        lb_anhgoc.setIcon(imageIcon);
    }
    /**
     * 
     */
    private void setProcessImage(){
        ImageIcon imageIcon = new ImageIcon(image);
        SetSizeImage ss = new SetSizeImage();
        Image img1 = ss.setSizeImageIcon(imageIcon, 217, 217);
        imageIcon = new ImageIcon(img1);
        lb_anhxuly.setIcon(imageIcon);
    }
    
    private BufferedImage ImgtoBuff(String tenanh){
        ImageIcon anh = new ImageIcon(getClass().getResource(tenanh));
        BufferedImage buf = new BufferedImage(anh.getIconWidth(), anh.getIconHeight(), BufferedImage.SCALE_DEFAULT);
        buf.getGraphics().drawImage(anh.getImage(), 0, 0, anh.getImageObserver());
        return buf;
    }
    
    public FrameMain() {
        initComponents();
     
        setIconImage(new ImageIcon(getClass().getResource("logo.jpg")).getImage());
        img = ImgtoBuff("anh2.jpg");
        image = ImgtoBuff("anh.jpg");
        _image = img;
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new MyFileFilter());
        lb_time.setText("Image Process");
        text_saltpepper.setEnabled(false);
        bt_sp.setEnabled(false);
        setOriginalImage();
//        setProcessImage();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lb_anhgoc = new javax.swing.JLabel();
        lb_anhxuly = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_repeat = new javax.swing.JTextField();
        rd_color = new javax.swing.JRadioButton();
        rd_grayscale = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        text_size = new javax.swing.JTextField();
        text_saltpepper = new javax.swing.JTextField();
        btOpen = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_time = new javax.swing.JLabel();
        bt_sp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Neighbourhood processing");

        lb_anhgoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_anhxuly.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Filter Size");

        jLabel4.setText("Repeat");

        jLabel5.setText("Transform");

        text_repeat.setText("2");

        buttonGroup1.add(rd_color);
        rd_color.setSelected(true);
        rd_color.setText("Color");
        rd_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_colorActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_grayscale);
        rd_grayscale.setText("Grayscale");
        rd_grayscale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_grayscaleActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Min", "Median", "Max" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        text_size.setText("3");

        text_saltpepper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_saltpepperActionPerformed(evt);
            }
        });

        btOpen.setText("Open");
        btOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenActionPerformed(evt);
            }
        });

        jButton2.setText("Process");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btSave.setText("Save");
        btSave.setEnabled(false);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("NEIGHBOURHOOD PROCESSING");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Original Image");

        lb_time.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        bt_sp.setText("Add salt n pepper noise");
        bt_sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_spActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel2)
                                .addGap(113, 113, 113)
                                .addComponent(lb_time, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_saltpepper, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_sp)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_anhgoc, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_anhxuly, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rd_color)
                                                .addGap(72, 72, 72)
                                                .addComponent(rd_grayscale))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4))
                                                .addGap(74, 74, 74)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(text_repeat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(text_size, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_color)
                            .addComponent(rd_grayscale))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(text_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(text_repeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_anhxuly, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_anhgoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btOpen)
                    .addComponent(jButton2)
                    .addComponent(btSave)
                    .addComponent(lb_time, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_saltpepper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sp))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rd_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_colorActionPerformed
        if(rd_color.isSelected()){
            _image = img;
//            String sp = text_saltpepper.getText();
//            if(!sp.equals("")){
//                try{
//                    int _sp = Integer.parseInt(sp);
                    AddSaltPepper n = new AddSaltPepper();
                    _image = n.Add_saltpepper(_image, _sp);
//                }catch(Exception e){
//                    System.out.println(e);
//                }
//            }
            setOriginalImage();
        }
    }//GEN-LAST:event_rd_colorActionPerformed

    private void rd_grayscaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_grayscaleActionPerformed
        if(rd_grayscale.isSelected()){
            _image = img;
            Grayscale gr = new Grayscale();
            _image = gr.GrayImage(_image);
//            String sp = text_saltpepper.getText();
//            if(!sp.equals("")){
//                try{
//                    _sp = Integer.parseInt(sp);
                    AddSaltPepper n = new AddSaltPepper();
                    _image = n.Add_saltpepper(_image, _sp);
//                }catch(Exception e){
//                    System.out.println(e);
//                }
//            }
            setOriginalImage();
        }
    }//GEN-LAST:event_rd_grayscaleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        long startTime = System.currentTimeMillis();
        image = _image;
        
        String filter = jComboBox1.getSelectedItem().toString();
        String size = text_size.getText();
        String rep = text_repeat.getText();
        String sp = text_repeat.getText();
        int _size = 0, _rep = 0;
        
        try{
            _size = Integer.parseInt(size);
            if(_size%2==0 || _size <3)
                JOptionPane.showMessageDialog(null,"Lưu ý: Filter Size là số lẻ lớn hơn hoặc bằng 3!");
            else{
                _rep = Integer.parseInt(rep);
//                if(!sp.equals(""))
//                    _sp = Integer.parseInt(sp);
//                else
//                    _sp = 0;
                for(int i=0; i<_rep; i++){
                    if(filter.equals("Min")){
                        Neighbourhood nb = new Neighbourhood();
                        image = nb.MinFilter(image, _size);
                    }
                    if(filter.equals("Median")){
                        Neighbourhood nb = new Neighbourhood();
                        image = nb.MedianFilter(image, _size);
                    }

                    if(filter.equals("Max")){
                        Neighbourhood nb = new Neighbourhood();
                        image = nb.MaxFilter(image, _size);
                    }

                    setProcessImage();
                    btSave.setEnabled(true);
                    long endTime   = System.currentTimeMillis();
                    lb_time.setText("Processed Image "+(endTime - startTime)+" ms");  
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Giá trị bạn vừa nhập không đúng vui lòng kiểm tra lại");
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String filter = jComboBox1.getSelectedItem().toString();
        
        if(filter.equals("Min") || filter.equals("Max")){
            _image =img;
            _sp = 0;
            if(rd_grayscale.isSelected()){
                Grayscale gr = new Grayscale();
                _image = gr.GrayImage(_image);
            }
            
            setOriginalImage();
            text_saltpepper.setText("");
            text_saltpepper.setEnabled(false);
            bt_sp.setEnabled(false);
        }else{
            text_saltpepper.setText("30");
            text_saltpepper.setEnabled(true);
            bt_sp.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void text_saltpepperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_saltpepperActionPerformed
//        _image = img;
//        if(rd_grayscale.isSelected()){
//            Grayscale gr = new Grayscale();
//            _image = gr.GrayImage(_image);
//        }
//        String sp = text_saltpepper.getText();
//        try{
//            int _sp = Integer.parseInt(sp);
//            AddSaltPepper n = new AddSaltPepper();
//            _image = n.Add_saltpepper(_image, (float) _sp);
//            setOriginalImage();
//        }catch(Exception e){
//            System.out.println(e);
//        }
    }//GEN-LAST:event_text_saltpepperActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
       
       if(fileChooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
       {
           try {
               String temp = fileChooser.getSelectedFile().getAbsolutePath();
               String subfix="jpg";
               if(temp.endsWith(".jpg")==false&&temp.endsWith(".png")==false&&temp.endsWith(".bmp")==false&&temp.endsWith(".gif")==false)
               {
                   temp+=".jpg";
               }else
               {
                   //aaaa.png
                   int index = temp.lastIndexOf(".");
                   subfix = temp.substring(index+1, temp.length());
//                   System.out.println(""+subfix);
               }
               File outputfile = new File(temp);
               ImageIO.write(image, subfix, outputfile);
//               System.out.println(""+fileChooser.getSelectedFile().getAbsolutePath());
               JOptionPane.showMessageDialog(null, "Lưu thành công");
           } catch (IOException ex) {
               JOptionPane.showMessageDialog(null, "Thất bại!!");
               Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        
    }//GEN-LAST:event_btSaveActionPerformed

    private void btOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenActionPerformed
        if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            String temp = fileChooser.getSelectedFile().getAbsolutePath();
            if(temp.endsWith(".jpg")==false&&temp.endsWith(".png")==false&&temp.endsWith(".bmp")==false&&temp.endsWith(".gif")==false)
            {
                JOptionPane.showMessageDialog(null, "Đây không phải là file ảnhnh");
                return;
            }
            
            url = temp;
            url1 = temp;
            try {
            img = ImageIO.read(new File(url));
            image = ImageIO.read(new File(url1));
            _image = img;
//            text_saltpepper.setEnabled(false);
            setOriginalImage();
            CheckGray cg = new CheckGray();
            if(cg.checkImage(img) == true){
                
                rd_grayscale.setSelected(true);
                rd_color.setEnabled(false);
            }
            else{
                rd_color.setEnabled(true);
                rd_color.setSelected(true);
            }
//            setProcessImage();
        } catch (IOException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btOpenActionPerformed

    private void bt_spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_spActionPerformed
        _image = img;
        if(rd_grayscale.isSelected()){
            Grayscale gr = new Grayscale();
            _image = gr.GrayImage(_image);
        }
        String sp = text_saltpepper.getText();
        try{
            _sp = Integer.parseInt(sp);
            AddSaltPepper n = new AddSaltPepper();
            _image = n.Add_saltpepper(_image,  _sp);
            setOriginalImage();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_spActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btSave;
    private javax.swing.JButton bt_sp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lb_anhgoc;
    private javax.swing.JLabel lb_anhxuly;
    private javax.swing.JLabel lb_time;
    private javax.swing.JRadioButton rd_color;
    private javax.swing.JRadioButton rd_grayscale;
    private javax.swing.JTextField text_repeat;
    private javax.swing.JTextField text_saltpepper;
    private javax.swing.JTextField text_size;
    // End of variables declaration//GEN-END:variables
  
    class MyFileFilter extends FileFilter
    {

        @Override
        public boolean accept(File f) {
            if(f.isDirectory()==true)
                return true;
            if(f.getName().endsWith(".png")||f.getName().endsWith(".jpg")||f.getName().endsWith(".bmp")||f.getName().endsWith(".gif"))
                return true;
            return false;
        }

        @Override
        public String getDescription() {
            return "*.png,*.jpg,*.bmp,*.gif";
            }
        
    }
    
}