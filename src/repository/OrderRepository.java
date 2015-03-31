package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Database;
import entity.Ingredient;
import entity.Order;

public class OrderRepository {
	private ArrayList<Order> orders;
	private Database database;
	
	public OrderRepository(Database database){
		this.database = database;
		orders = new ArrayList<Order>();
	}
	
	public ArrayList<Order> getAllOrders(){
		Connection conn = this.database.getConn();
		try{
			Statement stm = conn.createStatement();
			String req = "SELECT * FROM ORDER";
			ResultSet res = stm.executeQuery(req);
			while(res.next()){
				int id = res.getInt("id_order");
				int id_user = res.getInt("id_user");
				Date order_date = res.getString("name");
				Date delivrance_date = res.getString("quantity_label");
				// creating and inserting new Ingredient in arraylist
				this.ingredients.add(new Ingredient(id,id_type, name, labelquantity));
			}
			res.close();
		}catch(SQLException e){
			// erreur
		}
		// returning arraylist of ingredients
		return ingredients;
	}
}
