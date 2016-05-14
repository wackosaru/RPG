import java.util.ArrayList;
import java.util.Scanner;

public class Market {

	public enum MarketType {
		KING, ELF, DWARF, WITCH
	}

	public static ArrayList<String> validIn = new ArrayList<String>();
	public static ArrayList<Integer> validInNum = new ArrayList<Integer>();

	public ArrayList<Weapon> swords = new ArrayList<Weapon>();
	public ArrayList<Weapon> bows = new ArrayList<Weapon>();
	public ArrayList<Weapon> spells = new ArrayList<Weapon>();
	public ArrayList<Item> armor = new ArrayList<Item>();
	public ArrayList<Item> misc = new ArrayList<Item>();

	public Point shopLocation;

	public MarketType type;

	public String name;

	private String answer;

	public Market(String n, MarketType t) {
		swords.clear();
		bows.clear();
		spells.clear();
		armor.clear();
		misc.clear();

		name = n;

		type = t;
		if (type == MarketType.KING) {
			stockKing();
		}
		if (type == MarketType.ELF) {
			stockElf();
		}
		if (type == MarketType.DWARF) {
			stockDwarf();
		}
		if (type == MarketType.WITCH) {
			stockDwarf();
		}
	}

	public void stockKing() {

		swords.add(Weapon.createShortSword());
		swords.add(Weapon.createBattleAxe());
		swords.add(Weapon.createSaber());
		swords.add(Weapon.createBroadSword());
		bows.add(Weapon.createSmallBow());
		bows.add(Weapon.createLongBow());
		bows.add(Weapon.createHuntingBow());
		bows.add(Weapon.createCrossbow());
		spells.add(Weapon.createFireBallSpell());
		spells.add(Weapon.createChokingVineSpell());
		spells.add(Weapon.createFreezingWindSpell());
		spells.add(Weapon.createLightningBoltSpell());
		armor.add(Item.createIronArmor());
		armor.add(Item.createSteelArmor());
		armor.add(Item.createLeatherArmor());
	}

	public void stockElf() {

	}

	public void stockDwarf() {

	}

	public void stockWitch() {

	}

	public void buy(Player p) {
		Scanner c = new Scanner(System.in);
		int t = 0;
		validInNum.clear();

		System.out.println("\nswords:\tinput\tname\t\tdamage\tcost");
		for (int i = 0; i < swords.size(); i++) {
			System.out.print("\t" + t + "\t" + swords.get(i).name);
			if (swords.get(i).name.length() < 8) {
				System.out.print("\t");
			}
			System.out.println("\t" + swords.get(i).minDamage + "-"
					+ swords.get(i).maxDamage + "\t" + swords.get(i).cost);
			validInNum.add(t);
			t++;
		}

		System.out.println("\nbows:\tinput\tname\t\tdamage\tcost");
		for (int i = 0; i < bows.size(); i++) {
			System.out.print("\t" + t + "\t" + bows.get(i).name);
			if (bows.get(i).name.length() < 8) {
				System.out.print("\t");
			}
			System.out.println("\t" + bows.get(i).minDamage + "-"
					+ bows.get(i).maxDamage + "\t" + bows.get(i).cost);
			validInNum.add(t);
			t++;
		}

		System.out
				.println("\nspells:\tinput\tname\t\t\tdamage\tcost\tmana\tstat damage");
		for (int i = 0; i < spells.size(); i++) {
			System.out.print("\t" + t + "\t" + spells.get(i).name);
			if (spells.get(i).name.length() < 15) {
				System.out.print("\t");
			}
			System.out.println("\t" + spells.get(i).minDamage + "-"
					+ spells.get(i).maxDamage + "\t" + spells.get(i).cost
					+ "\t" + spells.get(i).manaCost + "\t"
					+ spells.get(i).absTrMod + " " + spells.get(i).traight);
			validInNum.add(t);
			t++;
		}

		/*
		 * System.out.println("\narmor: input\tname\t\tdamage\tcost"); for (int
		 * i = 0; i < swords.size(); i++) { System.out.print("\t" + t + "\t" +
		 * swords.get(i).name); if (swords.get(i).name.length() < 8) {
		 * System.out.print("\t"); } System.out.println("\t" +
		 * swords.get(i).minDamage + "-" + swords.get(i).maxDamage + "\t" +
		 * swords.get(i).cost); validInNum.add(t); t++; }
		 * 
		 * 
		 * 
		 * System.out.println("\nmisc: input\tname\t\tdamage\tcost"); for (int i
		 * = 0; i < swords.size(); i++) { System.out.print("\t" + t + "\t" +
		 * swords.get(i).name); if (swords.get(i).name.length() < 8) {
		 * System.out.print("\t"); } System.out.println("\t" +
		 * swords.get(i).minDamage + "-" + swords.get(i).maxDamage + "\t" +
		 * swords.get(i).cost); validInNum.add(t); t++; }
		 */

		System.out.println("what item would you like to get");
		int choice = -1;
		boolean answerValid = false;
		while (!answerValid) {
			choice = c.nextInt();
			for (int q = 0; q < validInNum.size(); q++) {
				if (choice == (validInNum.get(q))) {
					answerValid = true;
				}
			}
			if (!answerValid) {
				System.out.println("that was not a valid input");
			}

			t = 0;
			for (int i = 0; i < swords.size(); i++) {
				if (t == choice) {
					System.out.println("you now own the " + swords.get(i).name);
					p.inventory.add(swords.get(i));
					p.money -= swords.get(i).cost;
					System.out.println("you have " + p.money + " gold left");
				}
				t++;
			}
			for (int i = 0; i < bows.size(); i++) {
				if (t == choice) {
					System.out.println("you now own the " + bows.get(i).name);
					p.inventory.add(bows.get(i));
					p.money -= bows.get(i).cost;
					System.out.println("you have " + p.money + " gold left");
				}
				t++;
			}
			for (int i = 0; i < spells.size(); i++) {
				if (t == choice) {
					System.out.println("you now own the " + spells.get(i).name);
					p.inventory.add(spells.get(i));
					p.money -= spells.get(i).cost;
					System.out.println("you have " + p.money + " gold left");
				}
				t++;
			}

		}

	}

	public void sell(Player p) {
		Scanner c = new Scanner(System.in);
		validInNum.clear();
		System.out.println("what would you like to sell");
		System.out.println("input\tname\t\t\tvalue");

		for (int i = 0; i < p.inventory.size(); i++) {
			System.out.print(i + "\t" + p.inventory.get(i).name);
			if (swords.get(i).name.length() < 8) {
				System.out.print("\t");
			}
			if (swords.get(i).name.length() < 16) {
				System.out.print("\t");
			}
			System.out.println("\t" + (p.inventory.get(i).cost) / 2);
			validInNum.add(i);
		}
		int choice = -1;
		boolean answerValid = false;

		while (!answerValid) {
			choice = c.nextInt();
			for (int q = 0; q < validInNum.size(); q++) {
				if (choice == (validInNum.get(q))) {
					answerValid = true;
				}
			}
			if (!answerValid) {
				System.out.println("that was not a valid input");
			}

		}

		System.out.println("you sold your " + p.inventory.get(choice).name
				+ " for " + ((p.inventory.get(choice).cost) / 2) + "gold");
		p.money += (p.inventory.get(choice).cost) / 2;
		p.inventory.remove(choice);

	}

	public void visitMarket(Player p) {
		Scanner c = new Scanner(System.in);
		String answer = "";
		System.out.println("welcome to the " + name + "'s market");
		System.out.println("you have " + p.money + " gold\n");
		System.out.println("'B' Buy");
		System.out.println("'S' Sell");

		answer = c.nextLine();

		if (answer.equals("B")) {
			buy(p);
		}
		if (answer.equals("S")) {
			sell(p);
		}
	}
}
