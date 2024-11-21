package pe.edu.i202217368.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202217368.Entity.City;
import pe.edu.i202217368.Entity.Country;
import pe.edu.i202217368.Entity.CountryLanguage;

import java.util.ArrayList;

public class JPAPersist {

    public static void main(String[] args) {

        // Referenciando al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // Aqui creo el pais imaginario con mi Nombre Arian
        Country country = new Country("ARI", "Arian", "Asia",
                "Caribe", 543.99,
                1957, 4567, null, 34.56,
                456.3, "Arian", "Republic",
                "Vincenti", 24, "A",
                new ArrayList<>(), new ArrayList<>());

        //Aqui agrego las 3 ciudades
        City ciudad1 = new City(99900, "ciudad1", "ARI", "Distrito1", 234, country);
        City ciudad2 = new City(99800, "ciudad2", "ARI", "Distrito2", 123, country);
        City ciudad3 = new City(99700, "ciudad3", "ARI", "Distrito3", 334, country);

        country.getCities().add(ciudad1);
        country.getCities().add(ciudad2);
        country.getCities().add(ciudad3);

        //Aqui creo 2 lenguajes
        CountryLanguage language1 = new CountryLanguage("ARI", "Vincent1", "T", 70.0);
        CountryLanguage language2 = new CountryLanguage("ARI", "Vincent2", "F", 30.0);

        language1.setCountry(country);
        language2.setCountry(country);

        country.getCountryLanguages().add(language1);
        country.getCountryLanguages().add(language2);

        // Persistir los datos
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        // Mostrar mensaje de éxito y datos completos del país
        System.out.println("País creado correctamente: " + country.getName());

        // Imprimir las ciudades del país
        System.out.println("Ciudades del país:");
        for (City city : country.getCities()) {
            System.out.println(" - Ciudad: " + city.getName() + ", Distrito: " + city.getDistrict() + ", Población: " + city.getPopulation());
        }

        // Imprimir los idiomas del país
        System.out.println("Idiomas del país:");
        for (CountryLanguage language : country.getCountryLanguages()) {
            System.out.println(" - Idioma: " + language.getLanguage() + ", Tipo: " + language.getIsOfficial() + ", Porcentaje: " + language.getPercentage() + "%");
        }

        em.close();
        emf.close();
    }
}
