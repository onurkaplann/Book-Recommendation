package yazlab1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class onerme extends javax.swing.JFrame {

    List bookratingkullanıcı = new ArrayList();
    List bookrating = new ArrayList();

    public onerme() {
        initComponents();
    }

    public void Oner() throws SQLException {
        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;
        Connection conn = null;
        ResultSet rs = null;//sorgudan donen kayıtlar bu nesnede tutuluyo
        Statement pst = null;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;//veritabanının adresi ve port numarası
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("mysql connector yok");
            e.printStackTrace();
        }
        try {
            conn = (Connection) DriverManager.getConnection(url, kullaniciadi, parola);

        } catch (SQLException e) {
            System.out.println("Baglanti basarisiz");
            e.printStackTrace();
        }
        if (conn != null) {
            System.out.println("basardik");
        } else {
            System.out.println("basarisiz");
        }

        int donceksayi = 5;

        ArrayList<Personel> list = new ArrayList<Personel>(); //Tüm Bookrating
        ArrayList<Personel> list2 = new ArrayList<Personel>(); //Bizim eleman
        ArrayList<Personel> list3 = new ArrayList<Personel>();  //Benzerler Kişiler
        ArrayList<Personel> ortaklar = new ArrayList<Personel>(); //Benzerlik Oranı
        Personel tampo = new Personel();

        String Sorgu = "SELECT UserID,Number,BookRating FROM `yazlab(1)`.bxbookratingsd";

        PreparedStatement preparedStmt = null;
        int UserID;
        int BookRating;
        String Number;
        pst = conn.createStatement();

        ResultSet x1 = pst.executeQuery(Sorgu);
        while (x1.next()) {
            UserID = x1.getInt("UserID");
            BookRating = x1.getInt("BookRating");
            Number = x1.getString("Number");
            list.add(new Personel(UserID, Number, BookRating));
        }

        x1.close();

        int id = UyeGirisi.a;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserID() == id) {
                list2.add(new Personel(list.get(i).getUserID(), list.get(i).getNumber(), list.get(i).getBookRating()));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list.get(i).getNumber().equals(list2.get(j).getNumber())) {
                    if (list.get(i).getUserID() == list2.get(j).getUserID()) {
                    } else {
                        list3.add(new Personel(list.get(i).getUserID(), list.get(i).getNumber(), list.get(i).getBookRating()));
                    }
                }
            }
        }

        double bookratingk = 0;
        double bookratingg = 0;
        int toplam1 = 0;
        int toplam2 = 0;
        int toplampay = 0;
        double benzerlik = 0;

        for (int i = 0; i < list3.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list3.get(i).getNumber().equals(list2.get(j).getNumber())) {
                    bookratingkullanıcı.add(list2.get(j).getBookRating());
                    bookrating.add(list3.get(i).getBookRating());
                    if ((i != list3.size() - 1) && (list3.get(i).getUserID() == list3.get(i + 1).getUserID())) {

                    } else {

                        for (int k = 0; k < bookrating.size(); k++) {
                            toplam1 = toplam1 + ((int) bookratingkullanıcı.get(k) * (int) bookratingkullanıcı.get(k));
                            toplam2 = toplam2 + ((int) bookrating.get(k) * (int) bookrating.get(k));
                            toplampay = toplampay + (((int) bookratingkullanıcı.get(k)) * ((int) bookrating.get(k)));
                        }

                        bookratingk = Math.pow(toplam1, 0.5);
                        bookratingg = Math.pow(toplam2, 0.5);

                        benzerlik = toplampay / (bookratingk * bookratingg);

                        bookrating.clear();
                        bookratingkullanıcı.clear();
                        toplam1 = 0;
                        toplam2 = 0;
                        toplampay = 0;
                        ortaklar.add(new Personel(benzerlik, list3.get(i).getUserID()));
                    }
                }
            }
        }

        double tampon = 0;
        for (int j = 0; j < ortaklar.size(); j++) {
            for (int i = j; i < ortaklar.size(); i++) {
                if (ortaklar.get(i).getBenzerlik() > tampon) {

                    tampon = ortaklar.get(i).getBenzerlik();
                    tampo = ortaklar.get(j);
                    ortaklar.set(j, ortaklar.get(i));
                    ortaklar.set(i, tampo);

                }
            }
            tampon = 0;
        }

        int t = 0;
        int tampon2 = 0;

        List kitaplar = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            for (int m = 0; m < donceksayi; m++) {
                if (list.get(i).getUserID() == ortaklar.get(m).getID()) {
                    for (int j = 0; j < list2.size(); j++) {
                        if (list.get(i).getNumber().equals(list2.get(j).getNumber()) == false) {
                            tampon2++;
                        }
                    }
                    if (tampon2 == 10) {
                        kitaplar.add(list.get(i).getNumber());
                    }
                    tampon2 = 0;
                }
            }
        }

        int[] dizi = new int[kitaplar.size()];

        for (int i = 0; i < kitaplar.size() - 1; i++) {
            for (int j = i + 1; j < kitaplar.size(); j++) {
                if (kitaplar.get(i).equals(kitaplar.get(j))) {
                    dizi[i]++;
                    kitaplar.remove(j);
                    j = j - 1;
                }
            }
        }

        int tut = 0;
        String tut2;

        for (int i = 0; i < dizi.length - 1; i++) {
            for (int j = 0; j < dizi.length - i - 1; j++) {
                if (dizi[j] < dizi[j + 1]) {
                    tut = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = tut;
                    tut2 = (String) kitaplar.get(j);
                    kitaplar.set(j, kitaplar.get(j + 1));
                    kitaplar.set(j + 1, tut2);
                }
            }
        }


        String z1 = "SELECT BookTitle,ImageURLS FROM `yazlab(1)`.bxbooksd Where Number = '" + kitaplar.get(0) + "'";
        String kitap = null;
        String url2 = null;
        pst = conn.createStatement();
        ResultSet x2 = pst.executeQuery(z1);
        while (x2.next()) {
            kitap = x2.getString("BookTitle");
            url2 =x2.getString("ImageURLS");
        }
        x2.close();
        
        jLabel1.setText(kitap);
        
        URL foto;
        
        try {
            foto = new URL(url2);
            BufferedImage buff = null;
            buff = ImageIO.read(foto);
            Image image = buff;
            ImageIcon icon = new ImageIcon(image.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            jLabel2.setIcon(icon);
            jLabel2.setText(url2);
            
        }catch (MalformedURLException ex) {
            Logger.getLogger(onerme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(onerme.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonÖner = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        geri = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonÖner.setText("Öner :");
        ButtonÖner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonÖnerActionPerformed(evt);
            }
        });

        geri.setText("Geri");
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonÖner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(geri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonÖner)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(geri))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonÖnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonÖnerActionPerformed
        try {
            Oner();
        } catch (SQLException ex) {
            Logger.getLogger(onerme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonÖnerActionPerformed

    private void geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriActionPerformed
        KullanıcıAraPanel frame = new KullanıcıAraPanel();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_geriActionPerformed

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
            java.util.logging.Logger.getLogger(onerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(onerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(onerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(onerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new onerme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtonÖner;
    private javax.swing.JToggleButton geri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
