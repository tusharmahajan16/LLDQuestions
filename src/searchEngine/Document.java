package searchEngine;

import java.util.Date;

public class Document {
    private String tile;
    private String author;
    private String content;
    private Date publishedDate;
    private Date lastUpdatedDate;
    private Date searchDate;

    public Document(String name, String content,String author) {
        this.tile = name;
        this.author = author;
        this.content = content;
        publishedDate = new Date(System.nanoTime());
        lastUpdatedDate = new Date(System.nanoTime());
        searchDate = null;
    }

    public String getTitle() {
        return tile;
    }

    public void setTitle(String tile) {
        this.tile = tile;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }
}
