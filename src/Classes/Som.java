package Classes;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Som {

    public Som(String Som) {
        try {
            if (Som == "disparo") {
                URL url = new URL("File:C:/disparo.wav");
                AudioClip ac = Applet.newAudioClip(url);
                ac.play();
                System.in.read();
                ac.stop();
            }
            if (Som == "morte") {
                URL url = new URL("File:C:/morte.wav");
                AudioClip ac = Applet.newAudioClip(url);
                ac.play();
                System.in.read();
                ac.stop();
            }
            if (Som == "menu") {
                URL url = new URL("File:C:/aberturaGame.wav");
                AudioClip ac = Applet.newAudioClip(url);
                ac.play();
                System.in.read();
                ac.stop();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
