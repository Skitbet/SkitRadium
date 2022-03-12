# SkitRadium

SkitRadium is a Discord JDA slash command and Selection Menu API. This API is simple and small, I plan to add more things to improve development for JDA developers. 

## Installation

The installation for SkitRadium is very simple and user-friendly.

To install you can either download the source and compile it or you can download the latest release and import it using Maven or Gradle!

To begin using the SkitRadium API all you have to do is make a new instance of RadiumApi and cast your bot instance into it!
```
radiumApi = new RadiumApi(bot instance);
```

## Commands

To create a command all you have to do is create a class and extend it off of the ICommand class.
The ICommand class has 4 basic methods that are required to make a command!
```
run() - This is where your command will be ran.
getName() - This is the name of your command.
getDescription() - This is the description of your command.
getOptions() - This is where your options for the command is. Please read the JDA documents about OptionData for more info.
```
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

To register the commad all you have to do is run the addCommand method in your main class
```
radiumApi.addCommand(new ExampleCommand());

radiumApi.registerCommands();
```



## Selection Menus
To create a menu all you have to do is create a class and extend it off of the IMenu class.
The IMenu class has 4 basic methods that are required to make a command!
```
run() - This is where your menu will be ran.
getName() - This is the name of your menu.
minSelectedRequired() - This is the min required amount of selected options.
maxSelectedRequired() - This is the max required amount of selected options.
getOptions() - This is where your options for the menu is. Please read the JDA documents about SelectionMenu for more info.
```
```public class ExampleMenu extends IMenu {

    @Override
    public void run(SelectionMenuEvent selectionMenuEvent) {
        selectionMenuEvent.getSelectedOptions().forEach(selectOption -> {
            selectionMenuEvent.reply(selectOption.getLabel()).queue();
        });
    }

    @Override
    public String getName() {
        return "Example Menu";
    }

    @Override
    public int minSelectedRequired() {
        return 1;
    }

    @Override
    public int maxSelectedRequired() {
        return 1;
    }

    @Override
    public HashMap<String, String> getOptions() {
        HashMap<String, String> options = new HashMap<>();
        options.put("Example 1", "exampleone"); // DisplayName, ID
        options.put("Example 2", "exampletwo"); // DisplayName, ID

        return options;
    }
}
```

To register a menu you have to run below in the main class of your bot
```
radiumApi.addMenu(new ExampleMenu());
```


