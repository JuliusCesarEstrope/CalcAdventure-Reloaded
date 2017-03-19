package game;

public class Utilities {
	
	public void display(String message){
		System.out.println(message);
	}
	
	public void display(String[] messages){
		for(int i = 0; i < messages.length; i++){
			System.out.println(messages[i]);
		}
	}
	
}
