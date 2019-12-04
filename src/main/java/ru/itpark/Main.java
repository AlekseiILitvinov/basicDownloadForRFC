package ru.itpark;

import ru.itpark.util.Downloader;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String pathBase = "download\\rfc%d.txt";
        String urlBase = "https://tools.ietf.org/rfc/rfc%d.txt";

        int start = 1;
        int stop = 5;

        if ((args.length > 0) && (args[0] != null)) {
            start = Integer.parseInt(args[0]);
        }
        if ((args.length > 1) && args[1] != null) {
            stop = Integer.parseInt(args[1]);
        }

        for (int i = start; i <= stop; i++) {
            Path pathFile = Paths.get(String.format(pathBase, i));
            if (!Downloader.download(String.format(urlBase, i), pathFile.toString())){
                System.out.println("not downloaded: rfc" + i);
            }
        }

    }
}
