package bo.com.ahosfot.patterns.behavior.Command.commands;

import bo.com.ahosfot.patterns.behavior.Command.editor.Editor;

import javax.sound.midi.Receiver;

public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
