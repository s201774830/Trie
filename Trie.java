import java.util.ArrayList;


public class Trie {
	private TrieNode root = new TrieNode("");

	public Trie() {

	}

	public boolean contains(String s) {
		s = s.toLowerCase();
		
		boolean a = false;
		TrieNode tmp = root;
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(i, i + 1);
			int index = sub.charAt(0) - 'a';
			if (!(tmp.children[index] == null)) {

				tmp = tmp.children[index];

			} else {

				a = false;
				i = s.length();
			}

			if (i == s.length() - 1 && tmp.isEnd == true) {
				a = true;
			}
		}

		return a;
	}

	public boolean isPrefix(String p) {
		p = p.toLowerCase();
		boolean a = false;
		TrieNode tmp = root;
		for (int i = 0; i < p.length(); i++) {
			String sub = p.substring(i, i + 1);
			int index = sub.charAt(0) - 'a';
			if (!(tmp.children[index] == null) && (tmp.children[index].Letter.equals(sub))) {

				tmp = tmp.children[index];
				a = true;
			} else {

				return false;
			}

		}

		return a;

	}

	public void insert(String s) {
		s = s.toLowerCase();
		
		 
		if (!contains(s)) {
			TrieNode tmp = root;
			for (int i = 0; i < s.length(); i++) {
				String sub = s.substring(i, i + 1);
				int index = sub.charAt(0) - 'a';
				if (tmp.children[index] == null) {

					tmp.children[index] = new TrieNode(sub);
					tmp = tmp.children[index];
				} else {
					
					tmp = tmp.children[index];
				}
				if (i == s.length() - 1) {

					tmp.isEnd = true;
				}

			}
		} else
			System.out.println("nop");

	}

	public void delete(String s) {
		s=s.toLowerCase();
		TrieNode tmp = root;
		int counter = 1;
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(i, i + 1);
			int index = sub.charAt(0) - 'a';
			if (tmp.children[index] != null)
				tmp = tmp.children[index];
			else
				i = s.length();

			if (tmp.isEnd) {
				tmp.isEnd = false;
				tmp.Letter = "";
				if (!(s.length() == 0))
					delete(s.substring(0, s.length() - 1));
			} else if (i == s.length() - 1) {
				for (int j = 0; j < 26; j++) {
					if (tmp.children[j] == null) {

						counter++;
					}
				}
				if (counter == 26) {

					tmp.isEnd = false;
					tmp.Letter = "";
					tmp = null;
					delete(s.substring(0, s.length() - 1));

				}
			}

		}

	}

	public boolean isEmpty() {
		int counter = 1;
		for (int i = 0; i < 26; i++) {
			if (root.children[i] == null) {
				counter++;
			}
		}
		if (counter == 26) {
			return true;
		} else
			return false;

	}

	public void clear() {
		for (int i = 0; i < 26; i++) {
			root.children[i] = null;
			root.children[i].Letter = "";
			root.children[i].isEnd = false;
		}
	}
	
	ArrayList<String> wordpre=new ArrayList<String>();
	public String[] allWordsPrefix(String p) {
		boolean a=true;
		
		String tr="";
		p=p.toLowerCase();
		TrieNode tmp=root;
		
			if(isPrefix(p)) {
			for (int i = 0; i < p.length(); i++) {
				if(tmp.children[p.charAt(i)-'a']!=null) {
				tmp=tmp.children[p.charAt(i)-'a'];}else a=false;}
			if(a) {
			for(int i=0;i<26;i++) {
				if(!(tmp.children[i]==null)) {
					if(tmp.children[i].isEnd) {
						tr=p+tmp.children[i].Letter;
						
						wordpre.add(tr);
						
					}
					else {
						allWordsPrefix(p+tmp.children[i].Letter);
					
					}
				}
			}}}
			String[] st = new String[wordpre.size()];
			for(int i=0;i<wordpre.size();i++) {
				st[i]=(String) wordpre.get(i).toUpperCase();
			}
				
		return st;	

	}

	
	

	public int size() {
		return RecSize(root);
	}

	public int RecSize(TrieNode no) {

		int counter = 0;

		for (int j = 0; j < 26; j++) {

			if (!(no.children[j] == null)) {
				counter++;
				counter = counter + RecSize(no.children[j]);
			}
		}

		return counter;

	}
}
