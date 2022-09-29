package zoo.entrypoint;

import zoo.entrypoint.models.GiantBat;
import zoo.entrypoint.models.Gorilla;

public class ZooTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla g = new Gorilla();
		System.out.println(g.displayEnergy());
		g.throwItem();
		g.throwItem();
		g.throwItem();
		System.out.println(g.displayEnergy());
		g.eatBananas();
		g.eatBananas();
		System.out.println(g.displayEnergy());
		g.climbTree();
		
		
		
		GiantBat bat1 = new GiantBat();
		System.out.println(bat1.displayEnergy());
		bat1.attackTown();
		bat1.attackTown();
		bat1.attackTown();
		System.out.println(bat1.displayEnergy());
		bat1.eatHumans();
		bat1.eatHumans();
		System.out.println(bat1.displayEnergy());
		bat1.fly();
		bat1.fly();
		System.out.println(bat1.displayEnergy());
	}

}
