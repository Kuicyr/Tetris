package mr.sample;

import javafx.scene.Scene;
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
                    mainPane.getGrid().controls.rotate();
                    break;
                }
                case S:
                {
                    mainPane.getGrid().controls.down(false);
                    break;
                }
                case A:
                {
                    mainPane.getGrid().controls.left();
                    break;
                }
                case D:
                {
                    mainPane.getGrid().controls.right();
                    break;
                }
                case R:
                {
                    mainPane.restart();
                    break;
                }
                case SPACE:
                {
                    mainPane.getGrid().controls.down(true);
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
