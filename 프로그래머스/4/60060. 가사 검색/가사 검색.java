import java.util.*;

class Solution {
    public class Node{
        HashMap<Character, Node> child;
        HashMap<Integer, Integer> lenMap;
        
        public Node(){
            this.child = new HashMap<>();
            this.lenMap = new HashMap<>();
        }
    }
    
    public class Trie{
        Node root;
        
        public Trie(){
            this.root = new Node();
        }
        
        public void insert(String str){
            Node node = this.root;
            
            for(int i = 0 ; i < str.length() ; i++){
                char c = str.charAt(i);
                node.child.putIfAbsent(c, new Node());
                node.lenMap.compute(str.length(), (k, ov) -> ov == null? 1 : ov + 1);
                
                node = node.child.get(c);
            }
        }
        
        public int search(String str){
            int ans = 0;
            Node node = this.root;
            
            if(str.charAt(0) == '?' ) ans = node.lenMap.getOrDefault(str.length(), 0);
            
            for(int i = 0 ; i < str.length() ; i++){
                char c = str.charAt(i);
                
                if(c == '?') break;
                if(! node.child.containsKey(c)) return 0;
                node = node.child.get(c);
                ans = node.lenMap.getOrDefault(str.length(), 0);
            }
            return ans;
        }
    }
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie trie = new Trie();
        Trie revTrie = new Trie();
        
        for(String word : words){
            trie.insert(word);
            revTrie.insert(new StringBuilder(word).reverse().toString());
        }
        
        for(int i = 0 ; i < queries.length ; i++){
            if(queries[i].charAt(0) != '?'){
                answer[i] = trie.search(queries[i]);
            }else{
                answer[i] = revTrie.search(new StringBuilder(queries[i]).reverse().toString());
            }
        }
        return answer;
    }
}