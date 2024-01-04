import javax.swing.*;

public class Frame extends JFrame {
	
	public Frame() {
		
		this.setTitle("ABC University");
		this.add(new LogInPanel());
		this.setSize(750, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
