package game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Utilities {
	
	public static void display(String message){
		System.out.println(message);
	}
	
	public static void display(String[] messages){
		for(int i = 0; i < messages.length; i++){
			System.out.println(messages[i]);
		}
	}
	
	public static String getInput(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static int randNum(int min, int max){
		Random random = new Random();
		return random.nextInt(max) + min;
	}
	
	public static int roll(int num){
		Random random = new Random();
		return random.nextInt(num) + 1;
	}
	
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
