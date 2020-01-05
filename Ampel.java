import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javafx.concurrent.*;

class Ampel
{
    String name = "ampel.local";    // IP-Adresse der Ampel
    String adresse = "http://"+name;

    // Methoden der Ampel
    /*
     * Gibt alle Informationen über die Lampe auf der Konsole aus
     */

    void infosAusgeben()
    {
        get(adresse);
    }

    /*
     * Einschalten
     */
    void setRot(boolean wert)
    {
        if(wert == true)
        {
            get(adresse + "/rotan");
        }
        if (wert == false)
        {
            get(adresse + "/rotaus");
        }
    }

    void setGelb(boolean wert)
    {
        if(wert == true)
        {
            get(adresse + "/gelban");
        }
        if (wert == false)
        {
            get(adresse + "/gelbaus");
        }
    }

    void setGruen(boolean wert)
    {
        if(wert == true)
        {
            get(adresse + "/gruenan");
        }
        if (wert == false)
        {
            get(adresse + "/gruenaus");
        }
    }

    private void get(String adresse){  

        try {
            URL url = new URL(adresse);                      
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            String readStream = readStream(con.getInputStream());
            System.out.println(readStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {

            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
