package org.example.marcheur;

import java.util.List;
import java.util.Objects;

public class Carte  {
   List<Object> carte;

   public Carte(List<Object> carte) {
      this.carte = carte;
   }

   public List<Object> getCarte() {
      return carte;
   }
}
