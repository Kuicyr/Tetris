package mr.sample.logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mr.sample.Application;
import mr.sample.blocks.Block;
import mr.sample.blocks.Position;
import mr.sample.fx.Grid;

public class Updater
{
    public Block block;

    private Grid grid;
    private Collision collision;
    private BlockChooser blockChooser;

    public Updater(Grid grid)
    {
        this.grid = grid;
        grid.gridTable = new int[10][20];
        collision = new Collision(grid, this);
        blockChooser = new BlockChooser();
        block = blockChooser.randomBlock();
        setBlock();
    }

    public void update()
    {
        grid.getChildren().clear();
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                if (grid.gridTable[x][y] != 0)
                {
                    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/block" +
                            grid.gridTable[x][y] + ".png"),
                            Application.blockSize, Application.blockSize, false, true));
                    imageView.setTranslateX(x * Application.blockSize);
                    imageView.setTranslateY(y * Application.blockSize);
                    grid.getChildren().add(imageView);
                }
            }
        }
    }


    private void clearBlock()
    {
        for (Position position : block.blocks)
        {
            grid.gridTable[position.x - 1][position.y - 1] = 0;
        }
    }

    private void setBlock()
    {
        for (Position position : block.blocks)
        {
            grid.gridTable[position.x - 1][position.y - 1] = block.id;
        }
        update();
    }

    public void rotate()
    {
        if (block != null)
        {
            clearBlock();
            block.rotate();
            collision.checkForRotation();
            setBlock();
        }
    }


    public void left()
    {
        if (block != null)
        {
            clearBlock();
            block.left();
            collision.checkForSide(true);
            setBlock();
        }
    }

    public void right()
    {
        if (block != null)
        {
            clearBlock();
            block.right();
            collision.checkForSide(false);
            setBlock();
        }
    }

    public void down()
    {
        if (block != null)
        {
            clearBlock();
            if (!collision.checkForGround())
            {
                block.down();
            } else
            {
                setBlock();
                collision.removeFullRow();
                collision.fillGaps();
                block = blockChooser.randomBlock();
            }
            setBlock();
        }
    }
}
