package fr.uparis.informatique.cpoo5.richtextdemo;

import java.io.*;
import java.util.LinkedList;

public class Mot extends Typedonnee implements Propriete {

    public Mot(){
        super(null);
    }
    public Mot(String mot){
        super(mot);

    }
    public void setMot(String mot) {
        this.type = mot;
    }

    @Override
    public Object getType() {
        return super.getType();
    }

    public String path (String fichier){
        File file = new File(fichier);
        return file.getAbsolutePath();
    }

    @Override
    public LinkedList<String> buildPropriete() {

       LinkedList<String> lks = new LinkedList<>();
       String path = path("texteN1.txt");
        File f=new File(path);


        String read = "";
            StringBuilder stb = new StringBuilder();
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            while((read = br.readLine()) != null)         //Read char by Char
            {
                stb.append(read);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String stringToarray[]  = stb.toString().split(" ");
        for (int i = 0; i < stringToarray.length; i++) {
            lks.add(stringToarray[i]);
        }


        return lks;

    }

}
