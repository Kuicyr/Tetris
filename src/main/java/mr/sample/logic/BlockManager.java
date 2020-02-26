package mr.sample.logic;

import mr.sample.blocks.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* author:
Mateusz Ryciuk
*/

public class BlockManager extends Random
{
    private int blockCount;
    private ArrayList<Integer> bag;

    public BlockManager(int blockCount)
    {
        this.blockCount = blockCount;
        bag = new ArrayList<>();
        fillBag();
    }

    public int randomBlockId()
    {
        if (bag.size() == 0)
        {
            fillBag();
        }
        int temp = bag.get(0);
        bag.remove(0);
        return temp;
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

    private void fillBag()
    {
        bag.clear();
        for (int i = 0; i < blockCount; i++)
        {
            bag.add(i);
        }
        Collections.shuffle(bag);
    }

    private void showBag()
    {
        String line = "";
        for (Integer integer : bag)
        {
            line += integer + "|";
        }
        System.out.println(line);
    }
}
