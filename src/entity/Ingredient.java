package entity;

public class Ingredient {
	private int id_ingredient;
	private int id_type;
	private String name;
	private String quantity_label;
	
	
	public Ingredient(int id_ingredient, int id_type, String name,
			String quantity_label) {
		this.id_ingredient = id_ingredient;
		this.id_type = id_type;
		this.name = name;
		this.quantity_label = quantity_label;
	}
	
	public int getId_ingredient() {
		return id_ingredient;
	}
	public void setId_ingredient(int id_ingredient) {
		this.id_ingredient = id_ingredient;
	}
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity_label() {
		return quantity_label;
	}
	public void setQuantity_label(String quantity_label) {
		this.quantity_label = quantity_label;
	}
	
	
	
}
