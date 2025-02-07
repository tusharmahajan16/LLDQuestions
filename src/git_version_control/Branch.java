package git_version_control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Branch {
    String branchName;
    List<Commit> commits;
    Stack<CommitMemento> commitHistory;

    Branch(String branchName) {
        this.branchName = branchName;
        commits = new ArrayList<>();
        commitHistory = new Stack<>();
    }

    public void addCommit(Commit commit) {
        commits.add(commit);
    }

    public void removeLastCommit() {
        commits.removeLast();
    }

    public void showLastCommit() {
        System.out.println(commits.get(commits.size() - 1));
    }

    public void addCommitHistory(CommitMemento commitMemento) {
        commitHistory.push(commitMemento);
    }

    public void rollback() {
        if (!commitHistory.isEmpty()) {
            commitHistory.pop(); // remove last commit from history
            removeLastCommit();
            if (!commitHistory.isEmpty()) {
                CommitMemento prevState = commitHistory.pop();
                Commit commit = new Commit("","",new HashMap<>());
                commit.restoreFromMemento(prevState);
                addCommit(commit);
                System.out.println("rolled back to commit :" + prevState.getMessage());
            } else {
                System.out.println("No Commits Repository is empty after rollback");
            }
        } else {
            System.out.println("No Commits to rollback");
        }

    }
}
