package searchEngine.search_strategies;

import searchEngine.Category;
import searchEngine.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UnorderedSearch implements SearchStrategy {

    @Override
    public List<Document> search(Category category, String pattern) {
        String[] keyword = pattern.toLowerCase().split(" ");
        Set<Document> documents = category.searchPattern(keyword[0]);
        for (int i = 1; i < keyword.length; i++) {
            documents.retainAll(category.searchPattern(keyword[i]));
        }
        return new ArrayList<>(documents);
    }
}
