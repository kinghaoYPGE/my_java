package com.springboot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class DemoApplicationTests {


	private static int aMethod(int i)throws Exception{
		try{
			return i / 10;
		}
		catch (Exception ex){
			throw new Exception("exception in a Method");
		} finally{
			System.out.printf("finally");
		}
	}
	public static void main(String [] args){
        long round = Math.round(7.25);
        System.out.println(round);

    }

}
