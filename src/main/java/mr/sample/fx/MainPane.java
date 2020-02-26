package mr.sample.fx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mr.sample.Application;

/* author:
Mateusz Ryciuk
*/

public class MainPane
{
    private Pane pane;
    private Grid grid;

    public MainPane()
    {
        pane = new Pane();
        restart();
    }

    public void restart()
    {
        pane.getChildren().clear();
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/back.png"),
                Application.width, Application.height, false, true));
        pane.getChildren().add(imageView);
        NextBlock nextBlock = new NextBlock();
        nextBlock.setTranslateX(Application.blockSize * 10);
        nextBlock.setTranslateY(Application.blockSize);
        pane.getChildren().add(nextBlock);

        InfPanel infPanel = new InfPanel(6);
        infPanel.setTranslateX(Application.blockSize * 13);
        infPanel.setTranslateY(Application.blockSize * 8);
        pane.getChildren().add(infPanel);

        grid = new Grid(nextBlock, infPanel);
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
