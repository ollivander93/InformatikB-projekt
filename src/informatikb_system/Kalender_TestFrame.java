/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Map;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Oliver
 */
public class Kalender_TestFrame extends javax.swing.JFrame {

    private Mote mote;
    private ArrayList<HashMap<String, String>> motesIden;
    private static String aid;
    private MyRenderer renderer;
    
    public Kalender_TestFrame(String aid) {
        initComponents();
        getContentPane().setBackground(Color.white);
        renderer = new MyRenderer();
        tableCalendar.setDefaultRenderer(Object.class, renderer);
        this.aid = aid;
        motesIden = new ArrayList<HashMap<String, String>>();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mote = new Mote();
        markeraCell();
        fillCbWeeks();
        tableCalendar.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        fyllKalender();
        
    }
    
    private void fillCbWeeks()
    {
        int week = getWeek();
        while(week < 53)
        {
            String strWeek = Integer.toString(week);
            cbWeeks.addItem(strWeek);
            week++;
        }
    }
    

        
    private void fyllKalender()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        ArrayList<HashMap<String, String>> moten = mote.hamtaMotenForVecka(realWeek);
        HashMap<String, String> motesInfoHash = new HashMap<>();
        if(moten != null)
        {
            for(int i = 0; i < moten.size(); i++)
            {
            String datum = moten.get(i).get("DATUM");
            String datum2 = datum.substring(8, datum.length());
            String titel = moten.get(i).get("TITEL");
            String startTid = moten.get(i).get("START_TID");
            String slutTid = moten.get(i).get("SLUT_TID");
            String veckoDag = moten.get(i).get("VECKODAG");
            String mid = moten.get(i).get("MID");
           
            motesInfoHash.put(mid, titel);
           
          
            int veckoDag2 = Integer.parseInt(veckoDag);
            String startTid2 = startTid.substring(0, 2);
            String slutTid2 = slutTid.substring(0, 2);
            int start = Integer.parseInt(startTid2);
            int slut = Integer.parseInt(slutTid2);
            int motesDag = mote.getDayOfWeek(datum);
            DefaultTableModel model = (DefaultTableModel) tableCalendar.getModel();
               //tid, dag
               model.setValueAt(titel, start, veckoDag2);
               renderer.getTableCellRendererComponent(tableCalendar, titel, true, true, start, veckoDag2);
            }
        }
        motesIden.add(motesInfoHash);
    }
    
    
    public void visaInfoOmMote()
    {
        int column = tableCalendar.getSelectedColumn();
        int row = tableCalendar.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableCalendar.getModel();
        Object obj = model.getValueAt(row, column);
        boolean found = false;
        if(obj != null)
        {
            for(int i = 0; i < motesIden.size(); i++)
            {
                HashMap<String, String> hash = motesIden.get(i);
                for(Map.Entry<String, String> entry : hash.entrySet())
                {
                    String key = entry.getKey();
                    String titel2 = entry.getValue();
                    String selectedTitel = getSelectedTitel();
                    HashMap<String, String> info = mote.getMoteId(titel2, key);
                    String mid21 = info.get("MID");
                    String titel21 = info.get("TITEL");
                            if(key.equals(mid21) && titel2.equals(titel21) && titel21.equals(selectedTitel) && !found)
                            {
                                MotesInfo motesInfo = new MotesInfo(mid21, aid);
                                motesInfo.setVisible(true);
                                found = true;
                            }
                    
                }
            }
        }
    }
    
    private String getSelectedTitel()
    {
        int column = tableCalendar.getSelectedColumn();
        int row = tableCalendar.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableCalendar.getModel();
        String titel = model.getValueAt(row, column).toString();
        return titel;
    }
    
    private void fillTime()
    {
        DefaultTableModel model = (DefaultTableModel) tableCalendar.getModel();
        for(int i = 0; i < 25; i++)
        {
            String str = Integer.toString(i) + ":00";
            if(i < 10)
            {
                str = "0" + str;
            }
            model.addRow(new Object[]{str});
        }
    }
    
    private int getWeek()
    {
        GregorianCalendar gc = new GregorianCalendar();
        int week = gc.get(Calendar.WEEK_OF_YEAR);
        return week;
    }
    
    private void setLableWeek()
    {
        String week = cbWeeks.getSelectedItem().toString();
        lblVecka.setText("Vecka:" + week);
    }
    
    private void markeraCell()
    {
        tableCalendar.setCellSelectionEnabled(true);
        tableCalendar.getSelectionModel().addListSelectionListener(tableCalendar);
    }
    
    private void setSondagRod()
    {
        DefaultTableCellRenderer headerRender = new DefaultTableCellRenderer();
        headerRender.setForeground(Color.red);
        tableCalendar.getColumnModel().getColumn(7).setHeaderRenderer(headerRender);
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
        tableCalendar = new javax.swing.JTable();
        lblVecka = new javax.swing.JLabel();
        cbWeeks = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1285, 700));
        setPreferredSize(new java.awt.Dimension(1285, 700));

        tableCalendar.setBackground(new java.awt.Color(255, 255, 255));
        tableCalendar.setBorder(null);
        tableCalendar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tableCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tid", "Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCalendar.setGridColor(new java.awt.Color(0, 0, 0));
        tableCalendar.setRowHeight(50);
        tableCalendar.setShowHorizontalLines(false);
        tableCalendar.setShowVerticalLines(true
        );
        tableCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCalendarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCalendar);
        if (tableCalendar.getColumnModel().getColumnCount() > 0) {
            tableCalendar.getColumnModel().getColumn(0).setMinWidth(50);
            tableCalendar.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableCalendar.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lblVecka.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblVecka.setText("Vecka:");

        cbWeeks.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbWeeksItemStateChanged(evt);
            }
        });

        jLabel1.setText("Välj vecka:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1273, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVecka, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(cbWeeks, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbWeeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVecka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbWeeksItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbWeeksItemStateChanged
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tableCalendar.getModel();
        for(int i = model.getRowCount() - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
       fillTime();
       fyllKalender();
       setLableWeek();
    }//GEN-LAST:event_cbWeeksItemStateChanged

    private void tableCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCalendarMouseClicked

        if(evt.getClickCount() == 2)
        {
            visaInfoOmMote();
        }
        
    }//GEN-LAST:event_tableCalendarMouseClicked

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
            java.util.logging.Logger.getLogger(Kalender_TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kalender_TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kalender_TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kalender_TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kalender_TestFrame(aid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbWeeks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVecka;
    private javax.swing.JTable tableCalendar;
    // End of variables declaration//GEN-END:variables
}
