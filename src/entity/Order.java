package entity;
import java.util.Date;

import javafx.beans.DefaultProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
	
	private final IntegerProperty id_order;
	private final StringProperty nomRecette;
	
	public Order(int id_order, String nomRecette) {
		super();
		this.id_order = new SimpleIntegerProperty(id_order);
		this.nomRecette = new SimpleStringProperty(nomRecette);
	}

	public int getId_order() {
		return id_order.get();
	}
	
	public IntegerProperty id_orderProperty(){
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order.set(id_order);
	}
	
	public StringProperty getnameProperty(){
		return this.nomRecette;
	}
	
	public String getName(){
		return this.nomRecette.get();
	}
	
}
