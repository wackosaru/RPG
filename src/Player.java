import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	public String charN;

	public ArrayList<Item> inventory;

	public int money = 100;

	public Point location;

	private Map world;
	
	public int HP;
	public int MaxHP = 100;
	public int Mana; // amount of mana currently available to the player
	public int MaxMana = 100; // maximum unmodified amount of mana a player can
								// carry at one time

	public int Str = 10;
	public int Dexterity = 10;
	public int Int = 10;

	public static ArrayList<String> validIn = new ArrayList<String>();

	public Player(String n, Map w) {
		charN = n;
		inventory = new ArrayList<Item>();
		HP = MaxHP;
		Mana = MaxMana;
		pickUp(Weapon.createShortSword());

		world = w;
		
		location = new Point(4, 0);
	}

	/**
	 * calculating total manaMod of all items in inventory
	 * 
	 * @return
	 */
	public int itemManaMod() {
		int m = 0;
		for (Item i : inventory) { // sets i to each item in inventory
			m += i.manaMod;
		}
		return m;
	}

	public int currentMaxMana() {
		return MaxMana + itemManaMod();
	}

	public void pickUp(Item i) {
		inventory.add(i);

	}

	public void move(Point p) {
		location = p;

		world.event(this);
	}

	public void options(Map m) {

		Scanner c = new Scanner(System.in);
		
		validIn.clear();

		System.out.println("you are at the "+m.areaName(location));
		System.out.println("\nyour options are to:\n");
		if (!m.onNorthEdge(location)) {
			System.out.println("'N' Move to the "
					+ m.areaName(location.toTheNorth()) + " to the north");
			validIn.add("N");
		}
		if (!m.onEastEdge(location)) {
			System.out.println("'E' Move to the "
					+ m.areaName(location.toTheEast()) + " to the east ");
			validIn.add("E");
		}
		if (!m.onSouthEdge(location)) {
			System.out.println("'S' Move to the "
					+ m.areaName(location.toTheSouth()) + " to the south");
			validIn.add("S");
		}
		if (!m.onWestEdge(location)) {
			System.out.println("'W' Move to the "
					+ m.areaName(location.toTheWest()) + " to the west");
			validIn.add("W");
		}

		if (m.area(location).isTown()) {
			System.out.println("'M' Purchase equipment at the market");
			validIn.add("M");
			System.out.println("'T' Visit the tavern");
			validIn.add("T");
		}

		System.out.println("'C' View character");
		validIn.add("C");

		String answer = "";
		boolean answerValid = false;
		while (!answerValid) {
			answer = c.nextLine();
			for (int q = 0; q < validIn.size(); q++) {
				if (answer.equals(validIn.get(q))) {
					answerValid = true;
				}
			}
			if (!answerValid) {
				System.out.println("that was not a valid input");
			}
		}

		switch (answer) {
		case "N":
			move(location.toTheNorth());
			break;
		case "E":
			move(location.toTheEast());
			break;
		case "S":
			move(location.toTheSouth());
			break;
		case "W":
			move(location.toTheWest());
			break;

		case "M":
			//TODO
			if(m.area(location).type==Area.AreaType.DWARFTOWN){
				JCP_KatelynKeyan.dwarf.visitMarket(this);
			}
			if(m.area(location).type==Area.AreaType.ELFTOWN){
				JCP_KatelynKeyan.elf.visitMarket(this);
			}
			if(m.area(location).type==Area.AreaType.KINGTOWN){
				JCP_KatelynKeyan.king.visitMarket(this);
			}
			if(m.area(location).type==Area.AreaType.WITCHTOWN){
				JCP_KatelynKeyan.witch.visitMarket(this);
			}
			break;

		case "T":
			visitTavern(m);
			break;

		case "C":
			viewCharacter();
			break;
		}
		// TODO:
	}
	
	
	
	

	public void visitTavern(Map m) {

	}

	public void viewCharacter() {

	}
}
