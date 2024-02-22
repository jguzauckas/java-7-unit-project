import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Setup {
    public static void writeStringToFile(String str, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);
        writer.close();
    }

    public static void writeListToFile(ArrayList list, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i) + "\n";
        }
        str.trim();
        writer.write(str);
        writer.close();
    }

    public static ArrayList<String> generate2018(int size) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            String str = "";
            for (int j = 0; j < 25; j++) {
                str += Character.toString((char) ((int) (Math.random() * 26 + 97)));
            }
            result.add(str);
        }
        return result;
    }

    public static String solve2018(ArrayList<String> list) {
        int countDouble = 0;
        int countTriple = 0;
        for (String str : list) {
            boolean hasDouble = false;
            boolean hasTriple = false;
            for (int i = 0; i < str.length(); i++) {
                int count = 0;
                String temp = str.substring(i, i + 1);
                for (int j  = 0; j < str.length(); j++) {
                    if (temp.equals(str.substring(j, j + 1))) {
                        count++;
                    }
                }
                if (count == 2) {
                    hasDouble = true;
                } else if (count == 3) {
                    hasTriple = true;
                }
            }
            if (hasDouble) {
                countDouble++;
            }
            if (hasTriple) {
                countTriple++;
            }
        }
        String answer = "There are " + countDouble + " double appearances and " + countTriple + " triple appearances. ";
        answer += "This produces a checksum of " + countDouble + " * " + countTriple + " = " + (countDouble * countTriple);
        return answer;
    }

    public static ArrayList<Integer> generate2019(int size) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        size = size - (size % 4);
        for (int i = 0; i < size - 1; i++) {
            if (i % 4 == 0) {
                if (Math.random() > 0.2) {
                    intList.add(1);
                } else if (Math.random() > 0.2) {
                    intList.add(2);
                } else {
                    intList.add(99);
                }
            } else {
                int temp = (int) (Math.random() * i);
                if (temp % 4 == 0) {
                    temp++;
                }
                intList.add(temp);
            }
        }
        intList.add(99);
        return intList;
    }

    public static String solve2019(ArrayList<Integer> in) {
        in.set(1, 12);
        in.set(2, 2);
        for (int i = 0; i < in.size(); i += 4) {
            if (in.get(i) == 1) {
                in.set(in.get(i + 3), in.get(in.get(i + 1)) + in.get(in.get(i + 2)));
            } else if (in.get(i) == 2) {
                in.set(in.get(i + 3), in.get(in.get(i + 1)) * in.get(in.get(i + 2)));
            } else {
                i = in.size();
            }
        }

        String answer = "The value at position 1 is " + in.get(1) + "\n";
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<String> p2018 = generate2018(250);
        ArrayList<Integer> p2019 = generate2019(200);

        try {
            writeListToFile(p2018, "2018/input.txt");
            writeStringToFile(solve2018(p2018), "2018/answer.txt");

            writeListToFile(p2019, "2019/input.txt");
            writeStringToFile(solve2019(p2019), "2019/answer.txt");
        } catch (IOException e1) {
			e1.printStackTrace();
		}
    }
}