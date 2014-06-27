package variante2;

class Wald {
    public static void main(String[] args) {
        Tier[] tiere = {
                new Tier(TierArt.HASE),
                new Tier(TierArt.FUCHS),
                new Tier(TierArt.HASE)};
        
        for (Tier tier : tiere) {
            tier.hatHunger();
        }        
    }
}

enum TierArt {
    HASE, FUCHS
}

class Tier {
    final TierArt art;
    
    Tier(TierArt art) {
        this.art = art;
    }
    
    TierArt getArt() {
        return this.art;
    }
    
    void hatHunger() {
        System.out.print("knurr.. ");
        this.willFressen();
    }
    
    void willFressen() {
        switch (this.getArt()) {
        case HASE:
            System.out.println("Wo ist das Möhrchen?");
            break;
        case FUCHS:
            System.out.println("Wo ist der Hase?");
        }
    }
}
 