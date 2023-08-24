package pack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class LoginGUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	String number;
	JTextField numT;
	JLabel number_label,student_icon;
	JButton login;
	JPanel Login_Panel, log_, icon_panel, empty_panel,empty_panel2,empty_panel3,empty_panel4;
	
	public LoginGUI() {
		//bileşenler nesne haline getirildi.
		Image icon = new ImageIcon("uni_icon.png").getImage();
		empty_panel = new JPanel();
		empty_panel2 = new JPanel();
		empty_panel3 = new JPanel();
		empty_panel4 = new JPanel();
		icon_panel = new JPanel();
		log_ = new JPanel();
		Login_Panel = new JPanel();
		ImageIcon login_icon = new ImageIcon("login_icon.png");
		student_icon = new JLabel(login_icon,JLabel.CENTER);
		number_label = new JLabel("Numaranız : ");
		numT = new JTextField();
		login = new JButton("Giriş Yap");
		
		//panellerin düzenleri ayarlandı.
		icon_panel.setLayout(new BorderLayout());
		log_.setLayout(new BorderLayout());		
		Login_Panel.setLayout(new GridLayout(2,1));
		
		//bileşenlerin dışgörünüşü(renk,font,vs) değiştirildi.
		number_label.setFont(new Font("ARIAL", Font.BOLD, 16));
		numT.setFont(new Font("ARIAL", Font.BOLD, 16));
		login.setBackground(Color.RED);
		login.setForeground(Color.WHITE);
		login.setFont(new Font("ARIAL", Font.BOLD, 16));
		
		//gereken bileşenlere actionlistener özelliği verildi.
		login.addActionListener(this);

		//gerekli bileşenler gerekli panellere eklendi.
		icon_panel.add(student_icon,BorderLayout.CENTER);
		log_.add(number_label,BorderLayout.WEST);
		log_.add(numT, BorderLayout.CENTER);
		
		//paneller başka panellere eklendi.
		Login_Panel.add(log_);
		Login_Panel.add(login);
		
		//frame özellikleri girildi.
		this.setIconImage(icon);
		this.setResizable(false);
		this.setTitle("Giriş Yap");
		this.setSize(300,300);
		this.setLayout(new GridLayout(2,1));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		//son oluşan paneller frame'e eklendi.
		this.add(icon_panel);
		this.add(Login_Panel);
		
		
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			//giriş yap butonuna tıklanınca işlenecek kodlar
			
			//SQL tablosuna bağlantı sağlandı.
			try{  
				number = numT.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/student_otomation","root","");
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from students where Number = '" + number + "'");
				while(rs.next()) {
					//tablodaki gerekli veriler kullanılarak OBS sisteminin sınıfı nesne haline getirildi.
					StudentsGUI s = new StudentsGUI(rs.getString(2), rs.getString(3), rs.getString(4));
					this.dispose();
				}
				
				con.close();
				}
			catch(Exception e1){ 
					System.err.println(e1);
				}
		}
	}
}