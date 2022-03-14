package com.example.basic.util;

import java.net.URL;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageUtil {
    public void save(String path) throws IOException {
        URL url = null;
        url = new URL(path);
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        String fileExt = path.substring(path.lastIndexOf(".") + 1);
        BufferedImage img = ImageIO.read(url);
        ImageIO.write(img, fileExt, new File(fileName));
    }

    public void print(String path){
        System.out.println(path);
    }
}