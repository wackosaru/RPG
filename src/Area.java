public class Area {
	public enum AreaType {
		FOREST, MOUNTAIN, ROAD, KINGTOWN, ELFTOWN, DWARFTOWN, WITCHTOWN, TOWER, CASTLE
	}

	public AreaType type;
	public String name;

	public Area(Area.AreaType t) {
		type = t;

		if (type == Area.AreaType.FOREST) {
			name = "forest";
		}
		if (type == Area.AreaType.MOUNTAIN) {
			name = "mountain";
		}
		if (type == Area.AreaType.ROAD) {
			name = "road";
		}
		if (type == Area.AreaType.CASTLE) {
			name = "castle";
		}
		if (type == Area.AreaType.TOWER) {
			name = "tower";
		}
		if (type == Area.AreaType.ELFTOWN) {
			name = "elven town";
		}
		if (type == Area.AreaType.DWARFTOWN) {
			name = "dwarven town";
		}
		if (type == Area.AreaType.KINGTOWN) {
			name = "king's town";
		}
		if (type == Area.AreaType.WITCHTOWN) {
			name = "witch's town";
		}
	}

	public String displayName() {
		return name;
	}

	public boolean isTown() {
		if (type == Area.AreaType.DWARFTOWN || type == Area.AreaType.ELFTOWN
				|| type == Area.AreaType.KINGTOWN
				|| type == Area.AreaType.WITCHTOWN) {
			return true;
		} else {
			return false;
		}
	}

}
