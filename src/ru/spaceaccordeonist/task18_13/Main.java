package ru.spaceaccordeonist.task18_13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main
{
    static final String srcFolder = "images";
    static final String dstFolder = "dst";
    public static void main(String[] args)
    {

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        System.out.println("Which compression do you need?");
        int compressionRate;
        try {
            compressionRate = Integer.parseInt(new Scanner(System.in).next());
        } catch (Exception ex){
            System.err.print("Error! Incorrect input");
            return;
        }

        int limit = Runtime.getRuntime().availableProcessors();
        if(limit != 0 && files != null && files.length != 0) {
            System.out.printf("Now available %d processors\n", limit);
            for (int i = 0; i < limit; i++) {
                File[] temp = new File[files.length / limit];
                System.arraycopy(files, i * temp.length, temp, 0, temp.length);
                new Thread(new CompressingTask(temp, compressionRate)).start();
            }
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }

    public static void compressImage(File file , int compressRate){
        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }

            BufferedImage image = ImageIO.read(file);
            if(image == null) {
                return;
            }

            int newWidth = image.getWidth() / compressRate;
            int newHeight = (int) Math.round(
                    image.getHeight() / (image.getWidth() / (double) newWidth)
            );
            BufferedImage newImage = new BufferedImage(
                    newWidth, newHeight, BufferedImage.TYPE_INT_RGB
            );

            int widthStep = image.getWidth() / newWidth;
            int heightStep = image.getHeight() / newHeight;

            for (int x = 0; x < newWidth; x++)
            {
                for (int y = 0; y < newHeight; y++) {
                    int rgb = image.getRGB(x * widthStep, y * heightStep);
                    newImage.setRGB(x, y, rgb);
                }
            }

            File newFile = new File(dstFolder + "/" + file.getName());
            ImageIO.write(newImage, "jpg", newFile);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
