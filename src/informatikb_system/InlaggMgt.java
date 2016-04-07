/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

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
    
     public void anslutDatabas()
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
        "ON ANSTALLD.AID = INLAGG.AID " +
        "WHERE ANSTALLD.FIRST_NAME = 'Karl';";
        try
        {
           inlagg = idb.fetchRows(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.print(sqlFraga);
        return inlagg;
    }
     
}
