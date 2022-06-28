package pt.labfinal.model;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Toolkit {
	
	   public static String DIRETORIO = System.getProperty("user.dir") +
			                            "/data/";
	   private static BufferedReader itemStr;
	   private static BufferedReader componentesStr;
	   
	   public static String[][]retrieveItems() {
		   String mapFile =  DIRETORIO + "item.csv";
		   try {
			  itemStr = new BufferedReader(
		               new FileReader(mapFile));
		      } catch(IOException erro){
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
		   String mapFile =  DIRETORIO + "componentes.csv";
		   try {
			  componentesStr = new BufferedReader(
		               new FileReader(mapFile));
		      } catch(IOException erro){
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
