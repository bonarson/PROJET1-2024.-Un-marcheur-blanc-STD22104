package org.example.marcheur;

import java.util.Arrays;
import java.util.List;

public class run {
    public static void main(String[] args) {

        Carte carte = new Carte(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
        Intinerance bjani =new Intinerance();
        System.out.println(bjani.marche("Hei", "Esti",carte.getCarte()));

    }
}
