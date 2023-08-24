package pack;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Homeworks extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	JTable homework_table;
	ArrayList<ArrayList<String>> data2;
	String[][] data_;
	public Homeworks() {}
	public Homeworks(String number) {
		// TODO Auto-generated constructor stub
		
		//işlenecek bileşen nesne haline getirildi.
		data2 = new ArrayList<>();
		
		//SQL tablosuna bağlantı sağlandı.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student_otomation","root","");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from homeworks where student_number = '" + number + "'");
			while(rs.next()) {
				//sql tablosundaki veriler işlenmek üzere gerekli fonksiyona gönderildi.
				set_data(rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
			con.close();
			}
		catch(Exception e1){ 
				System.out.println(e1);
			}

		//2B arraylist içindeki veriler 2B bir dizinin içine işlendi.
		data_ = new String[data2.size()][data2.get(0).size()];
		for (int i = 0; i < data2.size(); i++) {
			for (int j = 0; j < data2.get(0).size(); j++) {
				data_[i][j]= data2.get(i).get(j);
			}
			
		}

		//bileşenler nesne haline getirildi ve oluşturulan dizi ile tablo oluşturuldu
		String[] homework_columns = { " ", " "};
		homework_table = new JTable(data_, homework_columns);
		JScrollPane sp = new JScrollPane(homework_table);
		
		//bileşen özellikleri değiştirildi.
		homework_table.setEnabled(false);
		homework_table.setFont(new Font("ARIAL", Font.ITALIC, 16));
		
		//frame özellikleri girildi.
		this.setLayout(new BorderLayout());
		this.setVisible(false);
		
		//gerekli bileeşenler frame'e eklendi.
		this.add(sp);
	}
	
	public void set_data(String lesson, String finish_date, int statu) {
		//parametre olarak gelen veriler arraylist içine eklenip başka bir arraylist içine eklendi.
		ArrayList<String> homework = new ArrayList<>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		   
		//eğer ödev yapılmamışsa ve tarih günümüz tarihinden sonraysa ödev arrayliste eklendi.
		if(statu == 0) {
			String [] hd = finish_date.split("-");
			String [] cd = dtf.format(now).split("-");
			if(Integer.parseInt(hd[0])>= Integer.parseInt(cd[0])) {
				if(Integer.parseInt(hd[1])>= Integer.parseInt(cd[1])) {
					if(Integer.parseInt(hd[2])>= Integer.parseInt(cd[2])) {
						homework.add(lesson);
						homework.add(finish_date);
						data2.add(homework);
					}
				}
			}
		}
	}

}
