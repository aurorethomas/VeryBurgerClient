package application;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Order;
import repository.OrderRepository;

public class MainTest {
	public static void main(String[] args) {
		Database db = new Database("pleymar", "KDJjey62", "@oracle.iut-orsay.fr:1521:etudom");
		OrderRepository orderRepo = new OrderRepository(db);
		ArrayList<Order> orders = orderRepo.getAllOrders();
		for(Order i : orders){
			System.out.println("id " + i.getId_order());
		}
    }
	
}
