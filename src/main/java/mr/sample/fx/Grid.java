package mr.sample.fx;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import mr.sample.logic.Controls;

public class Grid extends Pane
{
    public int[][] gridTable;
    public Controls controls;

    private int counter;


    public Grid(NextBlock nextBlock, Score score)
    {
        controls = new Controls(this, nextBlock, score);

        AnimationTimer timer = new AnimationTimer()
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
        if (counter == 40)
        {
            controls.down(false);
            counter = 0;
        }
        counter++;

    }


}
