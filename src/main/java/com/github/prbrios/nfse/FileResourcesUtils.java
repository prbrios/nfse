package com.github.prbrios.nfse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileResourcesUtils {
    private static final Logger LOG = LoggerFactory.getLogger(FileResourcesUtils.class);

    /*
    public static void main(String[] args) throws IOException {

        FileResourcesUtils app = new FileResourcesUtils();

        // Sample 3 - read all files from a resources folder (JAR version)
        try {

            // get paths from src/main/resources/json
            List<Path> result = app.getPathsFromResourceJAR("com");
            for (Path path : result) {
                System.out.println("Path : " + path);

                String filePathInJAR = path.toString();
                // Windows will returns /json/file1.json, cut the first /
                // the correct path should be json/file1.json
                if (filePathInJAR.startsWith("/")) {
                    filePathInJAR = filePathInJAR.substring(1, filePathInJAR.length());
                }

                System.out.println("filePathInJAR : " + filePathInJAR);

                // read a file from resource folder
                InputStream is = app.getFileFromResourceAsStream(filePathInJAR);
                printInputStream(is);
            }

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

    }
    */

    public InputStream getFileFromResourceJAR(String folder, String fileName) {
        Map<String, InputStream> list = this.getFilesFromResourceJAR(folder);
        if (list != null) {

            List<String> a  = list.keySet()
                .stream()
                .filter(e -> e.equals(fileName))
                .collect(Collectors.toList());

            return a.size() > 0 ? list.get(a.get(0)) : null;
        }

        return null;
    }

    public Map<String, InputStream> getFilesFromResourceJAR(String folder) {
        Map<String, InputStream> files = null;

        try {

            List<Path> result = this.getPathsFromResourceJAR(folder);
            for (Path path : result) {
                LOG.trace(String.format("Path: %s", path));

                if (files == null)
                    files = new HashMap<>();

                String filePathInJAR = path.toString();
                if (filePathInJAR.startsWith("/")) {
                    filePathInJAR = filePathInJAR.substring(1, filePathInJAR.length());
                }

                LOG.trace(String.format("filePathInJAR: %s", filePathInJAR));

                files.put(filePathInJAR, this.getFileFromResourceAsStream(filePathInJAR));
            }

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return files;
    }


    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }


    private List<Path> getPathsFromResourceJAR(String folder)
        throws URISyntaxException, IOException {

        folder = (folder == null || folder.trim().equals("")) ? "/" : folder;
        List<Path> result;

        String jarPath = getClass().getProtectionDomain()
            .getCodeSource()
            .getLocation()
            .toURI()
            .getPath();
        LOG.trace(String.format("JAR Path: %s", jarPath));

        URI uri = URI.create("jar:file:" + jarPath);
        try (FileSystem fs = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
            result = Files.walk(fs.getPath(folder))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
        }

        return result;

    }

    // print input stream
    private static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
