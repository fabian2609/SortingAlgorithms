import sum.kern.Bildschirm;


enum Sort 
{ 
    quick, selection, insertion, bubble; 
} 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Bildschirm(1400,1000);
		
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				new Demo(Sort.quick, 100, 850);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run()
			{
				new Demo(Sort.insertion, 100, 400);
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			public void run()
			{
				new Demo(Sort.selection, 800, 850);
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			public void run()
			{
				new Demo(Sort.bubble, 800, 400);
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
