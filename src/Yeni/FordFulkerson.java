package Yeni;

import java.util.*;
import java.util.LinkedList;

class FordFulkerson
{
	
	int dugumSayisi;
	LinkedList<Integer> kesme = new LinkedList<>();
	public FordFulkerson(int dugumSayisi, LinkedList<Integer> kesme) {
		this.dugumSayisi = dugumSayisi;
		this.kesme = kesme;
	}

	boolean bfs(int residualGraph[][], int s, int t, int aile[])
	{
		boolean ziyaretEdildi[] = new boolean[dugumSayisi];
		for(int i=0; i<dugumSayisi; ++i) { //Burayý deðiþtirdim i 0 dý eþittir yoktu
			ziyaretEdildi[i]=false;
		}
			
		LinkedList<Integer> kuyruk = new LinkedList<Integer>();
		kuyruk.add(s);
		ziyaretEdildi[s] = true;
		aile[s]=-1;

		int ex1=0;
		while (kuyruk.size()!=0)
		{
			int ex = kuyruk.poll();
				for (int h=0; h<dugumSayisi; h++) {
					if (ziyaretEdildi[h]==false && residualGraph[ex][h] > 0) {
					kuyruk.add(h);
					aile[h] = ex;
					ziyaretEdildi[h] = true;
					}
				}
		}

		return (ziyaretEdildi[t] == true);
	}

	int FordFulkerson(int graph[][], int s, int t)
	{
		int k=0;
		int h=0;
		int sonucGraph[][] = new int[dugumSayisi][dugumSayisi];
		//sonucGraph[k][h] = graph[k][h];
		
		for (k = 0; k < dugumSayisi; k++) {
			for (h = 0; h < dugumSayisi; h++) {
				sonucGraph[k][h] = graph[k][h];
			}
		}
		int aile[] = new int[dugumSayisi];

		int max_flow = 0; 
		while (bfs(sonucGraph, s, t, aile))
		{
			int yol_akis = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
			
	        LinkedList<Integer> path = new LinkedList<>();
			path.add(t);
			
			int a= Integer.MAX_VALUE;
			int b= Integer.MAX_VALUE;
			int c= Integer.MAX_VALUE;
			for (h=t; h!=s; h=aile[h])
			{
				k = aile[h];
				path.add(k);
				if(sonucGraph[k][h]<min){
			    min = sonucGraph[k][h];
				a= k;
				b= h;
				c= sonucGraph[k][h];
				}

				yol_akis = Math.min(yol_akis, sonucGraph[k][h]);
			}
			
			kesme.add(a);
			kesme.add(b);
			kesme.add(c);
			
			for (h=t; h != s; h=aile[h])
			{
				k = aile[h];
				sonucGraph[k][h] -= yol_akis;
				sonucGraph[h][k] += yol_akis;
			}
			max_flow += yol_akis;
		}
		return max_flow;
	}
}
