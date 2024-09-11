package bo.com.ahosfot.patterns.behavior.Command.commands;

import bo.com.ahosfot.patterns.behavior.Command.editor.Editor;

import javax.sound.midi.Receiver;

public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty())
            return false;
        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
