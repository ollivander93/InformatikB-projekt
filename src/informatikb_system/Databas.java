package informatikb_system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oliver
 */
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;

public class Databas {
    
private InfDB idb;   

    public Databas()
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
    
    public ArrayList hamtaMotesDatum()
    {
        ArrayList<String> datum = new ArrayList();
        try
        {
            String sqlFraga = "SELECT DATUM FROM MOTE;";
            datum = idb.fetchColumn(sqlFraga);
            return datum;
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return datum;
    }
    
    
}
