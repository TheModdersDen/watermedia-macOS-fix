package me.srrapero720.watermedia.core.tools;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.lib720.madgag.gif.fmsware.GifDecoder;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static me.srrapero720.watermedia.WaterMedia.LOGGER;

public class JarTool {
    static final Marker IT = MarkerManager.getMarker("Tools");

    public static boolean copyAsset(ClassLoader loader, String origin, Path dest) {
        try (InputStream is = readResource(loader, origin)) {
            if (is == null) throw new FileNotFoundException("Resource was not found in " + origin);

            File destParent = dest.getParent().toFile();
            if (!destParent.exists() && !destParent.mkdirs()) LOGGER.fatal(IT, "Cannot be created parent directories to {}", dest.toString());
            Files.copy(is, dest, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            LOGGER.fatal(IT, "Failed to extract from (JAR) {} to {} due to unexpected error", origin, dest, e);
        }
        return false;
    }

    public static List<String> readStringList(ClassLoader loader, String path) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(readResource(loader, path)))) {
            result.addAll(new Gson().fromJson(reader, new TypeToken<List<String>>() {}.getType()));
        } catch (Exception e) {
            LOGGER.fatal(IT, "Exception trying to read JSON from {}", path, e);
        }

        return result;
    }

    public static BufferedImage readImage(ClassLoader loader, String path) {
        try (InputStream in = readResource(loader, path)) {
            BufferedImage image = ImageIO.read(in);
            if (image != null) return image;
            else throw new FileNotFoundException("result of BufferedImage was null");
        } catch (Exception e) {
            throw new IllegalStateException("Failed loading BufferedImage from resources", e);
        }
    }

    public static GifDecoder readGif(ClassLoader loader, String path) {
        try (BufferedInputStream in = new BufferedInputStream(readResource(loader, path))) {
            GifDecoder gif = new GifDecoder();
            int status = gif.read(in);
            if (status == GifDecoder.STATUS_OK) return gif;

            throw new IOException("Failed to process GIF - Decoder status: " + status);
        } catch (Exception e) {
            throw new IllegalStateException("Failed loading GIF from resources", e);
        }
    }

    public static InputStream readResource(ClassLoader loader, String source) {
        InputStream is = loader.getResourceAsStream(source);
        if (is == null && source.startsWith("/")) is = loader.getResourceAsStream(source.substring(1));
        return is;
    }
}