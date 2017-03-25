package game;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Entities.Entity;

public class Utilities {

	public static void display(String message) {
		System.out.println(message);
		pauseForEffect();
	}

	public static void display(String[] messages) {
		for (int i = 0; i < messages.length; i++) {
			System.out.println(messages[i]);
			pauseForEffect();
		}
	}

	public static void display(String message, String ... rest) {
		pauseForEffect();
		System.out.println(message);
		for (int i = 0; i < rest.length; i++) {
			System.out.println(rest[i]);
			pauseForEffect();
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
	
	public static void pauseForEffect(){
		try {
			Thread.sleep(1000);
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
			stringArray = new String[temp.length + 1];
			for (int j = 0; j < temp.length; j++)
				stringArray[j] = temp[j];
			stringArray[temp.length] = arr[i].toString();
		}
		return stringArray;
	}

	public static Entity[] removeEntity(Entity var, Entity[] arr) {
		Entity[] result = {}, temp = arr;
		result = new Entity[temp.length - 1];
		for(int i = 0; i < result.length; i++){
			if(temp[i] != var){
				result[i] = temp[i];
			}
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
