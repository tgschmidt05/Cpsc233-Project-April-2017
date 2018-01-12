package mainClasses;
import java.io.*;

/**
 * @author: Tobias Schmidt
 *
 * This class handles all of our file IO, used in both the 
 * main class and the search menu.
 * 
 */

public class SaveLoad {
	
	/**
	 * Our save file names.
	 */
	public static final String fileNameSingle = "LightCyclesSingleSave.txt";
	public static final String fileNameMulti = "LightCyclesMultiSave.txt";
	
	/**
	 * Saves names for singleplayer
	 */
	public void saveSingleScore (String playerName) {
		PrintWriter outputStream = null;
		playerName = playerName.toLowerCase();
		try {
			outputStream = new PrintWriter(new FileOutputStream (fileNameSingle, true));
			
			outputStream.println(playerName);
			outputStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Save file missing. Program exiting...");
			System.exit(0);
		}
	}
	
	/**
	 * Saves names for multiplayer
	 */
	public void saveMultiScore (String playerName) {
		PrintWriter outputStream = null;
		playerName = playerName.toLowerCase();
		try {
			outputStream = new PrintWriter(new FileOutputStream (fileNameMulti, true));
			
			outputStream.println(playerName);
			outputStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Save file missing. Program exiting...");
			System.exit(0);
		}
	}
	
	/**
	 * Loads names for singleplayer.
	 */
	public String[] loadSingleScore() {
		BufferedReader inputStream = null;
		String[] outputArray = new String[1];
		int arrayLength = 0;
		int arrayCount = 0;
		
		try {
			inputStream = new BufferedReader(new FileReader(fileNameSingle));
			
			String line = inputStream.readLine();
			while (line != null) {
				arrayLength = arrayLength + 1;
				line = inputStream.readLine();
			}
			
			if (arrayLength == 0) {
				outputArray[0] = "No Scores Yet!";
			}
			else {
				outputArray = new String[arrayLength];
			}
			
			inputStream.close();
			inputStream = new BufferedReader(new FileReader(fileNameSingle));
			
			line = inputStream.readLine();
			while (line != null) {
				outputArray[arrayCount] = line;
				arrayCount = arrayCount + 1;
				line = inputStream.readLine();
			}
			inputStream.close();
		}
		catch (FileNotFoundException e) {
			outputArray[0] = "filenotfound";
			return outputArray;
		}
		catch (IOException e) {
			System.out.println("File IO error. Program exiting...");
			System.exit(0);
		}
		return outputArray;
	}
	
	/**
	 * Loads names for multiplayer.
	 */
	public String[] loadMultiScore() {
		BufferedReader inputStream = null;
		String[] outputArray = new String[1];
		int arrayLength = 0;
		int arrayCount = 0;
		
		try {
			inputStream = new BufferedReader(new FileReader(fileNameMulti));
			
			String line = inputStream.readLine();
			while (line != null) {
				arrayLength = arrayLength + 1;
				line = inputStream.readLine();
			}
			
			if (arrayLength == 0) {
				outputArray[0] = "No Scores Yet!";
			}
			else {
				outputArray = new String[arrayLength];
			}
			
			inputStream.close();
			inputStream = new BufferedReader(new FileReader(fileNameMulti));
			
			line = inputStream.readLine();
			while (line != null) {
				outputArray[arrayCount] = line;
				arrayCount = arrayCount + 1;
				line = inputStream.readLine();
			}
			inputStream.close();
		}
		catch (FileNotFoundException e) {
			outputArray[0] = "filenotfound";
			return outputArray;
		}
		catch (IOException e) {
			System.out.println("File IO error. Program exiting...");
			System.exit(0);
		}
		return outputArray;
	}
}