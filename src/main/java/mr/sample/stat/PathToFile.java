package mr.sample.stat;

import java.io.File;
import java.io.IOException;

public class PathToFile
{
    public static String getPath()
    {
        String path = "file::";

        try
        {
            path += new File(".").getCanonicalPath();
            path += "\\src\\";
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return path;
    }
}
