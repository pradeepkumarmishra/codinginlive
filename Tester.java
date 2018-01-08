import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {

	public static void main(String[] args) {
		
		File f = new File("C://Users/mipradee/Documents"); // current directory

		//FilenameFilter textFilter = 

		File[] files = f.listFiles((File dir,String name)-> {
			String lowercaseName = name.toLowerCase();
			if (lowercaseName.endsWith(".txt")) {
				return true;
			} else {
				return false;
			}
	});
		//System.out.println(files.length);
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.print("directory:");
			} else {
				System.out.print("     file:");
			}
			try {
				System.out.println(file.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*
		FileReader fr;
		List<String> searchText = new ArrayList();
		// Scanner sc;
		try {
			fr = new FileReader(new File("C://Users/mipradee/Documents/a1.txt"));
			File files = new File("C://Users/mipradee/Documents");
			FilenameFilter fileNamesFilter = new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return name.matches("a.");
				}
			};
			
			String fNames[]=files.list(fileNamesFilter);
			System.out.println(fNames.length);
			
			//System.out.println(files.listFiles(fileNamesFilter));
				for(File file:files.listFiles(fileNamesFilter)){
					System.out.println(file.getName());
				}
				
			
			Scanner sc = new Scanner(fr);
			while (sc.hasNext()) {
				Pattern pattern = Pattern.compile("test");
				Matcher mt = pattern.matcher(sc.next());

				while (mt.find()) {
					searchText.add(mt.group());
					//System.out.println("starts at " + mt.start() + ": " + mt.group() + ": ends at " + mt.end());

				}

			}
			System.out.println(searchText.size());
		} catch (IOException e) {

		} finally {
			// sc.close();
		}
	*/}

}
