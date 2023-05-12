package fr.uparis.informatique.cpoo5.richtextdemo;

import java.util.LinkedList;

public class Phrase{
    private Mot mot;

    public Phrase( Mot mot) {

        this.mot = mot;
    }
    public Mot getMot() {
        return mot;
    }



    public void builSentence(){
        /*String tab[] = getMot().read_Characte_intofile();
        for (int i = 0; i < tab.length ; i++) {
                  //System.out.print(tab[i]+" ");
        }*/
  }

  //Copie de la fonction
  public LinkedList<String> getMotList(){
        LinkedList<String> lkst = new LinkedList<>();
      for (int i = 0; i < getMot().buildPropriete().size(); i++) {
          lkst.add(getMot().buildPropriete().get(i)+" ");
          if (i==6){
              lkst.add(6, "\n"+getMot().buildPropriete().get(i)+" ");
          }
      }

      return lkst;
  }

    public int nbMotinTexte(){
       return getMot().buildPropriete().size();
    }
}
