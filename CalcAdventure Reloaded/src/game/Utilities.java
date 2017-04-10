package game;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Entities.Entity;

public class Utilities {

	public static void display(String message) {
		display(new String[]{message});
	}

	public static void display(String message, int wait) {
		display(new String[]{message}, wait);
	}

	public static void display(String[] messages) {
		for (int i = 0; i < messages.length; i++) {
			System.out.println(messages[i]);
			pauseForEffect();
		}
	}

	public static void display(String[] messages, int wait) {
		for (int i = 0; i < messages.length; i++) {
			System.out.println(messages[i]);
			pauseForEffect(wait);
		}
	}

	public static void display(String message, String ... rest) {
		System.out.println(message);
		pauseForEffect();
		for (int i = 0; i < rest.length; i++) {
			System.out.println(rest[i]);
			pauseForEffect();
		}
	}

	public static void display(int wait, String message, String ... rest) {
		System.out.println(message);
		pauseForEffect(wait);
		for (int i = 0; i < rest.length; i++) {
			System.out.println(rest[i]);
			pauseForEffect(wait);
		}
	}

	public static <T> void showElements(T[] arr) {
		for (T obj : arr) {
			System.out.println(obj.toString());
		}
	}

	public static String getInput() {
		Scanner sc = new Scanner(System.in);
		String input = "";
		/*while(sc.hasNextLine()){
			input = sc.nextLine();
			if(!input.equals(""))
				break;
		}
		sc.close();*/
		input = sc.nextLine();
		return input;
	}

	public static String getValidInput(String[] choices) {
		return getValidInput(choices, "You can't do that.");
	}

	public static String getValidInput(String[] choices, String notification) {
		return getValidInput(choices, new String[] {notification});
	}

	public static String getValidInput(String[] choices, String[] notifications) {
		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		String input = "";
		while(!valid){
			input = sc.nextLine();
			if(isInArray(input, choices) != -1)
				valid = true;
			else{
				display(notifications[roll(notifications.length)-1]);
			}
		}
		//sc.close();//Known to cause problems
		return input;
	}
	
	public static boolean playerYN(){
		String[] yes = {"Yes", "Sure", "Yup", "Okay", "Absolutely", "I guess", "Ye", "Affirmative", "Fine", "Yea", "Yeah", "Aye"," Definitely", "By all means", "Certainly", "Sure Thing"};
		if(isInArray(getInput(), yes) != -1)
			return true;
		else
			return false;
	}
	
	public static void pauseForEffect(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void pauseForEffect(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForEnter(){
		try {
			display("Press enter to continue.");
			System.in.read();
			//Consider writing equivalencies for Mac and Linux
			//Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int randNum(int min, int max) {
		Random random = new Random();
		return random.nextInt(max) + min;
	}

	public static int roll(int num) {
		Random random = new Random();
		return random.nextInt(num) + 1;
	}
	
	public static int getGameTime(){
		return (int) (System.currentTimeMillis() %3600000) / 60000;
	}
	
	public static String getTimeOfDay(){
		String timeOfDay = "Whoops. Something went wrong.";
		if(getGameTime() <= 12)
			timeOfDay = "morning";
		else if(getGameTime() <= 36)
			timeOfDay = "midday";
		else if(getGameTime() <= 48)
			timeOfDay = "evening";
		else
			timeOfDay = "night";
		return timeOfDay;
	}

	public static <T> int isInArray(T var, T[] arr) {
		int foundIndex = -1, curIndex = 0;
		for (T arg : arr) {
			if (var.toString().equalsIgnoreCase(arg.toString()))
				foundIndex = curIndex;
			curIndex++;
		}
		return foundIndex;
	}
	
	public static <T> String[] toStringArray(T[] arr){
		String[] stringArray = {}, temp = {};
		for(int i = 0; i < arr.length; i++){
			temp = stringArray;
			Utilities.display(arr[i].toString());
			stringArray = new String[temp.length + 1];
			for (int j = 0; j < temp.length; j++)
				stringArray[j] = temp[j];
			stringArray[temp.length] = arr[i].toString();
		}
		return stringArray;
	}

	public static Entity[] removeEntity(Entity var, Entity[] arr) {
		Entity[] result = {};
		int count = 0;
		result = new Entity[arr.length - 1];		
		for(int i = 0; i < arr.length; i++){
			//Utilities.display("Looking at index " + i);//Used for troubleshooting
			if(arr[i] != var){
				result[count] = arr[i];
				//Utilities.display(arr[i].toString() + " was added to array.");//Used for troubleshooting
				count++;
			}
			//else
				//Utilities.display(var.toString() + " found. Not adding array.");//Used for troubleshooting
		}
		return result;
	}
	
	//The below does not work, gives error for trying to cast Object[] into Entity[]
/*
	@SuppressWarnings("unchecked")
	public static <T> T[] removeFromArray(T var, T[] arr) {
		List<T> result = new LinkedList<T>();

		for (T item : arr)
			if (!var.toString().equalsIgnoreCase(item.toString()))
				result.add(item);

		return (T[])result.toArray();
	}
	
	public static  Entity[] removeFromArray(Entity var, Entity[] arr) {
		List<Entity> result = new LinkedList<Entity>();

		for (Entity item : arr)
			if (!var.toString().equalsIgnoreCase(item.toString()))
				result.add(item);

		return (Entity[]) result.toArray();
	}
*/
	@SafeVarargs
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

}
