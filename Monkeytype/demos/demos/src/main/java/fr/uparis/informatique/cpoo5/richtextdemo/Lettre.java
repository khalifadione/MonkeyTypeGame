package fr.uparis.informatique.cpoo5.richtextdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Lettre extends Typedonnee implements Propriete {
    private char lettre;
    private Couleur couleur;
    public Lettre(char lettre,Couleur couleur) {
        super(lettre);
        this.couleur=couleur;
    }



    public void setLettre(char lettre) {
        this.lettre = lettre;
    }
    public char getLettre(){
        return this.lettre;
    }

    public void setCouleur(Couleur couleur) {this.couleur = couleur;}
    public Couleur getCouleur() {return couleur;}

    public String nameColore(){
        return getCouleur().getColorName();
    }

    @Override
    public LinkedList<String> buildPropriete() {
        return null;
    }
}
