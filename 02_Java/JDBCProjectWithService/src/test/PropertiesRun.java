package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {
	public static void main(String[] args) {
		// Properties
		/*
		 	Properties 특징 - Map계열 컬렉션 (key-value 형식으로 저장함)
		 	setProperty(key, value)
		 	getProperty(key) : value
		 	
		 	- 주로 외부파일(.properties / .xml)을 사용해서 입출력할 때 보다 편하게 변화해주는 객체
		 */
		/*
		// 파일로 출력하는 것
		Properties prop = new Properties();
		prop.setProperty("C", "INSERT");
		prop.setProperty("R", "SELECT");
		prop.setProperty("U", "UPDATE");
		prop.setProperty("D", "UPDATE");
		
		try {
			prop.store(new FileOutputStream("resources/driver.properties"), "Properties Test");
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "Properties Test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		// 파일로부터 값을 읽어오기
		Properties prop = new Properties();
		/*
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			
			System.out.println(prop.getProperty("insertMember"));
			System.out.println(prop.getProperty("selectList"));
			System.out.println(prop.getProperty("deleteMember"));
			System.out.println(prop.getProperty("updateMember"));
			System.out.println(prop.getProperty("selectByUserName"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
