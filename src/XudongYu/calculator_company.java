package XudongYu;

import java.util.HashMap;
import java.util.TreeMap;

public class calculator_company {
    public static void calculator(TrieNode root, HashMap<String,Integer> map, String line) {
        helper(root, map , line);
    }

    private static void helper(TrieNode root, HashMap<String,Integer> map, String line) {
        TrieNode cur = root;
        String str = "";
        for (int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);
            if ((c -'a' >= 0 && c-'a' <=26) || (c -'A' >= 0 && c- 'A' <= 26) || c == ' ') {
                if (!cur.children.containsKey(c)) {
                    cur = root;
                    str = "";
                    continue;
                    //helper(root,map, line.substring(i + 1));
                }
                cur = cur.children.get(c);
                str += c;
                if (cur.isWord) {
                    map.put(str, map.get(str) + 1);
                    cur = root;
                    str = "";
                }
                /*if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                    cur = root;
                    str = "";
                }*/
            }
        }
    }


}
