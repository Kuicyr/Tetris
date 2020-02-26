package mr.sample.blocks;

/* author:
Mateusz Ryciuk
*/

public class OBlock extends Block
{
    private int rotation;

    public OBlock()
    {
        super(4);
        rotation = 0;
        blocks.add(new Position(5, 1));
        blocks.add(new Position(5, 2));
        blocks.add(new Position(6, 1));
        blocks.add(new Position(6, 2));
    }

    @Override
    public void rotate()
    {
    }
}
