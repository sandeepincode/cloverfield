import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Graph.CityNode;
import Graph.Graph;
import Graph.interfaces.iCityNode;
import Graph.interfaces.iGraph;

public class MapParser {
	
	private BufferedReader fileInput;
	
	public MapParser(String filename) throws FileNotFoundException{
		fileInput = new BufferedReader(new FileReader(filename));
	}
	
	public iGraph createGraph() throws Exception {
		
		iGraph map = new Graph();
		iCityNode mainCityNode;
		
		String line = fileInput.readLine();
		StringTokenizer tokenizer;
		
		String mainCity;
		String DirtyString;
		String outboundCity;
		
		while( line != null) {
			
			tokenizer = new StringTokenizer(line);
			
			// Ignore empty lines
			if(!tokenizer.hasMoreTokens()) {
				line = fileInput.readLine();
				continue;
			}
			
			mainCity = tokenizer.nextToken();
			
			mainCityNode = new CityNode(mainCity);
			
			// No Directions
			if(!tokenizer.hasMoreTokens()) {
				throw new Exception("no city directions you cunt <3");
			}
			
			while(tokenizer.hasMoreTokens()) {
				
				DirtyString = tokenizer.nextToken();
				
				Integer equalsIndex = DirtyString.indexOf('=');
				
				outboundCity = DirtyString.substring((equalsIndex+1), (DirtyString.length())).trim().toLowerCase();
				
				mainCityNode.setCities(outboundCity);	
			
			}
			
			map.addCityNode(mainCityNode);
			
			line = fileInput.readLine();
		}
		return map;
	} 
	
}
