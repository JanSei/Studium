package lebewesen;

public abstract class Lebewesen implements Comparable<Lebewesen> {
	protected int alter;

	public int getAlter() {
		return alter;
	}
	
	@Override
	public int compareTo(Lebewesen that) {
		return (int) Math.signum(this.alter - that.alter);
	}
	
	@Override 
	public boolean equals(Object that) {
		if(this == that) return true;
		if( !(that instanceof Lebewesen) ) return false;
		if(this.getAlter() != ((Lebewesen) that).getAlter())
			return false;
		
			String nameC1 = "";
			String nameC2 = "";
			if(this instanceof Tier)
				nameC1 = ((Tier) this).getName();
			if(that instanceof Tier)
				nameC2 = ((Tier) that).getName();
			if(this instanceof Mensch)
				nameC1 = ((Mensch) this).getVorname().concat(" ").concat(((Mensch) this).getNachname());
			if(that instanceof Mensch)
				nameC2 = ((Mensch) that).getVorname().concat(" ").concat(((Mensch) that).getNachname());
			if(nameC1 == null && nameC2 == null)
				throw new NullPointerException();
			//TODO: this instanceof that			
			if(this instanceof Lebewesen)
				return nameC1.compareTo(nameC2) == 0 ? true : false;
				
			
		return nameC1.compareTo(nameC2) == 0 ? true : false;
	}
}
