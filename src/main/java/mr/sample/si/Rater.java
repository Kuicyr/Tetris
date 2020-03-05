package mr.sample.si;

/* author:
Mateusz Ryciuk
*/

import mr.sample.blocks.Position;
import mr.sample.blocks.ShadowBlock;

import java.util.ArrayList;

public class Rater
{
    private int[][] grid;
    private ArrayList<Position> block;

    public Rater(int[][] gridTable)
    {
        this.grid = gridTable;
    }

    public void analyze(ShadowBlock shadowBlock)
    {
        int wrongNodes=0;
        block = shadowBlock.getPosition();
        show();

        for (Position position : block)
        {
            if (position.y + 1 <= 20)
            {
                if (grid[position.x - 1][position.y] == 0)
                {
                    boolean isSelf = true;
                    for (Position blockPoz : block)
                    {
                        if (blockPoz.y == position.y + 1 && blockPoz.x == position.x)
                        {
                            isSelf = false;
                            break;
                        }
                    }
                    if (isSelf)
                    {
                        wrongNodes++;
                    }
                }
            }
        }
        System.out.println(wrongNodes);

    }

    private void show()
    {
        for (int y = 0; y < 20; y++)
        {
            String line = "";
            for (int x = 0; x < 10; x++)
            {
                boolean isBlock = false;
                for (Position position : block)
                {
                    if (position.x - 1 == x && position.y - 1 == y)
                    {
                        isBlock = true;
                        break;
                    }
                }
                if (isBlock)
                {
                    line += "X|";
                } else
                {
                    line += grid[x][y] + "|";
                }
            }
            System.out.println(line);
        }
        System.out.println("----------------------");
    }
}
