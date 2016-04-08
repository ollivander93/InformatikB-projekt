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
           
            for(String manad : datum)
            {
                String dag = manad.substring(8, manad.length());
                String manadForInlagg = manad.substring(5, 7);
                //om inlägget är gjort samma månad som nuvarande så läggs den till
                if(manadForInlagg.equals(thisMonth))
                {
                    dagar.add(dag);
                }
            }
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return dagar;
    }
    
    
}
