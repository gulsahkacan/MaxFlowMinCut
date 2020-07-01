package Yeni;

public class Kapasite {
	
	/*
	 * kapasite ozellikleri
	 * a,b -> kapasitenin konumu
	 * */
	int a, b;
	String dugumIsmi;
	
	//parametreli yapici metot
	public Kapasite(String mydugumIsmi, int myX, int myY) {
		a = myX;
		b = myY;
		dugumIsmi = mydugumIsmi;
	}
}