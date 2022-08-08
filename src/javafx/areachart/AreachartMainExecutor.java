package javafx.areachart;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AreachartMainExecutor extends Application {


	@Override
	public void start(Stage primaryStage) {
		try {
			
			//creer l'axe x comprend 12 niveua(tickMark) : NumberAxis( valeurMin, valeurMax, espaceEntreCesValeur ou unité(tickunit) );
//			NumberAxis axeX = new NumberAxis(1, 12, 1);
			
			NumberAxis axeX = new NumberAxis();
			axeX.setLowerBound(1); 	//Valeur minimale
			axeX.setUpperBound(12);  	//Valeur maximale
			axeX.setTickUnit(1);  	//Unité ou espace entre la Valeur minimale et Valeur maximale 
			
			NumberAxis axeY = new NumberAxis();
			
			AreaChart<Number, Number> areaChart = new AreaChart<>(axeX, axeY);
			areaChart.setTitle("Salaire Mensuelle");

		//legende du areachart
			areaChart.setLegendSide(Side.BOTTOM);
			
		//creation d'un objet qui va cotenir une donnée
			XYChart.Series<Number, Number> salaire2018 = new XYChart.Series<>();
			salaire2018.setName("Salaire Mensuelle en 2018");
			
		//ajout des données à l'objet
			salaire2018.getData().add(new XYChart.Data<>(1,400));
			salaire2018.getData().add(new XYChart.Data<>(2,1100));
			salaire2018.getData().add(new XYChart.Data<>(3,650));
			salaire2018.getData().add(new XYChart.Data<>(4,900));
			salaire2018.getData().add(new XYChart.Data<>(5,1400));
			salaire2018.getData().add(new XYChart.Data<>(6,1500));
			salaire2018.getData().add(new XYChart.Data<>(7,2030));
			salaire2018.getData().add(new XYChart.Data<>(8,975));
			salaire2018.getData().add(new XYChart.Data<>(9,800));
			salaire2018.getData().add(new XYChart.Data<>(10,1800));
			salaire2018.getData().add(new XYChart.Data<>(11,1500));
			salaire2018.getData().add(new XYChart.Data<>(12,1300));
			

		//creation d'un autre objet qui va cotenir une autre donnée
			XYChart.Series<Number, Number> salaire2020 = new XYChart.Series<>();
			salaire2020.setName("Salaire Mensuelle en 2020");
		//ajout des données
			salaire2020.getData().add(new XYChart.Data<>(1,2000));
			salaire2020.getData().add(new XYChart.Data<>(2,1500));
			salaire2020.getData().add(new XYChart.Data<>(3, 1300));
			salaire2020.getData().add(new XYChart.Data<>(4, 1000));
			salaire2020.getData().add(new XYChart.Data<>(5, 900));
			salaire2020.getData().add(new XYChart.Data<>(6,1350));
			salaire2020.getData().add(new XYChart.Data<>(7, 2500));
			salaire2020.getData().add(new XYChart.Data<>(8,2000));
			salaire2020.getData().add(new XYChart.Data<>(9,1000));
			salaire2020.getData().add(new XYChart.Data<>(10,790));
			salaire2020.getData().add(new XYChart.Data<>(11,702));
			salaire2020.getData().add(new XYChart.Data<>(12, 1100));
		
		//On met les ronds au sommets du areaChart 
			areaChart.setCreateSymbols(true);
		//On regle l'opacité
			areaChart.setOpacity(1);
			
		//Gerer l'animation lors de la chargement du données
			Timeline timeLine = new Timeline();
			
			timeLine.getKeyFrames().add(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					for(XYChart.Series<Number, Number> series : areaChart.getData()) {
						for(XYChart.Data<Number, Number> data : series.getData()) {
							//on recupere la valeur de Y/X pour chaque series de donnée
								Number yValue = data.getYValue();
							//on genere un nouveau valeur de Y avec un nombre aleatoire
								Number randomValue = yValue.doubleValue() * (2 *Math.random());
								
								data.setYValue(randomValue);
						}
					}
				}
				}));
			
			//repeter indefiniment jusqu'a l'appel de methode stop()
			timeLine.setCycleCount(Animation.INDEFINITE);
			timeLine.setAutoReverse(true);
			timeLine.play();
			
			
			primaryStage.setTitle("Les Révenues !!!");
			Scene scene = new Scene(areaChart, 800, 530);

			areaChart.getData().addAll(salaire2018, salaire2020);

		//ajout du fichier style.css à la scene
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setAlwaysOnTop(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch (Exception e) {
			System.out.println("ERREUR : "+e.getLocalizedMessage());
//			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
