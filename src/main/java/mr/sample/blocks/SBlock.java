package mr.sample.blocks;

import java.util.ArrayList;

/* author:
Mateusz Ryciuk
*/

public class SBlock extends Block
{
    private int rotation;

    public SBlock()
    {
        super(5);
        rotation = 2;
        blocks.add(new Position(6, 2));
        blocks.add(new Position(6, 1));
        blocks.add(new Position(5, 2));
        blocks.add(new Position(7, 1));
    }

    @Override
    public void rotate()
    {
        Position position = blocks.get(0);
        ArrayList<Position> rotated = new ArrayList<>();
        switch (rotation)
        {
            case 0:
            {
                rotated.add(new Position(position.x, position.y));
                rotated.add(new Position(position.x - 1, position.y - 1));
                rotated.add(new Position(position.x - 1, position.y));
                rotated.add(new Position(position.x, position.y + 1));
                break;
            }
            case 1:
            {
                rotated.add(new Position(position.x, position.y));
                rotated.add(new Position(position.x - 1, position.y));
                rotated.add(new Position(position.x, position.y - 1));
                rotated.add(new Position(position.x + 1, position.y - 1));
                break;
            }
            case 2:
            {
                rotated.add(new Position(position.x, position.y));
                rotated.add(new Position(position.x, position.y - 1));
                rotated.add(new Position(position.x + 1, position.y));
                rotated.add(new Position(position.x + 1, position.y + 1));
                break;
            }
            case 3:
            {
                rotated.add(new Position(position.x, position.y));
                rotated.add(new Position(position.x, position.y + 1));
                rotated.add(new Position(position.x - 1, position.y + 1));
                rotated.add(new Position(position.x + 1, position.y));
                break;
            }
        }

        boolean correct = true;
        for (Position rotatedPosition : rotated)
        {
            if (rotatedPosition.x > 10 || rotatedPosition.y > 20 || rotatedPosition.y < 1 || rotatedPosition.x < 1)
            {
                correct = false;
                break;
            }
        }

        if (correct)
        {
            blocks.clear();
            blocks = rotated;
            rotation++;
            rotation %= 4;
        }
    }
}
