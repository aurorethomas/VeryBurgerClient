package entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Position {

	private final IntegerProperty id_menu_order;
	private final StringProperty label_position;
	
	public Position(int id_menu_order, String label_position) {
		this.id_menu_order = new SimpleIntegerProperty(id_menu_order);
		this.label_position = new SimpleStringProperty(label_position);
	}

	public int getId_menu_order() {
		return id_menu_order.get();
	}

	public void setId_menu_order(int id_menu_order) {
		this.id_menu_order.set(id_menu_order);
	}

	public String getLabel_position() {
		return label_position.get();
	}

	public void setLabel_position(String label_position) {
		this.label_position.set(label_position);
	}
	
	
	
}
