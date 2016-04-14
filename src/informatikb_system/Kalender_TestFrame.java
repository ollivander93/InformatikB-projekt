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
import java.text.DateFormat;

/**
 *
 * @author Oliver
 */
public class Kalender_TestFrame extends javax.swing.JFrame {

    private Mote mote;
    
    public Kalender_TestFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mote = new Mote();
        markeraCell();
        fillTime();
        setLableWeek();
        fillCbWeeks();
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
        String dag = getMandagDatum();
        ArrayList<HashMap<String, String>> moten = mote.hamtaMotenForVecka(realWeek);
        for(int i = 0; i < moten.size(); i++)
        {
           String datum = moten.get(i).get("DATUM");
           String datum2 = datum.substring(8, datum.length());
           String titel = moten.get(i).get("TITEL");
           String startTid = moten.get(i).get("START_TID");
           String slutTid = moten.get(i).get("SLUT_TID");
           String veckoDag = moten.get(i).get("VECKODAG");
           int veckoDag2 = Integer.parseInt(veckoDag);
           String startTid2 = startTid.substring(0, 2);
           int start = Integer.parseInt(startTid2);
           int motesDag = mote.getDayOfWeek(datum);
               DefaultTableModel model = (DefaultTableModel) tableCalendar.getModel();
               //tid, dag
               model.setValueAt(titel, start, veckoDag2);
        }
    }
    
    private String getMandagDatum()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        SimpleDateFormat simple = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, realWeek);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monday = simple.format(cal.getTime()).substring(8, 10);
        return monday;
    }
    
    private void getTisdagDatum()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        SimpleDateFormat simple = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, realWeek);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        String monday = simple.format(cal.getTime()).substring(8, 10);
    }
    
    private void getOnsdagDatum()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        SimpleDateFormat simple = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, realWeek);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        String monday = simple.format(cal.getTime()).substring(8, 10);
    }
        
    private void getTorsdagDatum()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        SimpleDateFormat simple = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, realWeek);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        String monday = simple.format(cal.getTime()).substring(8, 10);
    }
            
    private void getFredagDatum()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        SimpleDateFormat simple = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, realWeek);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        String monday = simple.format(cal.getTime()).substring(8, 10);
    }
          
    private void getLordagDatum()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        SimpleDateFormat simple = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, realWeek);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String monday = simple.format(cal.getTime()).substring(8, 10);
    }
                    
    private void getSondagDatum()
    {
        String week = cbWeeks.getSelectedItem().toString();
        int realWeek = Integer.parseInt(week);
        SimpleDateFormat simple = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, realWeek);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String monday = simple.format(cal.getTime()).substring(8, 10);
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
        int week = getWeek();
        lblVecka.setText("Vecka:" + week);
    }
    
    private void markeraCell()
    {
        tableCalendar.setCellSelectionEnabled(true);
        tableCalendar.getSelectionModel().addListSelectionListener(tableCalendar);
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

        tableCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableCalendar.setRowHeight(50);
        tableCalendar.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableCalendar);
        if (tableCalendar.getColumnModel().getColumnCount() > 0) {
            tableCalendar.getColumnModel().getColumn(0).setMinWidth(50);
            tableCalendar.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableCalendar.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        lblVecka.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblVecka.setText("Vecka:");

        jLabel1.setText("Välj vecka:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                new Kalender_TestFrame().setVisible(true);
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
