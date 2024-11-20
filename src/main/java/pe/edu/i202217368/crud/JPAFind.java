package pe.edu.i202217368.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202217368.Entity.City;
import pe.edu.i202217368.Entity.Country;
import java.util.List;

public class JPAFind {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();


        Country country = em.find(Country.class, "PER");

        if (country == null) {
            System.out.println("No se encontró el País");
        } else {
            List<City> cities = country.getCities();
            cities.stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println("Ciudad con mas de 700k de Personas del pais:"+ city.getCountry().getName() +" es :" + city.getName()));
        }

        em.close();
        emf.close();
    }
}