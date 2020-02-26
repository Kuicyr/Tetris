package mr.sample.fx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mr.sample.Application;

/* author:
Mateusz Ryciuk
*/

public class InfPanel extends Pane
{
    private int scoreValue;
    private Text scoreText;
    private int levelValue;
    private Text levelText;
    private int fullRowToNextLevel;

    public InfPanel(int fullRowToNextLevel)
    {
        this.fullRowToNextLevel = fullRowToNextLevel;

        Text score = new Text();
        score.setText("Score");
        setStyle(score);
        getChildren().add(score);

        scoreText = new Text();
        scoreText.setText(String.valueOf(scoreValue));
        setStyle(scoreText);
        scoreText.setTranslateY(Application.blockSize);
        getChildren().add(scoreText);

        Text level = new Text();
        level.setTranslateY(Application.blockSize * 3);
        level.setText("Level");
        setStyle(level);
        getChildren().add(level);

        levelText = new Text();
        levelText.setText(String.valueOf(scoreValue));
        setStyle(levelText);
        levelText.setTranslateY(Application.blockSize * 4);
        getChildren().add(levelText);
    }

    public int getScoreValue()
    {
        return scoreValue;
    }

    public int getLevelValue()
    {
        return levelValue;
    }

    public boolean increaseLevel()
    {
        levelValue += 1;
        levelText.setText(String.valueOf(levelValue / fullRowToNextLevel));
        if (levelValue % fullRowToNextLevel == 0)
        {
            return true;
        }
        return false;
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
        scoreValue += amount * ((levelValue / fullRowToNextLevel) + 1);
        scoreText.setText(String.valueOf(scoreValue));
    }

    private void setStyle(Text text)
    {
        text.setFont(Font.loadFont("file:src/main/resources/Tetris.ttf", 35));
        text.setFill(Color.valueOf("357edf"));
    }
}
