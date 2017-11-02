package XudongYu;

import java.io.*;
import java.util.HashMap;

public class create_trie_tree {
    public static TrieNode create (String path, HashMap map, HashMap map_Of_Result) {
        TrieNode root = new TrieNode();
        try {
            String line;

            BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            while ((line = d.readLine()) != null) {
                String[] arr = line.split("\t");
                /*for (String str : arr) {
                    System.out.println(str);
                }*/
                TrieNode p = root;
                String str = "";
                for (char c : arr[0].toCharArray()) {
                    if ((c -'a' >= 0 && c-'a' <=26) || (c -'A' >= 0 && c- 'A' <= 26) || c == ' ') {
                        if (!p.children.containsKey(c)) {
                            p.children.put(c, new TrieNode());
                        }
                        p = p.children.get(c);
                        str += c;
                    }
                }
                p.isWord = true;
                map.put(arr[0],0);
                map_Of_Result.put(str, 0);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
