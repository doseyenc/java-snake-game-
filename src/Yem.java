import java.awt.Graphics;

import javax.swing.JLabel;

public class Yem extends JLabel implements YON {
	int yemGenislik=10;
	int yon;
	public Yem() {
		pozisyonAyarla(40, 60);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(1, 1,getWidth()-2 , getHeight()-2);
	}
	public void pozisyonAyarla(int x,int y) {
		setBounds(x, y, yemGenislik, yemGenislik);
	}
	public void sol() {
		int PosX=getX();
		int PosY=getY();
		PosX-=yemGenislik; 
		setBounds(PosX, PosY, yemGenislik, yemGenislik);
	}
	public void sag() {
		int PosX=getX();
		int PosY=getY();
		PosX+=yemGenislik; 
		setBounds(PosX, PosY, yemGenislik, yemGenislik);
		
	}
	public void yukarý() {
		int PosX=getX();
		int PosY=getY();
		PosY-=yemGenislik; 
		setBounds(PosX, PosY, yemGenislik, yemGenislik);
	}
	public void asagi() {
		int PosX=getX();
		int PosY=getY();
		PosY+=yemGenislik; 
		setBounds(PosX, PosY, yemGenislik, yemGenislik);
	}
	public void yemHareket () {
		yonBelirle();
		if(yon==YON.SOL) {
			sol();
		}
		else if(yon==YON.SAÐ) {
			sag();
		}
		else if(yon==YON.YUKARI) {
			yukarý();
		}
		else if(yon==YON.ASAGI) {
			asagi(); 
		}
	}
	public void yonBelirle() {
		int sayi=(int)(Math.random()*4)+1;
		if(sayi==1) {
			yon=YON.SAÐ;
		}
		else if(sayi==2) {
			yon=YON.SOL;
		}
		else if(sayi==3) {
			yon=YON.ASAGI;
		}
		else if(sayi==4) {
			yon=YON.YUKARI;
		}
	}

	
}
