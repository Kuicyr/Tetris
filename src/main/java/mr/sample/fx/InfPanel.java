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
        score.setText("SCORE");
        TextStyle.setStyle(score, 35);
        getChildren().add(score);

        scoreText = new Text();
        scoreText.setText(String.valueOf(scoreValue));
        TextStyle.setStyle(scoreText, 35);
        scoreText.setTranslateY(Application.blockSize);
        getChildren().add(scoreText);

        Text level = new Text();
        level.setTranslateY(Application.blockSize * 3);
        level.setText("LEVEL");
        TextStyle.setStyle(level, 35);
        getChildren().add(level);

        levelText = new Text();
        levelText.setText(String.valueOf(scoreValue));
        TextStyle.setStyle(levelText, 35);
        levelText.setTranslateY(Application.blockSize * 4);
        getChildren().add(levelText);
    }

    public int getScoreValue()
    {
        return scoreValue;
    }

    public boolean increaseLevel()
    {
        levelValue += 1;
        levelText.setText(String.valueOf(levelValue / fullRowToNextLevel));
        return levelValue % fullRowToNextLevel == 0;
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
}
