package String;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindTextInFile {

	public static void main(String[] args) throws FileNotFoundException {
		// WAP to find a text in a file
		String str = "Cloud";
		String filepath = "C:/Users/nsinh/Documents/Job/Notes/AWS/AWS.txt";
		System.out.println("The string is present in the file : "+findStringInFile(filepath, str));

	}
	
	private static boolean findStringInFile(String filePath, String str) throws FileNotFoundException {
		
		File file = new File(filePath);
		
		Scanner scanner = new Scanner(file);
		
		//read the file line by line
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if(line.contains(str)) {
				scanner.close();
				return true;
			}
		}scanner.close();
		return false;
	}

}
