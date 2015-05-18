package repository;

import java.sql.*;
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
				// creating and inserting new Orders in arraylist
				//this.orders.add(new Order(id,id_user, order_date, delivrance_date));
			}
			res.close();
		}catch(SQLException e){

		}
		return orders;
	}
	

	public void recipeIsDone(int idOrder) {
		Connection conn = this.database.getConn();
		CallableStatement cst;
		try {
			cst= conn.prepareCall("call commande_preparee (?)") ;
			cst.setInt(1, idOrder);
			//cst.registerOutParameter(1, java.sql.Types.NUMBER);
			boolean succes = cst.execute();
			//int rNb = cst.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
