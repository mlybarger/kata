package org.montyhall.kata;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	public boolean winner = false;
	
	public static Door pickWinningDoor(Door[] doors) {
		Random r = new java.util.Random();
		int i = r.nextInt(3);
		//System.out.println("i:" + i);
		doors[i].setPrize(true);
	    return doors[i];
	}
	
	public static void main(String[] args) {
		int winningCount = 0;
		for (int i=0; i<1000; i++)
		{
			Game game = new Game();
			game.play();
			if (game.winner) {
				winningCount++;
			}
		}
		System.out.println("winning Count:" + winningCount);
		
		winningCount = 0;
		for (int i=0; i<1000; i++)
		{
			Game game = new Game();
			game.playSecondStrategy();
			if (game.winner) {
				winningCount++;
			}
		}
		System.out.println("2nd winning Count:" + winningCount);
		
	}
	
	public void play() {
		Door[] doors = new Door[3];
		doors[0] = new Door();
		doors[1] = new Door();
		doors[2] = new Door();
		
		doors[0].setName("one");
		doors[1].setName("two");
		doors[2].setName("three");
		
		Door winner = Game.pickWinningDoor(doors);
		Door door = Game.pickRandomDoor(doors);
		Player player = new Player();
		player.setDoorName(door.getName());
		
		if (player.getDoorName().equals(winner.getName())) {
			this.winner = true;
		}
		
	}

	public static Door pickRandomDoor(Door[] doors) {
		Random r = new java.util.Random();
		int i = r.nextInt(3);
		//System.out.println("i:" + i);
		return doors[i];
	}

	public void playSecondStrategy() {
		Door[] doors = new Door[3];
		doors[0] = new Door();
		doors[1] = new Door();
		doors[2] = new Door();
		
		doors[0].setName("one");
		doors[1].setName("two");
		doors[2].setName("three");
		
		Door winner = Game.pickWinningDoor(doors);
		Door door = Game.pickRandomDoor(doors);
		Player player = new Player();
		player.setDoorName(door.getName());
		
		player.setDoorName(Game.pickOther(player.getDoorName(), doors));
		
		if (player.getDoorName().equals(winner.getName())) {
			this.winner = true;
		}
		
	}

	private static String pickOther(String doorName, Door[] doors) {
		// return door name from doors that isn't already picked and isn't winner.
		List doorList = new ArrayList();
		for (int i = 0; i < doors.length ; i++) {
			if (!doors[i].getName().equals(doorName)) {
				doorList.add(doors[i]);
			}
		}
		// doorList contains unpicked doors that isn't prize.  Now randomly pick one.
		// need to "show" one unpicked door.
		Random r = new Random();
		Door door1 = (Door) doorList.get(0);
		if (door1.isPrize())
			doorList.remove(doorList.get(1));
		else { 
			doorList.remove(door1);
		}		
		
		Door newdoor = (Door) doorList.get(r.nextInt(doorList.size()));
		//System.out.println("door:" + newdoor.getName());
		return newdoor.getName();
	}
	
}
