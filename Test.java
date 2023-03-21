import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	static ArrayList<String> array=new ArrayList<String>();
	public static  void permute(String str, int l, int r) 
    { 
        if (l == r) 
            array.add(str);
        else { 
            for (int i = l; i <= r; i++) { 
                str = swap(str, l, i); 
                permute(str, l + 1, r); 
                str = swap(str, l, i); 
            } 
        } 
    } 
  
   
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
	public static void main(String[]args) throws FileNotFoundException {
		Scanner kb=new Scanner(System.in);
		Scanner file=new Scanner(new File("dictionary.txt"));
		Scanner filePer=new Scanner(new File("dictionary.txt"));
	
		boolean run =true,runPer=true;
		Trie t = new Trie(); 
		Trie per = new Trie(); 
		while(file.hasNext()) {
			t.insert(file.next());
		}
	
		while(run) {
			System.out.println("TRIE PROJECT: Enter your choice?\r\n" + 
					"1) Create an empty trie\r\n" + 
					"2) Create a trie with initial letters\r\n" + 
					"3) Insert a word\r\n" + 
					"4) Delete a word\r\n" + 
					"5) List all words that begin with a prefix\r\n" + 
					"6) Size of the trie\r\n" + 
					"7) End\r\n" + 
					"");
			
			int a=kb.nextInt();
		if(a==1) {
			 t=new Trie();
			 System.out.println("Trie created");
		}
		if(a==2) {
			String in=kb.next();
			permute(in,0,in.length()-1);
			
			for(int i=0;i<array.size();i++) {
			if(t.contains(array.get(i))) {
				per.insert(array.get(i));
			}
		}
			while(runPer) {
				System.out.println("Enter your choice?\r\n" +  
						"1) Insert a word\r\n" + 
						"2) Delete a word\r\n" + 
						"3) List all words that begin with a prefix\r\n" + 
						"4) Size of the trie\r\n" 
						+"5) Back"
						);
				int pe=kb.nextInt();
				if(pe==1) {
					per.insert(kb.next());
				}
				if(pe==2) {
					per.delete(kb.next());
				}
				if(pe==3) {
					System.out.println(Arrays.toString(per.allWordsPrefix(kb.next())));
				}
				if(pe==4) {
					System.out.println(per.size());
				}
				if(pe==5) {
					runPer=false;
				}
				
			}
			}
		if(a==3) {
			System.out.println("Write a word to be inserted");
			t.insert(kb.next());
		}
		if(a==4) {
			System.out.println("Write a word to be deleted");
			t.delete(kb.next());
		}
		if(a==5) {
			System.out.println("Write a prefix to get all words");
			System.out.println(Arrays.toString(t.allWordsPrefix(kb.next())));
		}
		if(a==6) {
			
			System.out.println("Size of trie="+t.size());
		}
		if(a==7) {
			System.out.println("OFF");
			run=false;
		}
		
		}
		kb.close();
		file.close();
	}
}
