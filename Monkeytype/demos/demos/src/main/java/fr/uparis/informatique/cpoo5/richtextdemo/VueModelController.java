package fr.uparis.informatique.cpoo5.richtextdemo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.fxmisc.richtext.StyleClassedTextArea;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;



public class VueModelController extends Application {
    private Mot m = new Mot("");
    private Phrase p = new Phrase(m);
    private Correction jouer = new Correction();
    private LinkedList<String> lkString = new LinkedList<>();
     LinkedList<Lettre> lklettre = new LinkedList<>();
    private int TimerSeconde =0;
      StyleClassedTextArea textArea = new StyleClassedTextArea();
      StyleClassedTextArea textArea1 = new StyleClassedTextArea();

    private boolean finPartie=false;
     Text nbMotCorrect = new Text("      "+0+"/"+jouer.nbMotTexte(textArea.getText()));
    Text nbMotCorrect1 = new Text();
     Text nombre_de_Seconde = new Text();
    Text nbMot_par_Minute = new Text();
    private NumberAxis xAxis = new NumberAxis(0, 60, 1);
    private NumberAxis yAxis = new NumberAxis   (0, 60 , 2);
    private XYChart.Series series = new XYChart.Series();
    private LineChart linechart = new LineChart(xAxis, yAxis);
    private ArrayList<Integer> wpm = new ArrayList<>();
    private ArrayList<Integer> seconde = new ArrayList<>();






    public LinkedList<String> getTexteFile(StyleClassedTextArea textArea){

        LinkedList<String> lk = new LinkedList<>();
        LinkedList<Lettre> lklettre = new LinkedList<>();
        lk = jouer.equalsCaracMot(p.getMotList(), textArea.getText(),lklettre);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <lk.size() ; i++) {
            sb.append(lk.get(i));
        }
        String texte = sb.toString();
        String scanflks[] = texte.split(" ");

        LinkedList<String> lkfinal = new LinkedList<>();

        for (int i = 0; i < scanflks.length; i++) {
            lkfinal.add(scanflks[i]);
        }

        return lkfinal;
    }
    public String builTexte(StyleClassedTextArea textArea){

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < getTexteFile(textArea).size(); i++) {
            stb.append(getTexteFile(textArea).get(i)).append(" ");
        }
        String strToString  = stb.toString();
        return strToString;
    }


    public boolean endofline(StyleClassedTextArea textArea){
        boolean bool = false;
        lkString = jouer.equalsCaracMot(p.getMotList(), textArea.getText(),lklettre);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <lkString.size() ; i++) {
            sb.append(lkString.get(i));
        }
        String texte = sb.toString();
        String scanflks[] = texte.split(" ");

        Curseur c = new Curseur();
        String scanf[] = textArea.getText().split(" ");
        for (int i = 0; i < scanf.length; i++) {
            bool= c.getEndLineDecalage(scanflks,textArea.toString(),i);

        }
        return bool;
    }

    public LinkedList<Lettre> colorType(StyleClassedTextArea textArea,StyleClassedTextArea textArea1){
        LinkedList<Lettre> lettrecouleur = new LinkedList<>();
        lkString = jouer.equalsCaracMot(p.getMotList(), textArea.getText(),lettrecouleur);


        textArea1.replaceText(builTexte(textArea));
        textArea1.setStyleClass(textArea.getCaretPosition(), textArea1.getText().length(),"gray");

        for (int i = 0; i <lettrecouleur.size() ; i++) {
            if (lettrecouleur.get(i).nameColore()=="B"){
                textArea1.setStyleClass(i, i+1, "white");
            }
            if (lettrecouleur.get(i).nameColore()=="R"){
                textArea1.setStyleClass(i, i+1, "red");
            }
            if (lettrecouleur.get(i).nameColore()=="T"){
                int deb = new Curseur().DecColoriage(lkString, textArea.getText());
                int fin = new Curseur().DecalageCurseur(lkString, textArea.getText());
                textArea1.setStyleClass(i, i+1, "gray");
            }
            if (lettrecouleur.get(i).nameColore()=="RC"){
                textArea1.setStyleClass(i, i+1, "salmon");
            }
        }
        return lettrecouleur;
    }

    //permet de controler deux espaces successifs
    public void controlTwoSpace(StyleClassedTextArea textArea){
        String texte = textArea.getText();

        if (texte.charAt(texte.length()-1)==' '){
            char tab[] = texte.toCharArray();
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < tab.length-1; i++) {
                stb.append(tab[i]);
            }
            String autr = stb.toString();
            textArea.replaceText(autr);
        }
    }

    public void valideMot(){
        String tab []  =textArea.getText().split(" ");
        String texte = textArea.getText();
        String comp ="";
        int j=0;
        for (int i = 0; i < tab.length; i++) {
            j = i;
            comp = tab[i];
        }

        lkString = jouer.equalsCaracMot(p.getMotList(), textArea.getText(),lklettre);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <lkString.size() ; i++) {
            sb.append(lkString.get(i));
        }
        String texteInit = sb.toString();
        String scanflks[] = texteInit.split(" ");

        LinkedList<String> lkfinal = new LinkedList<>();

        for (int i = 0; i < scanflks.length; i++) {
            lkfinal.add(scanflks[i]);
        }



        if (scanflks[j].equals(comp)){

            if (texte.charAt(texte.length()-1)==' '){
                char tab1[] = texte.toCharArray();
                StringBuilder stb = new StringBuilder();
                for (int i = 0; i < tab1.length-1; i++) {
                    stb.append(tab1[i]);
                }
                String autr = stb.toString();
                textArea.replaceText(autr+"  ");
            }

       }
    }

    public void niveau1(Stage primaryStage){

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #323437;");
        nbMotCorrect.setStyle("-fx-font: 30 arial;");
        nbMotCorrect.setFill(Color.YELLOW);
        //nbMotCorrect.setStroke(Color.BLUE);

        VBox Vboxtexte = new VBox();
        Vboxtexte.setStyle("-fx-background-color: #323437;");


        VBox VboxTextarea = new VBox();
        VboxTextarea.setStyle("-fx-background-color: #323437;");
        VboxTextarea.getChildren().add(nbMotCorrect);
        Vboxtexte.setPadding( new Insets(50, 50, 50, 150));

        textArea.setStyle("-fx-background-color: #323437; -fx-font-size: 20pt;");
        textArea1.append(builTexte(textArea),"gray");
        textArea1.setStyle("-fx-background-color: #323437; -fx-font-size: 20pt;");
        textArea1.setEditable(false);


        Vboxtexte.getChildren().addAll(textArea1,textArea);
        Vboxtexte.setPadding( new Insets(0, 150, 50, 150));

        Button Quitter = new Button("Quitter");
        Button Recommencer = new Button("Recommencer");
        Quitter.setStyle("-fx-background-color: #FF0000; -fx-font-size: 15pt; -fx-text-fill: white ");
        Recommencer.setStyle("-fx-background-color: #0000FF; -fx-font-size: 15pt; -fx-text-fill: white; ");

        Quitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.close();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Recommencer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VueModelController r = new VueModelController();
                try {
                    primaryStage.close();
                    r.niveau1(primaryStage);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });


        HBox hbox = new HBox();
        hbox.getChildren().addAll(Quitter,Recommencer);
        hbox.setPadding(new Insets(20, 10, 20, 400));
        hbox.setSpacing(15);

        root.getChildren().addAll(VboxTextarea,Vboxtexte,hbox);

        textArea.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                colorType(textArea, textArea1);
                if (finParti(textArea, textArea1)) {
                    primaryStage.close();
                    StatistiqueInteface(primaryStage);
                }

                if ( event.getCode().name()=="SPACE") {
                    if (endofline(textArea)){
                        textArea.appendText("\n");
                    }
                }
            }
        });

        textArea.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE ) {
                    String t = textArea.getText();
                    Correction j =new Correction();
                    nbMotCorrect.setText("      "+j.nbMotJuste(textArea.getText())+"/"+jouer.nbMotTexte(textArea.getText()));
                    controlTwoSpace(textArea);

                }
            }
        });

        textArea.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.BACK_SPACE) {
                    valideMot();
                }
            }
        });

        Scene scene = new Scene(root, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.setFill(Color.web("#323437"));
        primaryStage.setTitle("Rich Text Demo");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
   //StatistiqueInteface(primaryStage);

    }

    public boolean finParti(StyleClassedTextArea textArea,StyleClassedTextArea textArea1) {
        Correction j =new Correction();
       return j.finJeux(textArea.getText(),textArea.getText());

    }


//methode permettant de récupérer les données du joeur en fin de jeu et trace la courbe
    public void StatistiqueInteface(Stage primaryStage){
        VBox root = new VBox();

        nbMotCorrect1.setStyle(" -fx-font: 26 arial;");
        nbMot_par_Minute.setStyle(" -fx-font: 26 arial;");
        nombre_de_Seconde.setStyle(" -fx-font: 26 arial;");

        nbMotCorrect1.setFill(Color.YELLOW);
        nbMot_par_Minute.setFill(Color.YELLOW);
        nombre_de_Seconde.setFill(Color.YELLOW);

        VBox Vboxtexte = new VBox();
        Vboxtexte.setStyle("-fx-background-color: #323437;");
        Vboxtexte.getChildren().addAll(nbMotCorrect1,nombre_de_Seconde,nbMot_par_Minute);

        xAxis.setLabel("temps/s");
        yAxis.setLabel("Mot par minute");

        series.setName("Statistiques");

        linechart.getData().add(series);
        linechart.setStyle("-fx-background-color: #323437");
        linechart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");
        Button Quitter = new Button("Quitter");
        Button Recommencer = new Button("Recommencer");
        Quitter.setStyle("-fx-background-color: #FF0000; -fx-font-size: 15pt; -fx-text-fill: white; ");
        Recommencer.setStyle("-fx-background-color: #0000FF; -fx-font-size: 15pt; -fx-text-fill: white; ");

        Quitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    primaryStage.close();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Recommencer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VueModelController r = new VueModelController();
                try {
                    primaryStage.close();
                   r.niveau1(primaryStage);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });



        HBox hbox = new HBox();
        hbox.getChildren().addAll(Quitter,Recommencer);
        hbox.setPadding(new Insets(20, 10, 20, 450));
        hbox.setSpacing(15);



        root.getChildren().addAll(Vboxtexte,linechart,hbox);

        Scene scene = new Scene(root, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.setFill(Color.web("#81c483"));
        primaryStage.setTitle("Rich Text Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /*methode permettant de déclancher le temps en seconde dès
    que l'utilisateur commence à saisir sur le clavier*/
    public void declancheTimer(StyleClassedTextArea textArea){




        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (textArea.getText().length()>0){


                    jouer.equalsCaracMot(p.getMotList(), textArea.getText(),lklettre);
                    int cpt=0;
                    for (int i = 0; i <lklettre.size() ; i++) {
                        if (lklettre.get(i).nameColore()=="B"){
                            cpt++;
                        }
                    }
                    TimerSeconde++;
                    int wmp = (int)((((double)cpt/5) / TimerSeconde)*60);
                    wpm.add(wmp);
                    seconde.add(TimerSeconde);

                    if (finParti(textArea, textArea1)){
                        cancel();
                        int x=0;
                       series.getData().add(new XYChart.Data(0, 0));
                        try{
                            for (int i = 1; i < wpm.size(); i++) {
                                series.getData().add(new XYChart.Data(seconde.get(i), wpm.get(i)));
                            }
                        }catch (Exception e ){
                            e.printStackTrace();
                        }
                        statistique(textArea, TimerSeconde);

                    }
                }
            }
        }, 1000, 1000);
    }

    public void statistique(StyleClassedTextArea textArea, int time){

        jouer.equalsCaracMot(p.getMotList(), textArea.getText(),lklettre);

        int cpt=0;
        for (int i = 0; i <lklettre.size() ; i++) {
            if (lklettre.get(i).nameColore()=="B"){
                cpt++;
            }
        }
        int wmp = (int)((((double)cpt/5) / time)*60);
        ArrayList<Integer> in = new ArrayList<>();
        in.add(cpt);

        nbMotCorrect1.setText("Nombre de mot(s) correct(s) :"+ nbMotCorrect.getText());
        nombre_de_Seconde.setText("Nombre de seconde(s) :      "+time);
        nbMot_par_Minute.setText("Nombre de mot(s) par minute :      "+wmp);


        //Setting the data to Line chart


    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
