/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author brokoby
 */
public class Mina_Moten extends javax.swing.JFrame {

   
    private static String aid;
    private Databas db;
    
    public Mina_Moten(String aid) {
        initComponents();
        this.aid = aid;
        db = new Databas();
        fyllSkapadeMoten();
        fyllMotesForslag();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }


   public void fyllSkapadeMoten()
   {
       listFardigstalldaMoten.removeAll();
       ArrayList<String> skapademoten = new ArrayList<String>();
       skapademoten = db.hamtaSkapadeMoteNamn(aid);
       
       for(String namn : skapademoten)
       {
           listFardigstalldaMoten.add(namn);
       }
       
       
   }
   
   public void fyllMotesForslag()
   {
       listMotesforslag.removeAll();
       ArrayList<String> forslagsmoten = new ArrayList<String>();
       forslagsmoten = db.hamtaForslagsNamn(aid);
       String[] fardigaMoten = listFardigstalldaMoten.getItems();
       Set<String> klaraMoten = new HashSet<String>(Arrays.asList(fardigaMoten));
     
       for(String motet : forslagsmoten)
       {
            if(!klaraMoten.contains(motet))
            {
                listMotesforslag.add(motet);
                   
            }
       }
           

       if(listMotesforslag.getItemCount() == 0)
       {
            listMotesforslag.add("Du har inga mötesförslag");
       }
       
       
   }
   
   public String hamtaUtMid()
   {
       String id = "";
       String detMotet = listMotesforslag.getSelectedItem().toString();
       String[] splitz = detMotet.split("\\.");
       id = splitz[0];
       return id;
   }
   
           
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMotesInfo = new javax.swing.JTabbedPane();
        jpFardigstalldaMoten = new javax.swing.JPanel();
        listFardigstalldaMoten = new java.awt.List();
        btnValjFardigtMote = new javax.swing.JButton();
        jpMotesforslag = new javax.swing.JPanel();
        listMotesforslag = new java.awt.List();
        btnMotesForslag = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnValjFardigtMote.setText("Välj");
        btnValjFardigtMote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValjFardigtMoteMouseClicked(evt);
            }
        });
        btnValjFardigtMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValjFardigtMoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFardigstalldaMotenLayout = new javax.swing.GroupLayout(jpFardigstalldaMoten);
        jpFardigstalldaMoten.setLayout(jpFardigstalldaMotenLayout);
        jpFardigstalldaMotenLayout.setHorizontalGroup(
            jpFardigstalldaMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFardigstalldaMotenLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jpFardigstalldaMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listFardigstalldaMoten, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFardigstalldaMotenLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnValjFardigtMote, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jpFardigstalldaMotenLayout.setVerticalGroup(
            jpFardigstalldaMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFardigstalldaMotenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listFardigstalldaMoten, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValjFardigtMote)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpMotesInfo.addTab("Färdigställda möten", jpFardigstalldaMoten);

        btnMotesForslag.setText("Välj");
        btnMotesForslag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMotesForslagMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpMotesforslagLayout = new javax.swing.GroupLayout(jpMotesforslag);
        jpMotesforslag.setLayout(jpMotesforslagLayout);
        jpMotesforslagLayout.setHorizontalGroup(
            jpMotesforslagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMotesforslagLayout.createSequentialGroup()
                .addGroup(jpMotesforslagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMotesforslagLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(listMotesforslag, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpMotesforslagLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnMotesForslag, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jpMotesforslagLayout.setVerticalGroup(
            jpMotesforslagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMotesforslagLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMotesforslag, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMotesForslag)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpMotesInfo.addTab("Mötesförslag", jpMotesforslag);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpMotesInfo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpMotesInfo))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMotesForslagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMotesForslagMouseClicked
        new Eget_Forslag_Info(aid, hamtaUtMid()).setVisible(true);
    }//GEN-LAST:event_btnMotesForslagMouseClicked

    private void btnValjFardigtMoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValjFardigtMoteMouseClicked
        
        String valtMote = listFardigstalldaMoten.getSelectedItem().toString();
        String[] mote = valtMote.split("\\.");
        String mid = mote[0];
        new MotesInfo(mid, aid).setVisible(true);
    }//GEN-LAST:event_btnValjFardigtMoteMouseClicked

    private void btnValjFardigtMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValjFardigtMoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnValjFardigtMoteActionPerformed

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
            java.util.logging.Logger.getLogger(Mina_Moten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mina_Moten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mina_Moten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mina_Moten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mina_Moten(aid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMotesForslag;
    private javax.swing.JButton btnValjFardigtMote;
    private javax.swing.JPanel jpFardigstalldaMoten;
    private javax.swing.JPanel jpMotesforslag;
    private java.awt.List listFardigstalldaMoten;
    private java.awt.List listMotesforslag;
    private javax.swing.JTabbedPane tpMotesInfo;
    // End of variables declaration//GEN-END:variables
}
