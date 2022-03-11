package com.skitbet.radium;

import com.skitbet.radium.command.ICommand;
import com.skitbet.radium.command.SlashCommandManager;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.login.LoginException;

public class RadiumApi {


    private final SlashCommandManager slashCommandManager;
    private final JDA bot;

    @Getter private static RadiumApi instance;

    public RadiumApi(JDA bot) {
        instance = this;
        this.bot = bot;
        slashCommandManager = new SlashCommandManager(bot.updateCommands());
        bot.addEventListener(slashCommandManager);
    }


    public void addCommand(ICommand command) {
        slashCommandManager.addCommand(command);
    }

    public void registerCommands() {
        slashCommandManager.registerAllCommands();
    }






}
