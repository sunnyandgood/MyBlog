package com.example.hwllo;

import java.math.BigInteger;
import java.util.Scanner;
public class Zimbabwe {
	private static double count = 0; 
	
	public static void main(String[] args) {
		Zimbabwe zimbabwe = new Zimbabwe();
		double value[] = new double[50];
		char strE[] = new char[100]; 
		int time;
		int m;
		
		System.out.print("The time is: ");
		
		Scanner input = new Scanner(System.in);
		time = input.nextInt();
		System.out.println();
		
		
		for(int i=0;i<time;i++){
			char pre_str[] = new char[100];
			String str = input.next();
			m = input.nextInt();
			
			strE = str.toCharArray();
			pre_str = zimbabwe.copyOf(strE);
			zimbabwe.permutation(strE,0,pre_str,m);
			value[i] = count%1000000007;
			count = 0;
		}
		
		System.out.println("The original strings is: ");
		
		for(int i=0;i<time;i++){
			String str = String.valueOf(value[i]);
			String arr[] = str.split("\\.");
			System.out.println(arr[0]);
		}
	}

	private char[] copyOf(char[] strE) {
		int length = strE.length;
		char[] str = new char[length];
		for(int i=0;i<length;i++){
			str[i] = strE[i];
		}
		return str;
	}

	private void permutation(char[] strE, int begin, char[] pre_str, int m) {
		Zimbabwe zimbabwe = new Zimbabwe();
		if(begin == strE.length){
			if(zimbabwe.compare(pre_str,strE)){
				if(zimbabwe.doubleParseInt(strE, m)){//zimbabwe.bigIntegerParseInt(strE, m)
					count++;
				}
			}
		}else{
			for(int i=begin;i<strE.length;i++){
				if(zimbabwe.isSwap(strE,begin,i)){
					char temp = strE[i];
					strE[i] = strE[begin];
					strE[begin] = temp;
					
					zimbabwe.permutation(strE,begin+1,pre_str,m);
					
					temp = strE[i];
					strE[i] = strE[begin];
					strE[begin] = temp;
				}
			}
		}
	}

	private boolean doubleParseInt(char[] strE,int m) {
		String str = new String(strE);
		double num = Double.valueOf(str);
		if(num%m==0.0)
			return true;
		return false;
	}
	
	private boolean bigIntegerParseInt(char[] strE,int m){
		String str = new String(strE);
		BigInteger bigNum = new BigInteger(str);
		BigInteger bigM = BigInteger.valueOf(m);
		if(bigNum.remainder(bigM) != null)
			return true;
		return false;
	}

	private boolean numParseInt(char[] strE,int m) {
		double value = 0.0;
		for(int i=0;i<strE.length;i++) {
			value = value+strE[i]*Math.pow(10.0,strE.length-1-i);
		}
		if(value%m==0.0)
			return true;
		return false;
	}

	private boolean isSwap(char[] strE, int begin, int end) {
		for(int i=begin;i<end;i++) {
			if(strE[i]==strE[end]) {
				return false;
			}
		}
		return true;
	}

	private boolean compare(char[] str1, char[] str2) {
		String string1 = new String(str1);
		String string2 = new String(str2);
		if(string1.compareTo(string2) > 0){
			return true;
		}
		else {
			return false;
		}
	}
}