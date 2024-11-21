package pe.edu.i202217368.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202217368.Entity.Country;

// JPARemove
public class JPARemove {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // Buscar el país
        Country country = em.find(Country.class, "ARI");
        if (country != null) {
            em.getTransaction().begin();
            em.remove(country);
            em.getTransaction().commit();
            System.out.println("País eliminado exitosamente: " + country.getName());
        } else {
            System.out.println("No se encontró el país con el código proporcionado.");
        }

        em.close();
        emf.close();
    }
}
