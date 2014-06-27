package variante3;

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

abstract class Tier extends Object {    
    void hatHunger() {
        System.out.print("knurr.. ");
        this.willFressen();
    }
    
    abstract void willFressen();
}

final class Hase extends Tier {
    void willFressen() {
        System.out.println("Wo ist das Möhrchen?");
    }
}

final class Fuchs extends Tier {
    void willFressen() {
        System.out.println("Wo ist der Hase?");
    }
}
