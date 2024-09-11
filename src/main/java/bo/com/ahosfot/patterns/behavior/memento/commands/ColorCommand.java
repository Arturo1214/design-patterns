package bo.com.ahosfot.patterns.behavior.memento.commands;

import bo.com.ahosfot.patterns.behavior.memento.editor.Editor;
import bo.com.ahosfot.patterns.behavior.memento.shapes.Shape;

import java.awt.*;

public class ColorCommand implements Command {
    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child: editor.getAllShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
