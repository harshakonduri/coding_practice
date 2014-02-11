package srm_practice;
public class Time {
public String whatTime(int seconds) {
	if(seconds > 86399 || seconds < 0) {
		return "0:0:0";
	}		
	int temp = 0;
	int h = 0,m = 0,s = 0;
	if(seconds >= 3600) {
		h = seconds / 3600;	
	}
	temp = seconds % 3600;
	if(temp >= 60) {
		m = temp/60;
	}
	temp = seconds % 60;
	s = temp;
	return h+":"+m+":"+s;
}
public static void main(String []args) {
	System.out.println(new Time().whatTime(60));
	System.out.println(new Time().whatTime(3660));
}
}
