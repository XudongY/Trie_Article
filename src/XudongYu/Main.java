package XudongYu;

import java.util.*;

public class Main {
    private static HashSet<String> set = new HashSet<>(Arrays.asList("a", "an", "the", "and", "or", "but"));
    //public static HashMap<String, Integer> map = new HashMap<String, Integer>();
    public static HashMap<String, Integer> map_of_result = new HashMap<String, Integer>();
    public static HashMap<String, List<String>> company_List = new HashMap<>();
    private static int sum = 0;
    public static int calculate_word (String line, int sum) {
        String[] arr = line.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            if (!set.contains(arr[i])) {
                sum++;
            }
        }
        return sum;
    }
    public static boolean validCheck(String line) {
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
        String path = "";

        System.out.println("please create file name company.dat");
        System.out.println("And input the path of compant.dat and input enter to quit");
        System.out.println("if the path is default path input enter");
        Scanner scanner1 = new Scanner(System.in);
        path= scanner1.nextLine();
        if (path.length() != 0) {
            path += "/companies.dat";
        } else {
            path = "companies.dat";
        }
        TrieNode root = create_trie_tree.create(path, company_List, map_of_result);
        HashMap<String, Integer> map_of_cornerCase = new HashMap<>();
        for (String str : map_of_result.keySet()) {
            int cornerCount = 0;
            String[] words = str.split(" ");
            for (String word : words) {
                if (set.contains(word)) {
                    cornerCount++;
                }
            }
            map_of_cornerCase.put(str, cornerCount);
        }
        //System.out.println("please input your article and end with another line of the whole'.'");
        System.out.println("please input your article path and name and end with enter. For example : /Users/yuxudong/Desktop/Steven/inteillJ/Trie_Article/article.dat");
        String path_of_artile = scanner1.nextLine();
        ;
        sum = calculator_company.calculator(root, map_of_result, path_of_artile, sum, map_of_cornerCase);
        print.print(map_of_result,company_List, sum);
    }
}
