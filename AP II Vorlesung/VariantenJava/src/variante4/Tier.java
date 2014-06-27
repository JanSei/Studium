package variante4;

final class Wald {
    public static void main(String[] args) {
        Tier[] tiere = {
                new Hase(),
                new Fuchs(),
                new Hase()};
        
        for (Tier tier : tiere) {
            tier.hatHunger();
        }     
    }
}

interface Tier {
    void willFressen();
    void hatHunger();
}

class Hase implements Tier {
    public void hatHunger() {
        System.out.print("knurr.. ");
        this.willFressen();
    }
    
    public void willFressen() {
        System.out.println("Wo ist das Möhrchen?");
    }
}

class Fuchs implements Tier {
    public void hatHunger() {
        System.out.print("knurr.. ");
        willFressen();
    }
    
    public void willFressen() {
        System.out.println("Wo ist der Hase?");
    }
}
 