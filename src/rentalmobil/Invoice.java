/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentalmobil;

import dashboard.*;
import java.awt.Image;
import utils.Functions;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rentalmobil.Login;

/**
 *
 * @author tohsaka
 */
public class Invoice extends javax.swing.JFrame {
    
    public static String idMobil;

    /**
     * Creates new form Payment
     */
    
    public Invoice() {
//        if (Functions.get_email() == null) {
//            JOptionPane.showMessageDialog(null, "Anda harus login terlebih dahulu!");
//            System.exit(0);
//        } else {
            initComponents();
            System.out.println();
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        berandaBtn = new javax.swing.JButton();
        promoBtn = new javax.swing.JButton();
        transaksiBtn = new javax.swing.JButton();
        profileBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        listMobilBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namaMember = new javax.swing.JLabel();
        noOrder = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        noTelp = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        rekening = new javax.swing.JLabel();
        noRek = new javax.swing.JLabel();
        alamat1 = new javax.swing.JLabel();
        alamat2 = new javax.swing.JLabel();
        alamat3 = new javax.swing.JLabel();
        alamat4 = new javax.swing.JLabel();
        alamat5 = new javax.swing.JLabel();
        alamat6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Invoice - Rentalkeun Dashboard");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 178, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_logo.png"))); // NOI18N

        berandaBtn.setBackground(new java.awt.Color(76, 196, 255));
        berandaBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        berandaBtn.setForeground(new java.awt.Color(255, 255, 255));
        berandaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_home.png"))); // NOI18N
        berandaBtn.setText("Beranda");
        berandaBtn.setBorderPainted(false);
        berandaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        berandaBtn.setIconTextGap(10);

        promoBtn.setBackground(new java.awt.Color(76, 196, 255));
        promoBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        promoBtn.setForeground(new java.awt.Color(255, 255, 255));
        promoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_discount.png"))); // NOI18N
        promoBtn.setText("Promo");
        promoBtn.setBorderPainted(false);
        promoBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        promoBtn.setIconTextGap(10);
        promoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promoBtnActionPerformed(evt);
            }
        });

        transaksiBtn.setBackground(new java.awt.Color(76, 196, 255));
        transaksiBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        transaksiBtn.setForeground(new java.awt.Color(255, 255, 255));
        transaksiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_payment.png"))); // NOI18N
        transaksiBtn.setText("Transaksi");
        transaksiBtn.setBorderPainted(false);
        transaksiBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transaksiBtn.setIconTextGap(10);

        profileBtn.setBackground(new java.awt.Color(76, 196, 255));
        profileBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(255, 255, 255));
        profileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_user.png"))); // NOI18N
        profileBtn.setText("Profile");
        profileBtn.setBorderPainted(false);
        profileBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        profileBtn.setIconTextGap(10);
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(0, 0, 0));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_exit.png"))); // NOI18N
        logoutBtn.setText("Log Out");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutBtn.setIconTextGap(10);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_info.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        listMobilBtn.setBackground(new java.awt.Color(76, 196, 255));
        listMobilBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        listMobilBtn.setForeground(new java.awt.Color(255, 255, 255));
        listMobilBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_car.png"))); // NOI18N
        listMobilBtn.setText("List Mobil");
        listMobilBtn.setBorderPainted(false);
        listMobilBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listMobilBtn.setIconTextGap(10);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(promoBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transaksiBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profileBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(berandaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(listMobilBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(berandaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listMobilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(promoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(transaksiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("SF Pro Display Medium", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("RentalKeun");

        jLabel4.setFont(new java.awt.Font("SF Pro Display Medium", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Invoice");

        namaMember.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        namaMember.setForeground(new java.awt.Color(51, 51, 51));
        namaMember.setText("Nama Member");

        noOrder.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        noOrder.setForeground(new java.awt.Color(51, 51, 51));
        noOrder.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        noOrder.setText("No Order");

        email.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        email.setForeground(new java.awt.Color(51, 51, 51));
        email.setText("Email");

        tanggal.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        tanggal.setForeground(new java.awt.Color(51, 51, 51));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tanggal.setText("Tanggal");

        noTelp.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        noTelp.setForeground(new java.awt.Color(51, 51, 51));
        noTelp.setText("No Telp");

        alamat.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat.setForeground(new java.awt.Color(51, 51, 51));
        alamat.setText("Alamat");

        rekening.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        rekening.setForeground(new java.awt.Color(51, 51, 51));
        rekening.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        rekening.setText("Rekening");

        noRek.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        noRek.setForeground(new java.awt.Color(51, 51, 51));
        noRek.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        noRek.setText("No Rek");

        alamat1.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat1.setForeground(new java.awt.Color(51, 51, 51));
        alamat1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat1.setText("DP :");

        alamat2.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat2.setForeground(new java.awt.Color(51, 51, 51));
        alamat2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat2.setText("Denda :");

        alamat3.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat3.setForeground(new java.awt.Color(204, 204, 0));
        alamat3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat3.setText("Subtotal :");

        alamat4.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat4.setForeground(new java.awt.Color(51, 51, 51));
        alamat4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat4.setText("Nominal");

        alamat5.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat5.setForeground(new java.awt.Color(51, 51, 51));
        alamat5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat5.setText("Nominal");

        alamat6.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat6.setForeground(new java.awt.Color(204, 204, 0));
        alamat6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat6.setText("Nominal");

        jButton1.setBackground(new java.awt.Color(0, 178, 255));
        jButton1.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BUKTI BAYAR DP");
        jButton1.setBorderPainted(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(alamat3)
                                .addComponent(alamat2)
                                .addComponent(alamat1))
                            .addGap(44, 44, 44)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(alamat4)
                                .addComponent(alamat5)
                                .addComponent(alamat6)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(alamat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(noRek))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(noTelp)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rekening))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(email)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tanggal))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(namaMember)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(noOrder))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaMember)
                    .addComponent(noOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(tanggal))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noTelp)
                    .addComponent(rekening))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat)
                    .addComponent(noRek))
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat1)
                    .addComponent(alamat4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat2)
                    .addComponent(alamat5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat3)
                    .addComponent(alamat6))
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        Functions.set_email(null);
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void promoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promoBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Promo().setVisible(true);
    }//GEN-LAST:event_promoBtnActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Info().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Profile().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profileBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel alamat1;
    private javax.swing.JLabel alamat2;
    private javax.swing.JLabel alamat3;
    private javax.swing.JLabel alamat4;
    private javax.swing.JLabel alamat5;
    private javax.swing.JLabel alamat6;
    private javax.swing.JButton berandaBtn;
    private javax.swing.JLabel email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton listMobilBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel namaMember;
    private javax.swing.JLabel noOrder;
    private javax.swing.JLabel noRek;
    private javax.swing.JLabel noTelp;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton promoBtn;
    private javax.swing.JLabel rekening;
    private javax.swing.JLabel tanggal;
    private javax.swing.JButton transaksiBtn;
    // End of variables declaration//GEN-END:variables
}
