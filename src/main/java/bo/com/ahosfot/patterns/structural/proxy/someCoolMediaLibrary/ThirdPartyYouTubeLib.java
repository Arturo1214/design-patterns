package bo.com.ahosfot.patterns.structural.proxy.someCoolMediaLibrary;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
