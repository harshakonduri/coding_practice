import java.util.ArrayList;
import java.util.List;


public class trieNode {
char data;
boolean is_End_of_String;
trieNode [] children;


trieNode childnode(trieNode t,char c) {
	if(t == null) {
		return null;
	}
	for(trieNode l:children) {
		if(l.data == c) {
			return l;
		}
	}
	return null;
}
}
