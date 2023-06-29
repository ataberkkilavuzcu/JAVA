public class Tile {


Player owner = new Player("", "");
private String name;
private int soldiers;
private static boolean attackChk;

public static boolean getattackChk() {
	return attackChk;
}

public static void setattackChk(boolean a ) {
	attackChk=a;
}


public Tile(String name, Player owner, int soldiers) {
	this.name = name;
	this.owner = owner;
	this.soldiers = soldiers;
}

public Player getOwner() {
	return this.owner;
}



public boolean connectedTiles(Tile t) {
	if (this.name == "Marmara") {
		if(t.name == "Ankara" || t.name == "the Aegean" || t.name == "the Black Sea") {
		return true;
		}
		else {
			return false;
		}
	}
	if (this.name == "the Black Sea") {
		if(t.name == "Ankara" || t.name == "Marmara" || t.name == "the East") {
		return true;
		}
		else {
			return false;
		}
	}
	if (this.name == "the Mediterranean") {
		if(t.name == "Ankara" || t.name == "the Aegean" || t.name == "the Southeast") {
		return true;
		}
		else {
			return false;
		}
	}
	if (this.name == "the Aegean") {
		if(t.name == "Ankara" || t.name == "Marmara" || t.name == "the Mediterranean") {
		return true;
		}
		else {
			return false;
		}
	}
	if (this.name == "the East") {
		if(t.name == "Ankara" || t.name == "the Southeast" || t.name == "the Black Sea") {
		return true;
		}
		else {
			return false;
		}
	}
	if (this.name == "the Southeast") {
		if(t.name == "Ankara" || t.name == "the Mediterranean" || t.name == "the East") {
		return true;
		}
		else {
			return false;
		}
	}
	else {
		return true;
	}
}


public int getSoldiers() {
	return this.soldiers;
}

public void Deploy(int soldiers) {
		this.addSoldiers(soldiers);	
	
}





public String getName() {
	return this.name;
}
public void setOwner(Player owner) {
	this.owner = owner;
}

public void addSoldiers(int newsold) {
	this.soldiers += newsold;
	doomsdayGui.setButtonText(this);
}

public void attack(Player p,  Tile defender) {
	
	boolean cTiles=this.connectedTiles(defender);
	
	
	if (p == this.getOwner() && p != defender.getOwner()&&cTiles==true) {
	boolean success = attackChance(this, defender);
	
	if (success == false) {
		attackChk=true;
		this.addSoldiers(-(this.soldiers-1));
		if (defender.soldiers!=1) {
		defender.addSoldiers(-1);
		}
	}
	
	else if (success == true) {
		attackChk=true;
		defender.owner = this.owner;
		doomsdayGui.startingColor(defender);
		defender.addSoldiers(-defender.soldiers);
		if (this.soldiers <= 3) {
			this.addSoldiers(-1);
		}
		else {
		this.addSoldiers(-2);
		}
		this.moveSoldiers(this.getSoldiers()/2, defender);
		
	}
	}
	}


public void moveSoldiers(int a,Tile lost) {
	this.addSoldiers(-a);
	lost.addSoldiers(a);

	
}



public static boolean attackChance(Tile attacker, Tile defender) {
	int soldif = attacker.soldiers-defender.soldiers;
	int chance;
	long diceroll;

	if(soldif<-3) {
		chance = 20;
	}
	
	else if (soldif < -1) {
		chance = 30;
	}
	else if (soldif < 0) {
		chance = 35;
	}
	
	else if (soldif < 1) {
		chance = 50;
	}
	
	else if (soldif < 2) {
		chance = 60;
	}
	
	else if (soldif < 3) {
		chance = 70;
	}
	else if (soldif<4) {
		chance = 75;
	}
	
	else {
		chance = 80;
	}
	
	
	if (chance == 0)
		return false;
	
	else if (chance == 20) {
		diceroll = Math.round(Math.random() * 100);
		if (diceroll < 20)
			return true;
		else
			return false;
		}
	
	else if (chance == 40) {
		diceroll = Math.round(Math.random() * 100);
		if (diceroll < 40)
			return true;
		else
			return false;
		
	}
	
	else if (chance == 60) {
		diceroll = Math.round(Math.random() * 100);
		if (diceroll < 60)
			return true;
		else
			return false;
		
	}
	
	else if (chance == 80) {
		diceroll = Math.round(Math.random() * 100);
		if (diceroll < 80)
			return true;
		else
			return false;
		
	}
	
	else
		return true;
}

public static void setTiles(Player p1,Player p2,Tile... tiles) {
int p1tile = 3, p2tile = 3;
	
	for (int it = 1; it < 7; it++) {
		long play = Math.round(Math.random());
		if (p1tile == 0) {
			tiles[it].setOwner(p2);
			p2tile--;
		}
		
		else if (p2tile == 0) { 
			tiles[it].setOwner(p1);
			p1tile--;
		}
		
		else if (play == 1) {
			tiles[it].setOwner(p2);
			p2tile--;
		}
		
		else {
			tiles[it].setOwner(p1);
			p1tile--;
		}
	}
}



}



