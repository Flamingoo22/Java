package zoo.entrypoint.models;

public class Animal {
	protected int energyLevel;

	public Animal() {
		// TODO Auto-generated constructor stub
		this.energyLevel = 100;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public String displayEnergy() {
		String message = String.format("The current energy level is %d", energyLevel);
		return message;
	}

}
