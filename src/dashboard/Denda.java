/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import utils.Functions;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rentalmobil.Login;

/**
 *
 * @author tohsaka
 */
public class Denda extends javax.swing.JFrame {

    public static File newImage;

    private static String order_id;

    /**
     * Creates new form Payment
     *
     * @param idOrder
     */
    public Denda(String idOrder) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        Denda.order_id = idOrder;
        loadTable();
    }

    private void loadTable() {
        jTable1.getTableHeader().setFont(new Font("SF Pro Display", Font.BOLD, 12));
        jTable1.getTableHeader().setBackground(new Color(0, 178, 255));
        jTable1.getTableHeader().setForeground(new Color(0, 0, 0));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.setRowHeight(25);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("ID");
        model.addColumn("Nama Denda");
        model.addColumn("Harga Denda");
        model.addColumn("Gambar");
        model.addColumn("Keterangan");

        int no = 1;
        String sql = "SELECT * FROM denda where order_id = '" + Denda.order_id + "'";
        try {
            Connection conn = (Connection) Functions.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{no++, res.getString("id_denda"), res.getString("nama_denda"), res.getString("harga_denda"),
                    res.getString("foto_bukti"), res.getString("keterangan")});
            }
            jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Denda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void clear() {
        txt_denda.setText(null);
        text_harga.setText(null);
        gambarField.setText(null);
        previewGambar.setIcon(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_denda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        text_harga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gambarField = new javax.swing.JTextField();
        tambahBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        hapusBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        pilihBtn = new javax.swing.JButton();
        previewGambar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_keterangan = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        hapusGambarBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Denda - Rentalkeun Dashboard");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SF Pro Display Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Menu Denda");

        jLabel4.setText("Nama Denda");

        txt_denda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dendaActionPerformed(evt);
            }
        });

        jLabel5.setText("Harga Denda");

        jLabel7.setText("Gambar");

        tambahBtn.setBackground(new java.awt.Color(0, 255, 71));
        tambahBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        tambahBtn.setForeground(new java.awt.Color(255, 255, 255));
        tambahBtn.setText("Tambah");
        tambahBtn.setBorderPainted(false);
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(0, 178, 255));
        editBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.setBorderPainted(false);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
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
        jTable1.setFocusable(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(0, 178, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        hapusBtn.setBackground(new java.awt.Color(255, 0, 29));
        hapusBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        hapusBtn.setForeground(new java.awt.Color(255, 255, 255));
        hapusBtn.setText("Hapus");
        hapusBtn.setBorderPainted(false);
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(0, 178, 255));
        clearBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.setBorderPainted(false);
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

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

        previewGambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        text_keterangan.setColumns(20);
        text_keterangan.setLineWrap(true);
        text_keterangan.setRows(5);
        jScrollPane2.setViewportView(text_keterangan);

        jLabel11.setText("Keterangan");

        hapusGambarBtn.setBackground(new java.awt.Color(0, 178, 255));
        hapusGambarBtn.setFont(new java.awt.Font("SF Pro Display Medium", 1, 15)); // NOI18N
        hapusGambarBtn.setForeground(new java.awt.Color(255, 255, 255));
        hapusGambarBtn.setText("Hapus");
        hapusGambarBtn.setBorderPainted(false);
        hapusGambarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusGambarBtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 178, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/rentalkeun_arrow.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(txt_denda, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                .addComponent(text_harga))
                            .addGap(89, 89, 89)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(gambarField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pilihBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hapusGambarBtn))
                                    .addComponent(previewGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jSeparator1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(tambahBtn)
                                    .addGap(42, 42, 42)
                                    .addComponent(hapusBtn)
                                    .addGap(42, 42, 42)
                                    .addComponent(editBtn)
                                    .addGap(42, 42, 42)
                                    .addComponent(clearBtn))
                                .addComponent(jLabel11))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addGap(179, 179, 179))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_denda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(previewGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gambarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihBtn)
                    .addComponent(hapusGambarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahBtn)
                    .addComponent(hapusBtn)
                    .addComponent(editBtn)
                    .addComponent(clearBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        try {
            if (txt_denda.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Text Field Nama Mobil Tidak Boleh Kosong!");
            } else if (text_harga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Text Field Harga Sewa Tidak Boleh Kosong!");
            } else if (gambarField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Text Field Gambar Tidak Boleh Kosong!");
            } else if (text_keterangan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Text Area Deskripsi Tidak Boleh Kosong!");
            } else {
                String query = "INSERT INTO denda (order_id, nama_denda, harga_denda, foto_bukti, keterangan) VALUES "
                        + "('" + Denda.order_id + "','" + txt_denda.getText() + "', " + text_harga.getText() + ",'" + gambarField.getText() + "'," + "'" + text_keterangan.getText() + "')";

                Connection conn = (Connection) Functions.configDB();

                String query2 = "SELECT * FROM orders WHERE id_order = '" + Denda.order_id + "'";
                PreparedStatement pst2 = conn.prepareStatement(query2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet res = pst2.executeQuery();

                if (res.next()) {
                    String result = "INSERT INTO denda (order_id, nama_denda, harga_denda, foto_bukti, keterangan) VALUES "
                            + "('" + Denda.order_id + "','" + txt_denda.getText() + "', " + text_harga.getText() + ",'" + gambarField.getText() + "'," + "'" + text_keterangan.getText() + "')";
                    PreparedStatement pst = conn.prepareStatement(result);
                    pst.execute();

                    int total = Integer.parseInt(res.getString("total")) + Integer.parseInt(text_harga.getText());

                    String query3 = "UPDATE orders SET total = " + total + " WHERE id_order = '" + Denda.order_id + "'";
                    PreparedStatement pst3 = conn.prepareStatement(query3);
                    pst3.execute();

                    JOptionPane.showMessageDialog(null, "Berhasil menambahkan data!");
                    clear();
                    loadTable();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
//        try {
//            String query = "UPDATE mobil SET nama_mobil='" + txt_denda.getText() + "', "
//                    + "harga_sewa=" + text_harga.getText() + ", no_polisi='" + noPolisiField.getText() + "', "
//                    + "gambar='" + gambarField.getText() + "', merk='" + merkField.getText() + "', '" + text_keterangan.getText() + "' WHERE id_mobil=" + idField.getText();
//            Connection conn = (Connection) Functions.configDB();
//            PreparedStatement pst = conn.prepareStatement(query);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
//            loadTable();
//            clear();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void pilihBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihBtnActionPerformed
        // TODO add your handling code here:
        String filename;
        try {
            if (gambarField.getText().length() > 3) {
                File dstFile = new File("src" + gambarField.getText());
                Files.delete(dstFile.toPath());
            }
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            Image icon = ImageIO.read(file);
            Image image = icon.getScaledInstance(345, 222, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            previewGambar.setIcon(ic);

            filename = file.getAbsolutePath();

            String newpath = "src/denda/";
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
            destinationFile = new File(newpath + "/denda-" + tanggal + "." + extension);
            newImage = destinationFile;
            String destFile = destinationFile.toString();
            String[] iconPath = destFile.split("src");
            gambarField.setText(iconPath[1]);
            Files.copy(sourceFile.toPath(), destinationFile.toPath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_pilihBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String id = jTable1.getValueAt(baris, 1).toString();
//        idField.setText(id);
        if (jTable1.getValueAt(baris, 2) == null) {
            txt_denda.setText("");
        } else {
            txt_denda.setText(jTable1.getValueAt(baris, 2).toString());
        }
        if (jTable1.getValueAt(baris, 3) == null) {
            text_harga.setText("");
        } else {
            text_harga.setText(jTable1.getValueAt(baris, 3).toString());
        }
        if (jTable1.getValueAt(baris, 4) == null) {
            gambarField.setText("");
        } else {
            gambarField.setText(jTable1.getValueAt(baris, 4).toString());
            Image icon = new ImageIcon(this.getClass().getResource(gambarField.getText())).getImage();
            Image image = icon.getScaledInstance(345, 222, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            previewGambar.setIcon(ic);
        }
        if (jTable1.getValueAt(baris, 5) == null) {
            text_keterangan.setText("");
        } else {
            text_keterangan.setText(jTable1.getValueAt(baris, 5).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed

    }//GEN-LAST:event_hapusBtnActionPerformed

    private void txt_dendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dendaActionPerformed

    private void hapusGambarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusGambarBtnActionPerformed
        // TODO add your handling code here:
        if (newImage == null) {
            JOptionPane.showMessageDialog(null, "Anda belum memilih gambar!");
        } else {
            try {
                Files.delete(newImage.toPath());
                gambarField.setText(null);
                previewGambar.setIcon(null);
                newImage = null;
            } catch (IOException ex) {
                Logger.getLogger(Denda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_hapusGambarBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Denda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Denda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Denda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Denda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Denda(order_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField gambarField;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JButton hapusGambarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pilihBtn;
    private javax.swing.JLabel previewGambar;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JTextField text_harga;
    private javax.swing.JTextArea text_keterangan;
    private javax.swing.JTextField txt_denda;
    // End of variables declaration//GEN-END:variables
}
