package utilities;

import java.io.File;

public class Utility {

	public static String getProjectDirectory() {
		File currDir= new File("");
		String path = currDir.getAbsolutePath();
		System.out.println("path-->"+path);
		return path;
	}
	
	public static void sleepforTime(int sleepTimeInMiliseconds) {
		try {
			Thread.sleep(sleepTimeInMiliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getProjectDirectory();
	}
}
