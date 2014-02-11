public class TrailingString {
    public static void main(String [] args) {
	try {
	    BufferedReader br = new BufferedReader(new FileReader(new File(args[1])));
	    String s = "";
	    while((s = br.readline() != null)) {
		String [] st = s.split(",");
		if(st[0].endsWith(st[1])) {
		    System.out.println("1");
		}
		else {
		    System.out.println("0");
		}
	    }
	}
	catch(IOException e) {}
    }
}
