package pe.edu.i202217368.Entity;


import java.io.Serializable;

public class CountryLanguagePriKeys implements Serializable {

    private String CountryCode;
    private String Language;

    public CountryLanguagePriKeys() {
    }

    public CountryLanguagePriKeys(String countryCode, String languageCode) {
        CountryCode = countryCode;
        Language = languageCode;
    }

    @Override
    public String toString() {
        return "CountryLanguagePKs{" +
                "CountryCode='" + CountryCode + '\'' +
                ", LanguageCode='" + Language + '\'' +
                '}';
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguageCode() {
        return Language;
    }

    public void setLanguageCode(String languageCode) {
        Language = languageCode;
    }
}
