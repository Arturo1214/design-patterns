package bo.com.ahosfot.patterns.behavior.Command.editor;

import bo.com.ahosfot.patterns.behavior.Command.commands.*;

import javax.swing.*;
import java.awt.*;

public class Editor {
    public JTextArea textField;
    public String clipboard;
    private CommandHistory history = new CommandHistory();

    public void init() {
        JFrame jFrame = new JFrame("Text Editor (Type & use buttons, Luke!)");
        JPanel content = new JPanel();
        jFrame.setContentPane(content);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton controlC = new JButton("Ctrl+C");
        JButton controlX = new JButton("Ctrl+X");
        JButton controlV = new JButton("Ctrl+V");
        JButton controlZ = new JButton("Ctrl+Z");
        Editor editor = this;
        controlC.addActionListener(e -> {executeCommand(new CopyCommand(editor));});
        controlX.addActionListener(e -> {executeCommand(new CutCommand(editor));});
        controlV.addActionListener(e -> {executeCommand(new PasteCommand(editor));});
        controlZ.addActionListener(e -> {undo();});
        buttonPanel.add(controlC);
        buttonPanel.add(controlX);
        buttonPanel.add(controlV);
        buttonPanel.add(controlZ);
        content.add(buttonPanel);
        jFrame.setSize(450, 200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            System.out.println("PUS Executing command: " + command);
            history.push(command);
        }
    }

    private void undo() {
        if (history.isEmpty()) {
            return;
        }
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

}
