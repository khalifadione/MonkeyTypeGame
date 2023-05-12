package fr.uparis.informatique.cpoo5.richtextdemo;


import org.fxmisc.richtext.StyleClassedTextArea;

import java.util.LinkedList;
import java.util.Scanner;


public class Correction {

//Fontion pour ajouter de nouveaux mots a la fin du texte si l'utilisateur trouve un mot du texte
    public String[] ajouteMot(int randretoune){
        String tabmot[] = {"Toutes ", "ecole ", "comme ", "le ", "marche ","Sysy ", "va ", "au ", "gare ",
                "capture", "decran", "en", "ligne"};

        return tabmot;
    }

   //fonction qui compte le nombre de mot juste
    public int nbMotJuste(String texteEntre){
        Mot m = new Mot();
        Phrase p  = new Phrase(m);
        LinkedList<String> lkstr = new LinkedList<>();
        LinkedList<Lettre> lklettre = new LinkedList<>();
        lkstr = equalsCaracMot(p.getMotList(), texteEntre, lklettre);



        String tab[] = texteEntre.split(" ");
        int comp =0;
        for (int i = 0; i < tab.length; i++) {
            if (lkstr.get(i).equals(tab[i].concat(" "))){
                comp++;

            }
        }
        return comp;
    }

//fonction qui renvoie vrai si on a atteint la taille du texte en mot tapés
    public boolean finJeux(String texteEntre,String texteAffiche){
        Mot m = new Mot();
        Phrase p  = new Phrase(m);
        LinkedList<String> lkstr = new LinkedList<>();
        LinkedList<Lettre> lklettre = new LinkedList<>();
        lkstr = equalsCaracMot(p.getMotList(), texteEntre, lklettre);


        String tab[] = texteEntre.split(" ");
        String tab2[] = texteAffiche.split(" ");

        return tab.length==lkstr.size() && texteEntre.charAt(texteEntre.length()-1)==' ';
    }

    public int nbMotTexte(String texteEntre){
        Mot m = new Mot();
        Phrase p  = new Phrase(m);
        LinkedList<String> lkstr = new LinkedList<>();
        LinkedList<Lettre> lklettre = new LinkedList<>();
        lkstr = equalsCaracMot(p.getMotList(), texteEntre, lklettre);

        return lkstr.size();
    }

/*fonction complexe qui teste les bons et mauvais caractères
 du texte tapé par le joueur c'est la fonction principale qui permet
 également de mettre à jour le texte
 */

    public LinkedList<String> equalsCaracMot(LinkedList<String> lks, String sca, LinkedList<Lettre> lklettre){
        String scanf[] = sca.split(" ");


        for (int i = 0; i < scanf.length; i++) {
            if (scanf[i].concat(" ").equals(lks.get(i)) && sca.contains(" ")) {
                lks.add(ajouteMot(i)[i]);
            }
        }

            StringBuilder sb = new StringBuilder();
        for (int i = 0; i <lks.size() ; i++) {
            sb.append(lks.get(i));
        }
        String texte = sb.toString();
        String scanlks[] = texte.split(" ");
        LinkedList<String> nvlk = new LinkedList<>();
        for (int i = 0; i < scanlks.length; i++) {
            nvlk.add(scanlks[i]);
        }

        for (int i = 0; i < scanf.length; i++) {
            if (scanf.length>nvlk.size()){
                //nvlk.add("");
            }

            if (scanf[i].equals(nvlk.get(i) ) && sca.contains(" ")){
                //ajouteMot(i,lks);
                //nvlk.add("kh");
            }

            char scanchar[]=scanf[i].toCharArray();
            char tabmotlklist[] = nvlk.get(i).toCharArray();
            int randint=  0;
            char[] charArray = nvlk.get(i).toCharArray();

            String resul = "";






            if (nvlk.get(i).length()== scanf[i].length()){
                if (nvlk.get(i).equals(scanf[i])){

                    for (int j = 0; j <scanchar.length ; j++) {
                        charArray[j] = scanchar[j];
                        lklettre.add(new Lettre(scanchar[j],new CouleurBlanche("B")));
                        resul=  new String(charArray);
                        lks.set(i,resul.concat(" "));
                    }
                }

                else {
                    for (int j = 0; j <tabmotlklist.length ; j++) {
                        if (scanchar[j] == tabmotlklist[j]) {
                            charArray[j] = scanchar[j];
                            lklettre.add(new Lettre(scanchar[j],new CouleurBlanche("B")));
                            resul = new String(charArray);
                            lks.set(i,resul.concat(" "));
                        } else {
                            charArray[j] = tabmotlklist[j];
                            lklettre.add(new Lettre(scanchar[j],new CouleurRouge("R")));
                            resul = new String(charArray);
                            lks.set(i,resul.concat(" "));
                        }
                    }
                }
                //System.out.println(new Curseur(sca.length()).getEndLineDecalage(nvlk, sca,i));

            }

            else{

                if (scanf[i].length() > nvlk.get(i).length()) {

                    StringBuffer stb = new StringBuffer();
                    for (int k = 0; k < tabmotlklist.length; k++) {
                        if (scanchar[k] == tabmotlklist[k]) {
                            charArray[k] = scanchar[k];
                            lklettre.add(new Lettre(scanchar[k],new CouleurBlanche("B")));
                            resul = new String(charArray);
                            lks.set(i,resul.concat(" "));
                        } else {
                            charArray[k] = tabmotlklist[k];
                            lklettre.add(new Lettre(scanchar[k],new CouleurRouge("R")));
                            resul = new String(charArray);
                            lks.set(i,resul.concat(" "));
                        }
                    }
                    for (int j = tabmotlklist.length; j < scanchar.length; j++) {
                        stb.append(scanchar[j]);
                        lklettre.add(new Lettre(scanchar[j],new CouleurRougeclaire("RC")));
                    }
                    String stbtostring = stb.toString();
                    resul = resul.concat(stbtostring);
                    lks.set(i,resul.concat(" "));
                }

                else if (scanf[i].length() < nvlk.get(i).length()) {
                    StringBuffer stb = new StringBuffer();
                    for (int j = 0; j < scanchar.length; j++) {
                        if (scanchar[j] == tabmotlklist[j]) {
                            charArray[j] = scanchar[j];
                            lklettre.add(new Lettre(scanchar[j],new CouleurBlanche("B")));
                            resul = new String(charArray);
                            lks.set(i,resul.concat(" "));
                        }
                        else {
                            charArray[j] = tabmotlklist[j];
                            lklettre.add(new Lettre(scanchar[j],new CouleurRouge("R")));
                            resul = new String(charArray);
                            lks.set(i,resul.concat(" "));
                        }
                    }
                    for (int j = scanchar.length; j < tabmotlklist.length; j++) {
                            stb.append(tabmotlklist[j]);
                            lklettre.add(new Lettre(tabmotlklist[j],new CouleurTransp("T")));
                    }
                }
            }
            lklettre.add(new Lettre(' ', new Couleur("")));
        }


        return lks;
    }

    //detecte les string ou il y a deux espaces successifs
    public String controlTwoSpace(String textArea){
        String texte = textArea;
        StringBuilder stb = new StringBuilder();
        if (texte.charAt(texte.length()-1)==' '){
            char tab[] = texte.toCharArray();

            for (int i = 0; i < tab.length-1; i++) {
                stb.append(tab[i]);
            }

        }
        String autr = stb.toString();
        return autr;
    }

    public String valideMot(String texte){
        String tab []  =texte.split(" ");
        String comp ="";
        int j=0;
        for (int i = 0; i < tab.length; i++) {
            j = i;
            comp = tab[i];
        }
        Mot m = new Mot();
        Phrase p = new Phrase(m);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <p.getMotList().size() ; i++) {
            sb.append(p.getMotList().get(i));
        }
        String texteInit = sb.toString();
        String scanflks[] = texteInit.split(" ");

        LinkedList<String> lkfinal = new LinkedList<>();

        for (int i = 0; i < scanflks.length; i++) {
            lkfinal.add(scanflks[i]);
        }


        StringBuilder stb = new StringBuilder();
        if (scanflks[j].equals(comp)){

            if (texte.charAt(texte.length()-1)==' '){
                char tab1[] = texte.toCharArray();

                for (int i = 0; i < tab1.length-1; i++) {
                    stb.append(tab1[i]);
                }

            }

        }
        String autr = stb.toString();
        return autr;

    }


}
