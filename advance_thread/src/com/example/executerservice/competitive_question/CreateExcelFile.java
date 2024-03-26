package com.example.executerservice.competitive_question;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FileCreateTask implements Callable<String>{

	List<String[]> datas ;
	FileCreateTask (List<String[]> datas ){
		this.datas= datas;
	}
	@Override
	public String call() throws Exception {
		System.out.println("Inside Call with Data : "+datas);
		fileWriter(datas);
		return "File has been created...!! by : "+Thread.currentThread();
	}
	private void fileWriter(List<String[]> datas) {

		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		String fileName = "file.csv";
		try {
			 fileWriter = new FileWriter(fileName);
			 printWriter = new PrintWriter(fileWriter);
			 createFileHeader(printWriter);
			 for (String[] strings : datas) {
				String content = strings[0]+","+strings[1]+","+strings[2];
				printWriter.println(content);
			}
			 
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileWriter.close();
				printWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void createFileHeader(PrintWriter printWriter) {

		String header = "Name ,Location ,Age";
		printWriter.println(header);
	}
}

public class CreateExcelFile {
	public static void main(String[] args) {

		List<String[]> datas = new ArrayList<>();
		String [] data = {"Sudhir" ,"Banglore" , "30"};
		String [] data2 = {"Gaurav" ,"Patna" , "30"};
		String [] data3 = {"Nikhil" ,"Gorari" , "31"};
		datas.add(data);
		datas.add(data2);
		datas.add(data3);
		
		List<String[]> datas2 = new ArrayList<>();
		String [] data11 = {"Jon" ,"US" , "30"};
		String [] data22 = {"RON" ,"UK" , "30"};
		String [] data33 = {"Son" ,"California" , "6"};
		datas2.add(data11);
		datas2.add(data22);
		datas2.add(data33);

		ExecutorService es =	Executors.newFixedThreadPool(5);

		FileCreateTask task = new FileCreateTask(datas);
		FileCreateTask task2 = new FileCreateTask(datas2);
		Future<String> future= es.submit(task);
		Future<String> future2= es.submit(task2); 
		
		
		try {
			System.out.println("Finally " + future.get());
			System.out.println("Finally " + future2.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		es.shutdown();
		
	}

}
