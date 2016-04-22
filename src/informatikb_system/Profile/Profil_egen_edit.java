/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system.Profile;
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * @author Sethox
 */
public class Profil_egen_edit extends JFrame{
    private ArrayList<String> ProfileInfo;
    private InfDB idb;
    private String AID;
    private JFileChooser fc;
    
    // Test Konstruktor
    public Profil_egen_edit() {
        initComponents();
        ProfileEdit_Cancel_Exit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { System.exit(0); }});
    }
    // Standardkonstruktor
    public Profil_egen_edit(ArrayList<String> ProfileInfo, String AID) {
        this.AID = AID;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        this.ProfileInfo = ProfileInfo;
        this.ProfileEdit_Name.setText(ProfileInfo.get(0));
        this.ProfileEdit_LastName.setText(ProfileInfo.get(1));
        this.ProfileEdit_City.setText(ProfileInfo.get(2));
        this.ProfileEdit_Email.setText(ProfileInfo.get(3));
        this.ProfileEdit_Telephone.setText(ProfileInfo.get(4));
        this.ProfileEdit_Bio.setText(ProfileInfo.get(5));
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
        Edit_Picture_Btn = new javax.swing.JButton();
        Profil_info = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ProfileEdit_LastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ProfileEdit_Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ProfileEdit_City = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        ProfileEdit_Telephone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ProfileEdit_Email = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProfileEdit_Bio = new javax.swing.JTextArea();
        ProfileEdit_Cancel_Exit = new javax.swing.JToggleButton();
        ProfileEdit_OK_Exit = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ändra Profil");
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(741, 531));
        setMinimumSize(new java.awt.Dimension(741, 531));

        profil_main.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        profil_main.setName("Profile_maininfo"); // NOI18N

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setToolTipText("Din Profilbild");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        Edit_Picture_Btn.setText("Sätt in bild / Bytt bild");
        Edit_Picture_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_Picture_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Edit_Picture_Btn)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(Edit_Picture_Btn))
        );

        javax.swing.GroupLayout profil_mainLayout = new javax.swing.GroupLayout(profil_main);
        profil_main.setLayout(profil_mainLayout);
        profil_mainLayout.setHorizontalGroup(
            profil_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profil_mainLayout.setVerticalGroup(
            profil_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profil_mainLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        Profil_info.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ProfileEdit_LastName.setToolTipText("Skriv ditt Efternamn");

        jLabel2.setText("Efternamn:");
        jLabel2.setToolTipText("");

        ProfileEdit_Name.setToolTipText("Skriv ditt Namn");

        jLabel1.setText("Namn:");

        jLabel3.setText("Ort:");

        ProfileEdit_City.setToolTipText("Din adress");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProfileEdit_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(ProfileEdit_City))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileEdit_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ProfileEdit_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ProfileEdit_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ProfileEdit_City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel4.setText("Tel.Nr:");

        jLabel7.setText("Email:");

        ProfileEdit_Email.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileEdit_Telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(32, 32, 32)
                .addComponent(ProfileEdit_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ProfileEdit_Telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ProfileEdit_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Biografi:");

        ProfileEdit_Bio.setColumns(20);
        ProfileEdit_Bio.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ProfileEdit_Bio.setRows(5);
        jScrollPane1.setViewportView(ProfileEdit_Bio);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        ProfileEdit_Cancel_Exit.setText("Cancel");
        ProfileEdit_Cancel_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileEdit_Cancel_ExitActionPerformed(evt);
            }
        });

        ProfileEdit_OK_Exit.setText("OK");
        ProfileEdit_OK_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileEdit_OK_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Profil_infoLayout = new javax.swing.GroupLayout(Profil_info);
        Profil_info.setLayout(Profil_infoLayout);
        Profil_infoLayout.setHorizontalGroup(
            Profil_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Profil_infoLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Profil_infoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProfileEdit_Cancel_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProfileEdit_OK_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Profil_infoLayout.setVerticalGroup(
            Profil_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Profil_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Profil_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileEdit_Cancel_Exit)
                    .addComponent(ProfileEdit_OK_Exit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profil_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Profil_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profil_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Profil_info, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Edit_Picture_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_Picture_BtnActionPerformed
        // TODO add your handling code here:
        JButton btnLclPic = new JButton("Open File");
        btnLclPic.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                File selectedFile = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Pictures", "jpg", "gif", "bmp", "jpeg", "png");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }
            String[] newNames = { selectedFile.getName() };
            //Path source = Paths.get("images/source/image.jpg"); //original file
            Path source = Paths.get(selectedFile.getAbsolutePath()); //original file
            Path targetDir = Paths.get("images/target"); 
                try {
                    Files.createDirectories(targetDir);//in case target directory didn't exist
                    for (String name : newNames) {
                        Path target = targetDir.resolve(name);// create new path ending with `name` content
                        System.out.println("Copying into: " + target);
                        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                        // I decided to replace already existing files with same name
                    }
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                    //Logger.getLogger(Profil_egen_edit.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
        });
        JButton btnURL = new JButton("URL");
        btnURL.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                String URL = JOptionPane.showInputDialog("URL:");
                System.out.println(URL);
            }
        });
        
        Object[] options = {"Cancel", btnURL, btnLclPic};
                    int n = JOptionPane.showOptionDialog(frame,
                                    "What kind of picture do you want to upload?",
                                    "Picture Upload",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    options,
                                    options[2]);
                    /*if (n == JOptionPane.YES_OPTION) {
                        //setLabel("Here you go: green eggs and ham!");
                        
                    } else if (n == JOptionPane.NO_OPTION) {
                        //setLabel("OK, just the ham, then.");
                    } else if (n == JOptionPane.CANCEL_OPTION) {
                        //setLabel("Well, I'm certainly not going to eat them!");
                    } else {
                        //setLabel("Please tell me what you want!");
                    }*/
    }//GEN-LAST:event_Edit_Picture_BtnActionPerformed

    private void ProfileEdit_OK_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileEdit_OK_ExitActionPerformed
        UpdateInsert();
        exitActionPerformed(evt);
    }//GEN-LAST:event_ProfileEdit_OK_ExitActionPerformed

    private void ProfileEdit_Cancel_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileEdit_Cancel_ExitActionPerformed
        exitActionPerformed(evt);
    }//GEN-LAST:event_ProfileEdit_Cancel_ExitActionPerformed

    private void exitActionPerformed(ActionEvent evt) {
        this.dispose();
    }
    
    public void windowClosing(WindowEvent e) {
        System.out.println("WindowListener method called: windowClosing.");
        //A pause so user can see the message before
        //the window actually closes.
        ActionListener task = new ActionListener() {
            boolean alreadyDisposed = false;
            public void actionPerformed(ActionEvent e) {
                if (frame.isDisplayable()) {
                    alreadyDisposed = true;
                    frame.dispose();
                }
            }
        };
    }
    
    public void UpdateInsert(){
        try{
            String sql_Q = "UPDATE ANSTALLD set FIRST_NAME='" + ProfileInfo.get(0) + "',LAST_NAME='" + ProfileInfo.get(1)
                + "', TELEFON=" + ProfileInfo.get(4) + ", BIO='" + ProfileInfo.get(5) + "',CITY='" + ProfileInfo.get(2) + "',EMAIL='" + ProfileInfo.get(3) + "' where(AID=" + this.AID + ");";
            System.out.println(sql_Q);
           idb.update(sql_Q);
        } catch(InfException e) {
            System.out.println(e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(Profil_egen_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profil_egen_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profil_egen_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profil_egen_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profil_egen_edit().setVisible(true);
            }
        });
    }
/** Sets the text displayed at the bottom of the frame. */
    void setLabel(String newText) {
        GLobal_label.setText(newText);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit_Picture_Btn;
    private javax.swing.JPanel Profil_info;
    private javax.swing.JTextArea ProfileEdit_Bio;
    private javax.swing.JToggleButton ProfileEdit_Cancel_Exit;
    private javax.swing.JTextField ProfileEdit_City;
    private javax.swing.JTextField ProfileEdit_Email;
    private javax.swing.JTextField ProfileEdit_LastName;
    private javax.swing.JTextField ProfileEdit_Name;
    private javax.swing.JToggleButton ProfileEdit_OK_Exit;
    private javax.swing.JTextField ProfileEdit_Telephone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel profil_main;
    // End of variables declaration//GEN-END:variables
    private JLabel GLobal_label;
    private JFrame frame;
}