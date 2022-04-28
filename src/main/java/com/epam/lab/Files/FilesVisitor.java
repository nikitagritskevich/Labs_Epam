package com.epam.lab.Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FilesVisitor extends SimpleFileVisitor<Path> {

    private List<Integer> testsList;
    private final String annotation = "@Test";
    private final Pattern pattern = Pattern.compile("[1-9]{1,}");
    private List<String> tempList;

    public FilesVisitor() {
        testsList = new ArrayList<>();
        tempList = new ArrayList<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        try (FileReader fileReader = new FileReader(file.toFile());
            BufferedReader reader = new BufferedReader(fileReader)) {
            tempList.addAll(reader.lines()
                .filter(lines -> lines.contains(annotation))
                .collect(Collectors.toList()));

            getNumbersTest(tempList);
            testsList = distinctAndSortList(testsList);
            tempList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Integer> getTestsList() {
        return testsList;
    }

    private void getNumbersTest(List<String> tempList) {
        for (int i = 0; i < tempList.size(); i++) {
            Matcher matcher = pattern.matcher(tempList.get(i));
            while (matcher.find()) {
                testsList.add(Integer.parseInt(matcher.group()));
            }
        }
    }

    private List<Integer> distinctAndSortList(List<Integer> list) {
        return list.stream().distinct().sorted().collect(Collectors.toList());
    }
}
