package mr.sample.logic;

import mr.sample.blocks.*;
import mr.sample.fx.Grid;


public class Collision
{
    private Grid grid;
    private Controls controls;

    public Collision(Grid grid, Controls controls)
    {
        this.grid = grid;
        this.controls = controls;
    }

    public void checkForSide(boolean left)
    {
        boolean correct = true;

        for (Position position : controls.block.blocks)
        {
            if (position.x >= 1 && position.x <= 10)
            {
                if (grid.gridTable[position.x - 1][position.y - 1] != 0)
                {
                    correct = false;
                }
            } else
            {
                correct = false;
            }
        }

        if (!correct)
        {
            if (left)
            {
                controls.block.right();
            } else
            {
                controls.block.left();
            }
        }
    }

    public void checkForRotation()
    {
        boolean correct = true;

        for (Position position : controls.block.blocks)
        {
            if (grid.gridTable[position.x - 1][position.y - 1] != 0)
            {
                correct = false;
            }
        }

        if (!correct)
        {
            controls.block.rotate();
            controls.block.rotate();
            controls.block.rotate();
        }
    }

    public boolean checkForGround()
    {
        if (controls.block != null)
        {
            for (Position position : controls.block.blocks)
            {
                boolean lowerBlocked = false;
                for (Position lowerOne : controls.block.blocks)
                {
                    if (lowerOne.x == position.x && lowerOne.y == position.y + 1)
                    {
                        lowerBlocked = true;
                    }
                }

                if (!lowerBlocked)
                {
                    if (position.y == 20)
                    {
                        return true;
                    } else if (grid.gridTable[position.x - 1][position.y] != 0)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void removeFullRow()
    {
        int rowCount = 0;
        for (int y = 0; y < 20; y++)
        {
            boolean fullRow = true;
            for (int x = 0; x < 10; x++)
            {
                if (grid.gridTable[x][y] == 0)
                {
                    fullRow = false;
                }
            }

            if (fullRow)
            {
                rowCount++;
                for (int x = 0; x < 10; x++)
                {
                    grid.gridTable[x][y] = 0;
                }
            }
        }
        controls.score.addScoreForFull(rowCount);
    }

    public void fillGaps()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int y = 18; y >= 0; y--)
            {
                boolean emptyBelow = true;
                for (int x = 0; x < 10; x++)
                {
                    if (grid.gridTable[x][y + 1] != 0)
                    {
                        emptyBelow = false;
                    }
                }

                if (emptyBelow)
                {
                    for (int x = 0; x < 10; x++)
                    {
                        grid.gridTable[x][y + 1] = grid.gridTable[x][y];
                        grid.gridTable[x][y] = 0;
                    }
                }
            }
        }
    }
}
