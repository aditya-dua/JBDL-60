package sync;

public class ThreadSyncMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Table t = new Table();
		Table table = new Table();
		
		Thread1 t1 = new Thread1(t);
		Thread2 t2 = new Thread2(t);
		//Thread2 t2 = new Thread2(table);
		
		t1.start();
		t2.start();
		
	}

}
