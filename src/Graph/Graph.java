package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import Graph.interfaces.iCityNode;
import Graph.interfaces.iGraph;
import Graph.interfaces.iMonster;

public class Graph implements iGraph{

	private ArrayList<iCityNode> cityNodeList;
	private ArrayList<iMonster> monsterList;
	private Random random;
	
	public Graph() {
		
		this.cityNodeList = new ArrayList<iCityNode>();
		this.monsterList = new ArrayList<iMonster>();
		this.random = new Random();
	}
	
	public boolean addCityNode( iCityNode city ) {
		
		this.cityNodeList.add(city);
		return true;
	}

	public boolean addMonster( iMonster monster ) {
		
		Integer randomInt = this.random.nextInt(this.cityNodeList.size());
		iCityNode randomCity = this.cityNodeList.get(randomInt);
		monster.setCurrentCity(randomCity);
		this.monsterList.add(monster);
		randomCity.addMonster(monster);
		return true;
	}
	
	private void checkCities() {
		
		for(iCityNode cityNode : this.cityNodeList) {

			if( (cityNode.monsterCount() > 1) && cityNode.isDestroyed() == false ) {

				ArrayList<iMonster> deadMonsters = cityNode.monsterFightResults();
				cityNode.destroyCity();
				this.monsterList.removeAll(deadMonsters);	
			}	
		}
	}
	
	private void moveMonsters() {	
		
		for(iMonster monster : this.monsterList) {
			
			if (monster.isAlive()) {
				
				ArrayList<String> surroundingCities = monster.getCurrentCity().getSurroundingCities();
				Integer randomCityIndex = this.random.nextInt(surroundingCities.size());
				
				boolean moved = false;
				
				do{
					
					if( surroundingCities.isEmpty() ) {
						
						System.out.println(monster.getMonsterName() + " is trapped in the city:" + monster.getCurrentCity().getCity());
						monster.kill();
						moved = true;
						break;
					}
					
					if( monster.moveMonster() == false ) {
						
						System.out.println(monster.getMonsterName() + " hit the move limit.");
						monster.kill();
						moved = true;
						break;
					}
					
					for (iCityNode cityNode : this.cityNodeList) {
						
						if( (cityNode.getCity()).equalsIgnoreCase(surroundingCities.get(randomCityIndex))) {
							
							if (cityNode.isDestroyed() == false) {
								
								//System.out.println(monster.getMonsterName() + " moved to the City: " + cityNode.getCity());
								
								// Removing monster from current city, since pass through
								this.cityNodeList.get( this.cityNodeList.indexOf(monster.getCurrentCity()) ).removeMonster(monster);
								
								// Adding monster to the next city
								monster.setCurrentCity(cityNode);
								this.cityNodeList.get(this.cityNodeList.indexOf(cityNode)).addMonster(monster);
								
								monster.moveMonster();
								moved = true;
								
							} else {
								
								Integer indexof = surroundingCities.indexOf(surroundingCities.get(randomCityIndex));
								surroundingCities.remove(indexof);
								randomCityIndex = this.random.nextInt(surroundingCities.size());
								
							}	
						}
					}
				}while(!moved);
			}
		}
	}
	
	public void runSimulation() {
		do{
			checkCities();
			moveMonsters();
		}while(this.monsterList.size() > 0);
		System.out.println("Game Over Beeetch!");
	}
}
