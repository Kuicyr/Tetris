package mr.sample.fx;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import mr.sample.logic.Controls;

/* author:
Mateusz Ryciuk
*/

public class Grid extends Pane
{
    public int[][] gridTable;
    public Controls controls;
    public boolean endGame;
    public boolean shadowBlock;
    public boolean pause;
    public AnimationTimer timer;

    private int counter;
    private int time;

    public Grid(NextBlock nextBlock, InfPanel infPanel)
    {
        time = 40;
        controls = new Controls(this, nextBlock, infPanel);
        endGame = false;
        shadowBlock = false;
        pause = false;

        timer = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                update();
            }
        };

        timer.start();
    }

    private void update()
    {
        if (endGame)
        {
            timer.stop();
        }

        if (counter >= time && !endGame)
        {
            controls.down(false);
            counter = 0;
        }
        counter++;

    }

    public void speedUp()
    {
        time *= (4 / 5.0);
        if (time < 1)
        {
            time = 1;
        }
    }
}
