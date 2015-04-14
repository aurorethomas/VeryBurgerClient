package application;

import entity.Ingredient;
import application.Main.Person;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class View extends Application{
	private final TableView<Ingredient> table = new TableView<>();
	private final ObservableList<Ingredient> data = FXCollections.observableArrayList();
	
	public void displayWindow(){
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new Group());
        stage.setTitle("VeryBurger");
        /*stage.setWidth(1050);
        stage.setHeight(550);*/
        final Label label = new Label("Commandes");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(false);
        
        stage.setScene(scene);
        stage.show();
		
	}
	
	public static void afficherModal(String text){
   	 Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create().
            children(new Text(text), new Button("Ok.")).
            alignment(Pos.CENTER).padding(new Insets(10)).build()));
        dialogStage.show();
   }
}
