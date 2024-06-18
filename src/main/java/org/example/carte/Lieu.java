package org.example.carte;
import java.util.Arrays;
import java.util.List;

public class Lieu {
    protected List<Object> lieux;

    public Lieu(List<Object> lieux) {
        this.lieux = lieux;
    }

    public List<Object> getLieux() {
        return lieux;
    }

    //        Lieu lieu = new Lieu(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
}
