package ThucHanhBuoi2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadFile {
	public static ArrayList<String> read (String url){
		int v = 0 ;
		ArrayList<String> result = new ArrayList<>();
		File file = new File(url) ;
		try {
			FileReader reader = new FileReader(file) ;
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			v = Integer.parseInt(line) ;
			line = buffer.readLine();
			while (line != null) {
				result.add(line);
				line = buffer.readLine();
			}
			
			
			
		} catch (Exception e) {
        e.printStackTrace();
        
		}
		return result;
	}
	public void print () {
	    ArrayList<String> arr = ReadFile.read("./dsdt.txt");
	    String[][] matrix = new String[arr.size()][];

	    for (int i = 0; i < arr.size(); i++) {
	        String line = arr.get(i);
	        String[] elements = line.split(" ");

	        matrix[i] = elements;
	    }

	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length; j++) {
	            System.out.print(matrix[i][j] + " ");
	        }
	        System.out.println(); 
	    }
	}
 
	

}
