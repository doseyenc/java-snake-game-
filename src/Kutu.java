import java.awt.Graphics;

import javax.swing.JLabel;

public class Kutu extends JLabel {
	int genislik=10;
	public int yon=YON.YUKARI;
	public Kutu() {
		setBounds(150, 150, genislik, genislik);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(1, 1,getWidth()-2 , getHeight()-2);
	}
	public void sol() {
		int PosX=getX();
		int PosY=getY();
		PosX-=genislik; 
		setBounds(PosX, PosY, genislik, genislik);
	}
	public void sag() {
		int PosX=getX();
		int PosY=getY();
		PosX+=genislik; 
		setBounds(PosX, PosY, genislik, genislik);
		
	}
	public void yukarý() {
		int PosX=getX();
		int PosY=getY();
		PosY-=genislik; 
		setBounds(PosX, PosY, genislik, genislik);
	}
	public void asagi() {
		int PosX=getX();
		int PosY=getY();
		PosY+=genislik; 
		setBounds(PosX, PosY, genislik, genislik);
	}
	public void Hareket () {
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
	public Kutu KutuYap() {
			Kutu kutu=new Kutu();
				int x=getX();
				int y=getY();
				kutu.setBounds(x, y, genislik, genislik);
				kutu.yon=-yon;
				kutu.Hareket();
				kutu.yon=yon;
				return kutu;
			
		
	}

}
