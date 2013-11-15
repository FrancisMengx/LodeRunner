//import java.io.FileInputStream;
//import java.io.IOException;
//
//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;
//
//    public class Sound {
//
//        public void music() {
//
//            AudioStream backgroundMusic;
//            AudioData musicData;
//            AudioPlayer musicPlayer = AudioPlayer.player;
//            ContinuousAudioDataStream loop = null;
//            try {
//                backgroundMusic = new AudioStream(new FileInputStream("chickendance.wav"));
//                musicData = backgroundMusic.getData();
//                loop = new ContinuousAudioDataStream(musicData);
//                musicPlayer.start(loop);
//            } catch (IOException error) { System.out.println(error);
//            }
//        }
//    }