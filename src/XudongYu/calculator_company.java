package XudongYu;

import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

public class calculator_company {
    public static int calculator(TrieNode root, HashMap<String,Integer> map, String path, int sum, HashMap<String, Integer> map_of_cornerCase) {
        try {
            BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            while ((line = d.readLine()) != null) {
                if (!Main.validCheck(line)) {
                    continue;
                }
                sum += Main.calculate_word(line, sum);
                helper(root, map , line, sum, map_of_cornerCase);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    private static void helper(TrieNode root, HashMap<String,Integer> map, String line, int sum,  HashMap<String, Integer> map_of_cornerCase) {
        TrieNode cur = root;
        String str = "";
        for (int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);
            if (Character.isLetterOrDigit(c) || c == ' ') {
                if (!cur.children.containsKey(c)) {
                    cur = root;
                    str = "";
                    continue;
                    //helper(root,map, line.substring(i + 1));
                }
                cur = cur.children.get(c);
                str += c;
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                    cur = root;
                    sum -= map_of_cornerCase.get(str);
                    str = "";
                }
            }
        }
    }


}
