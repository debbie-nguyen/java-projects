package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Presents the user with the game graphical user interface
 */
public class ViewGameBoard extends Application
{
    private Canvas gameCanvas;
    private ControllerGameBoard controller;
    private GameBoardLabel fishRemaining;
    private GameBoardLabel guessesRemaining;
    private GameBoardLabel message;

    public static void main(String[] args)
    {
        // TODO: launch the app
        launch(args);
    }

    public void updateHeader() {
        //TODO update labels
        this.fishRemaining.setText("Fish: " + controller.modelGameBoard.getFishRemaining());
        this.guessesRemaining.setText("Bait: " + controller.modelGameBoard.getGuessesRemaining());
        if(controller.fishWin()) {
            this.message.setText("Fishes win!");
        } else if(controller.playerWins()) {
            this.message.setText("You win!");
        } else {
            this.message.setText("Find the fish!");
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        controller = new ControllerGameBoard();
        // TODO initialize gameCanvas
        this.controller = new ControllerGameBoard();
        this.gameCanvas = new Canvas();

        this.fishRemaining = new GameBoardLabel();
        this.guessesRemaining = new GameBoardLabel();
        this.message = new GameBoardLabel();

        // TODO display game there are infinite ways to do this, I used BorderPane with HBox and VBox.
        updateHeader();

        HBox headerRow = new HBox();
        headerRow.getChildren().add(fishRemaining);
        headerRow.getChildren().add(guessesRemaining);
        headerRow.getChildren().add(message);

        VBox allRowsContainer = new VBox(5);
        allRowsContainer.getChildren().add(headerRow);

        for (int row=0; row < ModelGameBoard.DIMENSION; row++) {
            // TODO: create row container
            HBox rowContainer = new HBox(ModelGameBoard.DIMENSION);
            for (int col=0; col < ModelGameBoard.DIMENSION; col++) {
                GameBoardButton button = new GameBoardButton(row, col, controller.modelGameBoard.fishAt(row,col));
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> {
                    controller.makeGuess(finalRow, finalCol);
                    if(!controller.isGameOver()) {
                        button.handleClick();
                        updateHeader();
                    }
                });
                // TODO: add button to row
                rowContainer.getChildren().add(button);
            }
            // TODO: add row to column
            allRowsContainer.getChildren().add(rowContainer);
        }
        // TODO: create scene, stage, set title, and show
        Scene gameScene = new Scene(allRowsContainer);
        stage.setScene(gameScene);
        stage.setTitle("Gone Fishing");
        stage.show();
    }
}
