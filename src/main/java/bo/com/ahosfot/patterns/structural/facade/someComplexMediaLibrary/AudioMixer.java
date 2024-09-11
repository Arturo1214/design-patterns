package bo.com.ahosfot.patterns.structural.facade.someComplexMediaLibrary;

import java.io.File;

public class AudioMixer {

    public File fix(VideoFile videoFile) {
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
