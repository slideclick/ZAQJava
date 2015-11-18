package org.mypackage2;
import java.util.*;
import java.sql.*;
import java.util.Date;
import org.mypackage1.Count;
public class TestPackage {
	public static void main(String[] args){
		Date date1= new Date();				// µÈÍ¬ÓÚDate date1 = new java.util.Date();
		Date date2 = new java.sql.Date(0);
		System.out.println(date1);
		System.out.println(date2);
		Count count = new Count();
		count.m1(3, 5);
		System.out.println(count.m2(3, 5));
	}
}

