package fr.uparis.informatique.cpoo5.richtextdemo;

import org.fxmisc.richtext.StyleClassedTextArea;

import java.util.ArrayList;

public class Statistique {
	Mot m = new Mot("");
	Phrase p = new Phrase(m);
	VueModelController vmc = new VueModelController();
	Correction correction = new Correction();
	public void statistique(StyleClassedTextArea textArea, int time){

		correction.equalsCaracMot(p.getMotList(), textArea.getText(),vmc.lklettre);

		int cpt=0;
		for (int i = 0; i <vmc.lklettre.size() ; i++) {
			if (vmc.lklettre.get(i).nameColore()=="B"){
				cpt++;
			}
		}
		int wmp = (int)((((double)cpt/5) / time)*60);
		ArrayList<Integer> in = new ArrayList<>();
		in.add(cpt);

		vmc.nbMotCorrect1.setText("Nombre de mot(s) correct(s) :"+ vmc.nbMotCorrect.getText());
		vmc.nombre_de_Seconde.setText("Nombre de seconde(s) :      "+time);
		vmc.nbMot_par_Minute.setText("Nombre de mot(s) par minute :      "+wmp);


		//Setting the data to Line chart


	}
}
