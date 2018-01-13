/*@Author:Pradeep Mishra
 * 
 * this program finds word "test" from .txt file available inside folder and its sub folder using FORK-JOIN Pool
 * 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearcherUsingForkJoinPool {

	public static void main(String[] args) {
		
		ForkJoinPool pool=new ForkJoinPool();
		WorkSearchUtility ws=new WorkSearchUtility("C://Users/mipradee/Documents/testing","txt");
		pool.execute(ws);
		List<String> resultList=ws.join();
		System.out.println("Total test word found is:"+resultList.size());
	}

}

class WorkSearchUtility extends RecursiveTask<List<String>>{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String path;
	private String ext;
	
	public WorkSearchUtility(String path,String extension) {
		this.path=path;
		this.ext=extension;
	}

	@Override
	protected List<String> compute() {
		List<String> results=new ArrayList<>();
		
		List<WorkSearchUtility> subList=new ArrayList<>();
		
		File file=new File(this.path);
		File []files=file.listFiles();
		
		for(File f:files){
			if(f.isDirectory()){
				
				WorkSearchUtility ws=new WorkSearchUtility(f.getAbsolutePath(),ext);
				ws.fork();
				subList.add(ws);
			}else{
				
			   if(f.getName().endsWith(ext)){
				try {
					Scanner sc=new Scanner(f);
					while(sc.hasNext()){
						Pattern pattern=Pattern.compile("test");
						Matcher mat=pattern.matcher(sc.next());
						while(mat.find()){
							results.add(mat.group());
						}
					}
				  	sc.close();
				} catch (FileNotFoundException e) {
					System.out.println("exception came while scanning file");
				}
				
				
			 }
			}
		}
		
		for(WorkSearchUtility ws:subList){
			results.addAll(ws.join());
		}
		
		return results;
	}
	
}
