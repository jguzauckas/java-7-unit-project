import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment2019 {
    public static ArrayList<Integer> readIn(String filename) {
		BufferedReader in;
		String str = "";

		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			in = new BufferedReader(new FileReader(filename));
			while ((str = in.readLine()) != null) {
				list.add(Integer.parseInt(str));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return list;
	}

    public static void main(String[] args) {
        ArrayList<Integer> computerCodes = readIn("2019/input.txt");
        
		// Your work goes here!
    }
}
