/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Oliver
 */
public class TaBortAnvandareAdmin extends javax.swing.JFrame {

    private InfDB idb;
    
    public TaBortAnvandareAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        anslutDatabas();
        fyllLista();
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
    
    private void fyllLista()
    {
        ArrayList<HashMap<String, String>> anstallda = hamtaAllaAnstallda();
        DefaultListModel model = new DefaultListModel();
        listAnstallda.setModel(model);
        
        for(int i = 0; i < anstallda.size(); i++)
        {
            String fornamn = anstallda.get(i).get("FIRST_NAME");
            String efternamn = anstallda.get(i).get("LAST_NAME");
            String aid = anstallda.get(i).get("AID");
            model.addElement(aid + " " + fornamn + " " + efternamn);
        }
    }
    
    private void taBortAnstalld(String aid)
    {
        String sqlFraga = "delete from anstalld where anstalld.aid = " + aid + ";";

        try
        {
            idb.delete(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private ArrayList<HashMap<String, String>> hamtaAllaAnstallda()
    {
        String sqlFraga = "select anstalld.first_name, anstalld.last_name, anstalld.aid from anstalld;";
        ArrayList<HashMap<String, String>> anstallda = new ArrayList<HashMap<String, String>>();
        
        try
        {
           anstallda = idb.fetchRows(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return anstallda;
    }
    
    private void tomLista()
    {
        listAnstallda.removeAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listAnstallda = new javax.swing.JList<>();
        btnTaBort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listAnstallda);

        btnTaBort.setText("Ta bort");
        btnTaBort.setToolTipText("Ta bort markerad användare");
        btnTaBort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaBortMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTaBort, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(btnTaBort)
                .addGap(190, 190, 190))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaBortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortMouseClicked
        String aid = listAnstallda.getSelectedValue().substring(0, 1);
        taBortAnstalld(aid);
        tomLista();
        fyllLista();
    }//GEN-LAST:event_btnTaBortMouseClicked

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
            java.util.logging.Logger.getLogger(TaBortAnvandareAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaBortAnvandareAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaBortAnvandareAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaBortAnvandareAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaBortAnvandareAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaBort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listAnstallda;
    // End of variables declaration//GEN-END:variables
}