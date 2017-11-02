package XudongYu;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class create_trie_tree {
    public static TrieNode create (String path, HashMap<String, List<String>> company_List, HashMap<String, Integer> map_Of_Result) {
        TrieNode root = new TrieNode();
        try {
            String line;
            BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            while ((line = d.readLine()) != null) {
                String[] arr = line.split("\t");
                company_List.put(arr[0], new ArrayList<String>());
                //company_List.get(arr[0]).add(arr[0]);
                TrieNode p = root;
                for (int i = 0; i < arr.length; ++i) {
                    for (char c : arr[i].toCharArray()) {
                        if (c == ' ' || Character.isLetterOrDigit(c)) {
                            if (!p.children.containsKey(c)) {
                                p.children.put(c, new TrieNode());
                            }
                            p = p.children.get(c);
                        }
                    }
                    p.isWord = true;
                    p = root;
                    company_List.get(arr[0]).add(arr[i]);
                    map_Of_Result.put(arr[i], 0);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
