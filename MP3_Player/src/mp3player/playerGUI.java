package mp3player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

//MP3 playerin görüntüsünü ayarlayadığım class
public class playerGUI extends JFrame implements ActionListener, ListSelectionListener{
	//gerekli bileşenler girildi.
	JButton play_music, prev, next;
	JLabel song_name_label;
	JList<String> musics;
	DefaultListModel<String> model;
	MenuBar mb;
	Menu File,Exit;
	MenuItem open_folder,open_file,exit;
	Font digit_7;
	music_proccess mp;
	ImageIcon pause_icon, play_icon;
	
	//player kurulunca uygulanacak kodlar
	public playerGUI() {
		mp = new music_proccess();
		
		//butonlara eklenecek iconlar oluşturuldu.
		play_icon = new ImageIcon("play_icon.png");
		pause_icon = new ImageIcon("pause_icon.png");
		ImageIcon next_icon = new ImageIcon("next_icon.png");
		ImageIcon prev_icon = new ImageIcon("prev_icon.png");
		
		//kullanılacak font eklandi.
		try {
		    digit_7 = Font.createFont(Font.TRUETYPE_FONT, new File("digital-7.ttf")).deriveFont(24f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("digital-7.ttf")));
		} catch (IOException|FontFormatException e) {
		     System.out.println("Bir hata oluştu :" + e);
		}
		
		
		//bileşenler nesne haline getirildi.
		model = new DefaultListModel();
		musics = new JList<String>(model);
		musics.addListSelectionListener(this);
		
		mb = new MenuBar();
		File = new Menu("Dosya");
		Exit = new Menu("Çıkış");
		exit = new MenuItem("çık");
		
		Exit.add(exit);
		exit.addActionListener(this);
		
		open_file = new MenuItem("Dosya Aç");
		open_file.addActionListener(this);
		open_folder = new MenuItem("Klasör Aç");
		open_folder.addActionListener(this);
		
		File.add(open_folder);
		File.add(open_file);
		mb.add(File);
		mb.add(Exit);
		
		song_name_label = new JLabel("dosya ya da klasör seciniz",JLabel.CENTER);
		play_music = new JButton();
		play_music.addActionListener(this);
		prev = new JButton();
		prev.addActionListener(this);
		next = new JButton();
		next.addActionListener(this);
		
		//bileşenlerin boyut ve lokasyon özellikleri girildi.
		musics.setBounds(50, 200, 400, 440);
		song_name_label.setBounds(100,10,300,40);
		play_music.setBounds(200, 50, 100, 100);
		prev.setBounds(90, 55, 100, 100);
		next.setBounds(310, 55, 100, 100);
		
		
		//bileşenlerin dışgörünüşü değiştirildi.
		song_name_label.setOpaque(true);
		song_name_label.setBackground(new Color(102,109,65, 255));
		song_name_label.setForeground(new Color(0, 0, 0, 255));
		song_name_label.setFont(digit_7);
		
		play_music.setIcon(play_icon);
		play_music.setFocusable(false);
		play_music.setBorder(null);
		play_music.setBackground(new Color(0, 0, 0, 0));
		play_music.setOpaque(false);
		
		prev.setIcon(prev_icon);
		prev.setFocusable(false);
		prev.setBorder(null);
		prev.setBackground(new Color(0, 0, 0, 0));
		prev.setOpaque(false);
		
		next.setIcon(next_icon);
		next.setFocusable(false);
		next.setBorder(null);
		next.setBackground(new Color(0, 0, 0, 0));
		next.setOpaque(false);
		
		musics.setBackground(Color.GRAY);
		musics.setForeground(Color.WHITE);
		
		//playerin renk, başlık,boyut,düzen,görünürlük ve kapanış özellikleri girildi.
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setTitle("DİNLE BENİ Bİ");
		this.setSize(500,700);
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//bileşen nesneleri sınıf bileşenine eklendi.
		this.setMenuBar(mb);
		this.add(song_name_label);
		this.add(play_music);
		this.add(prev);
		this.add(next);
		this.add(musics);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == play_music) {
			//Tıklandığında eğer şarkı dosyası varsa oynatma ya da durdurma işlemini yapar. Yoksa uyarı verir.
			if (mp.clip == null) {
				JOptionPane.showMessageDialog(null, "Oynatılacak dosya bulunmamaktadır!!!", "UYARI", JOptionPane.WARNING_MESSAGE);
			} else {
				mp.PlayStopMusic();
				if(mp.music_run)
					play_music.setIcon(pause_icon);
				else
					play_music.setIcon(play_icon);
			}
		}
		if(e.getSource() == prev) {
			//Tıklandığında eğer şarkı dosyası varsa önceki şarkıya geçme işlemini yapar. Yoksa uyarı verir.
			if (mp.clip != null && mp.musics != null) {
				mp.prev();
				song_name_label.setText(mp.musics.get(mp.music_num).getName().replace(".wav", ""));
				musics.setSelectedIndex(mp.music_num);
			}else {
				JOptionPane.showMessageDialog(null, "Oynatılacak dosya bulunmamaktadır!!!", "UYARI", JOptionPane.WARNING_MESSAGE);
			}
				
		}
		if(e.getSource() == next) {
			//Tıklandığında eğer şarkı dosyası varsa sonraki şarkıya geçme işlemini yapar. Yoksa uyarı verir.
			if (mp.clip != null && mp.musics != null) {
				mp.next();
				song_name_label.setText(mp.musics.get(mp.music_num).getName().replace(".wav", ""));	
				musics.setSelectedIndex(mp.music_num);
			}else {
				JOptionPane.showMessageDialog(null, "Oynatılacak dosya bulunmamaktadır!!!", "UYARI", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == open_file) {
			//Seçilen dosyayı oynatma listesine ekler ve çalmaya başlar. Eğer dosya uzantısı .wav değilse uyarı verir
			if(mp.clip!=null) {
				mp.clip.stop();
			}
			JFileChooser choose = new JFileChooser();
			choose.setFileFilter(new FileNameExtensionFilter("Sound", "wav"));
			choose.setCurrentDirectory(new File("C:\\Users"));
			int response = choose.showOpenDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				String file = choose.getSelectedFile().getAbsolutePath();
				if(file.contains(".wav")) {
					mp.set_file(file);
					song_name_label.setText(mp.musics.get(model.getSize()).getName().replace(".wav", ""));
					model.add(model.getSize(), mp.musics.get(model.getSize()).getName().replace(".wav", ""));
					musics.setSelectedIndex(model.getSize()-1);	
				}
				else {
					JOptionPane.showMessageDialog(null, "Dosya uzantısı .wav olmak zorundadır!!!", "UYARI", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		if (e.getSource() == open_folder) {
			//Seçilen klasördeki wav dosyalarından oynatma listesi yapar ve çalmaya başlar.
			if(mp.clip!=null) {
				mp.clip.stop();
			}
			JFileChooser choose = new JFileChooser();
			choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			choose.setCurrentDirectory(new File("C:\\Users"));
			int response = choose.showOpenDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				String folder = choose.getSelectedFile().getAbsolutePath();
				boolean folder1 = mp.set_folder(folder);
				if(folder1) {
					song_name_label.setText(mp.musics.get(0).getName().replace(".wav", ""));	
					for (int i = 0; i < model.getSize(); i++) {
						model.removeElementAt(i);
					}
					for (java.io.File music : mp.musics) {
						model.add(model.getSize(), music.getName().replace(".wav", ""));
					}
					musics.setSelectedIndex(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Klasörde .wav uzantılı dosya bulunmamaktadır!!!", "UYARI", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		if(e.getSource() == exit) {
			this.dispose();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

		//Oynatma listesinde seçili olan şarkı değiştiği zaman seçilen şarkıyı oynatmaya başlar.
		 	JList list = (JList) e.getSource();
		    String item = (String) musics.getSelectedValue();
		    System.out.println(item);
		    if (item != null && !item.equals("")) {
		    	AudioInputStream audio_input;
				try {
					mp.clip.stop();
					mp.music_num=musics.getSelectedIndex();
					audio_input = AudioSystem.getAudioInputStream(mp.musics.get(mp.music_num));
					mp.clip = AudioSystem.getClip();
					mp.clip.open(audio_input);
					song_name_label.setText(mp.musics.get(mp.music_num).getName().replace(".wav", ""));	
					musics.setSelectedIndex(mp.music_num);
					mp.clip.start();
					mp.music_run=true;
					play_music.setIcon(pause_icon);
					
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		    }
	}
	
}
