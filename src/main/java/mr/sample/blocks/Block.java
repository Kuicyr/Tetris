package mr.sample.blocks;

import java.util.ArrayList;

/* author:
Mateusz Ryciuk
*/

public abstract class Block
{
    public int id;
    public ArrayList<Position> blocks;

    public Block()
    {
        blocks = new ArrayList<>();
        id = 0;
    }

    public Block(int id)
    {
        blocks = new ArrayList<>();
        this.id = id;
    }

    public abstract void rotate();

    public void down()
    {
        for (Position block : blocks)
        {
            block.y++;
        }
    }

    public void left()
    {
        for (Position block : blocks)
        {
            block.x--;
        }
    }

    public void right()
    {
        for (Position block : blocks)
        {
            block.x++;
        }
    }
}
