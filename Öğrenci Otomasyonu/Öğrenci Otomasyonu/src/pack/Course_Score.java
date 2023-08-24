package pack;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Course_Score extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	JTable lessons;
	ArrayList<ArrayList<String>> data2;
	String[][] data_;
	
	public Course_Score() {}
	public Course_Score(String number) {
		// TODO Auto-generated constructor stub

		//işlenecek bileşen nesne haline getirildi.
		data2 = new ArrayList<>();
		
		//SQL tablosuna bağlantı sağlandı.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student_otomation","root","");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from lessons where student_number = '" + number + "'");
			while(rs.next()) {
				//sql tablosundaki veriler işlenmek üzere gerekli fonksiyona gönderildi.
				set_data(rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
			con.close();
			}
		catch(Exception e1){ 
				System.err.println(e1);
			}
		
		//2B arraylist içindeki veriler 2B bir dizinin içine işlendi.
		data_ = new String[data2.size()][data2.get(0).size()];
		for (int i = 0; i < data2.size(); i++) {
			for (int j = 0; j < data2.get(0).size(); j++) {
				data_[i][j]= data2.get(i).get(j);
			}
			
		}
		//bileşenler nesne haline getirildi ve oluşturulan dizi ile tablo oluşturuldu
		String[] columnNames = { " ", "Ara Sınav", "Final Sınavı"};
		lessons = new JTable(data_, columnNames);
		JScrollPane sp = new JScrollPane(lessons);
		
		//bileşen özellikleri değiştirildi.
		lessons.setFont(new Font("ARIAL", Font.ITALIC, 16));
		lessons.setEnabled(false);	
		lessons.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	
		//frame özellikleri girildi.
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		//gerekli bileeşenler frame'e eklendi.
		this.add(sp);
	}
	
	public void set_data(String lesson, String midterm, String final_exam) {
		//parametre olarak gelen veriler arraylist içine eklenip başka bir arraylist içine eklendi.
		ArrayList<String> data = new ArrayList<>();
		data.add(lesson);
		data.add(midterm);
		data.add(final_exam);
		data2.add(data);
	}
}
