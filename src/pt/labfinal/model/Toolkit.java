package pt.labfinal.model;

import java.util.Objects;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Toolkit {

	   public static String DIRETORIO = System.getProperty("user.dir") +
			                            "/data/";
	   private static BufferedReader itemStr;
	   private static BufferedReader componentesStr;
	   
	   public static String[][]retrieveItems() {
		   
		   try {
			   InputStream in = Toolkit.class.getResourceAsStream("/data/item.csv");
			  itemStr = new BufferedReader(
		               new InputStreamReader(in));
		      } catch(Exception erro){
		         erro.printStackTrace();
		      }
		   	
		   Vector<String[]> v = new Vector<String[]>();
		      try {
		         String line = itemStr.readLine();
		         while (line != null) {
		            String ln[]  = line.split(",");
		            v.add(ln);
		            line = itemStr.readLine();
		         }
		         itemStr.close();
		      } catch (Exception erro) {
		         erro.printStackTrace();
		      }
		      return (String[][])v.toArray(new String[v.size()][]);
	   }
	   
	   public static String[][]retrieveComponents() {
		   try {
			   InputStream in = Toolkit.class.getResourceAsStream("/data/componentes.csv");
			  componentesStr = new BufferedReader(
					  new InputStreamReader(in));
		      } catch(Exception erro){
		         erro.printStackTrace();
		      }
		   	
		   Vector<String[]> v = new Vector<String[]>();
		      try {
		         String line = componentesStr.readLine();
		         while (line != null) {
		            String ln[]  = line.split(",");
		            v.add(ln);
		            line = componentesStr.readLine();
		         }
		         componentesStr.close();
		      } catch (Exception erro) {
		         erro.printStackTrace();
		      }
		      return (String[][])v.toArray(new String[v.size()][]);
	   }
}
