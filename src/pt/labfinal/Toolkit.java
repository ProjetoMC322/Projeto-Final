package pt.labfinal;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Toolkit {
	
	   public static String DIRETORIO = System.getProperty("user.dir") +
			                            "/src/pt/labfinal/";
	   private static BufferedReader mapStr;
	   
	   public static String[][]retrieveMap() {
		   String mapFile =  DIRETORIO + "map.csv";
		   try {
			  mapStr = new BufferedReader(
		               new FileReader(mapFile));
		      } catch(IOException erro){
		         erro.printStackTrace();
		      }
		   	
		   Vector<String[]> v = new Vector<String[]>();
		      try {
		         String line = mapStr.readLine();
		         while (line != null) {
		            String ln[]  = line.split(",");
		            v.add(ln);
		            line = mapStr.readLine();
		         }
		         mapStr.close();
		      } catch (Exception erro) {
		         erro.printStackTrace();
		      }
		      return (String[][])v.toArray(new String[v.size()][]);
	   }
}
