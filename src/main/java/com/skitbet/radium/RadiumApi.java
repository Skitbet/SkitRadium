package com.skitbet.radium;

import com.skitbet.radium.command.ICommand;
import com.skitbet.radium.command.SlashCommandManager;
import com.skitbet.radium.menu.IMenu;
import com.skitbet.radium.menu.RadiumMenuManager;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.reflections.Reflections;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.login.LoginException;
import java.util.Set;

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

    /**
     * Add a command to the bot, you need to rejoin the bot if you are testing, if you don't it can take up to 24 hours to update.
     * @param command The command to add
     */
    public void addCommand(ICommand command) {
        slashCommandManager.addCommand(command);
    }

    /**
     * Register all commands that have been added
     */
    public void registerCommands() {
        slashCommandManager.registerAllCommands();
    }

    /**
     * Add a menu to the bot and register it.
     * @param menu The menu to add
     */

    public void addMenu(IMenu menu) {
        radiumMenuManager.addMenu(menu);
    }

    /**
     * Get a menu that has been registered on the bot.
     * @param name The name of the menu to get
     * @return The menu you are looking for, will return null if it does not exist.
     */

    public IMenu getMenu(String name) {
        return radiumMenuManager.getMenu(name);
    }




}
