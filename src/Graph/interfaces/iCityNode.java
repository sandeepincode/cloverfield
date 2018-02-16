package Graph.interfaces;
import java.util.ArrayList;

import Graph.Monster;

public interface iCityNode {
	
	public String getCity();
	public boolean setCities(String city);
	public ArrayList<String> getSurroundingCities();
	public boolean isDestroyed();
	public void destroyCity();
	public boolean addMonster(iMonster Monster);
	public boolean removeMonster(iMonster Monster);
	public int monsterCount();
	public ArrayList<iMonster> monsterFightResults();
	public String toString();
	
}
