package be.tftic.java;

import be.tftic.java.presentation.impl.MainMenu;
import be.tftic.java.utils.EMFHolder;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EMFHolder.getInstance()
//                .overrideProp("hibernate.hbm2ddl.auto", "create")
                .open();

        new MainMenu().start();

        EMFHolder.getInstance().close();
    }
}
