package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class AppLineCounter {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scString = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the path of the file: ");
		String strPath = sc.nextLine();
		try (FileReader fr = new FileReader(strPath); BufferedReader br = new BufferedReader(fr)) {
			File file = new File(strPath);
			if (!file.exists()) {
				throw new IOException("File doesn't exist.");
			}

			int count = 0;
			String line = "line";

			if (br.readLine() != null) {
				count = 1;
				line = br.readLine();
			}

			while (line != null) {
				line = br.readLine();
				count = count + 1;
			}
			System.out.println("----------------------");
			System.out.println("The file " + strPath + " has " + count + " lines.");
			System.out.println("______________________");
			
		} 
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		finally {

			scString.close();
			sc.close();

		}

	}

}
