package git_version_control;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;

public class Repository {
    private static Repository instance;
    Map<String, Branch> branches;
    Map<String, File> stagingArea;
    Branch currentBranch;

    private Repository() {
        branches = new HashMap<>();
        stagingArea = new HashMap<>();
        createBranch("master");
    }

    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void createBranch(String branchName) {
        branches.putIfAbsent(branchName, new Branch(branchName));
        switchBranch(branchName);
    }

    public void switchBranch(String branchName) {
        if (branches.containsKey(branchName)) {
            currentBranch = branches.get(branchName);
            System.out.println("Switched to " + branchName);
        } else {
            System.out.println("Branch " + branchName + " not found");
        }
    }

    public void addFile(String name, String content) {
        stagingArea.put(name, new File(name, content));
    }

    public void commit(String commitMessage) {
        if (stagingArea.isEmpty()) {
            System.out.println("No Files to Commit");
            return;
        }
        Commit commit = new Commit(UUID.randomUUID().toString(), commitMessage, stagingArea);
        currentBranch.addCommit(commit);
        currentBranch.addCommitHistory(commit.saveToMemento());
        stagingArea.clear();
        System.out.println("Committed : " + commitMessage);
    }

    public void rollBack() {
        currentBranch.rollback();
    }


}
