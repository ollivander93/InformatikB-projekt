/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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
    

    
    public void skapaMotesForslag(ArrayList<String> tidsforslag, String ansvarig, String datum, String plats, String titel, String beskrivning, int vecka, int veckoDag)
    {
        try
        {
            String sqlFraga1 = "SELECT MID FROM MOTE_FORSLAG";
            ArrayList<String> kollaMoten = idb.fetchColumn(sqlFraga1);
            String id = "1"; 
            
            if(kollaMoten != null)
            {
               id = idb.getAutoIncrement("MOTE_FORSLAG", "MID");
            }
            String sqlFraga = "insert into MOTE_FORSLAG values (" + id + ", '" + datum +
                    "', '" + plats + "','" + titel + "', '" + beskrivning +
                    "', " + ansvarig + ", " + vecka + ", " + veckoDag + ");";
            idb.insert(sqlFraga);
           
            for(String forslag : tidsforslag)
            {
                String sqlKontroll = "SELECT ID FROM MOTE_ROSTNING";
                ArrayList<String> kollaTider = idb.fetchColumn(sqlKontroll);
                String id1 = "1";
            
                if(kollaTider != null)
                {
                    id1 = idb.getAutoIncrement("MOTE_ROSTNING", "ID");
                }
                String sqlFraga2 = "INSERT INTO MOTE_ROSTNING VALUES (" + id1 + ", '" + forslag + "', 0, " + id + ");";
                idb.insert(sqlFraga2);
                System.out.println(sqlFraga2);
                
            }
                
            
            System.out.println("Success");
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
        public int getDayOfWeek(String date)
    {
        Calendar cal = Calendar.getInstance();
        String today = cal.getTime().toString();
        //Gjorde ett dateFormat i formatet "yyyy-mm-dd"
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        //dayofweek är -1 för att visa att det har blivit fel om inte rätt värde returneras
        int dayOfWeek = -1;
        try
        {
            //konverterar datumsträngen till ett datum
            Date datum = format.parse(date);
            //sätter calendar objektet till datumet som man har stoppat in som parameter i metoden
            cal.setTime(datum);
            //hämtar vilken dag på veckan datumet är
            dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == 1)
            {
                dayOfWeek = 7;
                return dayOfWeek;
            }
            return dayOfWeek - 1;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return dayOfWeek;
    }
    
    public ArrayList<HashMap<String, String>> hamtaMotenForVecka(int vecka)
    {
        ArrayList<HashMap<String, String>> moten = new ArrayList<HashMap<String, String>>();
        String sqlFraga = "Select mote.titel, mote.start_tid, mote.slut_tid, mote.ansvarig, mote.datum, mote.veckodag, mote.mid from mote" + 
                " where mote.vecka = " + vecka + ";";
        try
        {
           moten = idb.fetchRows(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return moten;
    }
    
    public String getMoteTitel(String mid)
    {
        String sqlFraga = "Select mote.titel from mote where mote.mid = " + mid + ";";
        String titel = null;
        try
        {
            titel = idb.fetchSingle(sqlFraga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return titel;
    }
    
    public HashMap<String, String> getMoteId(String titel, String mid)
    {
        String sqlFraga = "Select mote.titel, mote.mid from mote where mote.mid = " + mid + " and mote.titel = '" + titel + "';";
        HashMap<String, String> info = new HashMap<>();
        try
        {
            info = idb.fetchRow(sqlFraga);
            return info;
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return info;
    }
}