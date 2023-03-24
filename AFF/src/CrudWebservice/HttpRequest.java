package CrudWebservice;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Clase HttpRequest: permite enviar (INSERT,DELETE,UPDATE) y recibir (SELECT) datos del WebService
 * 
 * 
 * @author encarna
 *
 */

public final class HttpRequest {

	
    /**
     * Hacemos cambio en nuestra base de datos
     * @param url
     * @param values
     * @return 
     */
    public static String POST_REQUEST(String url, String values) {
        try {
            StringBuilder result = new StringBuilder();
            URL url2 = new URL(url);
            URLConnection conn = url2.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(values);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            wr.close();
            rd.close();
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

   
    /**
     * Obtenemos el registro
     * @param url
     * @param values
     * @return 
     */
    public static String GET_REQUEST(String url, String values) {
        try {
            StringBuilder result = new StringBuilder();
            String URL = url + "?" + values+";";
            URL obj = new URL(URL);           
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //System.out.println("La url es: "+URL);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
    
    /**
     * Obtenemos los registros de nuestra tabla desde php
     * @param url
     * @return 
     */
    public static String GET_REQUEST1(String url) {
        try {
            StringBuilder result = new StringBuilder();
            String URL = url;
            URL obj = new URL(URL);           
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           // System.out.println("La url es: "+URL);
          //  System.out.println("La url2 es: "+URL2);
            
            //con.setRequestMethod("_POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
}