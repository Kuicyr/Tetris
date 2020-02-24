package mr.sample.logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mr.sample.Application;
import mr.sample.blocks.*;
import mr.sample.fx.Grid;


public class Collision
{
    private Grid grid;
    private Updater updater;

    public Collision(Grid grid, Updater updater)
    {
        this.grid = grid;
        this.updater = updater;
    }

    public void checkForSide(boolean left)
    {
        boolean correct = true;

        for (Position position : updater.block.blocks)
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
                updater.block.right();
            } else
            {
                updater.block.left();
            }
        }
    }

    public void checkForRotation()
    {
        boolean correct = true;

        for (Position position : updater.block.blocks)
        {
            if (grid.gridTable[position.x - 1][position.y - 1] != 0)
            {
                correct = false;
            }
        }

        if (!correct)
        {
            updater.block.rotate();
            updater.block.rotate();
            updater.block.rotate();
        }
    }

    public boolean checkForGround()
    {
        if (updater.block != null)
        {
            for (Position position : updater.block.blocks)
            {
                boolean lowerBlocked = false;
                for (Position lowerOne : updater.block.blocks)
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
                for (int x = 0; x < 10; x++)
                {
                    grid.gridTable[x][y] = 0;
                }
            }
        }
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
