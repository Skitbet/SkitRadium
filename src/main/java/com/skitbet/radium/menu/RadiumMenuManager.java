package com.skitbet.radium.menu;

import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class RadiumMenuManager extends ListenerAdapter {

    private List<IMenu> menus = new ArrayList<>();

    public void addMenu(IMenu menu) {
        menus.add(menu);
    }

    public IMenu getMenu(String menuName) {
        for (IMenu menu : menus) {
            if (Objects.equals(menu.getName(), menuName)) {
                return menu;
            }
        }
        return null;
    }

    public void onSelectionMenu(SelectionMenuEvent e) {
        if (e.getGuild() != null) {
            Iterator<IMenu> iterator = menus.iterator();
            while(iterator.hasNext()) {
                IMenu menu = iterator.next();
                if (Objects.equals(menu.getName(), Objects.requireNonNull(e.getComponent()).getPlaceholder())) {
                    menu.run(e);
                }
            }
        }
    }



}
