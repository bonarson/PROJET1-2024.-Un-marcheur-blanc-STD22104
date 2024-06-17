package org.example.marcheur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intinerance {


    public List<String> marche(String lieuDepart, String lieuDestination, List<Object> carte) {
        List<String> simpleStrings = new ArrayList<>();
        for (Object element : carte) {
            if (element instanceof String) {
                simpleStrings.add((String) element);
            }
        }

        int indexDepart = simpleStrings.indexOf(lieuDepart);
        List<String> st1 = new ArrayList<>();
        List<String> st2 = new ArrayList<>();

        List<String> targetStrings = new ArrayList<>(simpleStrings);
        List<List<String>> targetLists = Arrays.asList(Arrays.asList("Balancoire", "Esti", "Boulvard"));

        List<String> rp = new ArrayList<>();
        for (int i = 0; i < carte.size(); i++) {
            if (targetStrings.contains(carte.get(i))) {
                if (i - 1 >= 0 && carte.get(i - 1) instanceof List && targetLists.contains(carte.get(i - 1))) {
                    rp.add((String) carte.get(i));
                    // System.out.println(str.get(i));
                } else if (i + 1 < carte.size() && carte.get(i + 1) instanceof List && targetLists.contains(carte.get(i + 1))) {
                    rp.add((String) carte.get(i));
                    // System.out.println(str.get(i));
                }
            }
        }

        List<String> st1Mod = new ArrayList<>();
//        System.out.println("ST1 MODIFIER");
        if (simpleStrings.contains(lieuDepart) && simpleStrings.contains(lieuDestination)) {
            if (indexDepart != 0) {
                for (int i = indexDepart; i >= 0; i--) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = 1; i <= indexDepart; i++) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = indexDepart + 1; i <= simpleStrings.size() - 1; i++) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = simpleStrings.size() - 2; i >= indexDepart; i--) {
                    st1.add(simpleStrings.get(i));
                }
            } else {
                //========gauche deDEpart
                for (int i = indexDepart; i <= simpleStrings.size() - 1; i++) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = simpleStrings.size() - 2; i >= indexDepart; i--) {
                    st1.add(simpleStrings.get(i));
                }
            }
            if (simpleStrings.indexOf(lieuDepart) > simpleStrings.indexOf(lieuDestination)) {
                return simpleStrings.subList(simpleStrings.indexOf(lieuDestination), simpleStrings.indexOf(lieuDepart) + 1).reversed();

            } else if (simpleStrings.indexOf(lieuDepart) < simpleStrings.indexOf(lieuDestination)) {
                return simpleStrings.subList(simpleStrings.indexOf(lieuDepart), simpleStrings.indexOf(lieuDestination) + 1);

            } else {
                return simpleStrings.subList(simpleStrings.indexOf(lieuDepart), simpleStrings.indexOf(lieuDepart) + 1);
            }

        } else if ((!simpleStrings.contains(lieuDepart) && !simpleStrings.contains(lieuDestination))) {
            if (targetLists.get(0).indexOf(lieuDepart) < targetLists.get(0).indexOf(lieuDestination)) {
                return targetLists.get(0).subList(targetLists.get(0).indexOf(lieuDepart), targetLists.get(0).indexOf(lieuDestination) + 1);

            } else if (targetLists.get(0).indexOf(lieuDepart) > targetLists.get(0).indexOf(lieuDestination)) {
                return (targetLists.get(0).subList(targetLists.get(0).indexOf(lieuDestination), targetLists.get(0).indexOf(lieuDepart) + 1)).reversed();

            } else {
                return targetLists.get(0).subList(targetLists.get(0).indexOf(lieuDepart), targetLists.get(0).indexOf(lieuDepart) + 1);
            }

        } else if (!simpleStrings.contains(lieuDepart) && simpleStrings.contains(lieuDestination)) {
            if (targetLists.get(0).indexOf(lieuDepart)==0){
                st1Mod.add(targetLists.get(0).get(targetLists.get(0).indexOf(lieuDepart)));
                st1Mod.add(simpleStrings.get(simpleStrings.indexOf(lieuDestination)));
                return st1Mod;
            } else if (targetLists.get(0).indexOf(lieuDepart)==1) {
                st1Mod.add(targetLists.get(0).get(1));
                st1Mod.add(targetLists.get(0).get(0));
                st1Mod.add(simpleStrings.get(simpleStrings.indexOf(lieuDestination)));

            } else  {
                st1Mod.add(targetLists.get(0).get(2));
                st1Mod.add(targetLists.get(0).get(1));
                st1Mod.add(targetLists.get(0).get(0));
                st1Mod.add(simpleStrings.get(simpleStrings.indexOf(lieuDestination)));

            }

        } else if (simpleStrings.contains(lieuDepart) && !simpleStrings.contains(lieuDestination)) {

            if (indexDepart != 0) {
                for (int i = indexDepart; i >= 0; i--) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = 1; i <= indexDepart; i++) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = indexDepart + 1; i <= simpleStrings.size() - 1; i++) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = simpleStrings.size() - 2; i >= indexDepart; i--) {
                    st1.add(simpleStrings.get(i));
                }
            } else {
                //========gauche deDEpart
                for (int i = indexDepart; i <= simpleStrings.size() - 1; i++) {
                    st1.add(simpleStrings.get(i));
                }
                for (int i = simpleStrings.size() - 2; i >= indexDepart; i--) {
                    st1.add(simpleStrings.get(i));
                }
            }
//        System.out.println(rp);
//        System.out.println(rp.get(0));
//        System.out.println("index le chemin devier");
            int k = 0;
            for (int w = 0; w < st1.size(); w++) {

                if (st1.get(w).equals(rp.get(0))) {
                    k++;
                    if (k == 2) {
                        st1Mod = st1.subList(0, w + 1);
                    }
                }
            }
//        System.out.println("st1Mod : " + st1Mod);
//        System.out.println("nombre de K");
//        System.out.println(k);

            List<String> prTex = new ArrayList<>();

            // System.out.println("the index in lieuDestination");
            int index = -1;
            for (List<String> list : targetLists) {
                index = list.indexOf(lieuDestination);
                if (index != -1) {
                    break;
                }
            }
            // System.out.println(index);

            // System.out.println(targetLists.get(0).size());
            for (int y = 0; y < targetLists.get(0).size(); y++) {
                if (y != index) {
                    //System.out.println(targetLists.get(0).get(y));
                    st2.add(targetLists.get(0).get(y));
                    st1Mod.add(targetLists.get(0).get(y));

                }

            }
            st1Mod.add(targetLists.get(0).get(index));
            //System.out.println(st2);
            //System.out.println(st1Mod);

            return st1Mod;
        }

        return st1Mod;
    }

}
