/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.awt.Color;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Oliver
 */
public class AdminGUI extends javax.swing.JFrame {

    private InfDB idb;

    public AdminGUI() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        anslutDatabas();
    }
    
    private void anslutDatabas()
    {
                try
        {
            String path = System.getProperty("user.dir"); //Hämtar user direcotry
            idb = new InfDB(path + "/databas/DATABASE.FDB"); 
            System.out.println("Uppkopplingen lyckades");
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
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

        btnLaggTillAnvandare = new javax.swing.JButton();
        btnInlaggsHantering = new javax.swing.JButton();
        btnTaBortAnvandare = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLaggTillAnvandare.setText("Lägg till användare");
        btnLaggTillAnvandare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaggTillAnvandareMouseClicked(evt);
            }
        });

        btnInlaggsHantering.setText("Inläggshantering");
        btnInlaggsHantering.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInlaggsHanteringMouseClicked(evt);
            }
        });

        btnTaBortAnvandare.setText("Ta bort användare");
        btnTaBortAnvandare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaBortAnvandareMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLaggTillAnvandare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaBortAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInlaggsHantering)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLaggTillAnvandare, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnTaBortAnvandare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInlaggsHantering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTillAnvandareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillAnvandareMouseClicked
        Anvandarhantering anvH = new Anvandarhantering();
        anvH.setVisible(true);
    }//GEN-LAST:event_btnLaggTillAnvandareMouseClicked

    private void btnInlaggsHanteringMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInlaggsHanteringMouseClicked
        InlaggAdminGUI adminInlagg = new InlaggAdminGUI();
        adminInlagg.setVisible(true);
    }//GEN-LAST:event_btnInlaggsHanteringMouseClicked

    private void btnTaBortAnvandareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortAnvandareMouseClicked
        TaBortAnvandareAdmin anv = new TaBortAnvandareAdmin();
        anv.setVisible(true);
    }//GEN-LAST:event_btnTaBortAnvandareMouseClicked

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
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInlaggsHantering;
    private javax.swing.JButton btnLaggTillAnvandare;
    private javax.swing.JButton btnTaBortAnvandare;
    // End of variables declaration//GEN-END:variables
}