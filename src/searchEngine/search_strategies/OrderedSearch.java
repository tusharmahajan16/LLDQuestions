package searchEngine.search_strategies;

import searchEngine.Category;
import searchEngine.Document;

import java.util.ArrayList;
import java.util.List;

public class OrderedSearch implements SearchStrategy {
    @Override
    public List<Document> search(Category category, String pattern) {
        String[] keywords = pattern.toLowerCase().split(" ");
        List<Document> docs = new ArrayList<>();
        for (Document document : category.getDocuments()) {
            String content = document.getContent().toLowerCase();
            boolean found = true;
            int index = -1;
            for (String keyword : keywords) {
                index = content.indexOf(keyword, index + 1);
                if (index == -1) {
                    found = false;
                    break;
                }
            }
            if (found) {
                docs.add(document);
            }
        }
        return docs;
    }
}
