package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.PessoaTeste;

public class PersistenciaTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emf;

		 EntityManager em;
		emf = Persistence.createEntityManagerFactory("ReservasHotel");
		em = emf.createEntityManager();

		PessoaTeste p = new PessoaTeste();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Pronto!");
	}

}
