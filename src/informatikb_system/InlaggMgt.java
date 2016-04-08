/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
      public ArrayList<HashMap<String, String>> hamtaInlagg()
    {
        ArrayList inlagg = new ArrayList<HashMap<String, String>>();
        String sqlFraga = "select ANSTALLD.FIRST_NAME, INLAGG.DATUM, INLAGG.TID, INLAGG.TEXT " +
        "FROM ANSTALLD " +
        "JOIN INLAGG " +
        "ON ANSTALLD.AID = INLAGG.AID;";
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
