package com.practice.java8.udemy.fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcess {
	public static void main(String[] args) {
		readFile();
	}
	private static void readFile() {
		List<String> fileValues=null;
		try {
			fileValues=	Files.lines(Paths.get("file.txt")).collect(Collectors.toList());
			fileValues=	Files.lines(Paths.get("file.txt")).parallel().collect(Collectors.toList());// To read a huge file use parallel . Parallel use multi core of the processor 

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File content is : "+fileValues);
	}
}
