package mr.sample.logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mr.sample.Application;
import mr.sample.blocks.Block;
import mr.sample.blocks.Position;
import mr.sample.fx.Grid;
import mr.sample.fx.NextBlock;
import mr.sample.fx.Score;

public class Controls
{
    public Block block;
    public int nextBlockId;
    public Score score;

    private NextBlock nextBlock;
    private Grid grid;
    private Collision collision;
    private BlockManager blockManager;

    public Controls(Grid grid, NextBlock nextBlock, Score score)
    {
        this.nextBlock = nextBlock;
        this.grid = grid;
        this.score = score;
        grid.gridTable = new int[10][20];
        collision = new Collision(grid, this);
        blockManager = new BlockManager(7);
        block = blockManager.randomBlock();
        nextBlockId = blockManager.randomBlockId();
        nextBlock.next(nextBlockId);
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

    public void down(boolean allDown)
    {
        int rowNumber = 0;
        boolean czy = true;
        do
        {
            clearBlock();
            if (!collision.checkForGround())
            {
                block.down();
                rowNumber++;
            } else
            {
                czy = false;
                setBlock();
                collision.removeFullRow();
                collision.fillGaps();
                block = blockManager.blockId(nextBlockId);
                nextBlockId = blockManager.randomBlockId();
                nextBlock.next(nextBlockId);
            }
            setBlock();
        } while (czy && allDown);
        score.addScore(rowNumber);
    }
}