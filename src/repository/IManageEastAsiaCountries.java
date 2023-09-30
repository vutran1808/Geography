/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.Country;

/**
 *
 * @author ASUS
 */
public interface IManageEastAsiaCountries {
    
    void addCountry(ArrayList<Country> country);
    
    List<Country> showCountries();

    void searchCountry(ArrayList<Country> countries);

    void sortCountry(ArrayList<Country> countries);
}
