package repository;

import java.sql.*;
//import java.sql.SQLException;
import java.util.ArrayList;

import application.Database;
import entity.Ingredient;


public class IngredientRepository {
	private ArrayList<Ingredient> ingredients;
	private Database database;
	
	public IngredientRepository(Database database){
		ingredients = new ArrayList<Ingredient>();
		this.database = database;
	}
	
	public ArrayList<Ingredient> getAllIngredients(){
		Connection conn = this.database.getConn();
		try{
			Statement stm = conn.createStatement();
			String req = "SELECT * FROM INGREDIENT";
			ResultSet res = stm.executeQuery(req);
			while(res.next()){
				int id = res.getInt("id_ingredient");
				int id_type = res.getInt("id_type");
				String name = res.getString("name");
				String labelquantity = res.getString("quantity_label");
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
	
	public boolean createIngredient(Ingredient ing){
		Connection conn = this.database.getConn();
		try{
			String req = "INSERT INTO INGREDIENT (id_type, name, quantity_label) VALUES(?,?,?)";
			PreparedStatement stm = conn.prepareStatement(req);
			
			stm.setInt(1, ing.getId_type());
			stm.setString(2, ing.getName());
			stm.setString(3, ing.getQuantity_label());
			ResultSet res = stm.executeQuery();
			res.close();
			stm.close();
			return true;
		}catch(SQLException e){
			// erreur
			return false;
		}

	}
}
