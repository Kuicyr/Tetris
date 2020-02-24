package mr.sample.fx;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mr.sample.Application;
import mr.sample.blocks.*;
import mr.sample.logic.BlockChooser;
import mr.sample.logic.Collision;
import mr.sample.logic.Updater;

public class Grid extends Pane
{
    public int[][] gridTable;
    public Updater updater;

    private int counter;


    public Grid()
    {
        updater = new Updater(this);

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
        if (counter == 30)
        {
            updater.down();
            counter %= 30;
        }
        counter++;

    }


}
