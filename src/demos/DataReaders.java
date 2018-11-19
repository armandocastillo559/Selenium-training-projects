package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();

	}

	public static void readCSV() {
		String filename = "C:\\Users\\EatLocal\\Google Drive\\Education\\JAVA\\files\\UserAccounts.csv";
		utilities.CSV.get(filename);
		List <String[]> records = utilities.CSV.get(filename);
		
		
		// iterating through list
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		String filename = "C:\\Users\\EatLocal\\Google Drive\\Education\\JAVA\\files\\UserLogin.xls";
		String[][] data = utilities.Excel.get(filename);
		for (String[] record : data) {
			System.out.println("\nNEW RECORD");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
	
}
