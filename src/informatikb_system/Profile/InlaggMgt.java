/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system.Profile;
import com.sun.javafx.tk.FontLoader;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.text.*;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * @author Sethox
 */
public class InlaggMgt {
    private InfDB idb;
    private String AID;
 
    
public InlaggMgt(String AID){
    this.AID = AID;
    anslutDatabas();
}
    
private void anslutDatabas(){
    try{
        String path = System.getProperty("user.dir"); //Hämtar user direcotry
        idb = new InfDB(path + "/databas/DATABASE.FDB"); 
        System.out.println("Uppkopplingen lyckades");
    } catch(InfException e){
        System.out.println(e.getMessage());
    }
} 

public String getAnstNamn(String aid, String sqlFraga){
    //String sqlFraga = "SELECT ANSTALLD.FIRST_NAME FROM ANSTALLD WHERE AID = '" + aid + "';";
    System.err.println(sqlFraga);
    String ettNamn = "";
    System.err.println(sqlFraga);
    try{
        ettNamn = idb.fetchSingle(sqlFraga);
    }catch(InfException e){
        System.err.println("getAnstNamn funkar inte");
    }
        return ettNamn;
    }
     
public String getAnstEfterNamn(String aid, String sqlFraga){
    //String sqlFraga = "SELECT ANSTALLD.LAST_NAME FROM ANSTALLD WHERE AID = '" + aid + "';";
    String ettNamn = null;
    System.err.println(sqlFraga);
    try{
        ettNamn = idb.fetchSingle(sqlFraga);
        }catch(InfException e){
            System.err.println("getAnstEfterNamn funkar inte");
        }
        return ettNamn;
     }
     
public void showSocInlagg1(StyledDocument d, String amne){
    ArrayList<HashMap<String, String>>  list = hamtaInlagg(amne);
    if(!(list==null)){
        for (int i = list.size() - 1; i >= 0; i--) {
            String name = list.get(i).get("FIRST_NAME");
            String lastName = list.get(i).get("LAST_NAME");
            String datum = list.get(i).get("DATUM");
            String tid = list.get(i).get("TID");
            String bloggIn = list.get(i).get("TEXT");
            String title = list.get(i).get("TITEL");
            String vis = list.get(i).get("VISIBLE");
            
            SimpleAttributeSet AtrSet = new SimpleAttributeSet();
            Font font1 = new Font ("Serif", Font.ITALIC, 20);
            StyleConstants.setAlignment(AtrSet, StyleConstants.ALIGN_CENTER);
            d.setParagraphAttributes(0, d.getLength(), AtrSet, false);
            StyleConstants.setFontFamily(AtrSet, font1.getFamily());
            StyleConstants.setFontSize(AtrSet, font1.getSize());
                
            SimpleAttributeSet AtrSet1 = new SimpleAttributeSet();
            Font font = new Font ("Serif", Font.ITALIC, 15);
            StyleConstants.setForeground(AtrSet1, Color.white);
            StyleConstants.setBackground(AtrSet1, Color.RED);
            StyleConstants.setFontFamily(AtrSet1, font.getFamily());
            StyleConstants.setFontSize(AtrSet1, font.getSize());
                
            SimpleAttributeSet AtrSet2 = new SimpleAttributeSet();
            StyleConstants.setBold(AtrSet, true);
            StyleConstants.setFontFamily(AtrSet1, font.getFamily());
            StyleConstants.setFontSize(AtrSet1, font.getSize());
            
            if(vis.equals("true")){
                try{
                    d.insertString(0, tid + "  "+ datum + "\n", AtrSet2);
                    d.insertString(0, bloggIn + "\n " + "\n", AtrSet2);
                    d.insertString(0,"\""+ title + "\""+"\n", AtrSet);
                    d.insertString(0,"\n" + name + "  " + lastName + "\n", AtrSet1);
                    d.insertString(0," ------------------------------------------------" ,AtrSet);
                
                } catch(Exception e) { System.out.println(e); }
            }
        }
    } else if(list ==null){
        try{
            SimpleAttributeSet AtrSet2 = new SimpleAttributeSet();
            StyleConstants.setForeground(AtrSet2, Color.BLACK);
            StyleConstants.setAlignment(AtrSet2, StyleConstants.ALIGN_CENTER);
            StyleConstants.setBold(AtrSet2, true);
            d.insertString(0," Ooops, inga inlägg alls just nu #lonely" ,AtrSet2 );
            } catch(Exception e) { System.out.println(e); }
    }
}
     
public ArrayList<HashMap<String, String>> hamtaInlagg(String amne){
    ArrayList inlagg = new ArrayList<HashMap<String, String>>();
    String sqlFraga = "select ANSTALLD.FIRST_NAME, ANSTALLD.LAST_NAME, INLAGG.DATUM, INLAGG.TID, INLAGG.TEXT, INLAGG.TITEL, INLAGG.VISIBLE " +
    "FROM ANSTALLD " + "JOIN INLAGG " + "ON ANSTALLD.AID = INLAGG.AID WHERE AMNE = '" + amne + "' AND ANSTALLD.AID = " + this.AID + " ORDER BY IID ASC ;";
    System.out.println(sqlFraga);
    try{
        inlagg = idb.fetchRows(sqlFraga);
    } catch(InfException e){
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