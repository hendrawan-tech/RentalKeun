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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rentalmobil.Login;

/**
 *
 * @author tohsaka
 */
public class Detail extends javax.swing.JFrame {
    
    public static String id_user = Functions.get_id_user();
    public static String id_mobil;
    public static String id_promo = null;
    public static String id_payment = null;
    public static int harga_sewa;

    /**
     * Creates new form Payment
     */
    public Detail() {
        if (Functions.get_email() == null) {
            JOptionPane.showMessageDialog(null, "Anda harus login terlebih dahulu!");
            System.exit(0);
        } else {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setResizable(false);
        }
    }
    
    public Detail(String idMobil) throws SQLException {
        if (Functions.get_email() == null) {
            JOptionPane.showMessageDialog(null, "Anda harus login terlebih dahulu!");
            System.exit(0);
        } else {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            getDataMobil(idMobil);
            getDataBank();
        }
    }
    
    public void getDataMobil(String idMobil) throws SQLException {
        try {
            String query = "SELECT * FROM mobil WHERE id_mobil=" + idMobil;
            Connection conn = (Connection) Functions.configDB();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);
            if (res.next()) {
                Image icon = new ImageIcon(this.getClass().getResource(res.getString("gambar"))).getImage();
                Image image = icon.getScaledInstance(gambarMobil.getWidth(), gambarMobil.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic = new ImageIcon(image);
                gambarMobil.setIcon(ic);
                
                namaMobil.setText(res.getString("nama_mobil"));
                hargaMobil.setText("Rp. " + res.getString("harga_sewa"));
                platMobil.setText(res.getString("no_polisi"));
                merkMobil.setText(res.getString("merk"));
                deskripsi.setText(res.getString("deskripsi"));
                // yyyy-MM-dd
                
                id_mobil = res.getString("id_mobil");
                harga_sewa = Integer.parseInt(res.getString("harga_sewa"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error : " + e);
        }
    }
    
    public void getDataBank() {
        try {
            String query = "SELECT * FROM payments WHERE nama_bank='" + paymentComboBox.getSelectedItem().toString() + "'";
            Connection conn = (Connection) Functions.configDB();
            PreparedStatement pst = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                id_payment = res.getString("id_payment");
            }
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
        gambarMobil = new javax.swing.JLabel();
        namaMobil = new javax.swing.JLabel();
        hargaMobil = new javax.swing.JLabel();
        platMobil = new javax.swing.JLabel();
        merkMobil = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        paymentComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rentalBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tanggalSewa = new com.toedter.calendar.JDateChooser();
        tanggalKembali = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detail - Rentalkeun");

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
        transaksiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiBtnActionPerformed(evt);
            }
        });

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
                            .addComponent(listMobilBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(18, 18, 18)
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

        gambarMobil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        namaMobil.setFont(new java.awt.Font("SF Pro Display Medium", 1, 18)); // NOI18N
        namaMobil.setText("Nama Mobil");

        hargaMobil.setText("Harga Sewa");

        platMobil.setText("Nomor Polisi");

        merkMobil.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        merkMobil.setText("Merk");

        deskripsi.setEditable(false);
        deskripsi.setColumns(20);
        deskripsi.setRows(5);
        deskripsi.setText("Deskripsi Mobil");
        jScrollPane2.setViewportView(deskripsi);

        jLabel1.setText("Tanggal Sewa");

        paymentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BCA", "BNI" }));

        jLabel4.setText("Payment");

        jLabel5.setText("Tanggal Kembali");

        rentalBtn.setBackground(new java.awt.Color(0, 178, 255));
        rentalBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        rentalBtn.setForeground(new java.awt.Color(255, 255, 255));
        rentalBtn.setText("Rental");
        rentalBtn.setBorderPainted(false);
        rentalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SF Pro Display Medium", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Detail Mobil");

        tanggalSewa.setDateFormatString("dd-MM-yyyy");

        tanggalKembali.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(namaMobil)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(hargaMobil)
                        .addGap(163, 163, 163)
                        .addComponent(platMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(merkMobil))
                    .addComponent(gambarMobil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(tanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rentalBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(paymentComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 108, Short.MAX_VALUE)))
                    .addComponent(jSeparator1))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gambarMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(namaMobil)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaMobil)
                    .addComponent(platMobil)
                    .addComponent(merkMobil))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paymentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(rentalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
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
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profileBtnActionPerformed

    private void listMobilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMobilBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ListMobil().setVisible(true);
    }//GEN-LAST:event_listMobilBtnActionPerformed

    private void berandaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_berandaBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Beranda().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_berandaBtnActionPerformed

    private void rentalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalBtnActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
        String tglSewa = dateFor.format(tanggalSewa.getDate());
        String tglKembali = dateFor.format(tanggalKembali.getDate());
        String[] tglSewaArr = dateFor.format(tanggalSewa.getDate()).split("-");
        String[] tglKembaliArr = dateFor.format(tanggalKembali.getDate()).split("-");
        
        LocalDate fromDate = LocalDate.of(Integer.parseInt(tglSewaArr[0]), Integer.parseInt(tglSewaArr[1]), Integer.parseInt(tglSewaArr[2]));
        LocalDate toDate = LocalDate.of(Integer.parseInt(tglKembaliArr[0]), Integer.parseInt(tglKembaliArr[1]), Integer.parseInt(tglKembaliArr[2]));
        int days = (int) (ChronoUnit.DAYS.between(fromDate, toDate));
        
        int nilaiDp = (harga_sewa * (days + 1)) / 2;
        int denda = 0;
        int total = harga_sewa * (days + 1);
        String dp = Integer.toString(nilaiDp);

        // Generate angka random untuk id order
        int min = 100000;
        int max = 999999;
        int random = (int) (Math.random() * (max - min + 1) + min);
        String id_order = "OR" + Integer.toString(random);
        try {
            String query = "INSERT INTO orders (id_order, id_user, id_mobil, id_payment, tanggal_penyewaan, tanggal_pengembalian,"
                    + "dp, total, status) VALUES ('" + id_order + "'," + id_user + "," + id_mobil + "," + id_payment + ","
                    + "'" + tglSewa + "','" + tglKembali + "'," + dp + "," + total + ",'DP')";
            String query2 = "SELECT * FROM user_meta um WHERE um.user_id = " + Functions.get_id_user();
            Connection conn = (Connection) Functions.configDB();
            PreparedStatement pst = conn.prepareStatement(query);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query2);
            if (res.next()) {
                pst.execute();
                JOptionPane.showMessageDialog(null, "Berhasil memilih mobil, silahkan untuk membayar uang DP nya ^-^, ");
                this.setVisible(false);
                new Transaksi().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Silahkan lengkapi data diri anda untuk melakukan transaksi!");
                this.setVisible(false);
                new Profile().setVisible(true);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error : " + e);
        }
    }//GEN-LAST:event_rentalBtnActionPerformed

    private void transaksiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Transaksi().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_transaksiBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton berandaBtn;
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JLabel gambarMobil;
    private javax.swing.JLabel hargaMobil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton listMobilBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel merkMobil;
    private javax.swing.JLabel namaMobil;
    private javax.swing.JComboBox<String> paymentComboBox;
    private javax.swing.JLabel platMobil;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton promoBtn;
    private javax.swing.JButton rentalBtn;
    private com.toedter.calendar.JDateChooser tanggalKembali;
    private com.toedter.calendar.JDateChooser tanggalSewa;
    private javax.swing.JButton transaksiBtn;
    // End of variables declaration//GEN-END:variables
}
