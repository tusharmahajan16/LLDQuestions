package git_version_control;

public class Git {
    public static void main(String[] args) {
        Repository repo = Repository.getInstance();
        repo.createBranch("develop");
        repo.addFile("Intro.txt", "Hi My Name is Tushar");
        repo.addFile("Food.txt", "I like Hot Chocolate");
        repo.commit("Adding some details related to me");
        repo.addFile("Age.txt", "I am 24 years old");
        repo.commit("Adding age");

        repo.createBranch("NewFeature");
        repo.addFile("NewFeature.txt", "NewFeature work");
        repo.commit("New Feature details");
        repo.rollBack();
        repo.switchBranch("develop");
        repo.rollBack();
    }
}
