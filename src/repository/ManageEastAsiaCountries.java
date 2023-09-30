/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.CountryDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Country;

/**
 *
 * @author ASUS
 */
public class ManageEastAsiaCountries implements IManageEastAsiaCountries{
    private List<Country> countries;

    public ManageEastAsiaCountries() {
        this.countries = new ArrayList<>();
    }

    @Override
    public List<Country> showCountries() {
        return countries;
    }

    @Override
    public void sortCountry(ArrayList<Country> countries) {
        Collections.sort(countries, Comparator.comparing(Country::getCountryName));
    }

    @Override
    public void searchCountry(ArrayList<Country> countries) {
        CountryDao.Instance().searchCountry(countries);
    }

    @Override
    public void addCountry(ArrayList<Country> countries) {
        CountryDao.Instance().createCountry(countries);
    }
    
}
