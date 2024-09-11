package bo.com.ahosfot.patterns.structural.facade.someComplexMediaLibrary;

import lombok.Getter;

public class VideoFile {
    @Getter
    private String fileName;
    @Getter
    private String codecType;

    public VideoFile(String fileName) {
        this.fileName = fileName;
        this.codecType = fileName.substring(fileName.indexOf(".") + 1);
    }
}
