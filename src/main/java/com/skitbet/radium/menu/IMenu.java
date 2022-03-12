package com.skitbet.radium.menu;

import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;

import java.util.HashMap;

public abstract class IMenu {

    public abstract void run(SelectionMenuEvent event);
    public abstract String getName();
    public abstract int minSelectedRequired();
    public abstract int maxSelectedRequired();
    public abstract HashMap<String, String> getOptions();

    public SelectionMenu getSelectionMenu() {
        SelectionMenu.Builder menu = SelectionMenu.create("menu:class")
                .setPlaceholder(getName()) // shows the placeholder indicating what this menu is for
                .setRequiredRange(minSelectedRequired(), maxSelectedRequired()); // only one can be selected
        for (String key : getOptions().keySet()) {
            menu.addOption(key, getOptions().get(key));
        }
        return menu.build();
    }

}
