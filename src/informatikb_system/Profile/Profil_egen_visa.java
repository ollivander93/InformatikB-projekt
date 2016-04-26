/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system.Profile;
import informatikb_system.Profile.InlaggMgt.*;
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * @author Sethox
 */
public class Profil_egen_visa extends javax.swing.JFrame {
    private InfDB idb;
    private ArrayList<HashMap<String, String>> ProfileInfo;
    private String AID;
    private Profil_egen_edit EditProfile;
    private String name = null, lastName = null, city = null, email = null, phone = null, BIO = null, ProfilePicture = null;
    private InlaggMgt inlagg;
    
    // Konstruktor för test
    public Profil_egen_visa() {
        initComponents();
        Profile_Bio.setEditable(false);
        Profile_Cancel_Exit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { System.exit(0); }});
        anslutDatabas();
    }
    // Standardkonstruktor
    public Profil_egen_visa(String AID) {
        this.AID = AID;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        profil_main.setBackground(Color.white);
        jPanel1.setBackground(Color.white);
        jPanel2.setBackground(Color.white);
        jPanel3.setBackground(Color.white);
        jPanel4.setBackground(Color.white);
        jPanel5.setBackground(Color.white);
        jPanel6.setBackground(Color.white);
        Profile_Bio.setEditable(false);
        anslutDatabas();
        setProfileInfo();
        setupProfile();
        inlagg = new InlaggMgt(AID);
        showSocInlagg("Socialt");
    }
    
public void showSocInlagg(String amne1){
    if(amne1 == null){
        amne1 = "Socialt";
        StyledDocument docSoc = txtPaneSocialt.getStyledDocument();
        inlagg.emptyInlaggPane(docSoc);
        inlagg.showSocInlagg1(docSoc, amne1);
    } else if(amne1.equals("Socialt")){
        StyledDocument docSoc = txtPaneSocialt.getStyledDocument();
        inlagg.emptyInlaggPane(docSoc);
        inlagg.showSocInlagg1(docSoc, amne1);
    } else if(amne1.equals("Forskning")){
        StyledDocument docForsk = jTextPaneForsk.getStyledDocument();  
        inlagg.emptyInlaggPane(docForsk);
        inlagg.showSocInlagg1(docForsk, amne1);
    } else if(amne1.equals("Utbildning")){
        StyledDocument docUtb = jTextPaneUtbildning.getStyledDocument();
        inlagg.emptyInlaggPane(docUtb);
        //String sqlFraga = "select ANSTALLD.FIRST_NAME, ANSTALLD.LAST_NAME, INLAGG.DATUM, INLAGG.TID, INLAGG.TEXT, INLAGG.TITEL, INLAGG.VISIBLE " +
        //"FROM ANSTALLD " + "JOIN INLAGG " + "ON ANSTALLD.AID = INLAGG.AID WHERE AMNE = 'Utbildning' ORDER BY IID ASC ;";
       inlagg.showSocInlagg1(docUtb, amne1);
    }
}
    
    // Metod för att ansluta till databasen
    private void anslutDatabas(){
        try{
            String path = System.getProperty("user.dir"); //Hämtar user direcotry
            idb = new InfDB(path + "/databas/DATABASE.FDB"); 
            System.out.println("Uppkopplingen lyckades");
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
    }
    //Fyller ProfileInfo listan med värden
    private void setProfileInfo(){
        String sqlFraga = "Select * from anstalld where anstalld.aid = " + AID + ";";
        try{
            ProfileInfo = idb.fetchRows(sqlFraga);
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
    }
    // Metod för att sätta upp profilen med data
    private void setupProfile(){
        // Loopar igenom hela ProfileInfo
        for (HashMap<String, String> ProfileInfo1 : ProfileInfo) {
            //Sparar Profilens info i applikationen
            if (AID.equals(ProfileInfo1.get("AID"))) {
                name = ProfileInfo1.get("FIRST_NAME");
                lastName = ProfileInfo1.get("LAST_NAME");
                city = ProfileInfo1.get("CITY");
                email = ProfileInfo1.get("EMAIL");
                phone = ProfileInfo1.get("TELEFON");
                BIO = ProfileInfo1.get("BIO");
                ProfilePicture = ProfileInfo1.get("PROFILE_PICTURE");
                break;
            }
        }
        // Ändrar på texten som LABELS har
        Name_Get.setText(name);
        LastName_Get.setText(lastName);
        City_Get.setText(city);
        Email_Get.setText(email);
        TelefonNr_Get.setText(phone);
        Profile_Bio.setText(BIO);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profil_main = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Profile_Bio = new javax.swing.JTextArea();
        Control_Panel = new javax.swing.JPanel();
        Edit_Profile = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Name_Get = new javax.swing.JLabel();
        LastName_Get = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        TelefonNr_Get = new javax.swing.JLabel();
        Email_Get = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTabPanelAmnen = new javax.swing.JTabbedPane();
        jtabPaneSocialt = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneSocialt = new javax.swing.JTextPane();
        jtabPaneForsk = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneForsk = new javax.swing.JTextPane();
        tabPaneUtb = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPaneUtbildning = new javax.swing.JTextPane();
        City_Get = new javax.swing.JLabel();
        Profile_OK_Exit = new javax.swing.JToggleButton();
        Profile_Cancel_Exit = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profil_main.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        profil_main.setName("Profile_maininfo"); // NOI18N

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setToolTipText("Din Profilbild");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        Profile_Bio.setColumns(20);
        Profile_Bio.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Profile_Bio.setRows(5);
        jScrollPane1.setViewportView(Profile_Bio);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Control_Panel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        Edit_Profile.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Edit_Profile.setText("Ändra din profil");
        Edit_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_ProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Control_PanelLayout = new javax.swing.GroupLayout(Control_Panel);
        Control_Panel.setLayout(Control_PanelLayout);
        Control_PanelLayout.setHorizontalGroup(
            Control_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Control_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Edit_Profile, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Control_PanelLayout.setVerticalGroup(
            Control_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Control_PanelLayout.createSequentialGroup()
                .addComponent(Edit_Profile)
                .addGap(0, 245, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout profil_mainLayout = new javax.swing.GroupLayout(profil_main);
        profil_main.setLayout(profil_mainLayout);
        profil_mainLayout.setHorizontalGroup(
            profil_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Control_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profil_mainLayout.setVerticalGroup(
            profil_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profil_mainLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Control_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setMaximumSize(new java.awt.Dimension(741, 531));
        jPanel3.setMinimumSize(new java.awt.Dimension(741, 531));
        jPanel3.setPreferredSize(new java.awt.Dimension(741, 531));

        Name_Get.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        Name_Get.setText("Name_Get");

        LastName_Get.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        LastName_Get.setText("LastName_Get");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name_Get, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastName_Get, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Name_Get)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastName_Get)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        TelefonNr_Get.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TelefonNr_Get.setText("TelefonNr_Get");

        Email_Get.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Email_Get.setText("Email_Get");

        jTabPanelAmnen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTabPanelAmnen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabPanelAmnenStateChanged(evt);
            }
        });

        jScrollPane2.setViewportView(txtPaneSocialt);

        javax.swing.GroupLayout jtabPaneSocialtLayout = new javax.swing.GroupLayout(jtabPaneSocialt);
        jtabPaneSocialt.setLayout(jtabPaneSocialtLayout);
        jtabPaneSocialtLayout.setHorizontalGroup(
            jtabPaneSocialtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        jtabPaneSocialtLayout.setVerticalGroup(
            jtabPaneSocialtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );

        jTabPanelAmnen.addTab("Socialt", jtabPaneSocialt);

        jScrollPane3.setViewportView(jTextPaneForsk);

        javax.swing.GroupLayout jtabPaneForskLayout = new javax.swing.GroupLayout(jtabPaneForsk);
        jtabPaneForsk.setLayout(jtabPaneForskLayout);
        jtabPaneForskLayout.setHorizontalGroup(
            jtabPaneForskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        jtabPaneForskLayout.setVerticalGroup(
            jtabPaneForskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );

        jTabPanelAmnen.addTab("Forskning", jtabPaneForsk);

        jScrollPane4.setViewportView(jTextPaneUtbildning);

        javax.swing.GroupLayout tabPaneUtbLayout = new javax.swing.GroupLayout(tabPaneUtb);
        tabPaneUtb.setLayout(tabPaneUtbLayout);
        tabPaneUtbLayout.setHorizontalGroup(
            tabPaneUtbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        tabPaneUtbLayout.setVerticalGroup(
            tabPaneUtbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );

        jTabPanelAmnen.addTab("Utbildning", tabPaneUtb);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabPanelAmnen))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabPanelAmnen)
                .addContainerGap())
        );

        City_Get.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        City_Get.setText("City_Get");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Email_Get, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(City_Get, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TelefonNr_Get, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelefonNr_Get)
                    .addComponent(City_Get))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email_Get)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        Profile_OK_Exit.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Profile_OK_Exit.setText("OK");
        Profile_OK_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Profile_OK_ExitActionPerformed(evt);
            }
        });

        Profile_Cancel_Exit.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Profile_Cancel_Exit.setText("Cancel");
        Profile_Cancel_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Profile_Cancel_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profil_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Profile_Cancel_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Profile_OK_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profil_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Profile_Cancel_Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Profile_OK_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Edit_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_ProfileActionPerformed
        ArrayList<String> Profile_Edit = new ArrayList<String>();
        Profile_Edit.add(Name_Get.getText());
        Profile_Edit.add(LastName_Get.getText());
        Profile_Edit.add(City_Get.getText());
        Profile_Edit.add(Email_Get.getText());
        Profile_Edit.add(TelefonNr_Get.getText());
        Profile_Edit.add(Profile_Bio.getText());
        this.EditProfile = new Profil_egen_edit(Profile_Edit, this.AID);
        
        if(!this.EditProfile.isVisible()){
            //this.setVisible(false);
            this.EditProfile.setVisible(true);
        }
        updateProfile();
    }//GEN-LAST:event_Edit_ProfileActionPerformed

    private void updateProfile(){
        ProfileInfo.clear();
        setProfileInfo();
        setupProfile();
    }
    
    private void Profile_OK_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Profile_OK_ExitActionPerformed
        exitActionPerformed(evt);
    }//GEN-LAST:event_Profile_OK_ExitActionPerformed

    private void Profile_Cancel_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Profile_Cancel_ExitActionPerformed
        exitActionPerformed(evt);
    }//GEN-LAST:event_Profile_Cancel_ExitActionPerformed

    private void jTabPanelAmnenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabPanelAmnenStateChanged
        String a = jTabPanelAmnen.getTitleAt(jTabPanelAmnen.getSelectedIndex());
        System.out.println(a);
        String b = "Forskning";
        String c = "Utbildning";
        String d = "Socialt";
        
        if(a.equals(b)){
            showSocInlagg(a);
            showSocInlagg(d);
        }
        if(a.equals(c)){
            showSocInlagg(a);
            showSocInlagg(d);
        }
    }//GEN-LAST:event_jTabPanelAmnenStateChanged
    
    private void exitActionPerformed(ActionEvent evt) {
        this.dispose();
    }
    
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
            java.util.logging.Logger.getLogger(Profil_egen_visa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profil_egen_visa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profil_egen_visa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profil_egen_visa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profil_egen_visa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel City_Get;
    private javax.swing.JPanel Control_Panel;
    private javax.swing.JButton Edit_Profile;
    private javax.swing.JLabel Email_Get;
    private javax.swing.JLabel LastName_Get;
    public javax.swing.JLabel Name_Get;
    private javax.swing.JTextArea Profile_Bio;
    private javax.swing.JToggleButton Profile_Cancel_Exit;
    private javax.swing.JToggleButton Profile_OK_Exit;
    private javax.swing.JLabel TelefonNr_Get;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabPanelAmnen;
    private javax.swing.JTextPane jTextPaneForsk;
    private javax.swing.JTextPane jTextPaneUtbildning;
    private javax.swing.JPanel jtabPaneForsk;
    private javax.swing.JPanel jtabPaneSocialt;
    private javax.swing.JPanel profil_main;
    private javax.swing.JPanel tabPaneUtb;
    private javax.swing.JTextPane txtPaneSocialt;
    // End of variables declaration//GEN-END:variables
}
