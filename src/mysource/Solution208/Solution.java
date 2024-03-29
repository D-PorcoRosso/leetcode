package mysource.Solution208;

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch-'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {

    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        char[] wordArray = word.toCharArray();
        for ( int i = 0 ; i < wordArray.length ; i++ ) {
            if (!node.containsKey(wordArray[i])) {
                node.put(wordArray[i], new TrieNode());
            }
            node = node.get(wordArray[i]);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        char[] wordArray = word.toCharArray();
        for ( int i = 0 ; i < wordArray.length ; i++ ) {
            node = node.get(wordArray[i]);
            if (node == null)
                return false;
        }
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] wordArray = prefix.toCharArray();
        for ( int i = 0 ; i < wordArray.length ; i++ ) {
            node = node.get(wordArray[i]);
            if (node == null)
                return false;
        }
        return true;
    }
}