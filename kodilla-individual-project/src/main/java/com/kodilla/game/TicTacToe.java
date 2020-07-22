package com.kodilla.game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TicTacToe extends Application {

    private final Image imageBack = new Image("file/scene.jpg");
    private final Image cross = new Image("file/cross.jpg");
    private final Image circle = new Image("file/circle.png");

    //private FlowPane signs = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5, 5, 5, 0));
        grid.setHgap(20);
        grid.setVgap(17);
        grid.setBackground(background);


        ImageView pos1 = new ImageView(cross);
        //signs.getChildren().add(img);

        ImageView pos2 = new ImageView(circle);
        //signs.getChildren().add(img2);

        ImageView pos3 = new ImageView(cross);
        //signs.getChildren().add(img3);

        ImageView pos4 = new ImageView(circle);
        //signs.getChildren().add(img4);

        ImageView pos5 = new ImageView(cross);
        //signs.getChildren().add(img5);

        ImageView pos6 = new ImageView(circle);
        //signs.getChildren().add(img6);

        ImageView pos7 = new ImageView(cross);
        //signs.getChildren().add(img7);

        ImageView pos8 = new ImageView(circle);
        //signs.getChildren().add(img8);

        ImageView pos9 = new ImageView(cross);
        //signs.getChildren().add(img9);

        grid.add(pos1,5,4,1,1);
        grid.add(pos2,7,4,1,1);
        grid.add(pos3,9,4,1,1);
        grid.add(pos4,5,7,1,1);
        grid.add(pos5,7,7,1,1);
        grid.add(pos6,9,7,1,1);
        grid.add(pos7,5,10,1,1);
        grid.add(pos8,7,10,1,1);
        grid.add(pos9,9,10,1,1);



        }
        //grid.setAlignment(Pos.TOP_LEFT);
        //grid.addRow(10, img, img2);
        //grid.setHgap(20);

        Scene scene = new Scene((Parent) grid, 500, 500);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}




