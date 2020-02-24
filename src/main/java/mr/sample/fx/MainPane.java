package mr.sample.fx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mr.sample.Application;

public class MainPane
{
    private Pane pane;
    private Grid grid;

    public MainPane()
    {
        pane = new Pane();
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/back.png"),
                Application.width, Application.height, false, true));
        pane.setPrefHeight(Application.height);
        pane.setPrefWidth(Application.width);
        pane.getChildren().add(imageView);

        grid = new Grid();
        grid.setTranslateX(Application.blockSize);
        grid.setTranslateY(Application.blockSize);
        pane.getChildren().add(grid);
    }

    public Pane getPane()
    {
        return pane;
    }

    public Grid getGrid()
    {
        return grid;
    }
}
