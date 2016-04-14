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
    
    public void skapaMote(String ansvarig, String datum, String plats, String starttid, String sluttid, String titel, String beskrivning, int vecka, int veckoDag)
    {
        try
        {
            String sqlFraga = "insert into MOTE values (" + idb.getAutoIncrement("MOTE", "MID") + ", '" + datum +
                    "', '" + plats + "', '" + starttid + "', '" + sluttid + "','" + titel + "', '" + beskrivning +
                    "', " + ansvarig + ", " + vecka + ", " + veckoDag + ");";
            idb.insert(sqlFraga);
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
            System.out.println(dayOfWeek);
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
        String sqlFraga = "Select mote.titel, mote.start_tid, mote.slut_tid, mote.ansvarig, mote.datum, mote.veckodag from mote" + 
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
}