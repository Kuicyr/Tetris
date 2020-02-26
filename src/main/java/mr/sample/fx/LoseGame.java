package mr.sample.fx;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
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
        TextStyle.setStyle(scoreText, 90);
        scoreText.setTextAlignment(TextAlignment.CENTER);
        scoreText.setTranslateY(Application.blockSize * 3);
        scoreText.setTranslateX(Application.blockSize * 2);
        getChildren().add(scoreText);
    }

    public void display(int score)
    {
        scoreText.setText("SCORE\n" + score);
    }
}
