/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.ScannerFactory;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Country;
import model.EastAsiaCountries;
import repository.ManageEastAsiaCountries;

/**
 *
 * @author ASUS
 */
public class CountryDao {

    private static CountryDao instance = null;
    ScannerFactory sc;
    ManageEastAsiaCountries mn;

    public CountryDao() {
        mn = new ManageEastAsiaCountries();
        sc = new ScannerFactory();
    }

    public static CountryDao Instance() {
        if (instance == null) {
            synchronized (CountryDao.class) {
                if (instance == null) {
                    instance = new CountryDao();
                }
            }
        }
        return instance;
    }

    public void showAll(ArrayList<Country> countries) {
        Formatter ft = new Formatter();
        System.out.println("ID           Name        Total Area         Terrain");
        for (Country country : countries) {
            if (country instanceof EastAsiaCountries) {
                ft.format("%1s %14s %12s %12s\n", country.getCountryCode(), country.getCountryName(), country.getTotalArea(), ((EastAsiaCountries) country).getCountryTerrain());
            }
        }
        System.out.println(ft);
        System.out.println(" ");
    }

    public void createCountry(ArrayList<Country> countries) {
        Country japan = new EastAsiaCountries("JP", "Japan", 100000, "Nice");
        Country China = new EastAsiaCountries("CN", "Chian", 100000, "Nice");
        Country indonesia = new EastAsiaCountries("ID", "Indonesia", 100000, "Nice");
        Country taiwan = new EastAsiaCountries("TW", "Taiwan", 100000, "Nice");
        Country vietnam = new EastAsiaCountries("VN", "Viet Nam", 100000, "Nice");
        Country korea = new EastAsiaCountries("KR", "Korea", 100000, "Nice");
        countries.add(japan);
        countries.add(China);
        countries.add(indonesia);
        countries.add(taiwan);
        countries.add(taiwan);
        countries.add(korea);
        while (true) {
            System.out.println("Enter Country Code: ");
            String countrycode = sc.getString();
            System.out.println("Enter Country Name: ");
            String countryName = sc.getString();
            System.out.println("Enter Total of area: ");
            double totalArea = sc.getScanner().nextDouble();
            System.out.println("Enter terrain: ");
            String terrain = sc.getString();
            Country country = new EastAsiaCountries(countrycode, countryName, totalArea, terrain);
            countries.add(country);
            System.out.println("Added");
            System.out.println("Do you want to Continute(Y/N)");
            String type = sc.getYN();
            if (type.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void searchCountry(ArrayList<Country> coutries) {
        showAll(coutries);
        System.out.println("Enter Country name: ");
        String name = sc.getScanner().nextLine();
        showAll((ArrayList<Country>) coutries.stream().filter(sameName(name)).collect(Collectors.<Country>toList()));
    }

    public Predicate<Country> sameName(String name) {
        return country -> country.getCountryName().equalsIgnoreCase(name);
    }

    public void sortCountries(ArrayList<Country> countries) {
        mn.sortCountry(countries);
    }
}
