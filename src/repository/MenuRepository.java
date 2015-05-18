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
		ObservableList<Menu> menus = FXCollections.observableArrayList();
		try {
			//PreparedStatement stm = this.database.getConn().prepareStatement(req);
			//ResultSet monRes = stm.executeQuery();
			Statement stm = this.database.getConn().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY,
					ResultSet.CLOSE_CURSORS_AT_COMMIT);
			String req = "SELECT * FROM VUE_AFFICHAGE_LISTE_MENU";
			ResultSet monRes =stm.executeQuery(req);
			System.out.println(monRes.first());
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
			return menus;
		}
		
	}
	
	public Integer commencerCommande(){
		Connection conn = this.database.getConn();
		CallableStatement cst;
		try {
			cst= conn.prepareCall(" ? = call Get_id_commande") ;
			//cst.setInt(1, idOrder);
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			boolean succes = cst.execute();
			int idCommande = cst.getInt(1);
			return idCommande;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void ajouterMenuCommande(Integer idCommande, Integer Idmenu, Integer quantity){
		Connection conn = this.database.getConn();
		CallableStatement cst;
		try {
			cst= conn.prepareCall("call Ajouter_menu_commande (?, ?, ?)") ;
			cst.setInt(1, idCommande);
			cst.setInt(2, Idmenu);
			cst.setInt(3, quantity);
			//cst.registerOutParameter(1, java.sql.Types.INTEGER);
			boolean succes = cst.execute();
			//int idCommande = cst.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validerCommande(Integer idCommande){
		Connection conn = this.database.getConn();
		CallableStatement cst;
		try {
			cst= conn.prepareCall("call valider_commande (?)") ;
			cst.setInt(1, idCommande);
			//cst.registerOutParameter(1, java.sql.Types.INTEGER);
			boolean succes = cst.execute();
			//int idCommande = cst.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
