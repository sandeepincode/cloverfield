import java.io.FileNotFoundException;
import java.io.IOException;

import Graph.Monster;
import Graph.interfaces.iGraph;
import Graph.interfaces.iMonster;

public class Main {

	private static iMonster monster;
	private static iGraph graph;
	private static MapParser Map;
	private static Integer MonsterCount;
	
	public static void main(String[] args) throws Exception {
		
		Map = new MapParser("world_map_medium.txt");
		
		graph = Map.createGraph();
		
		MonsterCount = 500;
		
		for(int i = 0; i < MonsterCount; i+=1) {
			
			String monsterName = "Monster " + i;
			monster = new Monster(monsterName);
			graph.addMonster(monster);
				
		}
		
		graph.runSimulation();
	}
}
