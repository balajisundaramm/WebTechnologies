package com.balaji.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArithmetcOperations {
	public static boolean isPrime(int num) {
		if (inputValidation(num)) {
			if (num==2 || num==3) {
				return true;			
			}
			int cond=(int)Math.sqrt(num);
			boolean flag=false;
			for (int j =2; j <=cond; j++) {
				if((num%j)==0) {
					flag=false;
					break;
				}
				else {
					flag=true;
				}
			}
			return flag;
		}
		else {
			return false;
		}
	}

	public static boolean inputValidation(int num) {
		return (num>1)?true:false;
	}

	public static boolean isSquare(int num) {
		int sqrt=(int)Math.sqrt(num);
		return ((sqrt*sqrt)==num)?true:false;
	}
	public static BigDecimal findFactorial(BigDecimal num) {
		if(validateFactorial(num.intValue())) {
			if(num.intValue()==0)
				return BigDecimal.valueOf(0);
			return (num.intValue()==1)?BigDecimal.valueOf(1):num.multiply(findFactorial(num.subtract(BigDecimal.valueOf(1))));
		}
		return BigDecimal.valueOf(-1);
	}
	/**
	 * This method is used to validate the given number for factorial
	 * @param num input value to validate.
	 * @return boolean based on the validation
	 */
	public static boolean validateFactorial(int num) {
		return (num>=0 && num<=5400)?true:false;
	}

	public static String[] multiplicationTable(int num) {
		String[] result=new String[10];
		for (int i = 0; i <result.length; i++) {
			int j=i+1;
			result[i]=num+" * "+j+" = "+(num*j);
		}
		return result;
	}

	public static List<Integer> fibonacci(int num) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(0);
		int first=0,second=1;  
		if(num>=1) {
			list.add(1);
			for (int sum = 0; sum <=num;) {
				sum=first+second;
				if(sum<=num)
					list.add(sum);
				first=second;
				second=sum;
			}
		}
		return list;
	}

}
