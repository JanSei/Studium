package lebewesen;

public abstract class Tier extends Lebewesen {
	protected String name;

	@Override
	public String toString() {
		return "Ich heiße " + this.name;
	}
	
	public String getName() {
		return name;
	}
}