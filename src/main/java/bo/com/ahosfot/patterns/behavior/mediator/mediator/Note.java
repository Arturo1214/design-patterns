package bo.com.ahosfot.patterns.behavior.mediator.mediator;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Note {
    private String name;
    private String text;

    public Note() {
        name = "New note";
    }

    @Override
    public String toString() {
        return name;
    }
}
