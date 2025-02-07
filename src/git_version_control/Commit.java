package git_version_control;

import java.util.HashMap;
import java.util.Map;

public class Commit {
    private String id;
    private String message;
    private Map<String, File> files;

    Commit(String id, String message, Map<String, File> files) {
        this.id = id;
        this.message = message;
        this.files = new HashMap<>();
        for (Map.Entry<String, File> entry : files.entrySet()) {
            this.files.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public CommitMemento saveToMemento()
    {
        return new CommitMemento(id, message, files);
    }

    public void restoreFromMemento(CommitMemento memento)
    {
        this.id = memento.getId();
        this.message = memento.getMessage();
        this.files = memento.getFiles();
    }
}
