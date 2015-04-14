package entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recipe {

	private final IntegerProperty id_recipe;
	private final StringProperty name_recipe;
	private final DoubleProperty price;
	private final IntegerProperty id_type;
	
	public Recipe(int id_recipe, String name_recipe, double price, int id_type) {
		this.id_recipe = new SimpleIntegerProperty(id_recipe);
		this.name_recipe = new SimpleStringProperty(name_recipe);
		this.price =  new SimpleDoubleProperty(price);
		this.id_type = new SimpleIntegerProperty(id_type);
	}

	public int getId_recipe() {
		return id_recipe.get();
	}

	public void setId_recipe(int id_recipe) {
		this.id_recipe.set(id_recipe);
	}

	public String getName_recipe() {
		return name_recipe.get();
	}

	public void setName_recipe(String name_recipe) {
		this.name_recipe.set(name_recipe);
	}

	public double getPrice() {
		return price.get();
	}

	public void setPrice(double price) {
		this.price.set(price);
	}
	
	public int getId_type() {
		return id_type.get();
	}

	public void setId_type(int id_type) {
		this.id_type.set(id_type);
	}

	
	
}
