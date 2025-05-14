import java.util.*;

class Solution {
    static class Trie{
        Node root;
        
        public Trie(){
            this.root = new Node();
        }
        
        public void insert(String str){
            Node node = this.root;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                
                node.child.putIfAbsent(c, new Node());
                // System.out.println(c +" " + node.child.get(c).leftWord);
                node = node.child.get(c);
                node.leftWord++;
                
            }
            node.isEnd = true;
        }
        
        int search(String str){
            Node node = this.root;
            
            int cnt = 0;
            for(int i = 0 ; i < str.length() ; i++){
                cnt++;
                char c = str.charAt(i);
                if(node.child.containsKey(c)){
                    // System.out.println(c);
                    if(node.child.get(c).leftWord == 1) return cnt;
                    node = node.child.get(c);
                }else{
                    return -1;
                }
            }
            return cnt;
        }
    }
    static class Node{
        boolean isEnd;
        int leftWord;
        Map<Character, Node> child;
        public Node(){
            this.child = new HashMap<Character, Node>();
            this.isEnd = false;
            this.leftWord = 0;
        }
    }
    public int solution(String[] words) {
        int answer = 0;
        Trie t = new Trie();
        for(String word : words){
            t.insert(word);
        }
        for(String word : words){
            int cnt = t.search(word);
            // System.out.println(cnt);
            answer += cnt;
        }
        
        return answer;
    }
}