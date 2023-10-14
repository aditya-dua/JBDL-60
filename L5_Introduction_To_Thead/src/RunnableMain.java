
public class RunnableMain {
	
	public static void main(String[] args) {
		
		// This is the object of the class which implements Runnable
		GenerateNumbersUsingLoop genRunnable = new GenerateNumbersUsingLoop();
		
		// Object of the runnable class is then passed on to the thread object
		Thread runnable1= new Thread(genRunnable,"My Runnable Thread");
		
		//runnable1.setDaemon(true);
		
		Thread runnable2 = new Thread(genRunnable,"My Runnable Thread - 2");
		
		runnable1.start();
		runnable2.start();
		
		GenerateNumberThread genNumber = new GenerateNumberThread();
		//genNumber.start();
		
		System.out.println(genNumber.getId());
		System.out.println(runnable1.getName());
		System.out.println(genNumber.getPriority());
		System.out.println(genNumber.isDaemon());

		//Yes, we can directly call the run method, but that makes it run as a function on the main thread itself.
		//genNumber.run();
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Main:"+ i);
		}
		
	}

}
