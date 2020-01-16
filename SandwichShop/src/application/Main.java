package application;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.*;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main<orderTotal> extends Application {

public static void main(String[] args) {
launch(args);
}

final Button button = new Button ("Place Order");
final Label notification = new Label ();
final TextField name = new TextField("");
final TextArea text = new TextArea ("");
final Label total = new Label("$0");
final static Integer[] orderTotal = new Integer[] {
		5, 10, 15
};

@Override public void start(Stage stage) {
    stage.setTitle("Valencia Sandwich Shop");
    Scene scene = new Scene(new Group(), 450, 650);

    // Dropdown for bread
    final ComboBox breadComboBox = new ComboBox();
    breadComboBox.getItems().addAll(
        "White",
        "Wheat",
        "Rye"
    );

    // Dropdown for meat
    final ComboBox meatComboBox = new ComboBox();
    meatComboBox.getItems().addAll(
        "Chicken",
        "Turkey",
        "Ham",
        "Veggie"
    );

    // Radioboxes for additional ingredients
    // create a tile pane
    TilePane r = new TilePane();

    // create a label
    Label radiolabel = new Label("Choose your veggies (no charge): ");

    // create radiobuttons
    RadioButton r1 = new RadioButton("Tomato");
    RadioButton r2 = new RadioButton("Lettuce");
    RadioButton r3 = new RadioButton("Onion");

    // add label
    r.getChildren().add(radiolabel);
    r.getChildren().add(r1);
    r.getChildren().add(r2);
    r.getChildren().add(r3);

    // Demonstrating how to set a default value for dropdown
    breadComboBox.setValue("Wheat");
    meatComboBox.setValue("Ham");

    GridPane grid = new GridPane();
    grid.setVgap(4);
    grid.setHgap(10);
    grid.setPadding(new Insets(5, 5, 5, 5));
    grid.add(new Label("Choose Bread: "), 0, 0);
    grid.add(breadComboBox, 1, 0);
    grid.add(new Label("Choose Meat: "), 2, 0);
    grid.add(meatComboBox, 3, 0);
    grid.add(radiolabel, 0, 2, 4, 1);
    grid.add(r1, 0, 3, 4, 1);
    grid.add(r2, 0, 4, 4, 1);
    grid.add(r3, 0, 6, 4, 1);
    grid.add(new Label("Name for the Order: "), 0, 8);
    grid.add(name, 1, 8, 3, 1);
    grid.add(new Label("Order Total: "), 0, 10);
    grid.add(total, 1, 10, 3, 1);
    grid.add(button, 0, 14);
    grid.add (notification, 1, 3, 3, 1);

    Group root = (Group)scene.getRoot();
    root.getChildren().add(grid);
    stage.setScene(scene);
    stage.show();

    // Add action on selections for total
    breadComboBox.setOnAction((e) -> {
        total.setText("$5.00");
   });

    meatComboBox.setOnAction((e) -> {
        total.setText("$10.00");
   });

    button.setOnAction((ActionEvent e) -> {
    	 button.setText("Accepted");
    	});
}
}

