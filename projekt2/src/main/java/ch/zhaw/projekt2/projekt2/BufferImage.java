package ch.zhaw.projekt2.projekt2;
import ai.djl.modality.cv.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferImage {
    public static BufferedImage bufferImage(Image image) throws IOException {
        BufferedImage bufferedImage = ImageUtils.toBufferedImage(image);

        return bufferedImage;
    }

    public static void saveImage(BufferedImage bufferedImage, String outputPath, String format) throws IOException {
        File outputFile = new File(outputPath);
        ImageIO.write(bufferedImage, format, outputFile);
    }
}
