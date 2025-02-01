package searchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Category {
    private String categoryName;
    List<Document> documents;
    InvertedIndex invertedIndex;

    Category(String categoryName) {
        this.categoryName = categoryName;
        documents = new ArrayList<>();
        invertedIndex = new InvertedIndex();
    }

    public void addDocument(Document document) {
        documents.add(document);
        updateInvertedIndex(document);
    }

    public void updateInvertedIndex(Document document) {
        invertedIndex.addDocument(document);
    }

    public Set<Document> searchPattern(String pattern) {
        return invertedIndex.getDocumentsForWord(pattern);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Document> getDocuments() {
        return documents;
    }
}
