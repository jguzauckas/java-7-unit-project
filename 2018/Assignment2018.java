import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment2018 {
    public static ArrayList<String> readIn(String filename) {
		BufferedReader in;
		String str = "";

		ArrayList<String> list = new ArrayList<String>();

		try {
			in = new BufferedReader(new FileReader(filename));
			while ((str = in.readLine()) != null) {
				list.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return list;
	}

    public static void main(String[] args) {
        ArrayList<String> inventoryIDs = readIn("2018/input.txt");
		
		// Your work goes here!
    }
}
