import javax.swing.JFrame;

public class AnaPencere extends JFrame {
	 
	public AnaPencere() {
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		Yilan yilan=new Yilan();
		add(yilan);
		setVisible(true);
	}
	

}
