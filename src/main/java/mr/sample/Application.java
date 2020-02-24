package mr.sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mr.sample.fx.MainPane;


public class Application extends javafx.application.Application
{
    public static int width = 170 * 4;
    public static int height = 220 * 4;
    public static int blockSize = height / 22;

    private double xOffset;
    private double yOffset;

    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception
    {
        MainPane mainPane = new MainPane();
        Scene scene = new Scene(mainPane.getPane());

        scene.setOnMousePressed(event ->
        {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        scene.setOnMouseDragged(event ->
        {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        scene.setOnKeyPressed(event ->
        {
            switch (event.getCode())
            {
                case W:
                {
                    mainPane.getGrid().updater.rotate();
                    break;
                }
                case S:
                {
                    mainPane.getGrid().updater.down();
                    break;
                }
                case A:
                {
                    mainPane.getGrid().updater.left();
                    break;
                }
                case D:
                {
                    mainPane.getGrid().updater.right();
                    break;
                }
                case ESCAPE:
                {
                    System.exit(0);
                    break;
                }
            }
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}