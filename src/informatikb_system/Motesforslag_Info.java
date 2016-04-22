/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import oru.inf.InfDB;

/**
 *
 * @author Maximilian
 */
public class Motesforslag_Info extends javax.swing.JFrame {
    
    private Databas db;
    private HashMap<String, String> info;
    private static String mID;
    private static String aid;

    /**
     * Creates new form MotesInfo
     */
    public Motesforslag_Info(String aid, String mID) {
        this.mID = mID;
        this.aid = aid;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        db = new Databas();
        hamtaMotesForslagsInfo(mID);
        fillMotesInfo();
        fillMotesTider(mID);
    }
    /*
    * Metod för att hämta info om valt möte
    */
    public void fillMotesInfo()
    {
        String aid = info.get("ANSVARIG");
        System.out.println(aid);
        String namn = db.hamtaAnstalldNamn(aid);
        lblAnsvarig.setText(namn);
        lblTitel.setText(info.get("TITEL"));
        lblDatum.setText(info.get("DATUM"));
        lblPlats1.setText(info.get("SAL"));
        taBeskrivning.setText(info.get("BESKRIVNING"));
    }
    
    /*
    * Hämtar info för det valda mötet och sparar lokalt i objektet
    */
    public void hamtaMotesForslagsInfo(String mID)
    {
        info = db.hamtaMotesForslagsInfo(mID);
    }
    
    public void fillMotesTider(String mID)
    {
        ArrayList<HashMap<String, String>> tider = new ArrayList<HashMap<String, String>>();
        tider = db.hamtaTidsForslag(mID);
        
        for(HashMap<String, String> tidinfo : tider)
        {
            String id = tidinfo.get("ID");
            String tid = tidinfo.get("TID");
            String finalTid = id + ". " + tid;
            cbTider.addItem(finalTid);
        }
    }
    
    public void rostaPaTid()
    {
        String valdTid = cbTider.getSelectedItem().toString();
        String[] tidSplit = valdTid.split("\\.");
        String id = tidSplit[0];
        
        if(!db.rostatPaMote(mID, aid))
        {
            db.rostaPaMote(id, aid, mID);
            JOptionPane.showMessageDialog(this, "Du har nu röstat på mötestiden");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Du har redan röstat på tid för detta möte");
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taBeskrivning = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblTitel = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        lblPlats1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAnsvarig = new javax.swing.JLabel();
        cbTider = new javax.swing.JComboBox<>();
        lblTider = new javax.swing.JLabel();
        btnRosta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Plats:");

        jLabel4.setText("Beskrivning:");

        taBeskrivning.setEditable(false);
        taBeskrivning.setColumns(20);
        taBeskrivning.setRows(5);
        jScrollPane1.setViewportView(taBeskrivning);

        jLabel1.setText("Datum:");

        lblTitel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        lblTitel.setText("Titel");

        lblDatum.setText("DATUM");

        lblPlats1.setText("PLATS");

        jLabel2.setText("Ansvarig:");

        lblAnsvarig.setText("ANSVARIG");

        lblTider.setText("Tidsförslag:");

        btnRosta.setText("Rösta på tid");
        btnRosta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRostaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatum)
                            .addComponent(lblAnsvarig)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPlats1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblTider))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbTider, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRosta)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAnsvarig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblPlats1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTider)
                .addGap(4, 4, 4)
                .addComponent(cbTider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRosta)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRostaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRostaMouseClicked
       rostaPaTid();
    }//GEN-LAST:event_btnRostaMouseClicked

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
            java.util.logging.Logger.getLogger(Motesforslag_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Motesforslag_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Motesforslag_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Motesforslag_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Motesforslag_Info(aid, mID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRosta;
    private javax.swing.JComboBox<String> cbTider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnsvarig;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblPlats1;
    private javax.swing.JLabel lblTider;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JTextArea taBeskrivning;
    // End of variables declaration//GEN-END:variables
}
