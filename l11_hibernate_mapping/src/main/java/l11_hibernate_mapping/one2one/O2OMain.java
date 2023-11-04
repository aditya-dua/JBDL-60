package l11_hibernate_mapping.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-o2o.cfg.xml").buildSessionFactory();
	
		System.out.println(sf);
		Session s = sf.openSession();
		System.out.println("Session started:"+s);
		
		Transaction tx = s.beginTransaction();
		CustomerTransaction ctx = new CustomerTransaction();
		ctx.setTotal(100);
		
		Customer cx = new Customer();
		cx.setName("Aditya");
		cx.setAddress("Delhi");
		cx.setEmail("aditya@aditya.com");
		
		ctx.setCustomer(cx);
		cx.setTransaction(ctx);
		
		s.save(ctx);
		
		s.flush();
		tx.commit();
		s.close();
		sf.close();
		
	}

}
