package pack;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Absences extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//gerekli bileşenler girildi.
	String[][] data_;
	JTable absence_table;
	JLabel absence_label;
	ArrayList<ArrayList<String>> data2;
	
	public Absences() {}
	
	public Absences(String number) {
		// TODO Auto-generated constructor stub

		//işlenecek bileşen nesne haline getirildi.
		data2 = new ArrayList<>();
		
		//SQL tablosuna bağlantı sağlandı.
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student_otomation","root","");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from absence_status where student_number = '" + number + "'");
			while(rs.next()) {
				//sql tablosundaki veriler işlenmek üzere gerekli fonksiyona gönderildi.
				set_data(rs.getString(2), rs.getInt(3));
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
		String[] absence_columns = { " ", " "};
		absence_table = new JTable(data_, absence_columns);		
		JScrollPane sp = new JScrollPane(absence_table);

		//bileşen özellikleri değiştirildi.
		absence_table.setEnabled(false);
		absence_table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		absence_table.setFont(new Font("ARIAL", Font.ITALIC, 16));	
		
		//frame özellikleri girildi.
		this.setLayout(new BorderLayout());
		this.setVisible(false);
		
		//gerekli bileeşenler frame'e eklendi.
		this.add(sp);
		
	}
	
	public void set_data(String date, int is_absence) {
		//parametre olarak gelen veriler arraylist içine eklenip başka bir arraylist içine eklendi.
		ArrayList<String> absence = new ArrayList<>();
		absence.add(date);
		//eğer devamsızlık durumu 1 ise devamsız anlamında "X" konuldu aksi takdirde boş geçildi.
		if(is_absence==1)
			absence.add("X");
		else
			absence.add("");
		data2.add(absence);
	}
}
