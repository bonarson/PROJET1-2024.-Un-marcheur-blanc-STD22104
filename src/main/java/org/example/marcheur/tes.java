package org.example.marcheur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class tes {
    public static void main(String[] args) {
        List<Object> str = Arrays.asList("A", "B", "C", Arrays.asList("F", "H", "G"), "D", Arrays.asList("F", "H", "G"), "E");
        List<String> simpleStrings = new ArrayList<>();

        for (Object element : str) {
            if (element instanceof String) {
                simpleStrings.add((String) element);
            }
        }
        System.out.println("tab1=====");
        System.out.println(simpleStrings);//[A, B, C, D, E]
        System.out.println(simpleStrings.indexOf("C"));
        int indexDepart =simpleStrings.indexOf("C");
        List<String> st1 = new ArrayList<>();
        List<String> st2 = new ArrayList<>();
        if(indexDepart!=0){
            for (int i =indexDepart; i >= 0; i--) {
                st1.add(simpleStrings.get(i));
            }
            for (int i =1; i<=indexDepart; i++) {
                st1.add(simpleStrings.get(i));
            }
            for (int i =indexDepart+1; i<=simpleStrings.size()-1; i++) {
                st1.add(simpleStrings.get(i));
            }
            for (int i =simpleStrings.size()-2; i>=indexDepart; i--) {
                st1.add(simpleStrings.get(i));
            }
        }else {
            //========gauche deDEpart
            for (int i =indexDepart; i<=simpleStrings.size()-1; i++) {
                st1.add(simpleStrings.get(i));
            }
            for (int i =simpleStrings.size()-2; i>=indexDepart; i--) {
                st1.add(simpleStrings.get(i));
            }
        }
        System.out.println("st1");
        System.out.println(st1);






        System.out.println("===========");


        List<String> targetStrings = new ArrayList<>(simpleStrings);
        List<List<String>> targetLists = Arrays.asList(Arrays.asList("F", "H", "G"));

        List<String> rp = new ArrayList<>();

      List<String>st1Mod= new ArrayList<>();
        System.out.println("ST1 MODIFIER");


        for (int i = 0; i < str.size(); i++) {
            if (targetStrings.contains(str.get(i))) {
                if (i - 1 >= 0 && str.get(i - 1) instanceof List && targetLists.contains(str.get(i - 1))) {
                    rp.add((String) str.get(i));
                    // System.out.println(str.get(i));
                } else if (i + 1 < str.size() && str.get(i + 1) instanceof List && targetLists.contains(str.get(i + 1))) {
                    rp.add((String) str.get(i));
                    // System.out.println(str.get(i));
                }
            }
        }
        System.out.println(rp);
        System.out.println(rp.get(0));
        System.out.println("index le chemin devier");
        int k=0;
        for (int w=0;w<st1.size();w++){

            if(st1.get(w).equals("C")){
                k++;
                if (k==2){
                    st1Mod=st1.subList(0,w+1);
                }
            }
        }
        System.out.println("st1Mod : "+st1Mod);
        System.out.println("nombre de K");
        System.out.println(k);

        List<String>prTex=new ArrayList<>();

        System.out.println("the index in H");
        int index = -1;
        for (List<String> list : targetLists) {
            index = list.indexOf("G");
            if (index != -1) {
                break;
            }
        }
        System.out.println(index);

        System.out.println(targetLists.get(0).size());
        for(int y=0;y<targetLists.get(0).size();y++){
            if(y!=index){
                //System.out.println(targetLists.get(0).get(y));
                st2.add(targetLists.get(0).get(y));
                st1Mod.add(targetLists.get(0).get(y));

            }

        }
        st1Mod.add(targetLists.get(0).get(index));
        System.out.println(st2);
        System.out.println(st1Mod);


    }
}
