/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Reinis
 */
public class Inlagg extends javax.swing.JFrame {

    /**
     * Creates new form Inlagg
     */
    private InlaggMgt inlagg;

    private static String aid;

    public Inlagg(String aid) {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inlagg = new InlaggMgt();
        this.aid = aid;
        showInlaggInPane();
    }


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSocial = new javax.swing.JButton();
        btnUtbildning = new javax.swing.JButton();
        btnForskning = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        btnSkrivInlagg = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneInlagg = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        btnLaggTillMote = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnSocial.setText("Social");

        btnUtbildning.setText("Utbildning");

        btnForskning.setText("Forskning");
        btnForskning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForskningActionPerformed(evt);
            }
        });

        btnAll.setText("All");
        btnAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAllMouseClicked(evt);
            }
        });

        btnSkrivInlagg.setText("Skriv inlägg");
        btnSkrivInlagg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkrivInlaggMouseClicked(evt);
            }
        });

        btnTest.setText("testAID");
        btnTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTestMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(txtPaneInlagg);

        jButton1.setText("Titta på kalender");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLaggTillMote.setText("Lägg till möte");
        btnLaggTillMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillMoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSkrivInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUtbildning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnForskning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTest)
                    .addComponent(btnLaggTillMote))
                .addGap(909, 909, 909))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSkrivInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUtbildning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnForskning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLaggTillMote)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnForskningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForskningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnForskningActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }

    public void refreshList() {

    }//GEN-LAST:event_formWindowOpened
  
    
    public void showInlaggInPane(){
       
       ArrayList<HashMap<String, String>> txtArea = inlagg.hamtaInlagg();
       StyledDocument doc = txtPaneInlagg.getStyledDocument();
       
       
            for (int i = txtArea.size() - 1; i >= 0; i--) {
                 String firstName = txtArea.get(i).get("FIRST_NAME");
                String datum = txtArea.get(i).get("DATUM");
                String tid = txtArea.get(i).get("TID");
                String bloggIn = txtArea.get(i).get("TEXT");

                SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setForeground(AtrSet, Color.RED);
                StyleConstants.setBackground(AtrSet, Color.YELLOW);
                StyleConstants.setBold(AtrSet, true);
                try{
                doc.insertString(0," ------------------------------------------------" + "\n" + firstName + "\n" + "Datum: " + datum + " Klockan: " + tid + "\n" + "\n" + bloggIn + "\n" + "\n" + "\n",AtrSet );
                    }catch(Exception e) { System.out.println(e); }
                    }
            }   

    
    private void btnAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAllMouseClicked
        StyledDocument doc = txtPaneInlagg.getStyledDocument();
        inlagg.emptyInlaggPane(doc);
        showInlaggInPane();
    }//GEN-LAST:event_btnAllMouseClicked

    private void btnSkrivInlaggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkrivInlaggMouseClicked
        SkrivaInlagg skriva = new SkrivaInlagg(aid, this);
        skriva.setVisible(true);
    }//GEN-LAST:event_btnSkrivInlaggMouseClicked

    private void btnTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMouseClicked
        System.out.println(aid);
    }//GEN-LAST:event_btnTestMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CalendarFrame cal = new CalendarFrame();
        cal.run();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLaggTillMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillMoteActionPerformed
        MoteTest mote = new MoteTest();
        mote.setVisible(true);
    }//GEN-LAST:event_btnLaggTillMoteActionPerformed

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
            java.util.logging.Logger.getLogger(Inlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inlagg(aid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnForskning;
    private javax.swing.JButton btnLaggTillMote;
    private javax.swing.JButton btnSkrivInlagg;
    private javax.swing.JButton btnSocial;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btnUtbildning;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtPaneInlagg;
    // End of variables declaration//GEN-END:variables
}
