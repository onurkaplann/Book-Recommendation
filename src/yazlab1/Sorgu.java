package yazlab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Sorgu extends javax.swing.JFrame {

    public Sorgu() {
        initComponents();
    }

    public void Guncelle_P() throws SQLException {

        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;
        Connection conn = null;
        ResultSet rs = null;
        Statement pst = null;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
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
        pst = conn.createStatement();
        DefaultTableModel model = (DefaultTableModel) TableP.getModel();
        String[] k3 = new String[30];
        String[] k3_isim = new String[30];
        int tampon = 0;
        int i = 0;
        String k4 = "SELECT v.Number FROM `yazlab(1)`.bxbooksd AS v INNER JOIN(SELECT Number FROM `yazlab(1)`.bxbookratingsd GROUP BY number ORDER BY COUNT(*) DESC LIMIT 29)as v2 ON v.Number=v2.Number";
        ResultSet x1 = pst.executeQuery(k4);
        
        while (x1.next()) {

            k3[tampon] = x1.getString("Number");
            tampon++;
        }

        for (i = 0; i < 10; i++) {
            String k6 = "SELECT BookTitle FROM `yazlab(1)`.bxbooksd where Number='" + k3[i] + "'";
            ResultSet x3 = pst.executeQuery(k6);
            while (x3.next()) {
                k3_isim[i] = x3.getString("BookTitle");
            }
        }

        model.addRow(new Object[]{k3_isim[0]});
        model.addRow(new Object[]{k3_isim[1]});
        model.addRow(new Object[]{k3_isim[2]});
        model.addRow(new Object[]{k3_isim[3]});
        model.addRow(new Object[]{k3_isim[4]});
        model.addRow(new Object[]{k3_isim[5]});
        model.addRow(new Object[]{k3_isim[6]});
        model.addRow(new Object[]{k3_isim[7]});
        model.addRow(new Object[]{k3_isim[8]});
        model.addRow(new Object[]{k3_isim[9]});

    }

    public void Guncelle_B() throws SQLException {

        String kullaniciadi = "root";
        String parola = "";
        String host = "127.0.0.1";
        String db = "yazlab(1)";
        int port = 3306;
        Connection conn = null;
        ResultSet rs = null;
        Statement pst = null;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
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
        pst = conn.createStatement();
        String[] k3 = new String[15];
        double[] x = new double[15];
        String[] k3_isim = new String[15];
        int tampon = 0;
        int i = 0;

        String k4 = "SELECT v.Number FROM `yazlab(1)`.bxbooksd AS v INNER JOIN(SELECT bxbookratingsd.Number FROM `yazlab(1)`.bxbookratingsd GROUP BY Number ORDER BY avg(bxbookratingsd.BookRating)DESC LIMIT 50)as v2 ON v.Number=v2.Number LIMIT 10";
        ResultSet x1 = pst.executeQuery(k4);
        while (x1.next()) {

            k3[tampon] = x1.getString("Number");
            tampon++;
        }
        x1.close();

        for (i = 0; i < 10; i++) {
            String k5 = "SELECT AVG(BookRating) FROM `yazlab(1)`.bxbookratingsd where Number='" + k3[i] + "'";
            ResultSet x2 = pst.executeQuery(k5);
            while (x2.next()) {
                x[i] = x2.getDouble("AVG(BookRating)");
            }
            x2.close();
        }
        DefaultTableModel model = (DefaultTableModel) TableB.getModel();
        Object[] row = new Object[11];

        for (i = 0; i < 10; i++) {
            String k6 = "SELECT BookTitle FROM `yazlab(1)`.bxbooksd where Number='" + k3[i] + "'";
            ResultSet x3 = pst.executeQuery(k6);
            while (x3.next()) {
                k3_isim[i] = x3.getString("BookTitle");
            }
            x3.close();
        }

        model.addRow(new Object[]{k3_isim[0], x[0]});
        model.addRow(new Object[]{k3_isim[1], x[1]});
        model.addRow(new Object[]{k3_isim[2], x[2]});
        model.addRow(new Object[]{k3_isim[3], x[3]});
        model.addRow(new Object[]{k3_isim[4], x[4]});
        model.addRow(new Object[]{k3_isim[5], x[5]});
        model.addRow(new Object[]{k3_isim[6], x[6]});
        model.addRow(new Object[]{k3_isim[7], x[7]});
        model.addRow(new Object[]{k3_isim[8], x[8]});
        model.addRow(new Object[]{k3_isim[9], x[9]});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableP = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableB = new javax.swing.JTable();
        Guncelle_Popular = new javax.swing.JToggleButton();
        Guncelle_Best = new javax.swing.JToggleButton();
        geri = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(676, 591));

        TableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Top10PopülerBook"
            }
        ));
        TableP.setRowHeight(26);
        jScrollPane1.setViewportView(TableP);

        TableB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Top10BestBook", "AVG"
            }
        ));
        TableB.setRowHeight(26);
        jScrollPane2.setViewportView(TableB);

        Guncelle_Popular.setText("Güncelle");
        Guncelle_Popular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guncelle_PopularActionPerformed(evt);
            }
        });

        Guncelle_Best.setText("Güncelle");
        Guncelle_Best.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guncelle_BestActionPerformed(evt);
            }
        });

        geri.setText("Geri");
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(Guncelle_Popular)
                .addGap(131, 131, 131)
                .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Guncelle_Best)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guncelle_Popular)
                    .addComponent(Guncelle_Best)
                    .addComponent(geri))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Guncelle_BestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guncelle_BestActionPerformed
        try {
            Guncelle_B();
        } catch (SQLException ex) {
            Logger.getLogger(Sorgu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Guncelle_BestActionPerformed

    private void Guncelle_PopularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guncelle_PopularActionPerformed
        try {
            Guncelle_P();
        } catch (SQLException ex) {
            Logger.getLogger(Sorgu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Guncelle_PopularActionPerformed

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
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sorgu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Guncelle_Best;
    private javax.swing.JToggleButton Guncelle_Popular;
    private javax.swing.JTable TableB;
    private javax.swing.JTable TableP;
    private javax.swing.JToggleButton geri;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
