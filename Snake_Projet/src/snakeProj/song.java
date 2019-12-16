package snakeProj;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.applet.Main;

 
 
public class song
{
	public static Mixer mixer;
	public static Clip clip; 
	
	public void song() {
    	Mixer.Info[] mixInfos= AudioSystem.getMixerInfo();
        /*
    	for(Mixer.Info info : mixInfos)
    	{
    		System.out.println(info.getName() + "---" + info.getDescription());
    	}
    	*/
    	mixer= AudioSystem.getMixer(mixInfos[0]);
    	
    	DataLine.Info dataInfo = new DataLine.Info(Clip.class,  null);
    	try {clip =(Clip)mixer.getLine(dataInfo);}
    	catch(LineUnavailableException lue){lue.printStackTrace();}
    	
    	try 
    	{
    		URL soundURL= Main.class.getResource("/snakeProj/test.wav");
    		AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
    		clip.open(audioStream);
    	}
    	catch(LineUnavailableException lue){lue.printStackTrace();}
    	catch(UnsupportedAudioFileException uafe){uafe.printStackTrace();}
    	catch(IOException ioe){ioe.printStackTrace();}
    	clip.start();
    	do
    	{
    		try { Thread.sleep(50);}
    		catch(InterruptedException ie){ie.printStackTrace();}
    	}while(clip.isActive());
    }


}