package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HoldInventoryController extends Application {
    HoldInventory holdInventory = new HoldInventory();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        holdInventory.showTable();
    }

    static class HoldInventory {
        // stores the Hold object added to Inventory
        ObservableList<Inventory> bufferAdd = FXCollections.observableArrayList();

        void showTable() {
            // Data the TableView displays
            ObservableList<Inventory> tableData = FXCollections.observableArrayList();

            // The Table displays elements from the Inventory
            tableData.addAll(bufferAdd);

            // Create the table
            TableView<Inventory> table = new TableView<>();
            table.setItems(tableData);

            Scene scene = new Scene(new BorderPane());
            final Label label = new Label("Inventory of Holds (Mesa Rim Mira Mesa)");

            TableColumn holdType = new TableColumn("Hold type");
            holdType.setMinWidth(100);
            holdType.setCellValueFactory(new PropertyValueFactory<Inventory, String>("holdType"));

            TableColumn manufacture = new TableColumn("Manufacture");
            manufacture.setMinWidth(100);
            manufacture.setCellValueFactory(new PropertyValueFactory<Inventory, String>("manufacture"));

            TableColumn mountingOption = new TableColumn("Mounting Option");
            mountingOption.setMinWidth(200);
            mountingOption.setCellValueFactory(new PropertyValueFactory<Inventory, String>("mountingOption"));

            TableColumn texture = new TableColumn("Texture");
            texture.setMinWidth(200);
            texture.setCellValueFactory(new PropertyValueFactory<Inventory, String>("texture"));

            TableColumn difficulty = new TableColumn("Difficulty");
            difficulty.setMinWidth(200);
            difficulty.setCellValueFactory(new PropertyValueFactory<Inventory, String>("difficulty"));

            TableColumn color = new TableColumn("Color");
            color.setMinWidth(200);
            color.setCellValueFactory(new PropertyValueFactory<Inventory, String>("color"));

            TableColumn size = new TableColumn("Size");
            size.setMinWidth(200);
            size.setCellValueFactory(new PropertyValueFactory<Inventory, String>("size"));

            table.getColumns().addAll(holdType, manufacture, mountingOption, texture, difficulty, color, size);

            // TextField for inventory input
            TextField addHoldType = new TextField();
            addHoldType.setPromptText("Hold Type");
            addHoldType.setMaxWidth(holdType.getPrefWidth());

            TextField addManufacture = new TextField();
            addManufacture.setMaxWidth(manufacture.getPrefWidth());
            addManufacture.setPromptText("Manufacture");

            TextField addMountingOption = new TextField();
            addMountingOption.setMaxWidth(mountingOption.getPrefWidth());
            addMountingOption.setPromptText("Mounting Option");

            TextField addTexture = new TextField();
            addTexture.setMaxWidth(texture.getPrefWidth());
            addTexture.setPromptText("Texture");

            TextField addDifficulty = new TextField();
            addDifficulty.setMaxWidth(difficulty.getPrefWidth());
            addDifficulty.setPromptText("Difficulty");

            TextField addColor = new TextField();
            addColor.setMaxWidth(color.getPrefWidth());
            addColor.setPromptText("Color");

            TextField addSize = new TextField();
            addSize.setMaxWidth(texture.getPrefWidth());
            addSize.setPromptText("Size");

            // Button to add a new hold
            Button addButton = new Button("Add");
            addButton.setOnAction(e -> {

                Inventory newInventory = new Inventory(addHoldType.getText(), addManufacture.getText(),
                        addMountingOption.getText(), addTexture.getText(), addDifficulty.getText(),
                        addColor.getText(), addSize.getText());

                // Add a new element to the table data
                // clears the textfield for new entry
                tableData.add(newInventory);
                addHoldType.clear();
                addManufacture.clear();
                addMountingOption.clear();
                addTexture.clear();
                addDifficulty.clear();
                addColor.clear();
                addSize.clear();
            });

            // Button to remove a hold
            Button removeButton = new Button("Remove");
            removeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    Inventory selectedItem = table.getSelectionModel().getSelectedItem();

                    if (selectedItem != null) {
                        // Remove the item from the list of the displayed holds
                        tableData.remove(selectedItem);
                    }
                }
            });

            HBox input = new HBox();
            input.getChildren().addAll(addHoldType, addManufacture, addMountingOption, addTexture,
                    addDifficulty, addColor, addSize, addButton, removeButton);
            input.setSpacing(3);

            VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(label, table, input);

            BorderPane root = (BorderPane) scene.getRoot();
            root.setCenter(vbox);

            Stage stage = new Stage();

            HBox hbox = new HBox();
            hbox.setSpacing(5);
            hbox.setPadding(new Insets(10, 0, 0, 10));

            // Save button
            Button saveButton = new Button("Save");
            saveButton.setStyle("-fx-background-color: #3f6ab6; -fx-text-fill: white");

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
            saveButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    //Opening a dialog box
                    fileChooser.showSaveDialog(stage);
                }
            });

            // Cancel button
            Button cancelButton = new Button("Cancel");
            cancelButton.setStyle("-fx-background-color: #3f6ab6; -fx-text-fill: white");
            cancelButton.setOnAction(e -> stage.close());

            hbox.getChildren().addAll(saveButton, cancelButton);

            root.setBottom(hbox);
            stage.setScene(scene);
            stage.show();
        }
    }
}


