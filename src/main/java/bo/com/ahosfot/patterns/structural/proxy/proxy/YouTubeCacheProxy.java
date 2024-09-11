package bo.com.ahosfot.patterns.structural.proxy.proxy;

import bo.com.ahosfot.patterns.structural.proxy.someCoolMediaLibrary.ThirdPartyYouTubeClass;
import bo.com.ahosfot.patterns.structural.proxy.someCoolMediaLibrary.ThirdPartyYouTubeLib;
import bo.com.ahosfot.patterns.structural.proxy.someCoolMediaLibrary.Video;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

    private ThirdPartyYouTubeLib thirdPartyYouTubeLib;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy() {
        this.thirdPartyYouTubeLib = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = thirdPartyYouTubeLib.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = thirdPartyYouTubeLib.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        this.cachePopular.clear();
        this.cacheAll.clear();
    }
}
