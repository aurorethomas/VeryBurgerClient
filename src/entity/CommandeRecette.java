package entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CommandeRecette {

	private final IntegerProperty id_menu;
	private final StringProperty name_menu;
	private final DoubleProperty price_menu;
	
	public CommandeRecette(int id_menu, String name_menu, double price_menu) {
		this.id_menu = new SimpleIntegerProperty(id_menu);
        this.name_menu = new SimpleStringProperty(name_menu);
		this.price_menu = new SimpleDoubleProperty(price_menu);
	}
	
	public Integer getId_menu() {
		return id_menu.get();
	}


	public void setId_menu(int id_menu) {
		this.id_menu.set(id_menu);
	}


	public String getName_menu() {
		return name_menu.get();
	}


	public void setName_menu(String name_menu) {
		this.name_menu.set(name_menu);
	}


	public double getPrice_menu() {
		return price_menu.get();
	}


	public void setPrice_menu(double price_menu) {
		this.price_menu.set(price_menu);
	}
		
}
