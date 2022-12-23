public class Threads2 extends Thread {
	Thread t;
	Threads2()
	{
		t=new Thread(this);
		t.start();
//		System.out.println(t);
	}
	
	public void run() 
	{
		System.out.println(t);
		try {
			for(int i=0;i<2;i++) {
				System.out.println(i+" "+t.getName());
//				Thread.sleep(1000);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(t.getName()+" is terminated");
	}
	public static void main(String[] args) {
		Threads2 t1=new Threads2();
		t1.start();
		Threads2 t2=new Threads2();
		t2.start();
		Threads2 t3=new Threads2();
		t3.start();
		Threads2 t4=new Threads2();
		t4.setPriority(8);
		t4.start();
		Threads2 t5=new Threads2();
		t5.setPriority(9);		
		t5.start();
		Threads2 t6=new Threads2();
		t6.setPriority(6);
		t6.start();
		Threads2 t7=new Threads2();
		t7.setPriority(10);
		t7.start();
		System.out.println("Main Finish");
	}
	
}
