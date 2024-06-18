package org.example.carte;

import java.util.List;


public class Carte extends Lieu {

    public Carte(List<Object> listLieux) {
        super(listLieux);
    }

    public List<Object> getCarte() {
        return lieux;
    }
}
