package mr.sample.logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mr.sample.Application;
import mr.sample.blocks.Block;
import mr.sample.blocks.Position;
import mr.sample.blocks.ShadowBlock;
import mr.sample.fx.Grid;
import mr.sample.fx.LoseGame;
import mr.sample.fx.NextBlock;
import mr.sample.fx.InfPanel;
import mr.sample.si.Rater;

/* author:
Mateusz Ryciuk
*/

public class Controls
{
    public Block block;
    public int nextBlockId;
    public InfPanel infPanel;

    private NextBlock nextBlock;
    private Grid grid;
    private Collision collision;
    private BlockManager blockManager;
    private ShadowBlock shadowBlock;
    private Rater rater;

    public Controls(Grid grid, NextBlock nextBlock, InfPanel infPanel)
    {
        this.nextBlock = nextBlock;
        this.grid = grid;
        this.infPanel = infPanel;
        grid.gridTable = new int[10][20];
        collision = new Collision(grid, this);
        blockManager = new BlockManager(7);
        block = blockManager.randomBlock();
        nextBlockId = blockManager.randomBlockId();
        nextBlock.next(nextBlockId);
        shadowBlock = new ShadowBlock(block, grid);

        rater = new Rater(grid.gridTable);
        setBlock();
    }

    public void update()
    {
        grid.getChildren().clear();
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                if (grid.gridTable[x][y] > 0)
                {
                    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/block" +
                            grid.gridTable[x][y] + ".png"),
                            Application.blockSize, Application.blockSize, false, true));
                    imageView.setTranslateX(x * Application.blockSize);
                    imageView.setTranslateY(y * Application.blockSize);
                    grid.getChildren().add(imageView);
                } else if (grid.gridTable[x][y] == -1 && grid.shadowBlock)
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
        if (block != null)
        {
            for (Position position : shadowBlock.blocks)
            {
                grid.gridTable[position.x - 1][position.y - 1] = 0;
            }
            for (Position position : block.blocks)
            {
                grid.gridTable[position.x - 1][position.y - 1] = 0;
            }
        }
    }

    private void setBlock()
    {
        if (block != null)
        {
            rater.analyze(shadowBlock);
            for (Position position : shadowBlock.getPosition())
            {
                grid.gridTable[position.x - 1][position.y - 1] = -1;
            }
            for (Position position : block.blocks)
            {
                grid.gridTable[position.x - 1][position.y - 1] = block.id;
            }
            update();
        }
    }

    public void rotate()
    {
        if (block != null && !grid.pause)
        {
            clearBlock();
            block.rotate();
            collision.checkForRotation();
            setBlock();
        }
    }


    public void left()
    {
        if (block != null && !grid.pause)
        {
            clearBlock();
            block.left();
            collision.checkForSide(true);
            setBlock();
        }
    }

    public void right()
    {
        if (block != null && !grid.pause)
        {
            clearBlock();
            block.right();
            collision.checkForSide(false);
            setBlock();
        }
    }

    public void down(boolean allDown)
    {
        if (block != null && !grid.pause)
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
                    shadowBlock = new ShadowBlock(block, grid);
                    if (collision.checkForLose())
                    {
                        gameLose();
                    }
                    nextBlockId = blockManager.randomBlockId();
                    nextBlock.next(nextBlockId);
                  //  rater.analyze(shadowBlock);
                }
                setBlock();
            } while (czy && allDown);
            infPanel.addScore(rowNumber);
        }
    }

    private void gameLose()
    {
        grid.endGame = true;
        setBlock();
        block = null;
        LoseGame loseGame = new LoseGame();
        loseGame.display(infPanel.getScoreValue());
        grid.getChildren().add(loseGame);
    }

    public void stop()
    {
        grid.getChildren().clear();
        for (int x = 3; x < 7; x += 3)
        {
            for (int y = 8; y < 12; y++)
            {
                ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/block-1.png"),
                        Application.blockSize, Application.blockSize, false, true));
                imageView.setTranslateX(x * Application.blockSize);
                imageView.setTranslateY(y * Application.blockSize);
                grid.getChildren().add(imageView);
            }
        }

    }
}
