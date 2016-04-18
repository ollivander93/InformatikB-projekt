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
import java.time.LocalDateTime;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;


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
        ArrayList<String> dagar = new ArrayList();
        //hämtar dagens datum och översätter det till en string
        String todayDate = LocalDateTime.now().toString();
        //tar bara ut månaden ur stringen(dagens månad)
        String thisMonth = todayDate.substring(5, 7);
        try
        {
            String sqlFraga = "SELECT DATUM FROM MOTE;";
            datum = idb.fetchColumn(sqlFraga);
            if(datum != null)
            {
                for(String manad : datum)
                {
                    String dag = manad.substring(8, manad.length());
                    String manadForInlagg = manad.substring(5, 7);
                    //om inlägget är gjort samma månad som nuvarande så läggs den till
                    if(manadForInlagg.equals(thisMonth))
                    {
                    dagar.add(dag);
                    System.out.println(dagar);
                    }
                }
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return dagar;
    }
    
    /*
    * Hämtar all info om ett specifikt möte utifrån titel
    */
    public HashMap<String, String> hamtaMotesInfo(String mid)
    {
        String sqlFraga = "SELECT * FROM MOTE WHERE MID = " + mid + ";";
        HashMap<String, String> mote = new HashMap<String, String>();
        try
        {
            mote = idb.fetchRow(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return mote;
    }
   
    /*
    * Hämtar alla anställda för ett visst möte. Mötes-id som parameter
    */
    public ArrayList<String> hamtaAnstalldaMote(String mid)
    {
        ArrayList<String> anstallda = new ArrayList<String>();
        try
        {
            String sqlFornamn = "SELECT ANSTALLD.FIRST_NAME FROM "
                    + "ANSTALLD JOIN MOTE_ANSTALLD ON ANSTALLD.AID = MOTE_ANSTALLD.AID "
                    + "WHERE MID = '" + mid + "'";
            String sqlEfternamn = "SELECT ANSTALLD.LAST_NAME FROM "
                    + "ANSTALLD JOIN MOTE_ANSTALLD ON ANSTALLD.AID = MOTE_ANSTALLD.AID "
                    + "WHERE MID = '" + mid + "'";
            ArrayList<String> fornamn = idb.fetchColumn(sqlFornamn);
            ArrayList<String> efternamn = idb.fetchColumn(sqlEfternamn);
            int i = 0;
            if(fornamn.isEmpty())
            {
                System.out.println("rebarmuskel");
            }
            else
            {
            while(i < fornamn.size())
            {
                String heltNamn = fornamn.get(i) + " " + efternamn.get(i);
                anstallda.add(heltNamn);
                i++;
            }
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return anstallda;
    }
    
    
    public String hamtaAnstalldNamn(String ID)
    {
        String sqlFraga = "SELECT FIRST_NAME FROM ANSTALLD WHERE AID = '" + ID + "';";
        String sqlFraga1 = "SELECT LAST_NAME FROM ANSTALLD WHERE AID = '" + ID + "';";
        String fullName = "";
        
        try
        {
            fullName = idb.fetchSingle(sqlFraga) + idb.fetchSingle(sqlFraga1);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return fullName;
    }
    
    public ArrayList<String> hamtaAllaAnstallda()
    {
        String sqlAids = "SELECT AID FROM ANSTALLD;";
        String sqlFraga = "SELECT FIRST_NAME FROM ANSTALLD;";
        String sqlFraga1 = "SELECT LAST_NAME FROM ANSTALLD;";
        String fullName = "";
        ArrayList<String> aids = new ArrayList<String>();
        ArrayList<String> anstallda = new ArrayList<String>();
        ArrayList<String> fornamn = new ArrayList<String>();
        ArrayList<String> efternamn = new ArrayList<String>();
        try
        {
            aids = idb.fetchColumn(sqlAids);
            fornamn = idb.fetchColumn(sqlFraga);
            efternamn = idb.fetchColumn(sqlFraga1);
            for(int i = 0; i < fornamn.size(); i++)
            {
                fullName = aids.get(i) + ". " + fornamn.get(i) + " " + efternamn.get(i);
                anstallda.add(fullName);
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return anstallda;
    }
    
    public void anmalAnstalldTillMote(String AID, String MID)
    {
        String sqlFraga = "INSERT INTO MOTE_ANSTALLD VALUES(" + MID + ", " + AID + ");";
        try
        {
            idb.insert(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void avanmalAnstalldMote(String aid, String MID)
    {
        String sqlFraga = "DELETE FROM MOTE_ANSTALLD WHERE MID = " + MID + " AND AID = " + aid + ";";
        System.out.println(sqlFraga);
        try
        {
            idb.delete(sqlFraga);
        }
        catch(InfException e)
                {
                    System.out.println(e.getMessage());
                }
    }
        
        
    public String hamtaAnsvarigForMote(String MID)
    {
        String sqlFraga = "SELECT ANSVARIG FROM MOTE WHERE MID = " + MID + ";";
        String fullName = "";
        try
        {
            String aid = idb.fetchSingle(sqlFraga);
            String firstName = "SELECT FIRST_NAME FROM ANSTALLD WHERE AID = " + aid + ";";
            String lastName = "SELECT LAST_NAME FROM ANSTALLD WHERE AID = " + aid + ";";
            fullName = firstName + lastName;
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return fullName;
    }
    
    public ArrayList<String> hamtaAidFromMote(String MID)
    {
        String sqlFraga = "SELECT AID FROM MOTE_ANSTALLD WHERE MID = " + MID + ";";
        ArrayList<String> deltagare = new ArrayList<String>();
        try
        {
            deltagare = idb.fetchColumn(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return deltagare;
    }
    
    /*
    *Kollar om en anställd är anmäld till ett möte
    */
    public boolean anmaldTillMote(String aid, String mid)
    {
        boolean anmald = false;
        ArrayList<String> deltagare = new ArrayList<String>();
        deltagare = hamtaAidFromMote(mid);
        for(String deltagande : deltagare)
        {
            if(deltagande.equals(aid))
            {
                anmald = true;
            }
        }
        return anmald;
    }
    
    public void bjudInTillMote(String mid, String aid)
    {
        try
        {
            String sqlFraga = "insert into mote_anstalld values (" + mid + ", " + aid + ");";
            System.out.println(sqlFraga);
            idb.insert(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public String hamtaMid(String titel)
    {
        String mid = "";
        try
        {
            String sqlFraga = "SELECT MID FROM MOTE WHERE TITEL = '" + titel + "';";
            mid = idb.fetchSingle(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return mid;
    }
}
