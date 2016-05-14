public class Weapon extends Item {
	public enum WeaponType {
		RANGED, MELEE
	}

	public WeaponType type;

	public int minDamage;
	public int maxDamage;
	public int manaCost;
	public int dexDamage;
	public int strDamage;
	public int intDamage;
	public int absTrMod;
	public String traight;

	public Weapon(String n, WeaponType t, int min, int max, int c) {
		super(n, c);
		minDamage = min;
		maxDamage = max;
		type = t;
	}

	public static Weapon createShortSword() {
		Weapon w = new Weapon("short sword", Weapon.WeaponType.MELEE, 1, 3, 20);
		return w;
	}

	public static Weapon createBattleAxe() {
		Weapon w = new Weapon("battle axe", Weapon.WeaponType.MELEE, 2, 11, 64);
		return w;
	}

	public static Weapon createSaber() {
		Weapon w = new Weapon("saber", Weapon.WeaponType.MELEE, 5, 6, 54);
		return w;
	}

	public static Weapon createBroadSword() {
		Weapon w = new Weapon("broad sword", Weapon.WeaponType.MELEE, 10, 12,
				110);
		return w;
	}

	public static Weapon createSmallBow() {
		Weapon w = new Weapon("small bow", Weapon.WeaponType.RANGED, 2, 3, 30);
		return w;
	}

	public static Weapon createLongBow() {
		Weapon w = new Weapon("long bow", Weapon.WeaponType.RANGED, 6, 6, 72);
		return w;
	}

	public static Weapon createHuntingBow() {
		Weapon w = new Weapon("hunting bow", Weapon.WeaponType.RANGED, 1, 8, 54);
		return w;
	}

	public static Weapon createCrossbow() {
		Weapon w = new Weapon("crossbow", Weapon.WeaponType.RANGED, 10, 13, 138);
		return w;
	}

	public static Weapon createFireBallSpell() {
		Weapon w = new Weapon("fireball spell", Weapon.WeaponType.RANGED, 8,
				12, 100);
		w.manaCost = 40;
		w.traight="N/A";
		w.absTrMod=0;
		return w;
	}

	public static Weapon createLightningBoltSpell() {
		Weapon w = new Weapon("lightning bolt spell", Weapon.WeaponType.RANGED,
				7, 9, 100);
		w.intDamage = 2;
		w.manaCost = 40;
		w.absTrMod=2;
		w.traight="intelegance";
		return w;
	}

	public static Weapon createFreezingWindSpell() {
		Weapon w = new Weapon("freezing wind spell", Weapon.WeaponType.RANGED,
				7, 9, 100);
		w.strDamage = 1;
		w.manaCost = 40;
		w.traight="strength";
		w.absTrMod=1;
		return w;
	}

	public static Weapon createChokingVineSpell() {
		Weapon w = new Weapon("choking vine spell", Weapon.WeaponType.RANGED,
				7, 9, 100);
		w.dexDamage = 3;
		w.manaCost = 40;
		w.traight="dexterity";
		w.absTrMod=3;
		return w;
	}

}
