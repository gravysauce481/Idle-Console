import identifier.GameState;
import producer.Producer;

import java.util.ArrayList;

public abstract sealed class Application implements Runnable permits IdleConsole
{
    protected GameState gameState;
    protected GameState previousGameState;

    protected ArrayList<Producer> producers = new ArrayList<>();

    protected boolean shouldRun;

    @Override
    public final void run()
    {
        init();
        loop();
        terminate();
    }

    protected abstract void init();

    private void loop()
    {
        while (shouldRun)
        {
            if (gameState == GameState.MAIN_MENU)
            {
                mainMenu(previousGameState);
            }
            else if (gameState == GameState.SETTINGS)
            {
                settings(previousGameState);
            }
            else if (gameState == GameState.PRODUCTION)
            {
                production(previousGameState);
            }
        }
    }

    protected abstract void mainMenu(GameState source);

    protected abstract void settings(GameState source);

    protected abstract void production(GameState source);

    protected abstract void terminate();

    protected void switchState(GameState newState)
    {
        previousGameState = gameState;
        gameState = newState;
    }
}
