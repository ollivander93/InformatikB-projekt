/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.text.StyledDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Reinis
 */
public class InlaggMgt {
    private InfDB idb; 
 
    
   public InlaggMgt()
    {
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
     
     public void showSocInlagg1(StyledDocument d){
     String amne = "Socialt";
     ArrayList<HashMap<String, String>>  list = hamtaInlagg(amne);
       
       if(!(list.isEmpty())){
            for (int i = list.size() - 1; i >= 0; i--) {
                String firstName = list.get(i).get("FIRST_NAME");
                String datum = list.get(i).get("DATUM");
                String tid = list.get(i).get("TID");
                String bloggIn = list.get(i).get("TEXT");

                SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setForeground(AtrSet, Color.RED);
                StyleConstants.setBackground(AtrSet, Color.YELLOW);
                StyleConstants.setBold(AtrSet, true);
                try{
                d.insertString(0," ------------------------------------------------" + "\n" + firstName + "\n" + "Datum: " + datum + " Klockan: " + tid + "\n" + "\n" + bloggIn + "\n" + "\n" + "\n",AtrSet );
                    }catch(Exception e) { System.out.println(e); }
                    }
            }else{
           try{
               SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setForeground(AtrSet, Color.RED);
                StyleConstants.setBackground(AtrSet, Color.YELLOW);
                StyleConstants.setBold(AtrSet, true);
                d.insertString(0," Ooops, inga inlägg alls just nu #lonely" ,AtrSet );
                    }catch(Exception e) { System.out.println(e); }
                    }
       }
       
      public ArrayList<HashMap<String, String>> hamtaInlagg(String amne )
    {
        ArrayList inlagg = new ArrayList<HashMap<String, String>>();
        String sqlFraga = "select ANSTALLD.FIRST_NAME, INLAGG.DATUM, INLAGG.TID, INLAGG.TEXT " +
        "FROM ANSTALLD " +
        "JOIN INLAGG " +
        "ON ANSTALLD.AID = INLAGG.AID WHERE AMNE = '" + amne + "';";
        System.out.println(sqlFraga);
        try
        {
           inlagg = idb.fetchRows(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return inlagg;
    }
      
       public void emptyInlaggPane(StyledDocument dok){
           
        try {
            dok.remove(0, dok.getLength());
        } catch (BadLocationException ex) {
            System.out.print(ex.getMessage());
        }
   }

      public void laggTillBloggInlagg(String titel, String text, String aid)
      {
        String date = LocalDateTime.now().toString();
        String date2 = date.substring(0,10);
        String time = date.substring(11, 19);
        System.out.println(date2 + " Tid: " + time);
        String visible = "true";
          try
          {
    
          String sqlFraga = "INSERT INTO INLAGG "
                + "VALUES(" + idb.getAutoIncrement("INLAGG", "iid") + ",'" + titel + "', '" + date2 + "', '" + time + "', '" + visible + "', " + aid + ", '" + text + "');";  
          idb.insert(sqlFraga);
                
          }
          catch(InfException e)
          {
              System.out.println(e.getMessage());
          }
                  
      }

  
}
