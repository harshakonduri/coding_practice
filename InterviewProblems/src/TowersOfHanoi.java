public class TowersOfHanoi {
    public static void main(String [] args) {
	Tower [] t = new Tower[3];
	for(int i = 1;i < 4;i++)
	    t[i-1] = new Tower();
	for(int i = 1;i < 5;i++)
	    t[0].add(i);

    System.out.println(t[0].disk);
	t[0].moveDisks(4,t[2],t[1]);
    System.out.println(t[0].disk);
    System.out.println(t[2].disk);
    }
    
}
