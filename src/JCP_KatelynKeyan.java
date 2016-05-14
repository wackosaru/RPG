import java.util.ArrayList;
import java.util.Scanner;

public class JCP_KatelynKeyan {

	public static Market dwarf=new Market("dwarf",Market.MarketType.DWARF);
	public static Market elf=new Market("elf",Market.MarketType.ELF);
	public static Market king=new Market("king",Market.MarketType.KING);
	public static Market witch=new Market("witch",Market.MarketType.WITCH);

	public static void main(String[] args) {
		
		Map world;
		Player p1;
		
		
		
		System.out
				.println("King: Brave hero, I need your help. The evil witch has taken control of the weastern town.\n"
						+ "      Reinforcements are on their way, but they might not arrive in time. \n\n"
						+ "" + "Hero: Do not worry. I have got this.\n\n\n\n");
		world = new Map();
		p1 = new Player("Keyan",world);
		while (true) {
			p1.options(world);
		}

	}

}
