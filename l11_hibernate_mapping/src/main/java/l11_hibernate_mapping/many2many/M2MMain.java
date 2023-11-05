package l11_hibernate_mapping.many2many;

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
		SessionFactory sf = c.configure("hbm-m2m.cfg.xml").buildSessionFactory();
	
		System.out.println(sf);
		Session s = sf.openSession();
		System.out.println("Session started:"+s);
		
		Transaction tx = s.beginTransaction();
		
		
		Cart cart = new Cart();
		cart.setName("Big  billion day cart");
		
		Items i1= new Items("iphone", 20000);
		Items i2= new Items("macbook", 25000);
		Items i3= new Items("iphone pro", 20000);
		Items i4= new Items("macbook pro", 25000);
		
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(i1);
		itemsSet.add(i2);
		
		Set<Items> itemsSet2 = new HashSet<Items>();
		itemsSet.add(i3);
		itemsSet.add(i4);
		
		cart.setItems(itemsSet);
		cart.setTotal(100*2+50*5);
		
		Cart cart1 = new Cart();
		cart1.setName("Big  billion day cart- Amazon");
		cart1.setItems(itemsSet2);
		
		Set<Cart> cartSet = new HashSet<Cart>();
		cartSet.add(cart1);
		cartSet.add(cart);
		
		//i4.setCarts(cartSet);
		s.save(cart);
		s.save(i1);
		s.save(i2);
		s.save(i4);
		
		s.flush();
		tx.commit();
		System.out.println("Cart is saved with id:"+cart.getId());
		
	}

}
