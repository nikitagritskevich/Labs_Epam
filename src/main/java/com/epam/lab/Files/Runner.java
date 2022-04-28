package com.epam.lab.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Runner {
//"D:\\Projects\\misp-test-automation\\src\\test\\java\\com\\epam\\misp"
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter file path");
            Path path = Path.of(scanner.nextLine());

            FilesVisitor visitor = new FilesVisitor();
            Files.walkFileTree(path, visitor);
            visitor.getTestsList().forEach(s -> System.out.print(s + " "));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
