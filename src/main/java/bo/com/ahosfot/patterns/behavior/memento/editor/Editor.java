package bo.com.ahosfot.patterns.behavior.memento.editor;

import bo.com.ahosfot.patterns.behavior.memento.commands.Command;
import bo.com.ahosfot.patterns.behavior.memento.history.History;
import bo.com.ahosfot.patterns.behavior.memento.history.Memento;
import bo.com.ahosfot.patterns.behavior.memento.shapes.CompoundShape;
import bo.com.ahosfot.patterns.behavior.memento.shapes.Shape;
import lombok.Getter;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

public class Editor extends JComponent {
    private Canvas canvas;
    @Getter
    private CompoundShape allShapes = new CompoundShape();
    private History history;

    public Editor() {
        canvas = new Canvas(this);
        history = new History();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    public void execute(Command command) {
        history.push(command, new Memento(this));
        command.execute();
    }

    public void undo() {
        if (history.undo()) {
            canvas.repaint();
        }
    }

    public void redo() {
        if (history.redo()) {
            canvas.repaint();
        }
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException occurred.");
        } catch (IOException e) {
            System.out.println("IOException occurred.");
        }
    }

}
