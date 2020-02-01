package yazlab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class YoneticiListele extends javax.swing.JFrame {

    List UserID = new ArrayList();
    List OrtakUserID = new ArrayList();
    List UserName = new ArrayList();
    List Password = new ArrayList();

    public YoneticiListele() {
        initComponents();
    }

    private void kitapListele() throws Exception {

        ResultSet result;
        Connection connection = null;
        Statement statement;
        int sutunSayisi;
        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            connection = DriverManager.getConnection(url, kullaniciadi, parola);

            statement = connection.createStatement();
  
            result = statement.executeQuery("SELECT BookTitle FROM `yazlab(1)`.bxbooksd;");

            sutunSayisi = result.getMetaData().getColumnCount();

            DefaultTableModel table = new DefaultTableModel();

            for (int i = 1; i <= sutunSayisi; i++) {
                table.addColumn(result.getMetaData().getColumnName(i));
            }

            Object[] row = new Object[sutunSayisi];

            while (result.next()) {

                for (int i = 1; i <= sutunSayisi; i++) {
                    row[i - 1] = result.getObject(i);
                }
                table.addRow(row);
            }

            jTable1.setModel(table);

            result.close();
            connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
        }
    }

    private void SonKitap() throws Exception {

        ResultSet result;
        Connection connection = null;
        Statement statement;
        int sutunSayisi;
        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;
        try {
            Class.forName("com.mysql.jdbc.Driver");
   
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            connection = DriverManager.getConnection(url, kullaniciadi, parola);

            statement = connection.createStatement();

            result = statement.executeQuery("SELECT BookTitle FROM `yazlab(1)`.sonkitap order by NumberSon Desc limit 5");

            sutunSayisi = result.getMetaData().getColumnCount();

            DefaultTableModel table = new DefaultTableModel();

            for (int i = 1; i <= sutunSayisi; i++) {
                table.addColumn(result.getMetaData().getColumnName(i));
            }

            Object[] row = new Object[sutunSayisi];

            while (result.next()) {

                for (int i = 1; i <= sutunSayisi; i++) {
                    row[i - 1] = result.getObject(i);
                }
                table.addRow(row);
            }

            jTable4.setModel(table);

            result.close();
            connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
        }
    }

    private void kullaniciListele() throws Exception {

        ResultSet result = null;
        Connection connection = null;
        Statement statement;
        int sutunSayisi;
        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            connection = DriverManager.getConnection(url, kullaniciadi, parola);

            statement = connection.createStatement();

            result = statement.executeQuery("SELECT * FROM `yazlab(1)`.bxusersd");

            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("UserID");
            table.addColumn("Location");
            table.addColumn("Age");

            Object[] row = new Object[5];
            while (result.next()) {
                for (int i = 1; i <= 3; i++) {
                    row[i - 1] = result.getObject(i);
                }
                table.addRow(row);
            }

            jTable2.setModel(table);

            result.close();
            connection.close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
        }
    }

    private void kullaniciListele2() throws Exception {

        ResultSet result;
        Connection connection = null;
        Statement statement;
        int sutunSayisi;
        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;
        try {
            Class.forName("com.mysql.jdbc.Driver");
      
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            connection = DriverManager.getConnection(url, kullaniciadi, parola);

            statement = connection.createStatement();

            result = statement.executeQuery("SELECT * FROM `yazlab(1)`.bx;");

            sutunSayisi = result.getMetaData().getColumnCount();

            DefaultTableModel table = new DefaultTableModel();

            for (int i = 1; i <= sutunSayisi; i++) {
                table.addColumn(result.getMetaData().getColumnName(i));
            }

            Object[] row = new Object[sutunSayisi];

            while (result.next()) {

                for (int i = 1; i <= sutunSayisi; i++) {
                    row[i - 1] = result.getObject(i);
                }
                table.addRow(row);
            }

            jTable3.setModel(table);

            result.close();
            connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        KitapListele = new javax.swing.JToggleButton();
        KullanıcıListele = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        YeniKullanıcıListele = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        Son5Kitap = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        KitapListele.setText("Kitap Listele");
        KitapListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KitapListeleActionPerformed(evt);
            }
        });

        KullanıcıListele.setText("Kullanıcı Listele");
        KullanıcıListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KullanıcıListeleActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        YeniKullanıcıListele.setText("Yeni Kullanıcı Listele");
        YeniKullanıcıListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YeniKullanıcıListeleActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Geri");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable4);

        Son5Kitap.setText("Son 5 Kitap");
        Son5Kitap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Son5KitapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(KitapListele, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(KullanıcıListele, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(YeniKullanıcıListele)
                        .addGap(67, 67, 67)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(Son5Kitap, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KitapListele)
                    .addComponent(KullanıcıListele))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YeniKullanıcıListele)
                    .addComponent(jToggleButton1)
                    .addComponent(Son5Kitap))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KitapListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KitapListeleActionPerformed
        try {
            kitapListele();
        } catch (Exception ex) {
            Logger.getLogger(YoneticiListele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_KitapListeleActionPerformed

    private void KullanıcıListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KullanıcıListeleActionPerformed
        try {
            kullaniciListele();
        } catch (Exception ex) {
            Logger.getLogger(YoneticiListele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_KullanıcıListeleActionPerformed

    private void YeniKullanıcıListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YeniKullanıcıListeleActionPerformed
        try {
            kullaniciListele2();
        } catch (Exception ex) {
            Logger.getLogger(YoneticiListele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_YeniKullanıcıListeleActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Yonetici frame = new Yonetici();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void Son5KitapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Son5KitapActionPerformed
        try {
            SonKitap();
        } catch (Exception ex) {
            Logger.getLogger(YoneticiListele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Son5KitapActionPerformed

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
            java.util.logging.Logger.getLogger(YoneticiListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticiListele().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton KitapListele;
    private javax.swing.JToggleButton KullanıcıListele;
    private javax.swing.JToggleButton Son5Kitap;
    private javax.swing.JToggleButton YeniKullanıcıListele;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
