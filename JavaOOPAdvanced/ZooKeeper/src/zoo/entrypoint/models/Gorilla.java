package zoo.entrypoint.models;

public class Gorilla extends Animal{

	public Gorilla() {
		// TODO Auto-generated constructor stub
	}
	
	public void throwItem() {
		this.energyLevel -= 5;
		System.out.println("Wraaaaagggh");
	}
	
	public void eatBananas() {
		this.energyLevel +=10;
		System.out.println("Ummm-ummm");
	}
	
	public void climbTree() {
		this.energyLevel -=10;
		System.out.println("Belch Belch");
	}

}
