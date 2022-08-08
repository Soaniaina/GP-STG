package javafx.piechart;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PieChartExecutor extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			
			PieChart pieChart = new PieChart();
			
		//recuperation des donnée qu'on veut afficher dans chaque tranche du pie chart
			PieChart.Data slice1 = new PieChart.Data("U.S.A", 2794);
			PieChart.Data slice2 = new PieChart.Data("U.E", 3050);
			PieChart.Data slice3 = new PieChart.Data("China", 3198);
			PieChart.Data slice6 = new PieChart.Data("Madagascar", 5106);
			PieChart.Data slice4 = new PieChart.Data("Japan", 2716);
			PieChart.Data slice5 = new PieChart.Data("India", 2010);
	
		//ajout des données récuperés dans le piechart
			pieChart.getData().add(slice1);
			pieChart.getData().add(slice2);
			pieChart.getData().add(slice3);
			pieChart.getData().add(slice4);
			pieChart.getData().add(slice5);
			pieChart.getData().add(slice6);
			
		//dimension du pie chart
//			pieChart.setPrefSize(300, 200);
		//positionnement de chaque tranche(slice) en sens inverse d'une montre
			pieChart.setClockwise(false);
		//longueur du ligne entre le label et le tranche
			pieChart.setLabelLineLength(20);
		//changement de l'angle de depart du pie chart 40deg au dessus de l'axe x'Ox
			pieChart.setStartAngle(40);
		//positionnement du legende du pie chart
			pieChart.setLegendSide(Side.BOTTOM);
		
			Label texte = new Label();
			texte.setText("Solo Soaniaina");
			texte.setTextFill(Color.BLUE);
			texte.setStyle("-fx-font:12 arial;");
	
		//parcourt de chaque tranche du pieChart
			for (final PieChart.Data tranche : pieChart.getData()) {
				/**
				 * Evenemen declenché quand la souris entre en contact avec chaque tranche
				 */
//					tranche.getNode().setOnDragDetected(e->System.out.println("DragDetected"));;
					tranche.getNode().setOnMouseEntered(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							
//							texte.setText(String.valueOf(tranche.getPieValue()));

//							System.out.println("P.I.B de l' " +tranche.getName()+" : "+ String.valueOf(tranche.getPieValue())+"$/personne/ans.");							
						}
					});
				/**
				 * Evenement declenché quand la souris quitte un tranche du piechArt
				 */
					tranche.getNode().setOnMouseExited(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
						
						//Positionne le label texte au coordonée de la souris en quand elle quitte la tranche du pieChart
							texte.setTranslateX(event.getSceneX());
							texte.setTranslateY(event.getSceneY());
							
							System.out.println("Position du souris en x : "+event.getSceneX());
							System.out.println("Position du souris en y : "+event.getSceneY());
							System.out.println('\n');
						}
					});
			}
			
		/**
		 * afficher::setLabelsVisible(true) /masquer::setLabelsVisible(false) la label de chaque tranche du piechart 
		 */
//			pieChart.setLabelsVisible(false);
			primaryStage.setTitle("Présentaion des PIB");
			AnchorPane root = new AnchorPane(pieChart);
			
			primaryStage.setScene(new Scene(root, 500,400));
			primaryStage.setResizable(false);
			primaryStage.setAlwaysOnTop(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
