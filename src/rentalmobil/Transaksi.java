/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentalmobil;

import dashboard.*;
import java.awt.Image;
import utils.Functions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rentalmobil.Login;

/**
 *
 * @author tohsaka
 */
public class Transaksi extends javax.swing.JFrame {
    
    public static String idMobil;

    /**
     * Creates new form Payment
     */
    
    public Transaksi() throws SQLException {
        if (Functions.get_email() == null) {
            JOptionPane.showMessageDialog(null, "Anda harus login terlebih dahulu!");
            System.exit(0);
        } else {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            getDataTransaksi(Functions.get_id_user());
        }
    }
    
    private void getDataTransaksi(String user_id) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("Id Order");
        model.addColumn("Nama Mobil");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Status");
        model.addColumn("Gambar");
        
        String query = "SELECT * FROM orders o, mobil m WHERE o.id_mobil = m.id_mobil AND o.id_user=" + user_id;
        Connection conn = (Connection)Functions.configDB();
        int no = 1;
        try {
            PreparedStatement pst = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                model.addRow(new Object[]{no++, res.getString("id_order"), res.getString("nama_mobil"), res.getString("created_at"),
                    res.getString("status"), res.getString("gambar")});
            }
            res.first();
            tabelTransaksi.setModel(model);
            Functions.set_id_order(res.getString("id_order"));
            namaMobil.setText(res.getString("nama_mobil"));
            tanggal.setText(res.getString("created_at"));
            status.setText("Status : " + res.getString("status"));
            path.setText(res.getString("gambar"));
            Image icon = new ImageIcon(this.getClass().getResource(path.getText())).getImage();
            Image image = icon.getScaledInstance(269, 175, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            picMobil.setIcon(ic);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error : " + e);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        picMobil = new javax.swing.JLabel();
        namaMobil = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        invoiceButton = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        path = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi - Rentalkeun");

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
        berandaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                berandaBtnActionPerformed(evt);
            }
        });

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
        listMobilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listMobilBtnActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("SF Pro Display Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Transaksi");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        picMobil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        namaMobil.setFont(new java.awt.Font("SF Pro Display Medium", 1, 18)); // NOI18N
        namaMobil.setForeground(new java.awt.Color(51, 51, 51));
        namaMobil.setText("Nama Mobil");

        tanggal.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        tanggal.setForeground(new java.awt.Color(51, 51, 51));
        tanggal.setText("Tanggal");

        invoiceButton.setBackground(new java.awt.Color(0, 178, 255));
        invoiceButton.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        invoiceButton.setForeground(new java.awt.Color(255, 255, 255));
        invoiceButton.setText("Invoice");
        invoiceButton.setBorderPainted(false);
        invoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceButtonActionPerformed(evt);
            }
        });

        status.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        status.setForeground(new java.awt.Color(51, 51, 51));
        status.setText("Status : ");

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelTransaksi);

        path.setForeground(new java.awt.Color(255, 255, 255));
        path.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(picMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaMobil)
                                    .addComponent(tanggal)
                                    .addComponent(status)
                                    .addComponent(path)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(invoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(picMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(namaMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(path)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
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
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profileBtnActionPerformed

    private void berandaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_berandaBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Beranda().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_berandaBtnActionPerformed

    private void listMobilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMobilBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ListMobil().setVisible(true);
    }//GEN-LAST:event_listMobilBtnActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
        int baris = tabelTransaksi.rowAtPoint(evt.getPoint());
        if (tabelTransaksi.getValueAt(baris, 1).toString() == null) {
            Functions.set_id_order(null);
        } else {
            Functions.set_id_order(tabelTransaksi.getValueAt(baris, 1).toString());
        }
        if (tabelTransaksi.getValueAt(baris, 2).toString() == null) {
            namaMobil.setText("");
        } else {
            namaMobil.setText(tabelTransaksi.getValueAt(baris, 2).toString());
        }
        if (tabelTransaksi.getValueAt(baris, 3).toString() == null) {
            tanggal.setText("");
        } else {
            tanggal.setText(tabelTransaksi.getValueAt(baris, 3).toString());
        }
        if (tabelTransaksi.getValueAt(baris, 4).toString() == null) {
            status.setText("");
        } else {
            status.setText("Status : " + tabelTransaksi.getValueAt(baris, 4).toString());
        }
        if (tabelTransaksi.getValueAt(baris, 5).toString() == null) {
            picMobil.setIcon(null);
        } else {
            path.setText(tabelTransaksi.getValueAt(baris, 5).toString());
            Image icon = new ImageIcon(this.getClass().getResource(path.getText())).getImage();
            Image image = icon.getScaledInstance(269, 175, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            picMobil.setIcon(ic);
        }
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void invoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Invoice().setVisible(true);
    }//GEN-LAST:event_invoiceButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Transaksi().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton berandaBtn;
    private javax.swing.JButton invoiceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton listMobilBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel namaMobil;
    private javax.swing.JLabel path;
    private javax.swing.JLabel picMobil;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton promoBtn;
    private javax.swing.JLabel status;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JLabel tanggal;
    private javax.swing.JButton transaksiBtn;
    // End of variables declaration//GEN-END:variables
}
