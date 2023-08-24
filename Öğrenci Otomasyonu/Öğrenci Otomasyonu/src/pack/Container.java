package pack;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class Container extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	Course_Score cs;
	Absences a;
	Homeworks h;
	Exams e;
	Syllabus s;
	public Container() {}
	public Container(String number) {
		// TODO Auto-generated constructor stub
		//bileşenler nesne haline getitildi.
		cs = new Course_Score(number);
		a = new Absences(number);
		h = new Homeworks(number);
		e = new Exams(number);
		s = new Syllabus(number);
		
		//Panel özellikleri girildi.
		this.setLayout(new CardLayout());
		
		//gerekli bileşenler panele eklendi.
		this.add(cs);
		this.add(a);
		this.add(h);
		this.add(e);
		this.add(s);
	}
}
