package mr.sample.fx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mr.sample.Application;

public class Score extends Pane
{
    private int scoreValue;
    private Text scoreText;

    public Score()
    {
        Text score = new Text();
        score.setText("Score");
        setStyle(score);
        getChildren().add(score);

        scoreText = new Text();
        scoreText.setText(String.valueOf(scoreValue));
        setStyle(scoreText);
        scoreText.setTranslateY(Application.blockSize);
        getChildren().add(scoreText);
    }

    public void addScore(int i)
    {
        if (i > 1)
        {
            scoreValue += i;
            scoreText.setText(String.valueOf(scoreValue));
        }
    }

    public void addScoreForFull(int i)
    {
        int amount = 0;
        switch (i)
        {
            case 1:
            {
                amount = 40;
                break;
            }
            case 2:
            {
                amount = 100;
                break;
            }
            case 3:
            {
                amount = 300;
                break;
            }
            case 4:
            {
                amount = 1200;
                break;
            }
        }
        scoreValue += amount;
        scoreText.setText(String.valueOf(scoreValue));
    }

    private void setStyle(Text text)
    {
        text.setFont(Font.loadFont("file:src/main/resources/Tetris.ttf", 35));
        text.setFill(Color.valueOf("357edf"));
    }
}
