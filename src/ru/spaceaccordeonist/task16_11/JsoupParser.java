package ru.spaceaccordeonist.task16_11;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsoupParser {
    public static final String SRC_URL = "https://www.mirea.ru/";
    public static final String OUTPUT_DIR = "out_img";
    public static void main(String[] args) {
        ArrayList<String> elementUrls = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(SRC_URL).get();
            doc.select("img").stream().forEach(element -> {
                if(!element.attr("abs:src").equals("")) {
                    elementUrls.add(element.attr("abs:src"));
                    System.out.println(element.attr("abs:src"));
                } else {
                    elementUrls.add(element.attr("abs:data-src"));
                    System.out.println(element.attr("abs:data-src"));
                }
            });

            for (String imgUrl: elementUrls) {
                URL urlImage = new URL(imgUrl);

                byte[] buffer = new byte[4096];
                int n = -1;

                String fileName = imgUrl.split("/")[imgUrl.split("/").length - 1];
                if(fileName.endsWith(".png")
                        || fileName.endsWith(".jpg")
                        || fileName.endsWith(".jpeg")) {
                    try (InputStream in = urlImage.openStream();
                         OutputStream os =
                                 new FileOutputStream(Path.of(OUTPUT_DIR + "/" + fileName).toFile(), false);) {
                        while ((n = in.read(buffer)) != -1) {
                            os.write(buffer, 0, n);
                        }
                        System.out.println("Image saved");
                    } catch (IOException | InvalidPathException e) {
                        System.out.println("Saving error!");
                    }
                } else {
                    System.out.println("Not img file!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
