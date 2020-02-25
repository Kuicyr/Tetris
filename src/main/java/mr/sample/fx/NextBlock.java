package mr.sample.fx;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mr.sample.Application;
import mr.sample.blocks.Block;
import mr.sample.blocks.Position;
import mr.sample.logic.BlockManager;

import java.util.ArrayList;

public class NextBlock extends Pane
{
    private ArrayList<Group> blocks;

    public NextBlock()
    {
        int size = 7;
        BlockManager blockManager = new BlockManager(size);
        blocks = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            Block block = blockManager.blockId(i);
            Group group = new Group();
            for (Position position : block.blocks)
            {
                ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/block" +
                        block.id + ".png"),
                        Application.blockSize, Application.blockSize, false, true));
                imageView.setTranslateX((position.x - 2) * Application.blockSize);
                imageView.setTranslateY(position.y * Application.blockSize);
                group.getChildren().add(imageView);
            }
            getChildren().add(group);
            blocks.add(group);
        }
    }

    public void next(int nextBlockId)
    {
        for (Group block : blocks)
        {
            block.setVisible(false);
        }

        blocks.get(nextBlockId).setVisible(true);
    }
}
