
public class Semaphore {
	int value;
	final int MAX;
	
	Semaphore(int value)
	{
		this.value=value;
		MAX=value;
	}
	public  synchronized void P()
	{
		if(value<=0)
		{
			while(value<=0)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		value--;
	}
	public synchronized void V()
	{
		if(value<MAX)
		{
			value++;
		}
		notify();
	}
	public static void main(String args[])
	{
		Semaphore s=new Semaphore(1);
		TestThread t1=new TestThread(s);
		TestThread t2=new TestThread(s);
	
		Thread tt1=new Thread(t1);
		Thread tt2=new Thread(t2);
		tt1.start();
		tt2.start();
	}
}
class TestThread implements Runnable
{
	Semaphore s;
	public TestThread(Semaphore s) {
		// TODO Auto-generated constructor stub
		this.s=s;
	}
	@Override
	public void run() {
		s.P();
		// TODO Auto-generated method stub
		System.out.println("Here!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!");
		s.V();
	}
	
}