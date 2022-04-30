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
    private final String idFormat = "%s*[0-9,.]+";
    private Pattern idPattern;
    private final Pattern descriptionPattern = Pattern.compile("description\\s*=\\s*\"\\w*-[0-9,. ]+.+[0-9]");
    private List<String> tempList;
    private String testTdSeparator;

    public FilesVisitor(String testIdSeparator) {
        this.testsList = new ArrayList<>();
        this.tempList = new ArrayList<>();
        this.testTdSeparator = testIdSeparator;
        this.idPattern = Pattern.compile(String.format(idFormat, testIdSeparator));
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
            Matcher descriptionMatcher = descriptionPattern.matcher(tempList.get(i));
            while(descriptionMatcher.find()){
                tempList.set(i, descriptionMatcher.group().replaceAll("description\\s+=\\s+\"", ""));
            }

                Matcher matcher = idPattern.matcher(tempList.get(i));
            while (matcher.find()) {
                String[] ids = matcher.group().split(",");
                for (String element : ids) {
                    String result = element.replaceAll(testTdSeparator, "");
                    testsList.add(Integer.parseInt(result));
                }
            }
        }
    }

    private List<Integer> distinctAndSortList(List<Integer> list) {
        return list.stream().distinct().sorted().collect(Collectors.toList());
    }
}
