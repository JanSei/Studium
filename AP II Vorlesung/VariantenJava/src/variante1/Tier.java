package variante1;

enum TierArt {
    HASE, FUCHS
}

class Wald {
    public static void main(String[] args) {
        TierArt[] tiere = { TierArt.HASE, TierArt.FUCHS, TierArt.HASE };

        for (TierArt tier : tiere) {
            Wald.hunger(tier);
        }
    }

    static void hunger(TierArt t) {
        System.out.print("knurr..  ");
        Wald.fressen(t);
    }

    static void fressen(TierArt t) {
        switch (t) {
        case HASE:
            System.out.println("Wo ist das Möhrchen?");
            break;
        case FUCHS:
            System.out.println("Wo ist der Hase?");
        }
    }
}
