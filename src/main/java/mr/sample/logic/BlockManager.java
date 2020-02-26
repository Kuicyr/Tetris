package mr.sample.logic;

import mr.sample.blocks.*;

import java.util.Random;

/* author:
Mateusz Ryciuk
*/

public class BlockManager extends Random
{
    private int blockCount;

    public BlockManager(int blockCount)
    {
        this.blockCount = blockCount;
    }

    public int randomBlockId()
    {
        return nextInt(blockCount);
    }

    public Block randomBlock()
    {
        return blockId(randomBlockId());
    }

    public Block blockId(int id)
    {
        Block blockToReturn = null;
        switch (id)
        {
            case 0:
            {
                blockToReturn = new IBlock();
                break;
            }
            case 1:
            {
                blockToReturn = new LBlock();
                break;
            }
            case 2:
            {
                blockToReturn = new JBlock();
                break;
            }
            case 3:
            {
                blockToReturn = new OBlock();
                break;
            }
            case 4:
            {
                blockToReturn = new SBlock();
                break;
            }
            case 5:
            {
                blockToReturn = new TBlock();
                break;
            }
            case 6:
            {
                blockToReturn = new ZBlock();
                break;
            }
        }

        return blockToReturn;
    }
}
