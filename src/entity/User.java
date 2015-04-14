package entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

	private final IntegerProperty id_user;
	private final StringProperty  firstName_user;
	private final StringProperty  surName_user;
	private final IntegerProperty  position;
	
	
	public User(int id_user, String firstName_user, String surName_user,
			int position) {
		this.id_user = new SimpleIntegerProperty(id_user);
		this.firstName_user = new SimpleStringProperty(firstName_user);
		this.surName_user = new SimpleStringProperty(surName_user);
		this.position = new SimpleIntegerProperty(position);
	}


	public int getId_user() {
		return id_user.get();
	}


	public void setId_user(int id_user) {
		this.id_user.set(id_user);
	}


	public String getFirstName_user() {
		return firstName_user.get();
	}


	public void setFirstName_user(String firstName_user) {
		this.firstName_user.set(firstName_user);
	}


	public String getSurName_user() {
		return surName_user.get();
	}


	public void setSurName_user(String surName_user) {
		this.surName_user.set(surName_user);
	}


	public int getPosition() {
		return position.get();
	}


	public void setPosition(int position) {
		this.position.set(position);
	}
	
}
