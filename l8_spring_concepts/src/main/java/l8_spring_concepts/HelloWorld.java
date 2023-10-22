package l8_spring_concepts;


public class HelloWorld {
	
	private String message;

	public String getMessage() {
		return message;
	}

	/*public void setMessage(String message) {
		System.out.println("Setter is called");
		this.message = message;
	}*/

	public void init() {
		System.out.println("Init called");
	}
	public void destroy() {
		System.out.println("Destroy called");
	}

	public HelloWorld(String message) {
		super();
		this.message = message;
		System.out.println("Bean Contructor called.");
	}
	public HelloWorld(int num, String message) {
		super();
		this.message = message;
		System.out.println("Bean Contructor called.");
	}


	public HelloWorld() {
		this("Test");
		//super();
		
		System.out.println("Bean DEFAULT Contructor called.");
		// TODO Auto-generated constructor stub
	}

	
	
	

}
