package edu.sdccd.cisc191;

import javafx.scene.control.Button;


/**
 * Extends the basic JavaFX Button with game functionality
 */
public class GameBoardButton extends Button {
    private int row;
    private int col;
    private boolean hasFish;
    private boolean isGuessed;

    private static String BASE_STYLE = "-fx-background-radius: 10px; -fx-text-fill:
    white;";
    private static String UNKNOWN_STYLE = BASE_STYLE + "-fx-background-color:
#0d1f78;";
    private static String FISH_STYLE = BASE_STYLE + "-fx-background-color: #050e40;
            -fx-opacity: 1;";
    private static String NOTHING_STYLE = BASE_STYLE + "-fx-background-color:
#3246a8;";

    public GameBoardButton(int row, int col, boolean hasFish)
    {
        this.row = row;
        this.col = col;
        this.hasFish = hasFish;

        // TODO: set min/pref width, default text
        this.setText("?");
        this.setPrefWidth(60);
        this.setMinWidth(60);
        this.setStyle(UNKNOWN_STYLE);
    }

    public void handleClick() {
        // TODO: update text
        // TODO "X"
        if(hasFish) {
            // TODO "<><"
            this.setText("<><");
            this.setStyle(FISH_STYLE);
        } else {
            this.setText("X");
            this.setStyle(NOTHING_STYLE);
        }
        isGuessed = true;
        setDisabled(true);
    }
}