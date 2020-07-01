package Yeni;

import java.util.*;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class grafCizdir extends JFrame {
	
	private static final long serialVersionUID = 1L;
	int genislik;
	int yukseklik;

	ArrayList<Dugum> dugumler;
	ArrayList<Kenar> kenarlar;

	ArrayList<Kapasite> kapasite;

	public grafCizdir() {
		setTitle("GG");
		setOpacity(0.9f);
		setBackground(new Color(250, 128, 114));
		getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		getContentPane().setForeground(new Color(25, 25, 112));
		getContentPane().setBackground(new Color(255, 182, 193)); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dugumler = new ArrayList<Dugum>();
		kenarlar = new ArrayList<Kenar>();
		genislik = 70;
		yukseklik = 70;

		kapasite = new ArrayList<Kapasite>();

	}
//Graf daire ayarý
	public grafCizdir(String dugumIsmi) {
		this.setTitle(dugumIsmi);
		this.setForeground(new Color(150,200,100));
		this.setBackground(new Color(200,200,200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dugumler = new ArrayList<Dugum>();
		kenarlar = new ArrayList<Kenar>();
		genislik = 50;
		yukseklik = 50;
		kapasite = new ArrayList<Kapasite>();

	}

	public void kapasiteEkle(String dugumIsmi, int x, int y) {
		this.setTitle(dugumIsmi);
		kapasite.add(new Kapasite(dugumIsmi, x, y));
		this.repaint();
	}

	public void dugumEkle(String dugumIsmi, int x, int y) {
		
		dugumler.add(new Dugum(dugumIsmi, x, y));
		this.repaint();
	}

	public void kenarEkle(int i, int j) {
		kenarlar.add(new Kenar(i, j));
		this.repaint();
	}

	public class RenkFont extends Applet {
	
		private int kirmizi,yesil,mavi;
		public void init() {
			kirmizi=100;
			yesil=255;
			mavi=125;
		}

	public void paintt(Graphics sd) {
		sd.setColor(new Color(kirmizi,yesil,mavi));
		setBackground(new Color(0,0,255));
		sd.setFont(new Font("TimesRoman",Font.BOLD,36));
		sd.drawString("ABCDEFGHIJKLMNOPQRSTUVWXYZ",50,33);
		showStatus("Su andaki font : "+sd.getFont());
	}
}
	public void paint(Graphics g) { 
		
		FontMetrics f = g.getFontMetrics();
		int Dugumyukseklik = Math.max(yukseklik, f.getHeight());
		
		for (Kenar e : kenarlar) {
			
			g.drawLine(dugumler.get(e.k).a, dugumler.get(e.k).b, dugumler.get(e.l).a, dugumler.get(e.l).b);
		}

		for (Kapasite k : kapasite) {
			g.drawString(k.dugumIsmi, k.a - f.stringWidth(k.dugumIsmi) / 2, k.b + f.getHeight() / 2);
			
		}
		for (Dugum n : dugumler) {
			int Dugumgenislik = Math.max(genislik, f.stringWidth(n.dugumIsmi) + genislik / 2);
			g.setColor(Color.darkGray);
			g.setColor(getForeground());
			g.fillOval(n.a - Dugumgenislik / 2, n.b - Dugumyukseklik / 2, Dugumgenislik, Dugumyukseklik);
			g.setColor(Color.BLACK);
			g.drawOval(n.a - Dugumgenislik / 2, n.b - Dugumyukseklik / 2, Dugumgenislik, Dugumyukseklik);
			g.drawString(n.dugumIsmi, n.a - f.stringWidth(n.dugumIsmi) / 2, n.b + f.getHeight() / 2);
		}
		
	}
}
