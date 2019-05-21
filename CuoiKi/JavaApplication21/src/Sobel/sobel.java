/*
 * Update: 21:55 24/9/2015
 * 
 * 
 */
package Sobel;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dao Trung Duyet
 */
public class sobel extends javax.swing.JFrame {

    BufferedImage anhGoc = null;
    BufferedImage bi_anhSobel = null;
    BufferedImage anhXam = null;
    private boolean iscolor = true;
    int Gx[][] = new int[3][3];
    int Gy[][] = new int[3][3];

    public sobel() {
        initComponents();
    }

    private void getGxGy() {
        Gx[0][0] = Integer.parseInt(x11.getText());
        Gx[0][1] = Integer.parseInt(x12.getText());
        Gx[0][2] = Integer.parseInt(x13.getText());
        Gx[1][0] = Integer.parseInt(x21.getText());
        Gx[1][1] = Integer.parseInt(x22.getText());
        Gx[1][2] = Integer.parseInt(x23.getText());
        Gx[2][0] = Integer.parseInt(x31.getText());
        Gx[2][1] = Integer.parseInt(x32.getText());
        Gx[2][2] = Integer.parseInt(x33.getText());

        Gy[0][0] = Integer.parseInt(y11.getText());
        Gy[0][1] = Integer.parseInt(y12.getText());
        Gy[0][2] = Integer.parseInt(y13.getText());
        Gy[1][0] = Integer.parseInt(y21.getText());
        Gy[1][1] = Integer.parseInt(y22.getText());
        Gy[1][2] = Integer.parseInt(y23.getText());
        Gy[2][0] = Integer.parseInt(y31.getText());
        Gy[2][1] = Integer.parseInt(y32.getText());
        Gy[2][2] = Integer.parseInt(y33.getText());
    }

    private void chuyenSangAnhXam() {
        anhXam = new BufferedImage(anhGoc.getWidth(), anhGoc.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int i, j;
        for (i = 0; i < this.anhGoc.getWidth(); i++) {
            for (j = 0; j < this.anhGoc.getHeight(); j++) {
                int pixel = this.anhGoc.getRGB(i, j);
                int alpha = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = (pixel) & 0xff;
                int trungBinh = (r + g + b) / 3;
                Color c = new Color(trungBinh, trungBinh, trungBinh, alpha);
                int k = c.getRGB();
                anhXam.setRGB(i, j, k);
            }
        }
    }

    public class ThreadForProgressBar extends Thread {

        private int maxValue;

        ThreadForProgressBar(int m) {
            maxValue = m;
            prob_progressbar.setMaximum(maxValue);
            prob_progressbar.setMinimum(0);
            prob_progressbar.setValue(0);
        }

        public void setValueForProgressBar(int i) {
            prob_progressbar.setValue(i);
        }

        @Override
        public void run() {
            prob_progressbar.setStringPainted(true);    //hien thi ti le tren thanh progress
        }
    }

    public class CreatePictureThread extends Thread {

        BufferedImage anh;

        public CreatePictureThread(BufferedImage bi) {
            anh = bi;
        }

        @Override
        public void run() {
            taoAnhMoi(anh);
        }
    }

    private void taoAnhMoi(BufferedImage anh) {
        // Khởi tạo thời gian bắt đầu
        long begin = Calendar.getInstance().getTimeInMillis();

        BufferedImage bi_anhGx = new BufferedImage(anh.getWidth(), anh.getHeight(), BufferedImage.TYPE_INT_ARGB);
        BufferedImage bi_anhGy = new BufferedImage(anh.getWidth(), anh.getHeight(), BufferedImage.TYPE_INT_ARGB);
        bi_anhSobel = new BufferedImage(anh.getWidth(), anh.getHeight(), BufferedImage.TYPE_INT_ARGB);

        int width = anh.getWidth();
        int height = anh.getHeight();
        int proMax = width * height;    //tinh so diem anh de tim maximum cua progress bar

        ThreadForProgressBar threadForProgressBar = new ThreadForProgressBar(proMax);
        threadForProgressBar.start();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                threadForProgressBar.setValueForProgressBar(i * width + j);  //tang gia tri cua thanh progress

                int diemAnh_Gx[] = new int[4];    //4 phần tử để lưu red, green, blue, alpha.
                int diemAnh_Gy[] = new int[4];
                int diemAnh_Sobel[] = new int[4];
                int alpha = 255;

                int k, m, n;
                for (k = -1; k <= 1; k++) {
                    for (m = -1; m <= 1; m++) {
                        if (i + m < 0 || j + k < 0 || i + m > width - 1 || j + k > height - 1) {
                            break;
                        }
                        int pi = anh.getRGB(i + m, j + k);
                        alpha = (pi >> 24) & 0xff;
                        int r = (pi >> 16) & 0xff;
                        int g = (pi >> 8) & 0xff;
                        int b = (pi) & 0xff;
                        //System.out.println(pi);
                        diemAnh_Gx[0] += Gx[k + 1][m + 1] * r;
                        diemAnh_Gx[1] += Gx[k + 1][m + 1] * g;
                        diemAnh_Gx[2] += Gx[k + 1][m + 1] * b;
                        // diemAnh_Gx[3] = alpha;

                        diemAnh_Gy[0] += Gy[k + 1][m + 1] * r;
                        diemAnh_Gy[1] += Gy[k + 1][m + 1] * g;
                        diemAnh_Gy[2] += Gy[k + 1][m + 1] * b;
                        //  diemAnh_Gy[3] = alpha;
                    }
                }
                for (n = 0; n < 3; n++) //xet tren 3 kenh mau
                {
                    //neu mau nho hon 0 hoac lon hon 255
                    if (diemAnh_Gx[n] < 0) {
                        diemAnh_Gx[n] = 0;
                    }
                    if (diemAnh_Gx[n] > 255) {
                        diemAnh_Gx[n] = 255;
                    }
                    if (diemAnh_Gy[n] < 0) {
                        diemAnh_Gy[n] = 0;
                    }
                    if (diemAnh_Gy[n] > 255) {
                        diemAnh_Gy[n] = 255;
                    }
                    //cong 2 ma tran lai
                    diemAnh_Sobel[n] = diemAnh_Gx[n] + diemAnh_Gy[n];
                    //xet lai gia tri cho ma tran sobel
                    if (diemAnh_Sobel[n] < 0) {
                        diemAnh_Sobel[n] = 0;
                    }
                    if (diemAnh_Sobel[n] > 255) {
                        diemAnh_Sobel[n] = 255;
                    }
                    //truong hop anh xam
                    if (iscolor == false) {
                        int threshold = Integer.parseInt(tf_Threshold.getText());
                        if (diemAnh_Gx[n] < threshold) //xu ly cho Gx
                        {
                            diemAnh_Gx[n] = 0;
                        } else {
                            diemAnh_Gx[n] = 255;
                        }
                        if (diemAnh_Gy[n] < threshold) //xu ly cho Gy
                        {
                            diemAnh_Gy[n] = 0;
                        } else {
                            diemAnh_Gy[n] = 255;
                        }
                        if (diemAnh_Sobel[n] < threshold) //xu ly cho Sobel
                        {
                            diemAnh_Sobel[n] = 0;
                        } else {
                            diemAnh_Sobel[n] = 255;
                        }
                    }
                }
                //sau khi xu ly xong thi bo vao anh
                //Gx
                Color cx = new Color(diemAnh_Gx[0], diemAnh_Gx[1], diemAnh_Gx[2], alpha);
                int tx = cx.getRGB();
                bi_anhGx.setRGB(i, j, tx);
                //Gy
                Color cy = new Color(diemAnh_Gy[0], diemAnh_Gy[1], diemAnh_Gy[2], alpha);
                int ty = cy.getRGB();
                bi_anhGy.setRGB(i, j, ty);
                //sobel
                Color cs = new Color(diemAnh_Sobel[0], diemAnh_Sobel[1], diemAnh_Sobel[2], alpha);
                int ts = cs.getRGB();
                bi_anhSobel.setRGB(i, j, ts);

            }
        }
        //set anh vao cac label
        Image anhGx = bi_anhGx.getScaledInstance(lb_anhGx.getWidth(), lb_anhGx.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ix = new ImageIcon(anhGx);
        lb_anhGx.setIcon(ix);

        Image anhGy = bi_anhGy.getScaledInstance(lb_anhGy.getWidth(), lb_anhGy.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iy = new ImageIcon(anhGy);
        lb_anhGy.setIcon(iy);

        Image sobel = bi_anhSobel.getScaledInstance(lb_anhSobel.getWidth(), lb_anhSobel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon is = new ImageIcon(sobel);
        lb_anhSobel.setIcon(is);
        threadForProgressBar.setValueForProgressBar(proMax); //set gia tri progress bar ve max de tranh sai so
        threadForProgressBar.stop();

        // thời gian kết thúc
        long end = Calendar.getInstance().getTimeInMillis();
        long thoiGianChay = end - begin;
        String st = String.valueOf(thoiGianChay);
        tf_time.setText(st);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        lb_anhGoc = new javax.swing.JLabel();
        lb_anhSobel = new javax.swing.JLabel();
        lb_anhGx = new javax.swing.JLabel();
        lb_anhGy = new javax.swing.JLabel();
        bt_EdgeDet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bt_save = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        x11 = new javax.swing.JTextField();
        x12 = new javax.swing.JTextField();
        x13 = new javax.swing.JTextField();
        x21 = new javax.swing.JTextField();
        x22 = new javax.swing.JTextField();
        x23 = new javax.swing.JTextField();
        x31 = new javax.swing.JTextField();
        x32 = new javax.swing.JTextField();
        x33 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        y11 = new javax.swing.JTextField();
        y12 = new javax.swing.JTextField();
        y13 = new javax.swing.JTextField();
        y23 = new javax.swing.JTextField();
        y22 = new javax.swing.JTextField();
        y21 = new javax.swing.JTextField();
        y31 = new javax.swing.JTextField();
        y32 = new javax.swing.JTextField();
        y33 = new javax.swing.JTextField();
        lb_Threshold = new javax.swing.JLabel();
        tf_Threshold = new javax.swing.JTextField();
        radioButtonColor = new javax.swing.JRadioButton();
        radioButtonGrayscale = new javax.swing.JRadioButton();
        prob_progressbar = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        tf_time = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mn_file = new javax.swing.JMenu();
        bt_load = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                form_load(evt);
            }
        });

        lb_anhGoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_anhSobel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_anhGx.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lb_anhGy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bt_EdgeDet.setText("Edge Detect");
        bt_EdgeDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EdgeDetActionPerformed(evt);
            }
        });

        jLabel1.setText("Ảnh Gốc:");

        jLabel2.setText("Ảnh Sobel:");

        jLabel3.setText("Ảnh Gx");

        jLabel4.setText("Ảnh Gy");

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        jLabel5.setText("Gx");

        x11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x11.setText("-1");

        x12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x12.setText("-2");

        x13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x13.setText("-1");

        x21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x21.setText("0");

        x22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x22.setText("0");

        x23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x23.setText("0");

        x31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x31.setText("1");

        x32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x32.setText("2");

        x33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x33.setText("1");

        jLabel6.setText("Gy");

        y11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y11.setText("-1");

        y12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y12.setText("0");

        y13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y13.setText("1");

        y23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y23.setText("2");

        y22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y22.setText("0");

        y21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y21.setText("-2");

        y31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y31.setText("-1");

        y32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y32.setText("0");

        y33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        y33.setText("1");

        lb_Threshold.setText("Threshold:");

        tf_Threshold.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_Threshold.setText("175");

        radioButtonColor.setText("Color");
        radioButtonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonColorActionPerformed(evt);
            }
        });

        radioButtonGrayscale.setText("Grayscale");
        radioButtonGrayscale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonGrayscaleActionPerformed(evt);
            }
        });

        jLabel7.setText("Executed Time:");

        jLabel8.setText("ms");

        mn_file.setText("File");

        bt_load.setText("Load");
        bt_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loadActionPerformed(evt);
            }
        });
        mn_file.add(bt_load);

        jMenuBar1.add(mn_file);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_anhGoc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(lb_anhGx, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_EdgeDet)
                            .addComponent(radioButtonColor)
                            .addComponent(radioButtonGrayscale)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(x11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lb_Threshold)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_Threshold, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(x31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(x21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(y21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(y22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(y23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(y11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(y12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(y13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(y31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(y32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(y33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_save, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_time, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lb_anhGy, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_anhSobel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(prob_progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_anhGoc, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_anhGx, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_anhSobel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_anhGy, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_EdgeDet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioButtonGrayscale)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_Threshold, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_Threshold))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(x11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(x21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(x31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(x33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(y11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(y12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(y13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(y21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(y22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(y23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(y31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(y32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(y33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(bt_save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_time, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(10, 10, 10)
                .addComponent(prob_progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loadActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Open a File");
        // ImageFileFilter là lớp mình tạo ra để lọc các file ảnh
        chooser.setFileFilter(new locFileAnh());
        chooser.showOpenDialog(null);
        String location;
        if (chooser.getSelectedFile() != null) {
            File f = chooser.getSelectedFile();
            location = f.getAbsolutePath();

            try {
                anhGoc = ImageIO.read(new File(location));
            } catch (IOException ex) {
                Logger.getLogger(sobel.class.getName()).log(Level.SEVERE, null, ex);
            }

            // scale lại kích thước cho phù hợp với label
            Image dimg = anhGoc.getScaledInstance(lb_anhGoc.getWidth(), lb_anhGoc.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            lb_anhGoc.setIcon(imageIcon);
        }


    }//GEN-LAST:event_bt_loadActionPerformed

    private void bt_EdgeDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EdgeDetActionPerformed

        if (anhGoc == null) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn ảnh!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        } else {
            if (radioButtonGrayscale.isSelected() == true) {
                chuyenSangAnhXam();
                iscolor = false;
                getGxGy();
                CreatePictureThread cpt = new CreatePictureThread(anhXam);
                cpt.start();
            } else {
                iscolor = true;
                getGxGy();
                CreatePictureThread cpt = new CreatePictureThread(anhGoc);
                cpt.start();

            }

        }
    }//GEN-LAST:event_bt_EdgeDetActionPerformed

    private void form_load(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_form_load
        // TODO add your handling code here:
        beforeProcessing();

    }//GEN-LAST:event_form_load

    private void radioButtonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonColorActionPerformed
        // TODO add your handling code here:
        tf_Threshold.setEnabled(false);
    }//GEN-LAST:event_radioButtonColorActionPerformed

    private void radioButtonGrayscaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonGrayscaleActionPerformed
        // TODO add your handling code here:
        tf_Threshold.setEnabled(true);
    }//GEN-LAST:event_radioButtonGrayscaleActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        // TODO add your handling code here:
        if (bi_anhSobel == null) {
            JOptionPane.showMessageDialog(null, "Chưa có thông tin để lưu ảnh!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        } else {
            JFileChooser save = new JFileChooser();
            save.setFileFilter(new locFileAnh());
            save.setDialogTitle("Lưu ảnh");

            int result = save.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = save.getSelectedFile();

                String fileName = file.getName();
                // nếu không có phần mở rộng thì thêm vào đuôi png
                if (!(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".bmp"))) {
                    file = new File(file.getAbsolutePath() + ".png");
                }
                try {
                    ImageIO.write(bi_anhSobel, "png", file);
                } catch (IOException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void beforeProcessing() {
        buttonGroup.add(radioButtonColor);
        buttonGroup.add(radioButtonGrayscale);

        radioButtonColor.setSelected(true);
        tf_Threshold.setEnabled(false);

        tf_time.setEditable(false);
//        x11.setEditable(false);     //khong cho sua thong tin cua ma tran va
//        x12.setEditable(false);     //thoi gian hoat dong.
//        x13.setEditable(false);
//        x21.setEditable(false);
//        x22.setEditable(false);
//        x23.setEditable(false);
//        x31.setEditable(false);
//        x32.setEditable(false);
//        x33.setEditable(false);
//        y11.setEditable(false);
//        y12.setEditable(false);
//        y13.setEditable(false);
//        y21.setEditable(false);
//        y22.setEditable(false);
//        y23.setEditable(false);
//        y31.setEditable(false);
//        y32.setEditable(false);
//        y33.setEditable(false);
    }

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
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sobel().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_EdgeDet;
    private javax.swing.JMenuItem bt_load;
    private javax.swing.JButton bt_save;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lb_Threshold;
    private javax.swing.JLabel lb_anhGoc;
    private javax.swing.JLabel lb_anhGx;
    private javax.swing.JLabel lb_anhGy;
    private javax.swing.JLabel lb_anhSobel;
    private javax.swing.JMenu mn_file;
    private javax.swing.JProgressBar prob_progressbar;
    private javax.swing.JRadioButton radioButtonColor;
    private javax.swing.JRadioButton radioButtonGrayscale;
    private javax.swing.JTextField tf_Threshold;
    private javax.swing.JTextField tf_time;
    private javax.swing.JTextField x11;
    private javax.swing.JTextField x12;
    private javax.swing.JTextField x13;
    private javax.swing.JTextField x21;
    private javax.swing.JTextField x22;
    private javax.swing.JTextField x23;
    private javax.swing.JTextField x31;
    private javax.swing.JTextField x32;
    private javax.swing.JTextField x33;
    private javax.swing.JTextField y11;
    private javax.swing.JTextField y12;
    private javax.swing.JTextField y13;
    private javax.swing.JTextField y21;
    private javax.swing.JTextField y22;
    private javax.swing.JTextField y23;
    private javax.swing.JTextField y31;
    private javax.swing.JTextField y32;
    private javax.swing.JTextField y33;
    // End of variables declaration//GEN-END:variables
}
