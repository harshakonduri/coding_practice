
public class SemaphoreProblem {
	public static void main(String args[])
	{
		
		Semaphore s=new Semaphore(10);
		Semaphore lock1=new Semaphore(1);
		Semaphore lock2=new Semaphore(1);
		lock2.P();
		for(int i=0;i<20;i++)
		{
			new ThreadC(lock1,lock2).start();;
			new ThreadA(s).start();;
			new ThreadB(s, lock1, lock2).start();;
		}
	}
}
class ThreadA extends Thread
{
	Semaphore s;
	ThreadA(Semaphore s)
	{
		this.s=s;
	}
	public void run()
	{
		System.out.println("Thread A!");
		s.V();
	}
}
class ThreadB extends Thread
{
	Semaphore s;
	Semaphore lock1;
	Semaphore lock2;
	public ThreadB(Semaphore s,Semaphore lock1,Semaphore lock2) {
		// TODO Auto-generated constructor stub
		this.s=s;
		this.lock1=lock1;
		this.lock2=lock2;
		
		
	}
	public void run()
	{
		lock1.V();
		s.P();
		System.out.println("Thread B!");
		lock2.V();
		
	}
}
class ThreadC extends Thread
{
	Semaphore lock2;
	Semaphore lock1;
	public ThreadC(Semaphore lock1,Semaphore lock2) {
		// TODO Auto-generated constructor stub
		this.lock1=lock1;
		this.lock2=lock2;
	}
	public void run()
	{
		lock2.P();
		System.out.println("Thread C!");
		lock1.V();
	}
}