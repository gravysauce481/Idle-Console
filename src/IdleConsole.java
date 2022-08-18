import identifier.GameState;

import java.util.Scanner;

public final class IdleConsole extends Application
{
    private int coins = 100;
    private int gems = 50;

    private static final Scanner SC = new Scanner(System.in);

    // settings
    private boolean confirmExit = true;

    public static void main(String[] args)
    {
        new IdleConsole().run();
    }

    @Override
    protected void init()
    {

    }

    @Override
    protected void mainMenu(GameState source)
    {
        System.out.print(source != GameState.MAIN_MENU ? "Welcome to Idle Console! " : "");
        System.out.println("Type \"help\" for a list of instructions.");

        while (true)
        {
            switch(SC.nextLine().toLowerCase())
            {
                case "help", "h" ->
                {
                    nl();
                    System.out.println("Type \"help\" to get a list of commands.");
                    System.out.println("Type \"settings\" to view your configurations.");
                    System.out.println("Type \"production\" to view your production stations.");
                    System.out.println("Type \"quit\" to quit the game.");
                }
                case "settings", "se", "config", "co" ->
                {
                    nl();
                    switchState(GameState.SETTINGS);
                    return;
                }
                case "production", "p", "stations", "station", "st" ->
                {
                    nl();
                    switchState(GameState.PRODUCTION);
                }
                case "quit", "q", "terminate", "t", "close", "cl" ->
                {
                    if (confirmExit)
                    {
                        nl();
                        if (yesNoQuestion("Are you sure you want to quit the game?"))
                        {
                            shouldRun = false;
                            return;
                        }
                        nl();
                        switchState(GameState.MAIN_MENU);
                        return;
                    }
                    shouldRun = false;
                    return;
                }
            }
        }
    }

    @Override
    protected void settings(GameState source)
    {
        System.out.print(source != GameState.SETTINGS ? "Welcome. " : "");
        System.out.println("Type \"help\" for a list of instructions.");

        while (true)
        {
            switch (SC.nextLine().toLowerCase())
            {
                case "help", "h" ->
                {
                    nl();
                    System.out.println("Type \"help\" to get a list of commands.");
                    System.out.println("Type \"exit\" to return the main menu.");
                    nl();

                }
                case "exit", "e", "close", "c", "mainmenu", "m" ->
                {
                    nl();
                    switchState(GameState.MAIN_MENU);
                    return;
                }
            }
        }
    }

    @Override
    protected void production(GameState source)
    {
        System.out.println("Type \"help\" for a list of instructions.");

        while (true)
        {
            switch (SC.nextLine().toLowerCase())
            {
                case "help", "h" ->
                {
                    nl();
                    System.out.println("Type \"help\" for a list of commands.");
                    System.out.println("Type \"exit\" to return to the main menu.");
                    nl();
                    System.out.println("To select a prodution station, type the corresponding slot.");
                }
            }
        }
    }

    @Override
    protected void terminate()
    {

    }

    private boolean yesNoQuestion(String question)
    {
        System.out.println(question);
        while (true)
        {
            switch (SC.nextLine().toLowerCase())
            {
                case "yes", "y" ->
                {
                    return true;
                }
                case "no", "n" ->
                {
                    return false;
                }
            }
        }
    }

    private void nl()
    {
        System.out.println();
    }
}
