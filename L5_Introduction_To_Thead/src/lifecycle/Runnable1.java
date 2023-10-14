package lifecycle;

public class Runnable1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Thread is on");
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
