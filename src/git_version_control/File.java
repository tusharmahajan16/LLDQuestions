package git_version_control;

public class File {
    String name;
    String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }


    public File clone() {
        return new File(this.name, this.content);
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
