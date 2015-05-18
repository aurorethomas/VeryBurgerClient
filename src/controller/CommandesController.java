package controller;

import java.util.ArrayList;

import repository.OrderRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import application.MainApp;
import entity.Order;
import entity.Recipe;


public class CommandesController {
    @FXML
    public TableView<Order> ordersTable;
    @FXML
    public TableColumn<Order, Number> idOrder;
    @FXML
    private TableColumn<Order, String> quantity;
    @FXML
    private Label namerecette;
    @FXML
    private OrderRepository orderRepo;
    

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CommandesController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	idOrder.setCellValueFactory(cellData -> cellData.getValue().id_orderProperty() );
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	//nameRecette.setText("Cool");
    	showRecipe(null);
    }
    
    private void showRecipe(Order o){
    	if (o != null) {
    		namerecette.setText("");
    	}else
    	{
    		namerecette.setText("");
    	}
    }
    
    @FXML
    private void handleRecipeOk() {
        int selectedIndex = ordersTable.getSelectionModel().getSelectedIndex();
        // TODO
        //orderRepo.recipeIsDone(ordersTable.getItems().get(selectedIndex));
        ordersTable.getItems().remove(selectedIndex);
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        // Add observable list data to the table
        // personTable.setItems(mainApp.getPersonData());
        ObservableList<Order> orders = FXCollections.observableArrayList();
        orders.add(new Order(1, 1 , null, null));
        orders.add(new Order(2, 2 , null, null));
        ordersTable.setItems(orders);
    }
}
