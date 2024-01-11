package pl.zabrze.zs10.projektflags;

import java.util.ArrayList;

public class RepozytoriumWrozb {
    public static ArrayList<Wrozba> zwrocWrozbe(){
        ArrayList<Wrozba> wrozby = new ArrayList<>();
        wrozby.add(new Wrozba("Dzisiaj dostaniesz dobra ocenę z matematyki."));
        wrozby.add(new Wrozba("Przed tobą jest bogata przyszlość."));
        wrozby.add(new Wrozba("Szczęście, którego szukasz, jest w innej wróżbie."));
        wrozby.add(new Wrozba("Zdrowie i szczęście kieruje się w twoją stronę."));
        wrozby.add(new Wrozba("Czekaj na znak."));
        wrozby.add(new Wrozba("Twoje ukryte talenty znajdą drogę, by objawić się światu."));
        wrozby.add(new Wrozba("Co masz zrobić jutro, zrób to dziś."));
        wrozby.add(new Wrozba("Nie czekaj. Działaj."));
        wrozby.add(new Wrozba("Co tanio wychodzi, drogo wraca."));
        wrozby.add(new Wrozba("Nie goń wszystkiego, bo stracisz to co masz."));
        wrozby.add(new Wrozba("Nieobecny sam sobie szkodzi."));
        wrozby.add(new Wrozba("Szansa jest wielka."));

        return wrozby;
    }
}
