package mr.sample.fx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mr.sample.Application;

/* author:
Mateusz Ryciuk
*/

public class LoseGame extends Pane
{
    private Text scoreText;

    public LoseGame()
    {
        setTranslateX(-Application.blockSize);
        setTranslateY(Application.blockSize * 6);
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(Application.width);
        rectangle.setHeight(Application.blockSize * 7);
        getChildren().add(rectangle);
        scoreText = new Text();
        setStyle(scoreText);
        scoreText.setTextAlignment(TextAlignment.CENTER);
        scoreText.setTranslateY(Application.blockSize * 3);
        scoreText.setTranslateX(Application.blockSize * 2);
        getChildren().add(scoreText);
    }

    public void display(int score)
    {
        scoreText.setText("Score\n" + score);
    }

    private void setStyle(Text text)
    {
        text.setFont(Font.loadFont("file:src/main/resources/Tetris.ttf", 90));
        text.setFill(Color.valueOf("357edf"));
    }
}
