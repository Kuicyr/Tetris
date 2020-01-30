package mr.sample.fx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mr.sample.Application;

public class MainPane
{
    private Pane pane;

    public MainPane()
    {
        pane = new Pane();
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/back.png"),
                Application.width, Application.height, false, true));
        pane.setPrefHeight(Application.height);
        pane.setPrefWidth(Application.width);
        pane.getChildren().add(imageView);
    }

    public Pane getPane()
    {
        return pane;
    }
}
