/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.util.ArrayList;
import oru.inf.InfException;
import oru.inf.InfDB;

/**
 *
 * @author Oliver
 */
public class Anvandare {
    private InfDB idb;
    
    public Anvandare()
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
    
    public boolean valideraInloggning(String anvandarnamn, String losenord)
    {
        String sqlFraga = "SELECT ANSTALLD.LOSENORD "
                + "FROM ANSTALLD WHERE ANSTALLD.ANVANDARNAMN = '" + anvandarnamn + "';";
        String valideraLosenord = "";
        try        {

            valideraLosenord = idb.fetchSingle(sqlFraga);
            if(valideraLosenord.equals(losenord))
            {
                return true;
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public void laggTillNyAnvandare(String firstname, String lastname, String losenord, String telefon, String admin, String anvandarnamn)
    {
    
        try
        {
                String sqlFraga = "INSERT INTO ANSTALLD "
                + "VALUES(" + idb.getAutoIncrement("ANSTALLD", "AID") + ",'" + firstname + "', '" + lastname + "', '" + losenord + "', " + telefon + ", '" + admin + "', '" + anvandarnamn + "');";
            idb.insert(sqlFraga);
            System.out.println("Det funkade!");

        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
       
    
    }
    
}
