package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nav_Bar extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	JButton go_absences, go_scores, go_homeworks, go_exams, go_syllabus;
	Container c;
	JPanel empty_panel,nav_panel;
	StudentsGUI sGUI;
	public Nav_Bar(Container c, StudentsGUI sGUI) {
		// TODO Auto-generated constructor stub
		
		//parametreler bileşen içerisine tanımlandı
		this.c = c;
		this.sGUI = sGUI;
		
		//bileşenler nesne haline getirildi.
		empty_panel = new JPanel();
		nav_panel = new JPanel();
		go_scores = new JButton("Notlarım");
		go_absences = new JButton("Devamsızlıklarım");
		go_homeworks = new JButton("Ödevlerim");
		go_exams = new JButton("Sınavlarım");
		go_syllabus = new JButton("Ders Programım");
		
		//bileşenlere actionlistener eklendi.
		go_absences.addActionListener(this);
		go_scores.addActionListener(this);
		go_homeworks.addActionListener(this);
		go_exams.addActionListener(this);
		go_syllabus.addActionListener(this);
		
		//bileşenleri görünüşü değiştirildi.
		go_absences.setBackground(Color.RED);
		go_scores.setBackground(Color.RED);
		go_homeworks.setBackground(Color.RED);
		go_exams.setBackground(Color.RED);
		go_syllabus.setBackground(Color.RED);
		go_absences.setForeground(Color.WHITE);
		go_scores.setForeground(Color.WHITE);
		go_homeworks.setForeground(Color.WHITE);
		go_exams.setForeground(Color.WHITE);
		go_syllabus.setForeground(Color.WHITE);
		go_absences.setFont(new Font("ARIAL", Font.BOLD, 16));
		go_scores.setFont(new Font("ARIAL", Font.BOLD, 16));
		go_homeworks.setFont(new Font("ARIAL", Font.BOLD, 16));
		go_exams.setFont(new Font("ARIAL", Font.BOLD, 16));
		go_syllabus.setFont(new Font("ARIAL", Font.BOLD, 16));
		
		//panelin özellikleri değiştirildi.
		nav_panel.setLayout(new GridLayout(5,1));
		
		//gerekli bileşenler panele eklendi.
		nav_panel.add(go_scores);
		nav_panel.add(go_absences);
		nav_panel.add(go_homeworks);
		nav_panel.add(go_exams);
		nav_panel.add(go_syllabus);
		
		//frame özellikleri değiştirildi.
		this.setLayout(new BorderLayout());
		
		//gerekli bileşenler frame'e eklendi.
		this.add(nav_panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//tıklanan butona göre gereken nesne görünür hale getirildi, diğer nesneler görünmez hale getirildi.
		if (e.getSource()==go_absences) {
			c.cs.setVisible(false);
			c.a.setVisible(true);
			c.h.setVisible(false);
			c.e.setVisible(false);
			c.s.setVisible(false);
			sGUI.setTitle(sGUI.name + " || Devamsızlıklarım");
		}
		if (e.getSource()==go_scores) {
			c.cs.setVisible(true);
			c.a.setVisible(false);
			c.h.setVisible(false);
			c.e.setVisible(false);
			c.s.setVisible(false);
			sGUI.setTitle(sGUI.name + " || Notlarım");
		}
		if (e.getSource()==go_homeworks) {
			c.cs.setVisible(false);
			c.a.setVisible(false);
			c.h.setVisible(true);
			c.e.setVisible(false);
			c.s.setVisible(false);
			sGUI.setTitle(sGUI.name + " || Ödevlerim");
		}
		if (e.getSource()==go_exams) {
			c.cs.setVisible(false);
			c.a.setVisible(false);
			c.h.setVisible(false);
			c.e.setVisible(true);
			c.s.setVisible(false);
			sGUI.setTitle(sGUI.name + " || Sınav Takvimi");
		}		
		if (e.getSource()==go_syllabus) {
			c.cs.setVisible(false);
			c.a.setVisible(false);
			c.h.setVisible(false);
			c.e.setVisible(false);
			c.s.setVisible(true);
			sGUI.setTitle(sGUI.name + " || Ders Programı");
		}
	}
}
