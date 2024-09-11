package bo.com.ahosfot.patterns.behavior.mediator.component;

import bo.com.ahosfot.patterns.behavior.mediator.mediator.Mediator;
import bo.com.ahosfot.patterns.behavior.mediator.mediator.Note;

import javax.swing.*;

public class List extends JList implements Component {
    private Mediator mediator;
    private final DefaultListModel listModel;

    public List(DefaultListModel listModel) {
        super(listModel);
        this.listModel = listModel;
        setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        this.listModel.addElement(note);
        int index = this.listModel.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(this.listModel);
    }

    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            this.listModel.remove(index);
            mediator.sendToFilter(this.listModel);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public Note getCurrentElement() {
        return (Note) getSelectedValue();
    }

    @Override
    public String getName() {
        return "List";
    }

    private class Hide implements Runnable {
        private List list;

        Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.isSelectionEmpty()) {
                    mediator.hideElements(true);
                } else {
                    mediator.hideElements(false);
                }
            }
        }
    }
}
