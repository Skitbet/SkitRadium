package com.skitbet.radium;

import com.skitbet.radium.command.ICommand;
import com.skitbet.radium.command.SlashCommandManager;
import com.skitbet.radium.menu.IMenu;
import com.skitbet.radium.menu.RadiumMenuManager;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.login.LoginException;

public class RadiumApi {


    private final SlashCommandManager slashCommandManager;
    private final RadiumMenuManager radiumMenuManager;
    private final JDA bot;

    @Getter private static RadiumApi instance;

    public RadiumApi(JDA bot) {
        instance = this;
        this.bot = bot;
        slashCommandManager = new SlashCommandManager(bot.updateCommands());
        radiumMenuManager = new RadiumMenuManager();
        bot.addEventListener(slashCommandManager);
        bot.addEventListener(radiumMenuManager);
    }


    public void addCommand(ICommand command) {
        slashCommandManager.addCommand(command);
    }

    public void registerCommands() {
        slashCommandManager.registerAllCommands();
    }


    public void addMenu(IMenu menu) {
        radiumMenuManager.addMenu(menu);
    }

    public IMenu getMenu(String name) {
        return radiumMenuManager.getMenu(name);
    }



}
