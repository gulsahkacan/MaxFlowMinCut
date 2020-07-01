package Yeni;

public class Dugum {
	
	/*
	 * dugum ozellikleri
	 * a,b -> dugumun konumu
	 * */
	int a, b;
	String dugumIsmi;

	//parametreli yapici metot
	public Dugum(String mydugumIsmi, int myX, int myY) {
		a = myX;
		b = myY;
		dugumIsmi = mydugumIsmi;
	}
}