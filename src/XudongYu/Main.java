package XudongYu;

import java.util.*;

public class Main {
    private static HashSet<String> set = new HashSet<>(Arrays.asList("a", "an", "the", "and", "or", "but"));
    public static HashMap<String, Integer> map = new HashMap<String, Integer>();
    public static HashMap<String, Integer> map_of_result = new HashMap<String, Integer>();
    private static int calculate_word (String line) {
        int count = 0;
        String[] arr = line.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            if (!set.contains(arr[i])) {
                count++;
            }
        }
        return count;
    }
    private static boolean validCheck(String line) {
        if (line.equals("")) {
            return true;
        }
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) != '.') {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
	// write your code here
        TrieNode root = create_trie_tree.create("companies.dat", map, map_of_result);
        HashMap<String, Integer> map_of_cornerCase = new HashMap<>();
        for (String str : map.keySet()) {
            int cornerCount = 0;
            String[] words = str.split(" ");
            for (String word : words) {
                if (set.contains(word)) {
                    cornerCount++;
                }
            }
            map_of_cornerCase.put(str, cornerCount);
        }
        System.out.println("please input your article and end with another line of the whole'.'");
        int sum = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            //boolean res = validCheck(line);
            if (!validCheck(line)) {
                break;
            }
            sum += calculate_word(line);
            calculator_company.calculator(root, map_of_result, line);
        }
        for (String str : map.keySet()) {
             sum  -= map.get(str) * map_of_cornerCase.get(str);
        }
        print.print(map_of_result,map, sum);
    }
}
