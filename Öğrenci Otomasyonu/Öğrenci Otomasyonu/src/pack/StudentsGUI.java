package pack;


import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class StudentsGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	String number,name;
	Container c;
	Nav_Bar nb;
	

	public StudentsGUI() {}
	public StudentsGUI(String Name, String Surname, String number) {
		//parametreler bileşenlere tanımlandı.
		this.name = Name + " " + Surname;
		this.number = number;
		this.setTitle(this.name + " || Notlarım");
		
		//kalan bileşenler nesne haline getirildi.
		Image icon = new ImageIcon("uni_icon.png").getImage();
		c = new Container(this.number);
		nb = new Nav_Bar(c,this);
		
		//frame özellikleri girildi.
		this.setSize(800,200);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//gerekli bileşenler frame'e eklendi.
		this.setIconImage(icon);  
		this.add(nb,BorderLayout.WEST);
		this.add(c, BorderLayout.CENTER);
	}
}
