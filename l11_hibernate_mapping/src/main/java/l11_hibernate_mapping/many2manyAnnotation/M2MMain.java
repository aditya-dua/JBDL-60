package l11_hibernate_mapping.many2manyAnnotation;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class M2MMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-m2m-annotation.cfg.xml").buildSessionFactory();
	
		System.out.println(sf);
		Session s = sf.openSession();
		System.out.println("Session started:"+s);
		
		Transaction tx = s.beginTransaction();
		
		Items i1= new Items("iphone", 20000);
		Items i2= new Items("macbook", 25000);
		Items i3= new Items("iphone pro", 10000);
		Items i4= new Items("macbook pro", 15000);
		
		Cart cart = new Cart();
		Cart cart1 = new Cart();
		
		cart.setName("Big  billion day cart");
		cart1.setName("Big  billion day cart- Amazon");
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(i1);
		itemsSet.add(i2);
		cart.setItems(itemsSet);
		cart.setTotal(100*2+50*5);
		
		
		
		Set<Items> itemsSet2 = new HashSet<Items>();
		itemsSet2.add(i3);
		itemsSet2.add(i4);
		cart1.setItems(itemsSet2);
		
		
		//i4.setCarts(cartSet);
		s.save(cart);
		s.save(cart1);
		s.save(i1);
		s.save(i2);
		s.save(i4);
		
		s.flush();
		tx.commit();
		System.out.println("Cart is saved with id:"+cart.getId());
		
	}

}
