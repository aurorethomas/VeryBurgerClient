package application;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Ingredient;
import entity.Order;
import repository.IngredientRepository;
import repository.OrderRepository;

public class MainTest {
	public static void main(String[] args) {
		Database db = new Database("pleymar", "KDJjey62", "@oracle.iut-orsay.fr:1521:etudom");
		OrderRepository orderRepo = new OrderRepository(db);
		IngredientRepository ingredientRepo = new IngredientRepository(db);
		ArrayList<Order> orders = orderRepo.getAllOrders();
		ArrayList<Ingredient> ingredients = ingredientRepo.getAllIngredients();
		for(Order i : orders){
			System.out.println("id " + i.getId_order());
		}
		for(Ingredient a : ingredients){
			System.out.println( a.getName());
		}
		
		View vue = new View();
		vue.displayWindow();
    }
	
}
