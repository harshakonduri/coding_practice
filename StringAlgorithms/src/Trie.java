import java.util.ArrayList;


public class Trie {
trieNode root;
public Trie() {
	root = new trieNode();
	root.data = ' ';
	root.is_End_of_String = false;
	root.children = new trieNode[26];
}
public void insertTrie(String s) {
	int length = s.length();
	trieNode t = root;
	if(t == null) {
		//place char here
	}
	for(int i=0;i<length;i++) {
		t = insert(t,s,i);
	}
}
public trieNode insert(trieNode r,String s,int k) {
	char c =  s.charAt(k);
	int kk = c - 97;
	char newc=' ';
	int newk = 0;
	if(k<s.length()-1) {
		 newc = s.charAt(k+1);
		 newk = newc - 97;
	}
	System.out.println(kk);
	if(r == null) {
		System.out.println("1");
		trieNode temp = new trieNode();
		temp.data = c;
		temp.children = new trieNode[26];
		for(int i=0;i<26;i++) {
			temp.children[i] = null;
		}
		if(k == s.length()-1) {
		temp.is_End_of_String = true;
		}
		else {
		temp.children[newk] = insert(temp.children[kk],s,k+1);
		}
		return temp;
	}
	System.out.println("2");
	r.children[kk] = insert(r.children[kk],s,k);
/*	if(r.childnode(r, c) == null) {
		trieNode temp = new trieNode();
		r.children.add(k, temp);
		return r.children.get(k);
	}
	else {
	r = insert(r.children.get(k),c);
	}
	*/
	return r;
}
}
