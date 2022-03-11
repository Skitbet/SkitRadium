package com.skitbet.radium.command;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public abstract class ICommand {

    public abstract void run(SlashCommandEvent event);

    public abstract String getName();
    public abstract String getDescription();
    public abstract List<OptionData> getOptions();


}
