package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import application.Database;
import entity.Ingredient;
import entity.Order;

public class OrderRepository {
	//private ArrayList<Order> orders;
	private ObservableList<Order> orders;
	private Database database;
	
	public OrderRepository(Database database){
		this.database = database;
		orders = FXCollections.observableArrayList();
	}
	
	public ObservableList<Order> getAllOrders(){
		Connection conn = this.database.getConn();
		try{
			Statement stm = conn.createStatement();
			String req = "SELECT * FROM ORDERS";
			ResultSet res = stm.executeQuery(req);
			while(res.next()){
				int id = res.getInt("id_order");
				int id_user = res.getInt("id_user");
				Date order_date = res.getDate("order_date");
				Date delivrance_date = res.getDate("delivrance_date");
				// creating and inserting new Orders in arraylist
				this.orders.add(new Order(id,id_user, order_date, delivrance_date));
			}
			res.close();
		}catch(SQLException e){

		}
		return orders;
	}
	

	public void recipeIsDone(Order order) {
		// TODO Auto-generated method stub
		
	}
}
