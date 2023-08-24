package mp3player;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class music_proccess {
	//gereken değişkenler girildi
	String file_path, folder_path;
	ArrayList<File> musics;
	int music_num = 0;
	Clip clip;
	boolean music_run=false;
	public music_proccess() {
		//playlist için müzik listesi tanımlandı.
		musics= new ArrayList<>();
	}
	public void set_file(String file) {
		//seçilen dosya çalma listesine eklendi ve mevcut şarkı olarak ayarlandı
		file_path = file;
		try {
			File music_path = new File(file_path);
			if (music_path.exists()) {
				musics.add(music_path);
				AudioInputStream audio_input = AudioSystem.getAudioInputStream(music_path);
				clip = AudioSystem.getClip();
				clip.open(audio_input);
				
			} else {
				System.out.println("Dosya bulunamadı");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("bir hata oluştu :" + e);
		}
	}
	public boolean set_folder(String folder) {
		//seçilen klasörden şarkılar alındı, çalma listesine eklendi ve ilk şarkı mevcut şarkı olarak ayarlandı
		folder_path = folder;
		try {
			File musics_path = new File(folder_path);
			if (musics_path.exists()) {
				music_num = 0;
				for (int i = 0; i < musics.size(); i++) {
					musics.remove(i);
				}
				File[] is_musics = musics_path.listFiles();
				for (File music : is_musics) {
					if(music.getAbsolutePath().contains(".wav")) {
						musics.add(music);
					}
				}
				for (File music : musics) {
					System.out.println(music);
				}
				AudioInputStream audio_input = AudioSystem.getAudioInputStream(musics.get(music_num));
				clip = AudioSystem.getClip();
				clip.open(audio_input);
				return true;
			} else {
				System.out.println("Klasör bulunamadı");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("bir hata oluştu :" + e);
			return false;
		}
	}
	public void PlayStopMusic() {
		//müzik çalıyorsa durdur, aksi halde çal. 
		if (music_run) {
			clip.stop();
			music_run = false;
		}
		else {
			clip.start();
			music_run = true;
		}
	}
	public void next() {
		//sonraki şarkıya geçmek için sıra değişkenini arttır 
		music_num++;
		if(music_num == musics.size()) {
			music_num = 0;
		}
	}
	public void prev() {
		//önceki şarkıya geçmek için sıra değişkenini azalt.
		music_num--;
		if(music_num < 0) {
			music_num = musics.size()-1;
		}
	}
}
