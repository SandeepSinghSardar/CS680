package edu.umb.cs680.hw2;

public class Singleton {
		
		private Singleton() {
			System.out.println("Singleton No Errors");
		}
		private static Singleton instance = null;
		
		public static Singleton getInstance() {
			if(instance == null)
				instance = new Singleton();
			return instance;
				
			}		
	
		
	public static void main(String[] args) {
	
		System.out.println("Excuted Singleton");
	
	}
	}