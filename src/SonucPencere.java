import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SonucPencere extends JFrame {
	public SonucPencere() {
		setSize(400,200);
		JLabel label1=new JLabel("Geçen süre= "+(Yilan.bitis-Yilan.baslangic)/60+" sn");
		JLabel label2=new JLabel("       Yenilen yem sayisi= "+Yilan.counter);
		setLayout(new GridLayout(1,1));
		add(label2);
		add(label1);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
