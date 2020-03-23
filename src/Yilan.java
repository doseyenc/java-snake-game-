import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import javax.swing.JLabel;

public class Yilan extends JLabel {
	boolean flag=true;
	static int counter=0;
	Kutu kutuBas=new Kutu(); 
	ArrayList<Kutu> kutulArrayList=new ArrayList<>();
	Random random=null;
	Yem yem=new Yem();
	static long bitis;
	static long baslangic;
	public Yilan() {
		addKeyListener(new KlavyeKontrol());
		random=new Random(System.currentTimeMillis());
		ThreadDeneme threadDeneme=new ThreadDeneme();
		threadDeneme.yýlanThread.start();
		//threadDeneme.yemThread.start();
		baslangic=System.currentTimeMillis();
		setFocusable(true);
		add(kutuBas);
		add(yem);
		kutulArrayList.add(kutuBas);
		for(int i=0;i<5;i++) {
			addTail();
		}
	}

	public void Hareket2() {
		for(int i=kutulArrayList.size()-1;i>0;i--) {
			Kutu prevKutu=kutulArrayList.get(i-1);
			Kutu nextKutu=kutulArrayList.get(i);
			kutulArrayList.get(i).Hareket();
			nextKutu.yon=prevKutu.yon;
		}
		kutuBas.Hareket();
	}
	public boolean hareketDrumalýMý() {
		int width=getWidth();
		int height=getHeight();
		if(kutuBas.getX()<=5||kutuBas.getX()+kutuBas.genislik>=width||kutuBas.getY()<=5||kutuBas.getY()+kutuBas.genislik>=height) {
			return true;
		}
		for(int i=1;i<kutulArrayList.size();i++) {
			int X=kutulArrayList.get(i).getX();
			int Y=kutulArrayList.get(i).getY();
				if((X==kutuBas.getX())&&(Y==kutuBas.getY())) {
					return true;
				}
		}
		if((yem.getX()==kutuBas.getX())&&(yem.getY()==kutuBas.getY())){
			addTail();
			addYem();
			counter++;
		}
		return false;
	}
	public void addTail() {
		 Kutu k=kutulArrayList.get(kutulArrayList.size()-1).KutuYap();
		 kutulArrayList.add(k);
		 add(k);
	}
	public void addYem() {
		int Width=getWidth()-yem.yemGenislik;
		int Height=getHeight()-yem.yemGenislik;
		int randomX=Math.abs(random.nextInt())%Width;
		int randomY=Math.abs(random.nextInt())%Height;
		randomX=randomX-randomX%10;
		randomY=randomY-randomY%10;
		
			for(int i=0;i<kutulArrayList.size();i++) {
				if(randomX==kutulArrayList.get(i).getX()&&randomY==kutulArrayList.get(i).getY()) {
					addYem();
					return;
				}
			}
		yem.pozisyonAyarla(randomX, randomY);
		
		
	}

class KlavyeKontrol implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(kutuBas.yon!=YON.SAÐ) {
				kutuBas.yon=YON.SOL;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(kutuBas.yon!=YON.SOL) {
				kutuBas.yon=YON.SAÐ;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
			
			if(kutuBas.yon!=YON.ASAGI) {
				kutuBas.yon=YON.YUKARI;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(kutuBas.yon!=YON.YUKARI) {
				kutuBas.yon=YON.ASAGI;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class ThreadDeneme extends Thread{
	Thread yýlanThread=new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(flag) {
				Hareket2();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(hareketDrumalýMý()) {
					bitis=System.currentTimeMillis();
					flag=false;
					new SonucPencere();
				}
			}
		}
	});
	/*Thread yemThread=new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (flag) {
			yem.yemHareket();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
	});*/
}

}