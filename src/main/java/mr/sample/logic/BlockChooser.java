package mr.sample.logic;

import mr.sample.blocks.*;

import java.util.Random;

public class BlockChooser extends Random
{
    public Block randomBlock()
    {
        Block blockToReturn = null;
        switch (nextInt(7))
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
