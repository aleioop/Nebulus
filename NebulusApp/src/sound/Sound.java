//seperate class for handling import/play of sound files 
//utilizes sound.sampled method for sounds - all sound assets WMA format 
package sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.*;

public class Sound {
	public static void play(String sndFileNM) {
		//To work with javax.sound.sampled package - support wave, aiff, au but NOT mp3 
		try {
			File sndFile = new File(sndFileNM);
			AudioInputStream audio = AudioSystem.getAudioInputStream(sndFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (LineUnavailableException e) {
			System.out.println("No line is available for the sound");
		} catch (IOException e) {
			System.out.println("There are problems with your sound file");
		} catch (UnsupportedAudioFileException e) {
			System.out.println("The type of audio is not supported");
		}
	}
}
