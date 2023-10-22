package l8_spring_concepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new 
				ClassPathXmlApplicationContext("spring-config-ref.xml");
		
		System.out.println("Context: "+context);
		
		Employee emp = (Employee) context.getBean("empConstRef");
		
		System.out.println(emp);
		
		
	}

}
