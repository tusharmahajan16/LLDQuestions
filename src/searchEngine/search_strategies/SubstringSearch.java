package searchEngine.search_strategies;

import searchEngine.Category;
import searchEngine.Document;

import java.util.ArrayList;
import java.util.List;

public class SubstringSearch implements SearchStrategy {
    @Override
    public List<Document> search(Category category, String pattern) {
        List<Document> docs = new ArrayList<>();
        for (Document document : category.getDocuments()) {
            if (document.getContent().toLowerCase().contains(pattern.toLowerCase())) {
                docs.add(document);
            }
        }
        return docs;
    }
}
