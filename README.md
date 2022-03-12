# SkitRadium

SkitRadium is a Discord JDA slash command library. This API is very simple and small and i plan to add more things to improve development for JDA developers. 

## Installation

The installation for SkitRadium is very simple and user friendly.

To begin using the SkitRadium API all you have to do is add make a new instance of RadiumApi and put your bot as a argument
```
radiumApi = new RadiumApi(bot instance);
```

## Commands

To create a command all you have to do is make a class and extend it off of the ICommand class.
```
public class ExampleCommand extends ICommand {
    @Override
    public void run(SlashCommandEvent event) {
        event.reply("Option = " + event.getOption("exampleoption").getAsString()).queue();
    }

    @Override
    public String getName() {
        return "example";
    }

    @Override
    public String getDescription() {
        return "This is a example command!";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.STRING, "exampleoption", "Example Description", true));
        return options;
    }
}
```

The ICommand class has 4 basic methods that are required to make a command!
      - run() - This is where your command will be ran.
      - getName() - This is the name of you command.
      - getDescription() - This is the description of your command.
      - getOptions() - This is where your options for the command is. Please read the JDA documents about OptionData for more info.
