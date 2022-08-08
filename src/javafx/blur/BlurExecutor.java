package javafx.blur;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BlurExecutor extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		

	//position en x et en y
		double x = 10;
		double y = 150;
	
	//un objet de type texte qui contient mon nom
		Text nom = new Text();
		nom.setText("Solo Soaniaina");
	//on specifie sa couleur
		nom.setFill(Color.web("rgb(0, 80, 255)"));
	//on définie aussi le style, taille mais pas la police(null)
		nom.setFont(Font.font(null, FontWeight.BOLD, 80));
	//on le positionne 
		nom.setX(x); 
		nom.setY(y);
		
	//un objet de type boxBlur
		BoxBlur boxBlur = new BoxBlur();
		
		//largeur : min = 0.0 et max = 255.0
		boxBlur.setWidth(10);
//		hauteur : min = 0.0 et max : 255.0
		boxBlur.setHeight(5);
		
	//effet du flou : min 0 et max : 3
		boxBlur.setIterations(3);
	//on l'applique a notre objet Text
		nom.setEffect(boxBlur);
		
		
		Group group = new Group();
		group.getChildren().addAll(nom);
		
		primaryStage.setScene(new Scene(group, 700, 300));
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setTitle("Solo Soaniaina !!!");
		primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch(args);

	}

}
