package git_version_control;

import java.util.HashMap;
import java.util.Map;

public class CommitMemento {
    private String id;
    private String message;
    private Map<String, File> files;

    CommitMemento(String id, String message, Map<String, File> files) {
        this.id = id;
        this.message = message;
        this.files = new HashMap<>();
        for (Map.Entry<String, File> entry : files.entrySet()) {
            this.files.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, File> getFiles() {
        return new HashMap<>(files);
    }
}
