import java.util.ArrayList;

public class WaysforNSteps {
	
	public static void main(String []args) {
	int n = 5;
	int [] options = {1,2,3};
	findWays(n,options,0,new ArrayList<Integer>());
}

private static void findWays(int n,int []options,int opt,ArrayList<Integer> res) {
	int result = 0;
	if(n == 0) {
		System.out.println(res);
	}
	if(n < 0 || opt >= options.length) {
		return;
	}
	
	for(int i=opt;i < options.length;i++) {//if we cant use previous index then opt else 0
		result = n - options[i];
		if(result >= 0) {
		res.add(options[i]);
		findWays(result, options, i, res);
		res.remove(res.size()-1);
	}
	else {
		findWays(result, options, i+1, res);
	}
	}
}
}
