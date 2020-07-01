package Yeni;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class appGrafCizdir extends JFrame{
    

	public static void main(String[] args) {
		
	grafCizdir frame = new grafCizdir("150201124-180201062");
	frame.setTitle("180201062-1502010124");
	frame.setSize(1024,768);
	frame.setBackground(new Color(100,150,100));
	frame.setForeground(new Color(100,150,100));
	
	int y;
	int muslukSayisi;
	//int gecici=0;
	boolean donen=true;
	
	System.out.print("Musluk Sayisini Giriniz :");
	Scanner giris = new Scanner(System.in);
	muslukSayisi = giris.nextInt();
	System.out.println("\n->MATRÝS\n->Graflarýn birbiri ile olan iliþkisini yani baðlantýlarýný\n->Aralarýnda ki baðlantýlarýn kapasitelerini belirtir");
	System.out.println("\nKomþuluk matrisini giriniz : ");
	int[][] komsulukMatrisi = new int[muslukSayisi][muslukSayisi];

	for(int degisken=0;degisken<muslukSayisi;degisken++) {
		for(int a=0;a<muslukSayisi;a++) {
			
			komsulukMatrisi[degisken][a]=giris.nextInt();
            	
		}
	}
	
	System.out.println("\n\n");
	frame.setVisible(true);
	int degisken=0;
	int degisken1=0;
	
	for(degisken=0;degisken<muslukSayisi;degisken++) {
		
			for(degisken1=0;degisken1<muslukSayisi;degisken1++) {
				System.out.print(komsulukMatrisi[degisken][degisken1]+ "     ");
			}
			System.out.print("\n");
	}
	System.out.println("\n\n");
	
	/*
	for(degisken=0;degisken<muslukSayisi;degisken++) {
		
		for(degisken1=0;degisken1<muslukSayisi;degisken1++) {
			if(komsulukMatrisi[degisken][degisken1] == 0 && komsulukMatrisi[degisken1][degisken] == 0) {
				System.out.println((degisken+1 ) + " numaralý musluk ile " + (degisken1+1)   + " numaralý musluklar arasýnda baðlantý yoktur.");
			}
		}
		System.out.print("\n");
}
*/
	

	int i;
	int x=200;
	
	//Yazýsý ile musluk ekle
	for(i=0;i<muslukSayisi;i++) {
		if(i%2==0) {
			y=200;
		}else{
			y=450;
		}
		//frame.setFont(Font.BOLD);
		frame.dugumEkle("Musluk" + i, x,y);
		//frame.setForeground(Color.white);
		//frame.setBackground(Color.white);
		x+=75;
	}
	
	//Kenar ekleme durumu - li olursa bu fonksiyonda degistirebilirsin
	int k;
	int degisken4=0;
	for(k=0;k<muslukSayisi;k++) {
		if(donen == true) {
			for(degisken4=0; degisken4<muslukSayisi;degisken4++) {
				if(komsulukMatrisi[k][degisken4]>0) {
					x=k;
					y=degisken4;
					frame.kenarEkle(x,y);
					frame.kapasiteEkle(String.valueOf(komsulukMatrisi[k][degisken4]), k, degisken4);;
				}
				
			}
		}	
	}
	
	System.out.print("Kaynak muslugunu giriniz : ");
	int source = giris.nextInt();
	source--;
	System.out.print("Hedef muslugunu giriniz : ");
	int sink = giris.nextInt();
	sink--;
	
	final JFrame framee = new JFrame("150201124_180201062");
	JTextArea txtrMaxAks = new JTextArea(10, 20);
	txtrMaxAks.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
	txtrMaxAks.setBackground(new Color(230, 230, 250));
	txtrMaxAks.setEditable(false);
	

    JScrollPane sp = new JScrollPane(txtrMaxAks);
    framee.setSize(800,600);
    framee.getContentPane().add(sp);
    framee.setVisible(true);	
	
	LinkedList<Integer> cut = new LinkedList<>();
	FordFulkerson fordFulkerson = new FordFulkerson(muslukSayisi,cut);
    
    
	txtrMaxAks.setText("Secilen musluklardan olusabilecek\n\n" );
	System.out.println();
	int makakistuttunmu = fordFulkerson.FordFulkerson(komsulukMatrisi, source,sink) ;
	System.out.println("Maksimum Akýþ : " + fordFulkerson.FordFulkerson(komsulukMatrisi, source,sink ));
	System.out.println("___________________________________\n");
	txtrMaxAks.setText(txtrMaxAks.getText() + "Maksimum Akýþ :  " + fordFulkerson.FordFulkerson(komsulukMatrisi, source,sink ) + "\n" );
    Iterator<Integer> itrcut = cut.iterator();
	Iterator<Integer> tutAnamTut; 
	System.out.println("Minimum Kesme");
	System.out.println("___________________________________\n");
	System.out.println("Sature olmak : Graf üzerinde bulunan kapasiteli kenarlarýn kapasitelerinin bitmesi durumudur.\nÖrnek : Borunun kapasitesi kadar üzerinden akýþ saðlanmasý halinde oluþan durum.\n");
	txtrMaxAks.setText(txtrMaxAks.getText() + "Minimum Kesme" + "\n" );
	int cutsum=0;
	int yazdir;
	int yazdir1;
	int tuttunMu;
	for(;itrcut.hasNext();) {
		tutAnamTut=itrcut;
		yazdir=itrcut.next();
		tuttunMu = yazdir;
		yazdir1=itrcut.next();
		System.out.println("\n");
		//System.out.println("\n"+"yazdir : "+yazdir+"\n"+"yazdir1 : "+yazdir1);
		System.out.println((yazdir+1)+"--|----|--"+(yazdir1+1));
		txtrMaxAks.setText(txtrMaxAks.getText() + (yazdir+1)+"--|----|--"+ (yazdir1+1) + "\n");
		cutsum= cutsum + tutAnamTut.next();
		if (cutsum == makakistuttunmu)
			break;		
		}
	}
}
