package Graph.interfaces;
import Graph.CityNode;

public interface iMonster {
	
	public String getMonsterName();
	public boolean moveMonster();
	public int getMonsterMoveCount();
	public boolean isAlive();
	public boolean kill();
	public String toString();
	public boolean setCurrentCity(iCityNode randomCity);
	public iCityNode getCurrentCity();
	
}
