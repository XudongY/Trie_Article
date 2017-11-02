package XudongYu;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isWord;
    public TrieNode () {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
}
