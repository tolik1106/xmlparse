package com.zhitar.xml.example;

import java.io.*;

public class TestUtil {

    public String getXmlFromFile(String filePath) {
        try (Reader fileReade = new FileReader(getFileFromResources(filePath));
             BufferedReader bufferedReader = new BufferedReader(fileReade)) {
            StringBuilder result = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFileFromResources(String path) {
        return new File(getClass().getClassLoader().getResource(path).getFile());
    }
}
