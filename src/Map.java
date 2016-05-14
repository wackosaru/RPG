import java.util.Random;
import java.util.Scanner;

public class Map {
	public Area[][] map;
	public int width;
	public int height;
	public Map (){
		map=new Area[][]{
				{ new Area(Area.AreaType.DWARFTOWN), new Area(Area.AreaType.MOUNTAIN), new Area(Area.AreaType.MOUNTAIN),  new Area(Area.AreaType.FOREST),   new Area(Area.AreaType.TOWER) },
				{ new Area(Area.AreaType.MOUNTAIN),  new Area(Area.AreaType.MOUNTAIN), new Area(Area.AreaType.WITCHTOWN), new Area(Area.AreaType.ROAD),     new Area(Area.AreaType.ROAD) },
				{ new Area(Area.AreaType.MOUNTAIN),  new Area(Area.AreaType.FOREST),   new Area(Area.AreaType.ROAD),      new Area(Area.AreaType.MOUNTAIN), new Area(Area.AreaType.FOREST) },
				{ new Area(Area.AreaType.ROAD),      new Area(Area.AreaType.ROAD),     new Area(Area.AreaType.KINGTOWN),  new Area(Area.AreaType.FOREST),   new Area(Area.AreaType.FOREST) },
				{ new Area(Area.AreaType.CASTLE),    new Area(Area.AreaType.MOUNTAIN), new Area(Area.AreaType.FOREST),    new Area(Area.AreaType.FOREST),   new Area(Area.AreaType.ELFTOWN) }
		};
		Random c = new Random();
		int r=c.nextInt()%3;
		width=5;
		height=5;
	}
	public void event(Player p){
		
	}
	
	
	
	
	
	
	public boolean onNorthEdge(Point p){
		if(p.y==height-1){	//index starts at 0 so I have to add 1
			return true;
		}else{
			return false;
		}
	}

	
	
	
	public boolean onEastEdge(Point p){
		if(p.x==width-1){	//index starts at 0 so I have to add 1
			return true;
		}else{
			return false;
		}
	}

	
	
	
	public boolean onSouthEdge(Point p){
		if(p.y==0){
			return true;
		}else{
			return false;
		}
	}

	
	
	
	public boolean onWestEdge(Point p){
		if(p.x==0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	public String areaName(Point p){
		return map[p.x][p.y].name;
	}
	
	
	public Area area(Point p){
		return map[p.x][p.y];
	}
}