package searchEngine.search_strategies;

import searchEngine.Category;
import searchEngine.Document;

import java.util.List;

public interface SearchStrategy {
    List<Document> search(Category category, String pattern);
}
