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
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import oru.inf.InfDB;
import oru.inf.InfException;

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
    String amne;

    public Inlagg(String aid) {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        inlagg = new InlaggMgt();
        this.aid = aid;
        showSocInlagg(amne);
//        showForskInlagg();
//        showUtbInlagg();
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSkrivInlagg = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnLaggTillMote = new javax.swing.JButton();
        jTabPanelAmnen = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneSocialt = new javax.swing.JTextPane();
        jtabPaneForsk = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneForsk = new javax.swing.JTextPane();
        tabPaneUtb = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneUtbildning = new javax.swing.JTextPane();
        btnVisaKalender = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnSkrivInlagg.setText("Skriv inlägg");
        btnSkrivInlagg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkrivInlaggMouseClicked(evt);
            }
        });

        jButton1.setText("KALENDER");
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

        jTabPanelAmnen.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabPanelAmnen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabPanelAmnen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTabPanelAmnen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabPanelAmnenStateChanged(evt);
            }
        });

        txtPaneSocialt.setEditable(false);
        jScrollPane2.setViewportView(txtPaneSocialt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabPanelAmnen.addTab("Socialt", jPanel1);

        jTextPaneForsk.setEditable(false);
        jScrollPane1.setViewportView(jTextPaneForsk);

        javax.swing.GroupLayout jtabPaneForskLayout = new javax.swing.GroupLayout(jtabPaneForsk);
        jtabPaneForsk.setLayout(jtabPaneForskLayout);
        jtabPaneForskLayout.setHorizontalGroup(
            jtabPaneForskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtabPaneForskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
                .addContainerGap())
        );
        jtabPaneForskLayout.setVerticalGroup(
            jtabPaneForskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtabPaneForskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabPanelAmnen.addTab("Forskning", jtabPaneForsk);

        jTextPaneUtbildning.setEditable(false);
        jScrollPane3.setViewportView(jTextPaneUtbildning);

        javax.swing.GroupLayout tabPaneUtbLayout = new javax.swing.GroupLayout(tabPaneUtb);
        tabPaneUtb.setLayout(tabPaneUtbLayout);
        tabPaneUtbLayout.setHorizontalGroup(
            tabPaneUtbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPaneUtbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabPaneUtbLayout.setVerticalGroup(
            tabPaneUtbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPaneUtbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabPanelAmnen.addTab("Utbildning", tabPaneUtb);

        btnVisaKalender.setText("Visa Kalender");
        btnVisaKalender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVisaKalenderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisaKalender)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSkrivInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnLaggTillMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jTabPanelAmnen)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(810, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVisaKalender)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSkrivInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnLaggTillMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabPanelAmnen, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }

    public void refreshList() {

    }//GEN-LAST:event_formWindowOpened
  
    
    public void showSocInlagg(String amne1){
        jTextPaneUtbildning.setBackground(Color.LIGHT_GRAY);
        jTextPaneForsk.setBackground(Color.LIGHT_GRAY);
        txtPaneSocialt.setBackground(Color.lightGray);
    amne = jTabPanelAmnen.getTitleAt(jTabPanelAmnen.getSelectedIndex());
    amne1 = amne;
       if(amne1 == null){
           amne1 = "Socialt";
           StyledDocument docSoc = txtPaneSocialt.getStyledDocument();
           inlagg.emptyInlaggPane(docSoc);
           inlagg.showSocInlagg1(docSoc, amne1);
       }
       if(amne1.equals("Socialt")){
           
           StyledDocument docSoc = txtPaneSocialt.getStyledDocument();
           inlagg.emptyInlaggPane(docSoc);
           inlagg.showSocInlagg1(docSoc, amne1);
       }
       if(amne1.equals("Forskning")){
           
           StyledDocument docForsk = jTextPaneForsk.getStyledDocument();  
           inlagg.emptyInlaggPane(docForsk);
           inlagg.showSocInlagg1(docForsk, amne1);
       }
       if(amne1.equals("Utbildning")){
       
           StyledDocument docUtb = jTextPaneUtbildning.getStyledDocument();
           inlagg.emptyInlaggPane(docUtb);
           inlagg.showSocInlagg1(docUtb, amne1);
       }
       }
   
    
    private void btnSkrivInlaggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkrivInlaggMouseClicked
        SkrivaInlagg skriva = new SkrivaInlagg(aid, this);
        skriva.setVisible(true);
    }//GEN-LAST:event_btnSkrivInlaggMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CalendarFrame cal = new CalendarFrame();
        cal.run();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLaggTillMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillMoteActionPerformed
        LaggTillMote mote = new LaggTillMote(aid);
        mote.setVisible(true);
    }//GEN-LAST:event_btnLaggTillMoteActionPerformed

    private void jTabPanelAmnenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabPanelAmnenStateChanged
        String a = jTabPanelAmnen.getTitleAt(jTabPanelAmnen.getSelectedIndex());
        System.out.println(a);
        String b = "Forskning";
        String c = "Utbildning";
        if(a.equals(b)){
            
            showSocInlagg(a);
        }
        if(a.equals(c)){
            showSocInlagg(a);
        }
    }//GEN-LAST:event_jTabPanelAmnenStateChanged

    private void btnVisaKalenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisaKalenderMouseClicked
        Kalender_TestFrame kalender = new Kalender_TestFrame(aid);
        kalender.setVisible(true);
    }//GEN-LAST:event_btnVisaKalenderMouseClicked

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
    private javax.swing.JButton btnLaggTillMote;
    private javax.swing.JButton btnSkrivInlagg;
    private javax.swing.JButton btnVisaKalender;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabPanelAmnen;
    private javax.swing.JTextPane jTextPaneForsk;
    private javax.swing.JTextPane jTextPaneUtbildning;
    private javax.swing.JPanel jtabPaneForsk;
    private javax.swing.JPanel tabPaneUtb;
    private javax.swing.JTextPane txtPaneSocialt;
    // End of variables declaration//GEN-END:variables
}
