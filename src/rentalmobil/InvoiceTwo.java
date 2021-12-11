/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentalmobil;

import dashboard.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import utils.Functions;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static rentalmobil.ListMobil.idMobil;

/**
 *
 * @author tohsaka
 */
public class InvoiceTwo extends javax.swing.JFrame {

    public static String idMobil;
    public static File pathBuktiTransfer;

    /**
     * Creates new form Payment
     */
    public InvoiceTwo() {
        if (Functions.get_email() == null) {
            JOptionPane.showMessageDialog(null, "Anda harus login terlebih dahulu!");
            new Login().setVisible(true);
        } else {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setResizable(true);
            getDataInvoice(Functions.get_id_order());
            getOrderItem(Functions.get_id_order());
            getDenda();
        }
    }

    public void getDenda() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Denda");
        model.addColumn("Gambar");
        model.addColumn("Harga Denda");

        String query = "SELECT * FROM denda WHERE order_id = '" + Functions.get_id_order() + "'";

        try {
            Connection conn = (Connection) Functions.configDB();
            PreparedStatement pst = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                model.addRow(new Object[]{res.getString("nama_denda"), res.getString("foto_bukti"), res.getString("harga_denda")});
            }
            if (res.first()) {
                jTable1.setModel(model);
                pathDenda.setText(res.getString("foto_bukti"));
                Image icon = new ImageIcon(this.getClass().getResource(pathDenda.getText())).getImage();
                Image image = icon.getScaledInstance(306, 202, Image.SCALE_SMOOTH);
                ImageIcon ic = new ImageIcon(image);
                picDenda.setIcon(ic);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }

    private void getDataInvoice(String id_order) {
        try {
            String query = "SELECT * FROM orders o JOIN users u ON o.id_user = u.id_user JOIN payments p ON o.id_payment = p.id_payment "
                    + "JOIN mobil m ON o.id_mobil = m.id_mobil JOIN user_meta um ON o.id_user = um.user_id WHERE o.id_order = '" + id_order + "'";
            Connection conn = (Connection) Functions.configDB();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);
            if (res.next()) {
                namaMember.setText(res.getString("nama"));
                email.setText(res.getString("email"));
                noTelp.setText(res.getString("no_telepon"));
                alamat.setText(res.getString("alamat"));

                noOrder.setText("No. " + res.getString("id_order"));
                tanggal.setText("Tanggal : " + res.getString("created_at"));
                rekening.setText("Transfer : " + res.getString("p.nama"));
                noRek.setText("No Rek : " + res.getString("no_rekening"));

                namaMobil.setText(res.getString("nama_mobil"));
                noPolisi.setText(res.getString("no_polisi"));
                merkMobil.setText(res.getString("merk"));
                tanggalSewa.setText(res.getString("tanggal_penyewaan") + " - " + res.getString("tanggal_pengembalian"));
                hargaSewa.setText(res.getString("harga_sewa"));

                denda.setText(res.getString("total"));
                dp.setText(res.getString("dp"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error : " + e);
        }
    }

    private void getOrderItem(String id_order) {
        try {
            String query = "SELECT * FROM order_items WHERE order_id = '" + id_order + "' AND nama_bukti = 'Total'";
            Connection conn = (Connection) Functions.configDB();
            PreparedStatement pst = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                buktiTransfer.setText(res.getString("gambar_bukti"));
                Image icon = new ImageIcon(this.getClass().getResource(buktiTransfer.getText())).getImage();
                Image image = icon.getScaledInstance(306, 202, Image.SCALE_SMOOTH);
                ImageIcon ic = new ImageIcon(image);
                picBuktiTransfer.setIcon(ic);
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
        alamat2 = new javax.swing.JLabel();
        alamat3 = new javax.swing.JLabel();
        denda = new javax.swing.JLabel();
        dp = new javax.swing.JLabel();
        namaMobil = new javax.swing.JLabel();
        noPolisi = new javax.swing.JLabel();
        merkMobil = new javax.swing.JLabel();
        tanggalSewa = new javax.swing.JLabel();
        hargaSewa = new javax.swing.JLabel();
        panelPic = new javax.swing.JPanel();
        picDenda = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        pilihBtn = new javax.swing.JButton();
        simpanBtn = new javax.swing.JButton();
        hapusBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        picBuktiTransfer = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        buktiTransfer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        alamat4 = new javax.swing.JLabel();
        pathDenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Invoice - Rentalkeun");

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

        alamat2.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat2.setForeground(new java.awt.Color(51, 51, 51));
        alamat2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat2.setText("Denda :");

        alamat3.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat3.setForeground(new java.awt.Color(51, 51, 51));
        alamat3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat3.setText("DP :");

        denda.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        denda.setForeground(new java.awt.Color(51, 51, 51));
        denda.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        denda.setText("Nominal");

        dp.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        dp.setForeground(new java.awt.Color(51, 51, 51));
        dp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dp.setText("Nominal");

        namaMobil.setFont(new java.awt.Font("SF Pro Display Medium", 1, 24)); // NOI18N
        namaMobil.setForeground(new java.awt.Color(51, 51, 51));
        namaMobil.setText("Nama Mobil");

        noPolisi.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        noPolisi.setForeground(new java.awt.Color(51, 51, 51));
        noPolisi.setText("No. Polisi");

        merkMobil.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        merkMobil.setForeground(new java.awt.Color(51, 51, 51));
        merkMobil.setText("Merk Mobil");

        tanggalSewa.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        tanggalSewa.setForeground(new java.awt.Color(51, 51, 51));
        tanggalSewa.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tanggalSewa.setText("Tanggal Sewa");

        hargaSewa.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        hargaSewa.setForeground(new java.awt.Color(51, 51, 51));
        hargaSewa.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        hargaSewa.setText("Harga Sewa");

        javax.swing.GroupLayout panelPicLayout = new javax.swing.GroupLayout(panelPic);
        panelPic.setLayout(panelPicLayout);
        panelPicLayout.setHorizontalGroup(
            panelPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picDenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        panelPicLayout.setVerticalGroup(
            panelPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picDenda, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Denda");

        pilihBtn.setBackground(new java.awt.Color(0, 178, 255));
        pilihBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        pilihBtn.setForeground(new java.awt.Color(255, 255, 255));
        pilihBtn.setText("Pilih");
        pilihBtn.setBorderPainted(false);
        pilihBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihBtnActionPerformed(evt);
            }
        });

        simpanBtn.setBackground(new java.awt.Color(0, 178, 255));
        simpanBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        simpanBtn.setForeground(new java.awt.Color(255, 255, 255));
        simpanBtn.setText("Simpan");
        simpanBtn.setBorderPainted(false);
        simpanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtnActionPerformed(evt);
            }
        });

        hapusBtn.setBackground(new java.awt.Color(0, 178, 255));
        hapusBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        hapusBtn.setForeground(new java.awt.Color(255, 255, 255));
        hapusBtn.setText("Hapus");
        hapusBtn.setBorderPainted(false);
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picBuktiTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picBuktiTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Bukti Transfer");

        subtotal.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        subtotal.setForeground(new java.awt.Color(204, 204, 0));
        subtotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        subtotal.setText("Nominal");

        alamat4.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        alamat4.setForeground(new java.awt.Color(204, 204, 0));
        alamat4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        alamat4.setText("Subtotal :");

        pathDenda.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(alamat)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noRek))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(noTelp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rekening))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(email)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tanggal))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(namaMember)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noOrder))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(merkMobil)
                                .addComponent(noPolisi)
                                .addComponent(namaMobil))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hargaSewa, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tanggalSewa, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(panelPic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pathDenda)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(alamat3)
                                .addComponent(alamat2))
                            .addGap(44, 44, 44)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(denda)
                                .addComponent(dp)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(alamat4)
                            .addGap(44, 44, 44)
                            .addComponent(subtotal)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(pilihBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(simpanBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hapusBtn))
                                .addComponent(buktiTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12)))
                .addContainerGap(77, Short.MAX_VALUE))
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
                .addComponent(namaMobil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noPolisi)
                    .addComponent(tanggalSewa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(merkMobil)
                    .addComponent(hargaSewa))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pathDenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelPic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(buktiTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pilihBtn)
                            .addComponent(simpanBtn)
                            .addComponent(hapusBtn))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat3)
                    .addComponent(dp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat2)
                    .addComponent(denda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat4)
                    .addComponent(subtotal))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
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
            Logger.getLogger(InvoiceTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profileBtnActionPerformed

    private void berandaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_berandaBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Beranda().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_berandaBtnActionPerformed

    private void listMobilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMobilBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ListMobil().setVisible(true);
    }//GEN-LAST:event_listMobilBtnActionPerformed

    private void transaksiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Transaksi().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_transaksiBtnActionPerformed

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        // TODO add your handling code here:
        if (pathBuktiTransfer == null) {
            JOptionPane.showMessageDialog(null, "Anda belum memilih gambar!");
        } else {
            try {
                Files.delete(pathBuktiTransfer.toPath());
                buktiTransfer.setText(null);
                picDenda.setIcon(null);
                pathBuktiTransfer = null;
            } catch (IOException ex) {
                Logger.getLogger(Mobil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_hapusBtnActionPerformed

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
        if (buktiTransfer.getText().length() < 12) {
            simpanBtn.disable();
        } else {
            try {
                String query = "INSERT INTO order_items (order_id, gambar_bukti, nama_bukti) VALUES ('" + Functions.get_id_order() + "','" + buktiTransfer.getText() + "', 'Total')";
                Connection conn = (Connection) Functions.configDB();
                PreparedStatement pst = conn.prepareStatement(query);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Bukti transfer berhasil disimpan!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error : " + e);
            }
        }
    }//GEN-LAST:event_simpanBtnActionPerformed

    private void pilihBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihBtnActionPerformed
        // TODO add your handling code here:
        String filename;
        try {
            if (buktiTransfer.getText().length() > 3) {
                File dstFile = new File("src" + buktiTransfer.getText());
                Files.delete(dstFile.toPath());
            }
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            Image icon = ImageIO.read(file);
            Image image = icon.getScaledInstance(306, 202, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            picDenda.setIcon(ic);

            filename = file.getAbsolutePath();

            String newpath = "src/buktitf/";
            File directory = new File(newpath);
            if (!directory.exists()) {
                directory.mkdir();
            }

            File sourceFile = null;
            File destinationFile = null;

            String extension = filename.substring(filename.lastIndexOf('.') + 1);
            sourceFile = new File(filename);
            Date tanggal_update = new Date();
            String format_tanggal = "yyyyMMddhhmmss";
            SimpleDateFormat df = new SimpleDateFormat(format_tanggal);
            String tanggal = String.valueOf(df.format(tanggal_update));
            destinationFile = new File(newpath + "/buktitf-" + tanggal + "." + extension);
            pathBuktiTransfer = destinationFile;
            String destFile = destinationFile.toString();
            String[] iconPath = destFile.split("src");
            buktiTransfer.setText(iconPath[1]);
            Files.copy(sourceFile.toPath(), destinationFile.toPath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_pilihBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        if (jTable1.getValueAt(baris, 1) == null) {
            pathDenda.setText("");
        } else {
            pathDenda.setText(jTable1.getValueAt(baris, 1).toString());
            Image icon = new ImageIcon(this.getClass().getResource(pathDenda.getText())).getImage();
            Image image = icon.getScaledInstance(306, 202, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            picDenda.setIcon(ic);
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(InvoiceTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceTwo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel alamat2;
    private javax.swing.JLabel alamat3;
    private javax.swing.JLabel alamat4;
    private javax.swing.JButton berandaBtn;
    private javax.swing.JTextField buktiTransfer;
    private javax.swing.JLabel denda;
    private javax.swing.JLabel dp;
    private javax.swing.JLabel email;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JLabel hargaSewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listMobilBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel merkMobil;
    private javax.swing.JLabel namaMember;
    private javax.swing.JLabel namaMobil;
    private javax.swing.JLabel noOrder;
    private javax.swing.JLabel noPolisi;
    private javax.swing.JLabel noRek;
    private javax.swing.JLabel noTelp;
    private javax.swing.JPanel panelPic;
    private javax.swing.JLabel pathDenda;
    private javax.swing.JLabel picBuktiTransfer;
    private javax.swing.JLabel picDenda;
    private javax.swing.JButton pilihBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JLabel rekening;
    private javax.swing.JButton simpanBtn;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel tanggalSewa;
    private javax.swing.JButton transaksiBtn;
    // End of variables declaration//GEN-END:variables
}
