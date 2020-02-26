package mr.sample.fx;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/* author:
Mateusz Ryciuk
*/

public class TextStyle
{
    public static void setStyle(Text text, int size)
    {
        text.setFont(Font.loadFont(TextStyle.class.getResourceAsStream("/Tetris.ttf"), size));
        text.setFill(Color.valueOf("357edf"));
    }
}
