package fr.uparis.informatique.cpoo5.richtextdemo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws IOException {
        char cont=0;

            Mot m = new Mot("");
            Phrase p = new Phrase(m);
            p.builSentence();


            LinkedList<String> lk = new LinkedList<>();
            Scanner sc = new Scanner(System.in);
            String scc = sc.nextLine();

            Correction j = new Correction();
            LinkedList<Lettre> lklettre = new LinkedList<>();
            //lk = j.equalscaracMot(p.getMotList(), scc, lklettre);


            System.out.println("Texte apres");
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < lk.size(); i++) {
                stb.append(lk.get(i)).append(" ");
            }
            String strToString = stb.toString();
            System.out.println(strToString);

            System.out.println(" ");

            for (int i = 0; i < lklettre.size(); i++) {
                System.out.print(lklettre.get(i).getLettre()+"_"+lklettre.get(i).nameColore()+" ");
            }
            System.out.println(" ");

            System.out.print("Le nombre de mots trouve = "+j.nbMotJuste( scc));
    }

}
