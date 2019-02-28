package com.group14.ResourceLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {
    private HashMap<String, BufferedImage> images;

    public ImageLoader() {
        images = new HashMap<>();
    }

    // Returns true if image was successfully loaded.
    public boolean loadFromFile(String filename, String key) {
        boolean success = false;
        BufferedImage image;

        try {
            image = ImageIO.read(new File("pics/" + filename));
        } catch (IOException e) {
            image = null;
        }

        if (image != null) {
            images.put(key, image);
            success = true;
        }

        return success;
    }

    public BufferedImage getImage(String key) {
        return images.get(key);
    }
}