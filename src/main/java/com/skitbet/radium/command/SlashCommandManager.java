package com.skitbet.radium.command;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SlashCommandManager extends ListenerAdapter {

    private final List<ICommand> registeredCommands = new ArrayList<>();
    private final CommandListUpdateAction commands;

    public SlashCommandManager(CommandListUpdateAction commands) {
        this.commands = commands;
    }

    public void addCommand(ICommand clazz) {
        System.out.println("Adding command " + clazz.getName());
        registeredCommands.add(clazz);
    }

    public void registerAllCommands() {
        System.out.println("Registering commands");
        Iterator<ICommand> iterator = registeredCommands.iterator();
        while (iterator.hasNext()) {
            ICommand command = iterator.next();
            CommandData commandData = new CommandData(command.getName(), command.getDescription());
            Iterator<OptionData> iterator1 = command.getOptions().iterator();
            while (iterator1.hasNext()) {
                OptionData optionData = iterator1.next();
                commandData.addOptions(optionData);
            }
            this.commands.addCommands(commandData);
            System.out.println("Registered command: /" + command.getName() + " : " + command.getDescription());
        }
        this.commands.queue();
    }

    public void onSlashCommand(SlashCommandEvent e) {
        if (e.getGuild() != null) {
            Iterator<ICommand> iterator = registeredCommands.iterator();
            while (iterator.hasNext()) {
                ICommand command = iterator.next();
                if (e.getName().equalsIgnoreCase(command.getName())) {
                    command.run(e);
                }
            }
        }
    }

}
