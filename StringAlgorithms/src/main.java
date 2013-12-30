import java.util.List;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Trie t = new Trie();
	trieNode x = t.insert(t.root,"ball",0);
	trieNode x1 = t.insert(t.root,"bat",0);
	trieNode [] ch = t.root.children;

	displayTrie(t.root, "ball", 0);

	}
static void displayTrie(trieNode r,String s,int k) {
	if(r == null) {
		return;
	}
	if(k > s.length()-1) {
		if(r.is_End_of_String) {
		System.out.println("yes");
		}
		return;
	}
	char c =  s.charAt(k);
	int kk = c - 97;
	for(trieNode x:r.children) {
		if(x!=null) {
		System.out.print(" "+x.data+" "+x.is_End_of_String);
		if(x.is_End_of_String) {
			System.out.println();
		}
		displayTrie(x, s, kk);
		}
	}
	//System.out.println("c is"+c+" k is"+k+" kk "+kk);



/*	if(r.children[kk].data == s.charAt(k)){
		System.out.println("kk = "+kk+" data"+r.children[kk].data);
		displayTrie(r.children[kk], s, k+1);
	}*/
	}
	


}
