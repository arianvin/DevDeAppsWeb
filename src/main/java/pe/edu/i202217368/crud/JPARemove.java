package pe.edu.i202217368.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202217368.Entity.City;
import pe.edu.i202217368.Entity.Country;
import pe.edu.i202217368.Entity.CountryLanguage;

// JPARemove
public class JPARemove {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // Eliminar
        Country country = em.find(Country.class, "ARI");
        if (country != null) {
            em.getTransaction().begin();
            em.remove(country);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
}