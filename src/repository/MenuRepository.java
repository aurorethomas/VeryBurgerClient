package repository;
import java.sql.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import application.Database;
import entity.Menu;

public class MenuRepository {
	private Database database;

	public MenuRepository(Database database){
		this.database = database;
	}
	
	public ObservableList<Menu> getAllMenus(){
		String req = "select id_menu,name_menu, price_menu from MENU";
		PreparedStatement stm;
		try {
			stm = this.database.getConn().prepareStatement(req);
			ResultSet monRes = stm.executeQuery();
			ObservableList<Menu> menus = FXCollections.observableArrayList();
			while(monRes.next()){
				int id_menu = monRes.getInt("id_menu");
				String name = monRes.getString("name_menu");
				Double price = monRes.getDouble("price_menu");
				menus.add(new Menu(id_menu, name, price));
			}
			monRes.close();
			return menus;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/*public boolean createMenu(Menu menu){
		
	}
	
	public boolean deleteMenu(Menu menu){
		
	}
	
	public boolean updateMenu(Menu menu){
		
	}
*/
	
}
