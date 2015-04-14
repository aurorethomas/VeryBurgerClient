package entity;
import java.util.Date;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Purchase {

	private final IntegerProperty id_purchase;
	private final ObjectProperty<Date> purchaseDate;
	private final ObjectProperty<Date> throwDate;
	private final IntegerProperty throw_user_id;
	private final DoubleProperty purchasePrice;
	private final BooleanProperty available;
	private final IntegerProperty id_order;
	private final IntegerProperty id_ingredient;
	private final IntegerProperty quantite_ingredient;
	private final ObjectProperty<Date> expireDate;
	
	public Purchase(int id_purchase, Date purchaseDate, Date throwDate,
			int throw_user_id, int purchasePrice, Boolean available, int id_order, 
			int id_ingredient, int quantite_ingredient, Date expireDate) {
		this.id_purchase =  new SimpleIntegerProperty(id_purchase);
		this.purchaseDate = new SimpleObjectProperty<Date>(purchaseDate);
		this.throwDate = new SimpleObjectProperty<Date>(throwDate);
		this.throw_user_id = new SimpleIntegerProperty(throw_user_id);
		this.purchasePrice = new SimpleDoubleProperty(purchasePrice);
		this.available = new SimpleBooleanProperty(available);
		this.id_order = new SimpleIntegerProperty(id_order);
		this.id_ingredient = new SimpleIntegerProperty(id_ingredient);
		this.quantite_ingredient = new SimpleIntegerProperty(quantite_ingredient);
		this.expireDate = new SimpleObjectProperty<Date>(expireDate);
	}

	public int getId_purchase() {
		return id_purchase.get();
	}

	public void setId_purchase(int id_purchase) {
		this.id_purchase.set(id_purchase);
	}

	public Date getPurchaseDate() {
		return purchaseDate.get();
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate.set(purchaseDate);
	}

	public Date getThrowDate() {
		return throwDate.get();
	}

	public void setThrowDate(Date throwDate) {
		this.throwDate.set(throwDate);
	}

	public int getThrow_user_id() {
		return throw_user_id.get();
	}

	public void setThrow_user_id(int throw_user_id) {
		this.throw_user_id.set(throw_user_id);
	}

	public double getPurchasePrice() {
		return purchasePrice.get();
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice.set(purchasePrice);
	}

	public Boolean getAvailable() {
		return available.get();
	}

	public void setAvailable(Boolean available) {
		this.available.set(available);
	}

	public int getId_ingredient() {
		return id_ingredient.get();
	}
	
	public void setId_ingredient(int id_ingredient) {
		this.id_ingredient.set(id_ingredient);
	}

	public int getId_order() {
		return id_order.get();
	}
	
	public void setId_order(int id_order) {
		this.id_order.set(id_order);
	}

	public int getQuantite_ingredient() {
		return quantite_ingredient.get();
	}

	public void setQuantite_ingredient(int quantite_ingredient) {
		this.quantite_ingredient.set(quantite_ingredient);
	}

	public Date getExpireDate() {
		return expireDate.get();
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate.set(expireDate);
	}
	
	
	
}
