package edu.sdse.csvprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



public class CityRecord {
	int id;
	int year;
	String city;
	int pop;
		
		
	public void readAndProcess(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while (br.readLine()!=null) {
				String read = br.readLine();
				String[] items = read.split(",");
				id = Integer.parseInt(items[0]);
				year =  Integer.parseInt(items[1]);
				city = items[2].replace("\"","");
				pop =  Integer.parseInt(items[3]);
				String statement = String.format("Id: %d, Year: %d, City: %s, Population: %d", id,year,city,pop);
				System.out.println(statement);
				}
		}
		catch (Exception e) {
			System.out.println("Nope");
		}}

	public static final void main(String[] args) {
			CityRecord reader = new CityRecord();
				
			File dataDirectory = new File("data/");
			File csvFile = new File(dataDirectory, "Cities.csv");
				
			reader.readAndProcess(csvFile);
			}
}
