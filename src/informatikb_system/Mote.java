/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;

public class Mote {
    
private InfDB idb;   

    public Mote()
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
    
    public void skapaMote(String id, String datum, String tid, String plats)
    {
        try
        {
            String sqlFraga = "insert into MOTE values (" + id + ", '" + datum +
                    "', '" + tid + "', '" + plats + "');";
            idb.insert(sqlFraga);
            System.out.println("Success");
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
}