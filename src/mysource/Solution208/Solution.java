package mysource.Solution208;

class Trie {

    List<String> trie;
    /** Initialize your data structure here. */
    public Trie() {
        trie = new ArrayList<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (!trie.contains(word))
            trie.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return trie.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String s : trie) {
            if (s.startsWith(prefix))
                return true;
        }
        return false;
    }
}
