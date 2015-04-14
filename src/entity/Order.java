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
	private final IntegerProperty id_user;
	private final ObjectProperty<Date> order_date;
	private final ObjectProperty<Date> delivrance_date;
	
	public Order(int id_order, int id_user, Date order_date,
			Date delivrance_date) {
		super();
		this.id_order = new SimpleIntegerProperty(id_order);
		this.id_user = new SimpleIntegerProperty(id_user);
		this.order_date = new SimpleObjectProperty<Date>(order_date);
		this.delivrance_date = new SimpleObjectProperty<Date>(delivrance_date);
	}

	public int getId_order() {
		return id_order.get();
	}

	public void setId_order(int id_order) {
		this.id_order.set(id_order);
	}

	public int getId_user() {
		return id_user.get();
	}

	public void setId_user(int id_user) {
		this.id_user.set(id_user);
	}

	public Date getOrder_date() {
		return order_date.get();
	}

	public void setOrder_date(Date order_date) {
		this.order_date.set(order_date);
	}

	public Date getDelivrance_date() {
		return delivrance_date.get();
	}

	public void setDelivrance_date(Date delivrance_date) {
		this.delivrance_date.set(delivrance_date);
	}
	
	
}
