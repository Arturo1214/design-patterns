package bo.com.ahosfot.patterns.structural.proxy;

import bo.com.ahosfot.patterns.structural.proxy.downloader.YouTubeDownloader;
import bo.com.ahosfot.patterns.structural.proxy.proxy.YouTubeCacheProxy;
import bo.com.ahosfot.patterns.structural.proxy.someCoolMediaLibrary.ThirdPartyYouTubeClass;

public class Demo {

    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");
    }

    private static long test(YouTubeDownloader youtubeDownloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        youtubeDownloader.renderPopularVideos();
        youtubeDownloader.renderVideoPage("catzzzzzzzzz");
        youtubeDownloader.renderPopularVideos();
        youtubeDownloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        youtubeDownloader.renderVideoPage("catzzzzzzzzz");
        youtubeDownloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
