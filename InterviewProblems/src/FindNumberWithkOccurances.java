
public class FindNumberWithkOccurances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,1,3,1,1,4,5};
		System.out.println(findhalf(a));
	}
	static int findhalf(int []a) {
		int occurance = 0,count_occurance=0;
		for(int i : a) {
			if(count_occurance == 0 || i==occurance) {
				occurance = i;
				count_occurance++;
			}
			else {
				count_occurance--;
			}			
		}
		return occurance;
	}
}
