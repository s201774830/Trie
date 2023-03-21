
public class TrieNode {
	
	public TrieNode[] children = new TrieNode[26]; 
    public String Letter;
    boolean isEnd;
      
   public  TrieNode(String L){
	   Letter=L;
	   isEnd=false;
        for (int i = 0; i < 26; i++) 
            children[i] = null; 
        
        
    }
   public  TrieNode(){
	   Letter="";
        isEnd=false;
        for (int i = 0; i < 26; i++) 
            children[i] = null; 
        for (int i = 0; i < 26; i++) 
            children[i].Letter = null; 
    } 
}
