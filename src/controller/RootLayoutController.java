package controller;


import java.util.ArrayList;
import java.util.Optional;

import repository.OrderRepository;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.WindowEvent;
import javafx.util.Pair;
import application.Database;
import application.MainApp;
import entity.Order;
import entity.Recipe;


public class RootLayoutController {
   

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public RootLayoutController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	loginBoxLaunch();
    }
    
    @FXML
    private void exitApplication(){
    	mainApp.getPrimaryStage().close();
    }
    
    @FXML
    private void changeToCaisse(){
    	this.mainApp.showCaisseOverview();
    }
    
    @FXML
    private void changeToCuisinier(){
    	this.mainApp.showCommandOverview();
    }
    
    public Boolean login(String username, String password){
    	Database db = new Database();
    	Boolean succes = db.login(username, password, "@oracle.iut-orsay.fr:1521:etudom");

    	return succes;
    }
    
    private void accessNotGranted(){
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Accès refusé");
    	alert.setHeaderText("Accès refusé");
    	alert.setContentText("Votre login ou votre mot de passe est incorrect.");

    	alert.showAndWait();
    	
    	this.exitApplication();
    }
    
    @FXML
    private void loginBoxLaunch() {
    	/*Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText("Look, an Information Dialog");
    	alert.setContentText("I have a great message for you!");

    	alert.showAndWait();*/
    	
    	// Create the custom dialog.
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	dialog.setTitle("Connexion");
    	dialog.setHeaderText("Connectez-vous !");

    	// Set the icon (must be included in the project).
    	//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

    	// Set the button types.
    	ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    	// Create the username and password labels and fields.
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));

    	TextField username = new TextField();
    	username.setPromptText("Utilisateur");
    	PasswordField password = new PasswordField();
    	password.setPromptText("Mot de passe");

    	grid.add(new Label("Utilisateur :"), 0, 0);
    	grid.add(username, 1, 0);
    	grid.add(new Label("Mot de passe :"), 0, 1);
    	grid.add(password, 1, 1);

    	// Enable/Disable login button depending on whether a username was entered.
    	Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
    	loginButton.setDisable(true);

    	// Do some validation (using the Java 8 lambda syntax).
    	username.textProperty().addListener((observable, oldValue, newValue) -> {
    	    loginButton.setDisable(newValue.trim().isEmpty());
    	});

    	dialog.getDialogPane().setContent(grid);
    	
    	dialog.setOnCloseRequest(new EventHandler<DialogEvent>() {
            public void handle(DialogEvent we) {
                System.out.println("Stage is closing");
                
            }
        });   

    	// Request focus on the username field by default.
    	Platform.runLater(() -> username.requestFocus());

    	// Convert the result to a username-password-pair when the login button is clicked.
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == loginButtonType) {
    	        return new Pair<>(username.getText(), password.getText());
    	    }
    	    return null;
    	});

    	Optional<Pair<String, String>> result = dialog.showAndWait();

    	result.ifPresent(usernamePassword -> {
    		//this.test(usernamePassword.getKey());
    	    //System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
    	    
    		if(this.login(usernamePassword.getKey(), usernamePassword.getValue())){
    			this.changeToCaisse();
    		}else{
    			this.accessNotGranted();
    		}
    		
    	    
    	});
    }
    
    
   
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
