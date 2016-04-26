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
                    + "ANSTALLD JOIN DELTAGARE_MOTE ON ANSTALLD.AID = DELTAGARE_MOTE.AID "
                    + "WHERE MID = '" + mid + "'";
            String sqlEfternamn = "SELECT ANSTALLD.LAST_NAME FROM "
                    + "ANSTALLD JOIN DELTAGARE_MOTE ON ANSTALLD.AID = DELTAGARE_MOTE.AID "
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
    
    public ArrayList<String> hamtaInbjudnaAnstallda(String mid)
    {
        ArrayList<String> inbjudna = new ArrayList<String>();
        try
        {
            String sqlFornamn = "SELECT ANSTALLD.FIRST_NAME FROM "
                    + "ANSTALLD JOIN MOTE_ANSTALLD ON ANSTALLD.AID = MOTE_ANSTALLD.AID "
                    + "WHERE MID = '" + mid + "'";
            String sqlEfternamn = "SELECT ANSTALLD.LAST_NAME FROM "
                    + "ANSTALLD JOIN MOTE_ANSTALLD ON ANSTALLD.AID = MOTE_ANSTALLD.AID "
                    + "WHERE MID = '" + mid + "'";
            ArrayList<String> fornamn = new ArrayList<String>();
            fornamn = idb.fetchColumn(sqlFornamn);
            ArrayList<String> efternamn = idb.fetchColumn(sqlEfternamn);
            int i = 0;
            if(fornamn == null)
            {
               String info = "Det finns inga inbjudna till detta möte";
               inbjudna.add(info);
            }
            else
            {
            while(i < fornamn.size())
            {
                String heltNamn = fornamn.get(i) + " " + efternamn.get(i);
                inbjudna.add(heltNamn);
                i++;
            }
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return inbjudna;
    }
    
    
    public String hamtaAnstalldNamn(String ID)
    {
        String sqlFraga = "SELECT FIRST_NAME FROM ANSTALLD WHERE AID = " + ID + ";";
        String sqlFraga1 = "SELECT LAST_NAME FROM ANSTALLD WHERE AID = " + ID + ";";
        String fullName = "";
        
        try
        {
            fullName = idb.fetchSingle(sqlFraga) + " " + idb.fetchSingle(sqlFraga1);
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
        String sqlFraga = "INSERT INTO DELTAGARE_MOTE VALUES(" + MID + ", " + AID + ");";
        String sqlFraga1 = "DELETE FROM MOTE_ANSTALLD WHERE MID = " + MID + " AND AID = " + AID + ";";
        try
        {
            idb.delete(sqlFraga1);
            idb.insert(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void avanmalAnstalldMote(String AID, String MID)
    {
        String sqlFraga = "DELETE FROM DELTAGARE_MOTE WHERE MID = " + MID + " AND AID = " + AID + ";";
        String sqlFraga1 = "INSERT INTO MOTE_ANSTALLD VALUES(" + MID + ", " + AID + ");";
        try
        {
            idb.delete(sqlFraga);
            idb.insert(sqlFraga1);
            System.out.println(sqlFraga);
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
    
    /*
    *Hämtar aid för de som bekräftat att de kommer på ett möte
    */
    public ArrayList<String> hamtaAidFromMote(String MID)
    {
        String sqlFraga = "SELECT AID FROM DELTAGARE_MOTE WHERE MID = " + MID + ";";
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
    * Hämtar aid för inbjudna till ett specifikt möte
    */
    public ArrayList<String> hamtaAidFromMoteAnstalld(String MID)
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
    
    
    /*
    *Kollar om en anställd är inbjuden till möte
    */
    public boolean inbjudenTillMote(String aid, String mid)
    {
        boolean anmald = false;
        ArrayList<String> deltagare = new ArrayList<String>();
        deltagare = hamtaAidFromMoteAnstalld(mid);
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
            String sqlFraga = "insert into mote_anstalld values(" + mid + ", " + aid + ");";
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
            String sqlFraga = "SELECT MID FROM MOTE_FORSLAG WHERE TITEL = '" + titel + "';";
            mid = idb.fetchSingle(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return mid;
    }
    
    public ArrayList<String> hamtaInbjudnaTillMote(String MID)
    {
        String sqlFraga = "SELECT AID FROM MOTE_ANSTALLD WHERE MID ='" + MID + "';";
        ArrayList<String> inbjudna = new ArrayList<String>();
        try
        {
            inbjudna = idb.fetchColumn(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return inbjudna;
    }
    
    public HashMap<String, String> hamtaMotesForslagsInfo(String MID)
    {
        String sqlFraga = "SELECT * FROM MOTE_FORSLAG WHERE MID = " + MID + ";";
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
    
    public ArrayList<HashMap<String, String>> hamtaTidsForslag(String mID)
    {
        String sqlFraga = "select ID, TID from MOTE_ROSTNING WHERE MID = " + mID + ";";
        ArrayList<HashMap<String, String>> tider = new ArrayList<HashMap<String, String>>();
        try
        {
            tider = idb.fetchRows(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return tider;
    }
    
    /*
    * Ökar antalet röster för valt ID
    */
    public void rostaPaMote(String ID, String AID, String MID)
    {
        String sqlFraga = "select roster from MOTE_ROSTNING WHERE ID = " + ID + ";";
        
        try
        {
            String roster = idb.fetchSingle(sqlFraga);
            int rosterna = Integer.parseInt(roster);
            rosterna++;
            String nyttAntalRoster = Integer.toString(rosterna);
            String finalSqlFraga = "UPDATE MOTE_ROSTNING SET ROSTER = " + nyttAntalRoster + " WHERE ID = " + ID + ";";
            idb.update(finalSqlFraga);
            
            String sparaRost = "INSERT INTO ROSTAT_MOTE VALUES(" + MID + ", " + AID + ");";
            idb.insert(sparaRost);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<HashMap<String, String>> hamtaRoster(String MID)
    {
        String sqlFraga = "SELECT TID, ROSTER FROM MOTE_ROSTNING WHERE MID = " + MID + ";";
        ArrayList<HashMap<String, String>> roster = new ArrayList<HashMap<String, String>>();

        try
        {            
            roster = idb.fetchRows(sqlFraga);
            
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return roster;
    }
    
    /*
    * Returnerar true om personen röstat på tid för mötet
    */
    public boolean rostatPaMote(String MID, String AID)
    {
        String sqlFraga = "SELECT AID FROM ROSTAT_MOTE WHERE MID = " + MID + ";";
        boolean rostat = false;
        try
        {
            ArrayList<String> roster = new ArrayList<String>();
            roster = idb.fetchColumn(sqlFraga);
            
            if(roster != null)
            {
                for(String id : roster)
            {
                if(id.equals(AID))
                {
                    rostat = true;
                }
            }
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return rostat;
    }
    
    public ArrayList<String> hamtaInbjudningar(String AID)
    {
        String sqlFraga = "SELECT MID FROM MOTE_ANSTALLD WHERE AID = " + AID + ";";
        ArrayList<String> inbjudningar = new ArrayList<String>();
        try
        {
            inbjudningar = idb.fetchColumn(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return inbjudningar;
        
        
    }
    
    public String hamtaMotesForslagNamn(String MID)
    {
        String sqlFraga = "SELECT TITEL FROM MOTE_FORSLAG WHERE MID = " + MID + ";";
        String mote = "";
        try
        {
            mote = idb.fetchSingle(sqlFraga);
            
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return mote;
        
        
    }
    
    public ArrayList<String> hamtaSkapadeMoteNamn(String aid)
    {
        String sqlFraga = "SELECT MID, TITEL FROM MOTE WHERE ANSVARIG = " + aid + ";";
        ArrayList<String> mote = new ArrayList<String>();
        ArrayList<HashMap<String, String>> motesInfo = new ArrayList<HashMap<String, String>>();
        try
        {
            motesInfo = idb.fetchRows(sqlFraga);
            for(HashMap<String, String> infon : motesInfo)
            {
                String namn = infon.get("MID") + ". " + infon.get("TITEL");
                mote.add(namn);
            }
            if(mote == null)
            {
                mote.add("Inga skapade möten hittade");
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return mote; 
    }
    
    public ArrayList<String> hamtaForslagsNamn(String aid)
    {
        String sqlFraga = "SELECT MID, TITEL FROM MOTE_FORSLAG WHERE ANSVARIG = " + aid + ";";
        ArrayList<String> mote = new ArrayList<String>();
        ArrayList<HashMap<String, String>> motesInfo = new ArrayList<HashMap<String, String>>();
        try
        {
            motesInfo = idb.fetchRows(sqlFraga);
            
            if(motesInfo == null)
            {
                mote.add("Inga skapade moten hittade");
            }
            else
            {
                for(HashMap<String, String> infon : motesInfo)
            {
                String namn = infon.get("MID") + ". " + infon.get("TITEL");
                mote.add(namn);
            }
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return mote; 
    }
    
    public void skapaMote(String mid, String starttid, String sluttid, String aidAnsvarig, String datum, String plats, String titel, String beskrivning, String vecka, String veckoDag)
    {
        try
        {
            String sqlFraga = "insert into MOTE values (" + mid + ", '" + datum +
                    "', '" + plats + "','" + starttid + "', '" + sluttid + "','" + titel + "', '" + beskrivning +
                    "', " + aidAnsvarig + ", " + vecka + ", " + veckoDag + ");";
            idb.insert(sqlFraga);
                
            
            System.out.println("Success");
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> hamtaFardigaMid()
    {
        ArrayList<String> moten = new ArrayList<String>();
        try
        {
            String sqlFraga = "SELECT MID FROM MOTE";
            moten = idb.fetchColumn(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return moten;
    }
    
    public ArrayList<String> hamtaMotesforslagMid()
    {
        ArrayList<String> moten = new ArrayList<String>();
        try
        {
            String sqlFraga = "SELECT MID FROM MOTE_FORSLAG";
            moten = idb.fetchColumn(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return moten;
    }
    
    
}
