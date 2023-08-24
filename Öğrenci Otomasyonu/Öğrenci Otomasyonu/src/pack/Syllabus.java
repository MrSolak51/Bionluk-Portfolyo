package pack;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Syllabus extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	JTable syllabus_table;
	ArrayList<ArrayList<String>> data2;
	String[][] lessons;
	String[][] data_;
	public Syllabus() {}
	public Syllabus(String number) {
		// TODO Auto-generated constructor stub

		//işlenecek bileşenler nesne haline getirildi.
		data2 = new ArrayList<>();
		lessons = new  String[4][6];
		
		
		//SQL tablosuna bağlantı sağlandı.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student_otomation","root","");
			Statement stmt=con.createStatement();  		
			
			//günler ve ders saatlerine göre veriler çekilerek gerekli değişkenlere tanımlandı.
			int time = 1;
			while (time != 5) {
				ResultSet rs=stmt.executeQuery("select * from syllabus where student_number = '" + number + "' and time_ = '" + time + "'");
				int j = 0;
				while(rs.next()) {
					lessons[time-1][j]=rs.getString(2);
					j ++;
				}
				time ++;
			}
			con.close();
			}
		catch(Exception e1){ 
				System.err.println(e1);
			}
		
		//bileşenler nesne haline getirildi ve oluşturulan dizi ile tablo oluşturuldu
		String[] syllabus_columns = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma"};
		syllabus_table = new JTable(lessons, syllabus_columns);
		JScrollPane sp = new JScrollPane(syllabus_table);
		
		//bileşen özellikleri değiştirildi.
		syllabus_table.setEnabled(false);
		syllabus_table.setFont(new Font("ARIAL", Font.ITALIC, 16));
		
		//frame özellikleri girildi.
		this.setLayout(new BorderLayout());
		this.setVisible(false);
		
		//gerekli bileeşenler frame'e eklendi
		this.add(sp);
	}
}
