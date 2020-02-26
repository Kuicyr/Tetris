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

    private int counter;
    private AnimationTimer timer;


    public Grid(NextBlock nextBlock, Score score)
    {
        controls = new Controls(this, nextBlock, score);
        endGame = false;
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

        if (counter == 40 && !endGame)
        {
            controls.down(false);
            counter = 0;
        }
        counter++;

    }


}
