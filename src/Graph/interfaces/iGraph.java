package Graph.interfaces;
import Graph.CityNode;
import Graph.Monster;

public interface iGraph {
	
	public boolean addCityNode( iCityNode mainCityNode );
	public boolean addMonster( iMonster monster);
	public void runSimulation();
	
}
