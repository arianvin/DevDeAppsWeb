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
            List<City> filteredCities = cities.stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .toList(); // Recolectamos las ciudades filtradas

            if (!filteredCities.isEmpty()) {
                System.out.println("Ciudades con más de 700k de Personas del país: " + country.getName());
                filteredCities.forEach(city -> System.out.println("- " + city.getName()));
            } else {
                System.out.println("No hay ciudades con más de 700k de personas en el país: " + country.getName());
            }
        }

        em.close();
        emf.close();
    }
}