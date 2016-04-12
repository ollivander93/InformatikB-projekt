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
    
    public void skapaMote(String datum, String plats, String starttid, String sluttid, String titel, String beskrivning)
    {
        try
        {
            String sqlFraga = "insert into MOTE values (" + idb.getAutoIncrement("MOTE", "MID") + ", '" + datum +
                    "', '" + plats + "', '" + starttid + "', '" + sluttid + "','" + titel + "', '" + beskrivning + "');";
            System.out.println(sqlFraga);
            idb.insert(sqlFraga);
            System.out.println("Success");
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
}