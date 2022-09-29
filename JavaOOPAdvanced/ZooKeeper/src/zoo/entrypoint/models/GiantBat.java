package zoo.entrypoint.models;

public class GiantBat extends Animal {

	public GiantBat() {
		// TODO Auto-generated constructor stub
		this.energyLevel = 300;
	}
	
	public void fly() {
//		String name = this.getSimpleName();
		System.out.println("Reeeady, launchhhhh!!");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		this.energyLevel +=25;
	}
	
	public void attackTown() {
		System.out.println("AWWWWWW this is very tiring task....");
		this.energyLevel -= 100;
	}

}
