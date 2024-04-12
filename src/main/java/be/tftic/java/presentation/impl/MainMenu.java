package be.tftic.java.presentation.impl;

import be.tftic.java.presentation.AbstractMenu;
import be.tftic.java.presentation.Option;

import java.util.Map;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super("Competition Handler");
    }

    @Override
    protected Map<String, Option> initOptions() {
        var options = super.initOptions();
        options.put("1", new Option("new inscription", this::handleInscription));
        return options;
    }

    private void handleInscription(){
        Long competId = askForValue(Long.class, "> compet id: ");

    }

    @Override
    protected boolean handleError(Exception e) {
        return false;
    }
}
