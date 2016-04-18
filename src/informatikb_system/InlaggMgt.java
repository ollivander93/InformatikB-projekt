/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
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
       
       if(!(list==null)){
            for (int i = list.size() - 1; i >= 0; i--) {
              String name = list.get(i).get("FIRST_NAME");
                String lastName = list.get(i).get("LAST_NAME");
                String datum = list.get(i).get("DATUM");
                String tid = list.get(i).get("TID");
                String bloggIn = list.get(i).get("TEXT");
                String title = list.get(i).get("TITEL");
                
                SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setAlignment(AtrSet, StyleConstants.ALIGN_CENTER);
                d.setParagraphAttributes(0, d.getLength(), AtrSet, false);
                StyleConstants.setBold(AtrSet, true);
                
                SimpleAttributeSet AtrSet1 = new SimpleAttributeSet();
                Font font = new Font ("Serif", Font.ROMAN_BASELINE, 20);
                
                StyleConstants.setFontFamily(AtrSet1, font.getFamily());
                StyleConstants.setFontSize(AtrSet1, font.getSize());
                
                try{
                d.insertString(0, bloggIn + "\n", AtrSet1);
                d.insertString(0," ------------------------------------------------" + "\n" + name + "  " + lastName + "\n" + title + "\n" + datum  +" "+ tid + "\n" + "\n",AtrSet );
                   }catch(Exception e) { System.out.println(e); }
                    }
            }else{
           try{
               SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setForeground(AtrSet, Color.BLACK);
                StyleConstants.setAlignment(AtrSet, StyleConstants.ALIGN_CENTER);
                StyleConstants.setBold(AtrSet, true);
                d.insertString(0," Ooops, inga inlägg alls just nu #lonely" ,AtrSet );
                    }catch(Exception e) { System.out.println(e); }
                    }
       }
     
     public void showForskInlagg1(StyledDocument d){
     String amne = "Forskning";
     ArrayList<HashMap<String, String>>  list = hamtaInlagg(amne);
       
       if(!(list == null)){
            for (int i = list.size() - 1; i >= 0; i--) {
                String name = list.get(i).get("FIRST_NAME");
                String lastName = list.get(i).get("LAST_NAME");
                String datum = list.get(i).get("DATUM");
                String tid = list.get(i).get("TID");
                String bloggIn = list.get(i).get("TEXT");
                String title = list.get(i).get("TITEL");
                
                SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setForeground(AtrSet, Color.BLACK);
                StyleConstants.setAlignment(AtrSet, StyleConstants.ALIGN_CENTER);
                d.setParagraphAttributes(0, d.getLength(), AtrSet, false);
                StyleConstants.setBold(AtrSet, true);
                
                SimpleAttributeSet AtrSet1 = new SimpleAttributeSet();
                Font font = new Font ("Serif", Font.ROMAN_BASELINE, 20);
                
                StyleConstants.setFontFamily(AtrSet1, font.getFamily());
                StyleConstants.setFontSize(AtrSet1, font.getSize());
                
                
                try{
                d.insertString(0, bloggIn + "\n", AtrSet1);
                d.insertString(0," ------------------------------------------------" + "\n" + name + "  " + lastName + "\n" + title + "\n" + datum  +" "+ tid + "\n" + "\n" + "\n",AtrSet );
               
                    }catch(Exception e) { System.out.println(e); }
                    }
            }else{
           try{
                SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setAlignment(AtrSet, StyleConstants.ALIGN_CENTER);
                d.setParagraphAttributes(0, d.getLength(), AtrSet, false);
                StyleConstants.setForeground(AtrSet, Color.BLACK);
                StyleConstants.setBold(AtrSet, true);
                d.insertString(0," Ooops, inga inlägg alls just nu #lonely" ,AtrSet );
                    }catch(Exception e) { System.out.println(e); }
                    }
       }
       
     public void showUtbInlagg1(StyledDocument d){
     String amne = "Utbildning";
     ArrayList<HashMap<String, String>>  list = hamtaInlagg(amne);
       
       if(!(list==null)){
            for (int i = list.size() - 1; i >= 0; i--) {
                String name = list.get(i).get("FIRST_NAME");
                String lastName = list.get(i).get("LAST_NAME");
                String datum = list.get(i).get("DATUM");
                String tid = list.get(i).get("TID");
                String bloggIn = list.get(i).get("TEXT");
                String title = list.get(i).get("TITEL");
                
                SimpleAttributeSet AtrSet = new SimpleAttributeSet();
                StyleConstants.setAlignment(AtrSet, StyleConstants.ALIGN_CENTER);
                d.setParagraphAttributes(0, d.getLength(), AtrSet, false);
                StyleConstants.setForeground(AtrSet, Color.BLACK);
                StyleConstants.setBold(AtrSet, true);
                d.setParagraphAttributes(0, d.getLength(), AtrSet, false);
                try{
                d.insertString(0," ------------------------------------------------" + "\n" + name + "  " + lastName + "\n" + title + "\n" + datum  +" "+ tid + "\n" + "\n" + bloggIn  +"\n" + "\n",AtrSet );
                    }catch(Exception e) { System.out.println(e); }
                    }
            }else{
           try{
               SimpleAttributeSet AtrSet = new SimpleAttributeSet();
               StyleConstants.setAlignment(AtrSet, StyleConstants.ALIGN_CENTER);
               d.setParagraphAttributes(0, d.getLength(), AtrSet, false);
               StyleConstants.setForeground(AtrSet, Color.BLACK);
               StyleConstants.setBold(AtrSet, true);
                d.insertString(0," Ooops, inga inlägg alls just nu #lonely" ,AtrSet );
                    }catch(Exception e) { System.out.println(e); }
                    }
       }
      public ArrayList<HashMap<String, String>> hamtaInlagg(String amne )
    {
        ArrayList inlagg = new ArrayList<HashMap<String, String>>();
        String sqlFraga = "select ANSTALLD.FIRST_NAME, ANSTALLD.LAST_NAME, INLAGG.DATUM, INLAGG.TID, INLAGG.TEXT, INLAGG.TITEL " +
        "FROM ANSTALLD " +
        "JOIN INLAGG " +
        "ON ANSTALLD.AID = INLAGG.AID WHERE AMNE = '" + amne + "' ORDER BY IID ASC ;";
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
}