package curso.java.modelo;

import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProductoDBH {
	public static HashMap<Integer, ProductoH> mostrarCatalogo() {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<ProductoH> objs = null;
		try {
			objs = (List<ProductoH>) session.createQuery("from ProductoH").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		HashMap<Integer, ProductoH> catalogo = new HashMap<>();
		for(ProductoH producto:objs) {
			catalogo.put(producto.getId(), producto);
		}
		
		return catalogo;
	}

	public static ProductoH buscarProductoPorId(int id) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		ProductoH p = (ProductoH) session.get(ProductoH.class, id);
		if (p == null) {
			System.out.println("No existe el album");
		} else {
			System.out.println(p.toString());
		}
		return p;
	}
}
