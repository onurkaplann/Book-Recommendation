package yazlab1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static yazlab1.Personel.list;

public class Sayfala extends javax.swing.JFrame {

    List list = new ArrayList();
    List list2 = new ArrayList();
    int limit = 0;
    int limits = 5;

    public Sayfala() {
        initComponents();
    }

    public void listele() throws ClassNotFoundException, SQLException {

        ResultSet result = null;
        java.sql.Connection connection = null;
        java.sql.Statement statement;
        int sutunSayisi;
        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;//veritabanının adresi ve port numarası
            connection = DriverManager.getConnection(url, kullaniciadi, parola);

            statement = connection.createStatement();

            String a1 = "SELECT ImageURLS FROM `yazlab(1)`.bxbooksd LIMIT " + limit + " , " + limits + "";

            ResultSet x1 = statement.executeQuery(a1);
            //int i = 0;
            while (x1.next()) {
                a1 = x1.getString("ImageURLS");
                list.add(a1);
            }
            x1.close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
        }

        URL tut;
        URL tut2;
        URL tut3;
        URL tut4;
        URL tut5;

        try {
            // for (int i = 0; i < 5; i++) {
            tut = new URL((String) list.get(0));
            BufferedImage buff = null;
            buff = ImageIO.read(tut);
            Image image = buff;
            ImageIcon icon = new ImageIcon(image.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            jLabel1.setIcon(icon);
            jLabel1.setText((String) list.get(0));
            // }
            tut2 = new URL((String) list.get(1));
            BufferedImage buff2 = null;
            buff2 = ImageIO.read(tut2);
            Image image2 = buff2;
            ImageIcon icon2 = new ImageIcon(image2.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            jLabel2.setIcon(icon2);
            jLabel2.setText((String) list.get(1));

            tut3 = new URL((String) list.get(2));
            BufferedImage buff3 = null;
            buff3 = ImageIO.read(tut3);
            Image image3 = buff3;
            ImageIcon icon3 = new ImageIcon(image3.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            jLabel3.setIcon(icon3);
            jLabel3.setText((String) list.get(2));

            tut4 = new URL((String) list.get(3));
            BufferedImage buff4 = null;
            buff4 = ImageIO.read(tut4);
            Image image4 = buff4;
            ImageIcon icon4 = new ImageIcon(image4.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            jLabel4.setIcon(icon4);
            jLabel4.setText((String) list.get(3));

            tut5 = new URL((String) list.get(4));
            BufferedImage buff5 = null;
            buff5 = ImageIO.read(tut5);
            Image image5 = buff5;
            ImageIcon icon5 = new ImageIcon(image5.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            jLabel5.setIcon(icon5);
            jLabel5.setText((String) list.get(4));

        } catch (MalformedURLException ex) {
            Logger.getLogger(Sayfala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sayfala.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listele2() {
        ResultSet result = null;
        java.sql.Connection connection = null;
        java.sql.Statement statement;
        int sutunSayisi;
        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;//veritabanının adresi ve port numarası
            connection = DriverManager.getConnection(url, kullaniciadi, parola);

            statement = connection.createStatement();

            String a1 = "SELECT BookTitle FROM `yazlab(1)`.bxbooksd LIMIT " + limit + " , " + limits + "";

            ResultSet x1 = statement.executeQuery(a1);
            //int i = 0;
            while (x1.next()) {
                a1 = x1.getString("BookTitle");
                list2.add(a1);
            }
            x1.close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
        }
        jLabel6.setText((String) list2.get(0));
        jLabel7.setText((String) list2.get(1));
        jLabel8.setText((String) list2.get(2));
        jLabel9.setText((String) list2.get(3));
        jLabel10.setText((String) list2.get(4));
    }

    public void listele3() {
        limit = limit + 10;
        list.clear();
        list2.clear();
       
    }

    public void listele4() {
        limit = limit - 5;
        list.clear();
        list2.clear();
        
    }

    public void PDF() {
        String FILE = "C:\\Users\\ABRA\\Desktop\\Yazlab1\\cek-london-beyaz-dish-tr.pdf";

        try {
            if ((new File(FILE)).exists()) {
                Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FILE);
                p.waitFor();
            } else {
                System.out.println("File is not exists");
            }
            System.out.println("Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Geri = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        İleri = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Oku = new javax.swing.JToggleButton();
        Oku2 = new javax.swing.JToggleButton();
        Oku3 = new javax.swing.JToggleButton();
        Oku4 = new javax.swing.JToggleButton();
        Oku5 = new javax.swing.JToggleButton();
        Panel = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Geri.setText("Geri");
        Geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeriActionPerformed(evt);
            }
        });

        İleri.setText("İleri");
        İleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                İleriActionPerformed(evt);
            }
        });

        Oku.setText("Oku");
        Oku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkuActionPerformed(evt);
            }
        });

        Oku2.setText("Oku");
        Oku2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Oku2ActionPerformed(evt);
            }
        });

        Oku3.setText("Oku");
        Oku3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Oku3ActionPerformed(evt);
            }
        });

        Oku4.setText("Oku");
        Oku4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Oku4ActionPerformed(evt);
            }
        });

        Oku5.setText("Oku");
        Oku5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Oku5ActionPerformed(evt);
            }
        });

        Panel.setText("Panele Dön");
        Panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Geri)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(İleri, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Oku4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Oku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Oku2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Oku3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Oku5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Panel))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(Oku)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(Oku2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(Oku3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Oku4)
                        .addGap(68, 68, 68)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(Oku5)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Geri)
                    .addComponent(İleri)
                    .addComponent(Panel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeriActionPerformed
        limit = limit - 5;
        listele4();
        try {
            listele();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sayfala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Sayfala.class.getName()).log(Level.SEVERE, null, ex);
        }
        listele2();
        limit = limit + 5;
        

    }//GEN-LAST:event_GeriActionPerformed

    private void Oku4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Oku4ActionPerformed
        PDF();
    }//GEN-LAST:event_Oku4ActionPerformed

    private void İleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_İleriActionPerformed
        listele3();
        limit = limit - 10;

        try {
            listele();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sayfala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Sayfala.class.getName()).log(Level.SEVERE, null, ex);
        }
        listele2();
        limit = limit + 5;
        
    }//GEN-LAST:event_İleriActionPerformed

    private void OkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkuActionPerformed
        PDF();
    }//GEN-LAST:event_OkuActionPerformed

    private void Oku2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Oku2ActionPerformed
        PDF();
    }//GEN-LAST:event_Oku2ActionPerformed

    private void Oku3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Oku3ActionPerformed
        PDF();
    }//GEN-LAST:event_Oku3ActionPerformed

    private void Oku5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Oku5ActionPerformed
        PDF();
    }//GEN-LAST:event_Oku5ActionPerformed

    private void PanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelActionPerformed
        KullanıcıAraPanel frame = new KullanıcıAraPanel();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_PanelActionPerformed

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
            java.util.logging.Logger.getLogger(Sayfala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sayfala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sayfala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sayfala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sayfala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Geri;
    private javax.swing.JToggleButton Oku;
    private javax.swing.JToggleButton Oku2;
    private javax.swing.JToggleButton Oku3;
    private javax.swing.JToggleButton Oku4;
    private javax.swing.JToggleButton Oku5;
    private javax.swing.JToggleButton Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToggleButton İleri;
    // End of variables declaration//GEN-END:variables
}
