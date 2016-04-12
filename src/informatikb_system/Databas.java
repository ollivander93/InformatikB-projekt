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
    
    public HashMap<String, String> hamtaMotesInfo(String titel)
    {
        String sqlFraga = "SELECT * FROM MOTE WHERE TITEL = '" + titel + "'";
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
   
    public ArrayList<String> hamtaAnstalldaMote()
    {
        ArrayList<String> anstallda = new ArrayList<String>();
        try
        {
            String sqlFornamn = "SELECT ANSTALLD.FIRST_NAME FROM "
                    + "ANSTALLD JOIN MOTE_ANSTALLD ON ANSTALLD.AID = MOTE_ANSTALLD.AID;";
            String sqlEfternamn = "SELECT ANSTALLD.LAST_NAME FROM "
                    + "ANSTALLD JOIN MOTE_ANSTALLD ON ANSTALLD.AID = MOTE_ANSTALLD.AID;";
            ArrayList<String> fornamn = idb.fetchColumn(sqlFornamn);
            ArrayList<String> efternamn = idb.fetchColumn(sqlEfternamn);
            int i = 0;
            while(i < fornamn.size())
            {
                String heltNamn = fornamn.get(i) + " " + efternamn.get(i);
                anstallda.add(heltNamn);
                i++;
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return anstallda;
    }
}
