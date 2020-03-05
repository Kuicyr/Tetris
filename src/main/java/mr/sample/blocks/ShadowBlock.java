package mr.sample.blocks;

import mr.sample.fx.Grid;

import java.util.ArrayList;

/* author:
Mateusz Ryciuk
*/

public class ShadowBlock
{
    public ArrayList<Position> blocks;

    private Block block;
    private Grid grid;

    public ShadowBlock(Block block, Grid grid)
    {
        this.block = block;
        this.grid = grid;
    }

    public ArrayList<Position> getPosition()
    {
        blocks = new ArrayList<>();
        for (Position position : block.blocks)
        {
            blocks.add(new Position(position.x, position.y));
        }

        boolean tryDown = true;
        while (tryDown)
        {
            for (Position position : blocks)
            {
                if (position.y <= 19)
                {
                    if (grid.gridTable[position.x - 1][position.y] > 0)
                    {
                        tryDown = false;
                        break;
                    }
                } else
                {
                    tryDown = false;
                    break;
                }

            }

            if (tryDown)
            {
                for (Position position : blocks)
                {
                    position.y += 1;
                }
            }
        }

        return blocks;
    }
}
