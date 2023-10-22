package l8_spring_concepts;

public class Employee {
	
	private int id;
	private String name;
	private int sal;
	private String email;
	private int baseSal;
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getBaseSal() {
		return baseSal;
	}
	public void setBaseSal(int baseSal) {
		this.baseSal = baseSal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", email=" + email + ", baseSal=" + baseSal
				+ ", address=" + address + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	

}
