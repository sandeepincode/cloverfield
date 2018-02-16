package Graph;

import Graph.interfaces.iCityNode;
import Graph.interfaces.iMonster;

public class Monster implements iMonster {

	private String monsterName;
	private iCityNode currentCity;
	private int monsterMoveCount;
	private boolean alive;

	public Monster(String monsterName) {
		this.monsterName = monsterName;
		this.monsterMoveCount = 0;
		this.alive = true;
	}

	public String getMonsterName() {
		return this.monsterName;
	}

	public boolean moveMonster() {
		if (this.monsterMoveCount > 10000) {
			this.alive = false;
			return false;
		}
		this.monsterMoveCount += 1;
		return true;
	}

	public int getMonsterMoveCount() {
		return this.monsterMoveCount;
	}

	public iCityNode getCurrentCity() {
		return this.currentCity;
	}

	public boolean setCurrentCity(iCityNode city) {
		this.currentCity = city;
		return true;
	}

	public boolean isAlive() {
		return this.alive;
	}

	public boolean kill() {
		this.alive = false;
		return true;
	}

	public String toString() {

		String str = "";
		str += "Monster Name:" + this.monsterName;
		str += ", current Location:" + this.currentCity.getCity();
		str += ", Number of Moves Complete: " + String.valueOf(this.monsterMoveCount);
		str += ", Alive: " + String.valueOf(this.alive);

		return str;
	}
}
