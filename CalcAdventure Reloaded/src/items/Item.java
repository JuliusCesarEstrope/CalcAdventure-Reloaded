package items;

public abstract class Item {

	public String name;
	public int weight = 0;
	public String description = "";
	
	public Item(String name, int weight, String description){
		this.name = name;
		this.weight = weight;
		this.description = description;
	}
	
	public String toString(){
		return name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public String getDescription(){
		return description;
	}

}
