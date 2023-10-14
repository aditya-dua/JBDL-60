package sync;

public class Table {

	public void printTable(int n) {
		
		System.out.println("-------Table of "+n+"--------");
		
		
		synchronized (this) {
			
			for(int i=1;i<=10;i++) {
				System.out.println(n + " X "+ i +" = "+i*n);
			}
		}
		System.out.println("-------Table of "+n+"--------");
		
	}
	
	public void display() {
		System.out.println("Display ");
	}
}
