package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.HashMap;

import Graph.interfaces.iCityNode;
import Graph.interfaces.iMonster;

public class CityNode implements iCityNode{
	
	private String city;
	private boolean isDestroyed;
	private Random random;
	private ArrayList<String> surroundingCities;
	private ArrayList<iMonster> monsterList;

	public CityNode(String city) {
		this.city = city;
		this.isDestroyed = false;
		this.random = new Random();
		this.surroundingCities = new ArrayList<String>();
		this.monsterList = new ArrayList<iMonster>();
	}
	
	public String getCity() {
		return this.city;
	}
	
	public boolean setCities(String city) {
		if( city.length() <= 0) {
			return false;
		}
		surroundingCities.add(city);
		return true;
	}
	
	public ArrayList<String> getSurroundingCities(){
		return this.surroundingCities;
	}
	
	public boolean isDestroyed() {
		return this.isDestroyed;
	}
	
	public void destroyCity() {
		this.isDestroyed = true;
	}

	public boolean addMonster(iMonster monster) {
		this.monsterList.add(monster);
		return true;
	}
	
	public boolean removeMonster(iMonster monster) {
		this.monsterList.remove(this.monsterList.indexOf(monster));
		return true;
	}

	public int monsterCount() {
		return this.monsterList.size();
	}

	public ArrayList<iMonster> monsterFightResults() {
		
		ArrayList<iMonster> deadMonsterList = new ArrayList<iMonster>();
		
		while(this.monsterList.size() != 1) {
			
			Integer randomIntWinner = this.random.nextInt(this.monsterList.size());
			Integer randomIntLoser = this.random.nextInt(this.monsterList.size());
				
			do {
				randomIntLoser = this.random.nextInt(this.monsterList.size());
			}while(randomIntWinner == randomIntLoser);
			
			System.out.println( monsterList.get(randomIntWinner).getMonsterName() + " has faught " + monsterList.get(randomIntLoser).getMonsterName() + " In the city, " + this.city+", and won!");
			
			iMonster monster = this.monsterList.get(randomIntLoser);
			
			this.monsterList.remove(monster);
			
			monster.kill();
			
			deadMonsterList.add(monster);			
		}
		return deadMonsterList;
	}
	
	// Mainly for debugging purposes
	public String toString() {
		
		String str = "";
		
		str += "City :" + this.city;
		str += ", isDestroyed:" + String.valueOf(this.isDestroyed);
		str += ", Surrounding Cities:" +  Arrays.toString(this.surroundingCities.toArray()); 
		str += " Monster count: " + String.valueOf(this.monsterList.size());
		
		for (iMonster monster : this.monsterList) {
			str += ", Monster: " + monster.getMonsterName() + " and Alive:" + String.valueOf(monster.isAlive());
		}
		
		return str;
	}
}
