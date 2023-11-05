

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class O2OAnnotationMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-o2o-annotation.cfg.xml").buildSessionFactory();
	
		System.out.println(sf);
		Session s = sf.openSession();
		System.out.println("Session started:"+s);
		
		Transaction tx = s.beginTransaction();
		
		
		Customer cx = new Customer();
		cx.setName("Aditya");
		cx.setAddress("Delhi");
		cx.setEmail("aditya@aditya.com");
		
		for(int i =0;i<100;i++) {
			cx = new Customer();
			cx.setName("Aditya "+i);
			cx.setAddress("Delhi" + i );
			cx.setEmail("aditya@aditya.com"+i);
			s.save(cx);
			
		}
		
		
		
		
			
		s.flush();
		tx.commit();
		
		// query to select multiple rows from a database
		Transaction tx2 = s.beginTransaction();
		
		Query query = s.createQuery("from Customer");
		List<Customer> customerList = query.list();
		
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
		
		tx2.commit();
		
		// query data on the basis of id
		Transaction tx3 = s.beginTransaction();
		Query query1 = s.createQuery("from Customer where id= :id");
		
		query1.setParameter("id",4);
		Customer cus= (Customer) query1.uniqueResult();
		System.out.println(cus);
		
		tx3.commit();
		
		
		// query data on the basis of id
		Transaction tx4 = s.beginTransaction();
		Query query2 = s.createQuery("delete from Customer where id= :id");
		
		query2.setParameter("id",4);
		int result = query2.executeUpdate();
		System.out.println("Deleted Docs Count:"+result);
		
		tx4.commit();
		
		// query data on the basis of id
		Transaction tx5 = s.beginTransaction();
		Query query3 = s.createQuery("update Customer set name= :name where id= :id");
		
		query3.setParameter("id",95);
		query3.setParameter("name","ADITYA DUA - GFG");

		int result_new = query3.executeUpdate();
		System.out.println("Updated Docs Count:"+result_new);
		
		tx5.commit();
		
		s.close();
		sf.close();
		
	}

}
