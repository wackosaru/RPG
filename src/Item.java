public class Item {
	public int mass;
	public int cost;

	public String name;

	public int HPMod;
	public int manaMod;
	public int dexMod;
	public int strMod;
	public int intMod;

	public Item(String n, int c) {
		name = n;
		cost = c;
	}

	public static Item createLeatherArmor() {
		Item i = new Item("leather armor", 30);
		i.HPMod = 20;
		return i;
	}

	public static Item createIronArmor() {
		Item i = new Item("iron armor", 74);
		i.HPMod = 50;
		return i;
	}

	public static Item createSteelArmor() {
		Item i = new Item("steel armor", 150);
		i.HPMod = 100;
		return i;
	}

}
