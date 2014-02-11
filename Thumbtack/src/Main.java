import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
public class Main {
	static boolean txblock;
	static int blockcount;
	static HashMap<String,Integer> db;
	static HashMap<Integer,TransactionNode>cache ;
	static HashMap<Integer,Integer>val;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create instances of all the 3 Data Structures
		db = new HashMap<String,Integer>();
		cache = new HashMap<Integer,TransactionNode>();
		val = new HashMap<Integer,Integer>();
		
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while((s = br.readLine()) != null) {
			int switchvar = (int)s.charAt(0);
			String [] op = s.split(" ");
			switch(switchvar) {
				case 66://BEGIN
					txblock = true;
					if(blockcount == 0) {
						blockcount++;					
						cache.put(blockcount, new TransactionNode(null,val));
					}
					else {
						TransactionNode temp = cache.get(blockcount);
						blockcount++;
						cache.put(blockcount, new TransactionNode(temp, temp.curVal));
					}
					break;
				case 67://COMMIT
					if(txblock) {
						HashMap<String, Integer> t1 = cache.get(blockcount).curData;
						commitOperation(t1);
						val = cache.get(blockcount).curVal;
						txblock = false;
						blockcount = 0;
					}
					else {
						
					}
					break;
				case 69://END
					System.exit(0);
					break;
				case 71://GET
					String varg = op[1];
					if(!txblock) {
						int i = getOperation(db, varg);
						if(-1 == i)
							System.out.println("NULL");
						else
							System.out.println(i);
					}
					else {
						//System.out.println(blockcount);
						int i = getOperation(cache.get(blockcount), varg);
						if(-1 == i)
							System.out.println("NULL");
						else
							System.out.println(i);
					}					
					break;
				case 78://NUMEQUALTO
					if(!txblock)
						System.out.println(numEqualToOperation(val, Integer.parseInt(op[1]),false));
					else {
						System.out.println(numEqualToOperation(cache.get(blockcount).curVal, 
								Integer.parseInt(op[1]), false));
					}
					break;
				case 82://ROLLBACK
					if(!txblock) {
						System.out.println("NO TRANSACTION");
					}
					else {
						cache.remove(blockcount);
						blockcount--;
						if(0 == blockcount) {
							txblock = false;
						}
					}
					break;
				case 83://SET
					String vars = op[1];
					Integer vals = Integer.parseInt(op[2]);
					if(!txblock) {
						setOperation(db, vars, vals);
					}
					else {
						setOperation(cache.get(blockcount), vars, vals);
					}
					break;
				case 85://UNSET
					if(!txblock) {
						unsetOperation(db, val, op[1]);
					}
					else {
						unsetOperation(cache.get(blockcount).curData,
										cache.get(blockcount).curVal, op[1]);
						cache.get(blockcount).unset = true;
						cache.get(blockcount).unsetVar.add(op[1]);
						
					}
					break;
				default:
					break;
			}
		}
		}
		catch(IOException e) {
			
		}
	}
	private static void commitOperation(HashMap<String, Integer> t1) {
		// TODO Auto-generated method stub
		Set<String> keys = t1.keySet();
		for(String k : keys) {
			Integer i = t1.get(k);
			if(db.containsKey(k)) {
				db.remove(k);
				db.put(k, i);
			}
			else {
				db.put(k, i);
			}
		}
	}
	static int getOperation(TransactionNode hm,String var) {
		/*if(null == hm) {
			if(db.containsKey(var)) {
				return db.get(var);
			}
			return -1;
		}*/
		if(hm.unsetVar.size() > 0) {
			if(hm.unsetVar.contains(var)) {
				return -1;
			}
			else {
			}
		}
	HashMap<String, Integer> temp = hm.curData;
	int t = blockcount;
	boolean res = true;
		while(t > 0 && res) {
			if(temp.containsKey(var)) {
				return temp.get(var);
			}
			else {
				if(null != hm.prevNode) {
					temp = hm.prevNode.curData;
					//System.out.println(temp);
				}
				else {
					res = false;
				}
			}
			t--;
		}	
	if(db.containsKey(var)) {
		return db.get(var);
	}
	return -1;
	}
	private static void setOperation(TransactionNode tn,
			String vars, Integer vals) {
		// TODO Auto-generated method stub
		if(tn.curData.containsKey(vars)) {
			Integer old = tn.curData.get(vars);
			modifyVal(tn.curVal, old);
			tn.curData.remove(vars);
			tn.curData.put(vars, vals);
			numEqualToOperation(tn.curVal, vals, true);
			return;
		}		
		tn.curData.put(vars, vals);
		numEqualToOperation(tn.curVal, vals,true);
	}
	static int getOperation(HashMap<String, Integer> hm,String var) {
		if(!hm.containsKey(var))
			return -1;
		else
			return hm.get(var);
	}
	static void setOperation(HashMap<String, Integer> hm,String var, int value) {
 			if(hm.containsKey(var)){
				Integer old = hm.get(var);
				modifyVal(val,old);
				hm.remove(var);
				hm.put(var, value);
				numEqualToOperation(val, value,true);
				return;
			}
			hm.put(var, value);
			numEqualToOperation(val, value,true);
	}
	static void unsetOperation(HashMap<String, Integer> hm,HashMap<Integer,Integer> val2,
								String var) {
		if(hm.containsKey(var)){
			modifyVal(val2, hm.get(var));
			hm.remove(var);
			return;
		}
		int temp = getOperation(cache.get(blockcount), var);
		if(-1 != temp) {
			modifyVal(val2, temp);
		}
	}
	 static void modifyVal(HashMap<Integer, Integer> val2, Integer old) {
		// TODO Auto-generated method stub
		 if(val2.containsKey(old)) {
			 //System.out.println("Removing value");
			 Integer i = val2.get(old);
			 i--;
			 //System.out.println(i);
			 val2.remove(old);
			 if(i>0) {
				 val2.put(old, i);
			 }
		 }
	}
	static int numEqualToOperation(HashMap<Integer,Integer> tval,int value,boolean ins) {
		if(!ins) {
			if(tval.containsKey(value))
				return tval.get(value);
			else 
				return 0;
		}
		if(tval.containsKey(value)) {
			Integer i = tval.get(value);
			i++;
			tval.remove(value);
			tval.put(value,i);
			return i;
		}
		Integer ii= new Integer(1);
		tval.put(value,ii);
		return ii;
		
	}
	static class TransactionNode {
		HashMap<String,Integer> curData;
		HashMap<Integer, Integer> curVal;
		TransactionNode prevNode;
		boolean unset;
		ArrayList<String> unsetVar;
		public TransactionNode(TransactionNode pre,HashMap<Integer, Integer> val) {
			this.curVal = new HashMap<Integer, Integer>(val);
			this.prevNode = pre;
			curData = new HashMap<String, Integer>();
			unsetVar = new ArrayList<String>();
		}
	}
}
