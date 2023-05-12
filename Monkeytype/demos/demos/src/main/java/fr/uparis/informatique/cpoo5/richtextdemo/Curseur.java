package fr.uparis.informatique.cpoo5.richtextdemo;

import java.util.LinkedList;

import static java.lang.Math.max;

public class Curseur {
	private int position;
	public Curseur(int position){
		this.position=position;
	}
	public Curseur(){
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return Integer.toString(getPosition());
	}

	public void positionCurseur(){
			System.out.print("pc = "+getPosition());
	}

	public int DecalageCurseur(LinkedList<String> lks, String texte){
		int positionCurseur=0;
		String scanf[] = texte.split(" ");
		int nombreEspaces = scanf.length;
		if (texte.contains(" ") && texte.charAt(texte.length()-1)==' '){
			for (int j = 0; j < nombreEspaces; j++) {
				positionCurseur = positionCurseur + lks.get(j).length() + 1;
			}
		}

		return positionCurseur;
	}

	public int DecColoriage(LinkedList<String> lks, String texte){
		int positionCurseur=0;
		String scanf[] = texte.split(" ");
		int nombreEspaces = scanf.length;
		if (texte.contains(" ") && texte.charAt(texte.length()-1)==' '){
			int j;
			for (j = 0; j < nombreEspaces-1; j++) {
				positionCurseur = positionCurseur + lks.get(j).length() + 1;
			}
			positionCurseur += scanf[j].length();
			//System.out.print("p-c "+new Curseur(positionCurseur).getPosition()+" ");
		}

		return positionCurseur;
	}

	public boolean getEndLineDecalage(String lks[], String texte, int posdecal){
		int positionCurseur=0;
		String scanf[] = texte.split(" ");

		       if (posdecal+1 < lks.length) {
				   if (lks[posdecal+1].charAt(0)=='\n') {
					   positionCurseur = positionCurseur+2;

					   return true;
				   }

			   }


		return false;

	}


}
