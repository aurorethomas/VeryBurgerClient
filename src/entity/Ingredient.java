package entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ingredient {
	private final IntegerProperty id_ingredient;
	private final StringProperty name;
	private final StringProperty quantity_label;
	
	public Ingredient(int id_ingredient, String name,
			String quantity_label) {
		this.id_ingredient = new SimpleIntegerProperty(id_ingredient);
        this.name = new SimpleStringProperty(name);
        this.quantity_label = new SimpleStringProperty(quantity_label);
	}

	public Integer getId_ingredient(){
		return id_ingredient.get();
	}

	public void setId_ingredient(Integer id_ingredient) {
		this.id_ingredient.set(id_ingredient);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getQuantity_label() {
		return quantity_label.get();
	}

	public void setQuantity_label(String quantity_label) {
		this.quantity_label.set(quantity_label);
	}	
	
	
}
