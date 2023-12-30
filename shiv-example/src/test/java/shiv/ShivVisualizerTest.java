package shiv;

import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxRectangle;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;
import shiv.Shiv;
import shiv.basicexample.deps.CoreModule;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class ShivVisualizerTest {


    @Test
    public void analyzeDependenciesTest(@TempDir(cleanup = CleanupMode.NEVER) Path out) throws IOException {
        Shiv shiv = Shiv.provide(new CoreModule());

        Graph g = shiv.rawAccess(Graph.class);
        JGraphXAdapter adapter = new JGraphXAdapter(g);
        var bi = mxCellRenderer.createBufferedImage(adapter, null, 5, Color.WHITE, true, new mxRectangle(new Rectangle(1000, 1000)));
        ImageIO.write(bi, "png", out.resolve("output.png").toFile());


    }

}
