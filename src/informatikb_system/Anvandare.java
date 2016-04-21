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
    private String aID;
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
            if(valideraLosenord == null)
            {
                return false;
            }
            
            if(valideraLosenord.equals(losenord))
            {
                setAID(anvandarnamn);
                return true;
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean isAdmin(String aid)
    {
        String sqlFraga = "Select anstalld.administrator from anstalld where anstalld.aid = " + aid + ";";
        String admin = "";
        try
        {
            admin = idb.fetchSingle(sqlFraga);
            if(admin.equals("true"))
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
    
    public void laggTillNyAnvandare(String firstname, String lastname, String losenord, String telefon, String admin, String anvandarnamn, String stad, String mail)
    {
    
        try
        {
                String sqlFraga = "INSERT INTO ANSTALLD "
                + "VALUES(" + idb.getAutoIncrement("ANSTALLD", "AID") + ",'" + firstname + "', '" + lastname + "', '" + losenord + "', " + telefon + ", '" + admin + "', '" + anvandarnamn
                        + "', 'Biografi', '" + stad + "', '" + mail + "');";
            idb.insert(sqlFraga);
            System.out.println("Det funkade!");

        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
       
    
    }
    
    private void setAID(String anvandarnamn)
    {
        String sqlFraga = "select anstalld.aid from anstalld where anstalld.anvandarnamn = '" + anvandarnamn + "';";
        String anstalldID = "";
        try
        {
            anstalldID = idb.fetchSingle(sqlFraga);
            aID = anstalldID;
        }
        
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public String getAID()
    {
        return aID;
    }
    
}
