package controller;

import java.util.ArrayList;

import repository.OrderRepository;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import application.MainApp;
import entity.Menu;
import entity.Order;
import entity.Recipe;


public class CaisseController {
    @FXML
    public TableView<Menu> menusTable;
    @FXML
    public TableColumn<Menu, String> menuName;
    @FXML
    private TableColumn<Menu, Number> menuPrix;
    @FXML
    private TableColumn<Menu, Number> menuQuantite;
    @FXML
    private TableColumn<Menu, Number> menuTotal;
    @FXML
    private Label prixTotal;
    @FXML
    private OrderRepository orderRepo;
    
    private Double prixTotalDouble;
    

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CaisseController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	this.updatePrice(0.0);
        // Initialize the person table with the two columns.
    	menuName.setCellValueFactory(cellData -> cellData.getValue().getName_menu_property() );
    	menuPrix.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty() ); 
    	menuQuantite.setCellValueFactory(cellData -> cellData.getValue().getQuantityProperty() );
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	//nameRecette.setText("Cool");
    	/*menusTable.getSelectionModel().selectedItemProperty().addListener(
    	            (observable, oldValue, newValue) -> addToCommande(newValue));*/
    }
    
    private void addToCommande(Menu men){
    	System.out.println(men);
    	this.updatePrice(this.prixTotalDouble + men.getPrice_menu());
    	men.setQuantity_menu(men.getQuantity_menu()+1);
    	menusTable.getSelectionModel().select(-1);
    }
    
    private void updatePrice(Double newPrice){
    	this.prixTotalDouble = newPrice;
    	this.prixTotal.setText(prixTotalDouble.toString()+"€");
    }
    
    private void showRecipe(Order o){
    	/*if (o != null) {
    		namerecette.setText("");
    	}else
    	{
    		namerecette.setText("");
    	}*/
    }
    
    @FXML
    private void handleCommandePaye() {
    	
       /* int selectedIndex = ordersTable.getSelectionModel().getSelectedIndex();
        orderRepo.recipeIsDone(ordersTable.getItems().get(selectedIndex));
        ordersTable.getItems().remove(selectedIndex);*/
    }
    
    @FXML
    private void handleClickMenu(){
    	this.addToCommande(menusTable.getSelectionModel().getSelectedItem());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
       /* // Add observable list data to the table
        // personTable.setItems(mainApp.getPersonData());
        ObservableList<Order> orders = FXCollections.observableArrayList();
        orders.add(new Order(1, 1 , null, null));
        orders.add(new Order(2, 2 , null, null));
        ordersTable.setItems(orders);*/
        ObservableList<Menu> menus = FXCollections.observableArrayList();
        menus.add(new Menu(1, "Repas très bon", 2));
        menus.add(new Menu(1, "Repas pas bon", 2));
        //menus = this.mainApp.menuRepo.getAllMenus();
        menusTable.setItems(menus);
    }
}
