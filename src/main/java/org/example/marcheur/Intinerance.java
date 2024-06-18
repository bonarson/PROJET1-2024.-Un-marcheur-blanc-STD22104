package org.example.marcheur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intinerance {

    public List<String> marche(String lieuDepart, String lieuDestination) {
        List<String> ligneDeBase = Arrays.asList("Marais", "Sekoly", "Hei", "Pullman", "Nexta");
        List<String> croisements = Arrays.asList("Hei", "Pullman");
        int pointDePositionDepart = ligneDeBase.indexOf(lieuDepart);
        int pointDePositionDestination = ligneDeBase.indexOf(lieuDestination);
        int position = ligneDeBase.indexOf(lieuDepart);
        List<String> trajectoire = new ArrayList<>();
        List<String> lieuAcoteDeDestination = new ArrayList<>();
        List<List<String>> sousLigneDeBase = Arrays.asList(Arrays.asList("Balancoire", "Esti", "Boulvard"));

        List<String> trajectoireModifie = new ArrayList<>();
        if (ligneDeBase.contains(lieuDepart) && ligneDeBase.contains(lieuDestination)) {
            if (position != 0) {
                for (int i = position; i <= ligneDeBase.size() - 1; i++) trajectoire.add(ligneDeBase.get(i));
                for (int i = ligneDeBase.size() - 2; i >= position; i--) trajectoire.add(ligneDeBase.get(i));
                for (int i = position - 1; i >= 0; i--) trajectoire.add(ligneDeBase.get(i));
                for (int i = 1; i <= position; i++) trajectoire.add(ligneDeBase.get(i));
            } else {
                //========gauche deDEpart
                for (int i = position; i <= ligneDeBase.size() - 1; i++) trajectoire.add(ligneDeBase.get(i));
                for (int i = ligneDeBase.size() - 2; i >= position; i--) trajectoire.add(ligneDeBase.get(i));
            }
            if (pointDePositionDepart > pointDePositionDestination) {
                if (pointDePositionDestination < 3) {
                    List<String> x = trajectoire.reversed().subList(0, 2);
                    for (int i = 0; i < sousLigneDeBase.get(0).size(); i++) {
                        x.add(sousLigneDeBase.get(0).get(i));
                    }
                    x.add(sousLigneDeBase.get(0).get(0));
                    for (int i = 3; i >= 0; i--) {

                        if (!(ligneDeBase.get(i).equals(lieuDestination))) {
                            x.add(ligneDeBase.get(i));
                        } else {
                            x.add(ligneDeBase.get(i));
                            break;
                        }
                    }
                    return x;
                }
                return trajectoire.subList(0, trajectoire.indexOf(lieuDestination) + 1);

            } else if (pointDePositionDepart < pointDePositionDestination) {

                if (pointDePositionDestination > 2) {
                    List<String> x = trajectoire.reversed().subList(0, 3);
                    for (int i = 0; i < sousLigneDeBase.get(0).size(); i++) {
                        x.add(sousLigneDeBase.get(0).get(i));
                    }
                    x.add(sousLigneDeBase.get(0).get(0));
                    for (int i = 2; i < ligneDeBase.size(); i++) {
                        if (!(ligneDeBase.get(i).equals(lieuDestination))) {
                            x.add(ligneDeBase.get(i));
                        } else {
                            x.add(ligneDeBase.get(i));
                            break;
                        }
                    }
                    return x;
                }
                return (trajectoire.reversed()).subList(0, trajectoire.reversed().indexOf(lieuDestination) + 1);

            } else {
                return ligneDeBase.subList(pointDePositionDepart, pointDePositionDepart + 1);
            }
        } else if ((!ligneDeBase.contains(lieuDepart) && !ligneDeBase.contains(lieuDestination))) {

            if (sousLigneDeBase.get(0).indexOf(lieuDepart) < sousLigneDeBase.get(0).indexOf(lieuDestination)) {

                return sousLigneDeBase.get(0).subList(sousLigneDeBase.get(0).indexOf(lieuDepart),
                        sousLigneDeBase.get(0).indexOf(lieuDestination) + 1);

            } else if (sousLigneDeBase.get(0).indexOf(lieuDepart) > sousLigneDeBase.get(0).indexOf(lieuDestination)) {

                return (sousLigneDeBase.get(0).subList(sousLigneDeBase.get(0).indexOf(lieuDestination),
                        sousLigneDeBase.get(0).indexOf(lieuDepart) + 1)).reversed();
            } else {

                return sousLigneDeBase.get(0).subList(sousLigneDeBase.get(0).indexOf(lieuDepart),
                        sousLigneDeBase.get(0).indexOf(lieuDepart) + 1);
            }
        } else if (!ligneDeBase.contains(lieuDepart) && ligneDeBase.contains(lieuDestination)) {
            if (sousLigneDeBase.get(0).indexOf(lieuDepart) == 0) {
                trajectoireModifie.add(sousLigneDeBase.get(0).get(sousLigneDeBase.get(0).indexOf(lieuDepart)));
                trajectoireModifie.add(ligneDeBase.get(ligneDeBase.indexOf(lieuDestination)));
                return trajectoireModifie;
            } else if (sousLigneDeBase.get(0).indexOf(lieuDepart) == 1) {
                trajectoireModifie.add(sousLigneDeBase.get(0).get(1));
                trajectoireModifie.add(sousLigneDeBase.get(0).get(0));
                trajectoireModifie.add(ligneDeBase.get(ligneDeBase.indexOf(lieuDestination)));

            } else {
                trajectoireModifie.add(sousLigneDeBase.get(0).get(2));
                trajectoireModifie.add(sousLigneDeBase.get(0).get(1));
                trajectoireModifie.add(sousLigneDeBase.get(0).get(0));
                trajectoireModifie.add(ligneDeBase.get(ligneDeBase.indexOf(lieuDestination)));
            }
        } else if (ligneDeBase.contains(lieuDepart) && !ligneDeBase.contains(lieuDestination)) {

            if (position != 0) {
                for (int i = position; i >= 0; i--) trajectoire.add(ligneDeBase.get(i));
                for (int i = 1; i <= position; i++) trajectoire.add(ligneDeBase.get(i));
                for (int i = position + 1; i <= ligneDeBase.size() - 1; i++) trajectoire.add(ligneDeBase.get(i));
                for (int i = ligneDeBase.size() - 2; i >= position; i--) trajectoire.add(ligneDeBase.get(i));
            } else {
                //========gauche deDEpart
                for (int i = position; i <= ligneDeBase.size() - 1; i++) trajectoire.add(ligneDeBase.get(i));
                for (int i = ligneDeBase.size() - 2; i >= position; i--) trajectoire.add(ligneDeBase.get(i));
            }
            int k = 0;
            for (int w = 0; w < trajectoire.size(); w++) {

                if (trajectoire.get(w).equals(croisements.get(0))) {
                    k++;
                    if (k == 2) {
                        trajectoireModifie = trajectoire.subList(0, w + 1);
                    }
                }
            }
            int index = -1;
            for (List<String> list : sousLigneDeBase) {
                index = list.indexOf(lieuDestination);
                if (index != -1) {
                    break;
                }
            }
            for (int y = 0; y < sousLigneDeBase.get(0).size(); y++) {
                if (y != index) {
                    lieuAcoteDeDestination.add(sousLigneDeBase.get(0).get(y));
                    trajectoireModifie.add(sousLigneDeBase.get(0).get(y));
                }
            }
            trajectoireModifie.add(sousLigneDeBase.get(0).get(index));
            return trajectoireModifie;
        }
        return trajectoireModifie;
    }
}
