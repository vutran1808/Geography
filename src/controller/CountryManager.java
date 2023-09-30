/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dataAccess.CountryDao;
import java.util.ArrayList;
import model.Country;
import repository.IManageEastAsiaCountries;
import repository.ManageEastAsiaCountries;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class CountryManager extends Menu{
    private IManageEastAsiaCountries imn;
    static String[] mc = {"Input the information of 11 countries in East Asia", "Display the information of country you've just input", "Search the information of country by user-entered name", "Display the information of countries sorted name in ascending order", "Exit"};
    ArrayList<Country> countries = new ArrayList<>();
    public CountryManager(){
        super("Menu", mc);
        imn = new ManageEastAsiaCountries();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> imn.addCountry(countries);
            case 2 -> CountryDao.Instance().showAll(countries);
            case 3 -> imn.searchCountry(countries);
            case 4 -> imn.sortCountry(countries);
            case 5 -> System.exit(0);
        }
    }
}
