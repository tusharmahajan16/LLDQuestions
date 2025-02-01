package searchEngine;

import searchEngine.order_strategies.DocumentOrderingFactory;
import searchEngine.order_strategies.DocumentOrderingStrategy;
import searchEngine.order_strategies.ResultOrderType;
import searchEngine.order_strategies.SortOrderType;
import searchEngine.search_strategies.SearchFactory;
import searchEngine.search_strategies.SearchStrategy;
import searchEngine.search_strategies.SearchType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    private static SearchEngine instance;
    Map<String,Category> categories;
    private SearchEngine(){
        categories = new HashMap<>();
    }
    public static SearchEngine getInstance(){
        if(instance == null){
            synchronized(SearchEngine.class){
                if(instance == null){
                    instance = new SearchEngine();
                }
            }
        }
        return instance;
    }

    public void createCategory(String categoryName){
        Category category = new Category(categoryName);
        categories.put(categoryName, category);
    }

    public void addDocumentToCategory(String categoryName, String title, String content, String author){
        Category category = categories.get(categoryName);
        Document document = new Document(title, content, author);
        category.addDocument(document);
    }

    public List<Document> search(String categoryName, String pattern, SearchType searchType, ResultOrderType resultOrderType, SortOrderType sortOrder){
        Category category = categories.get(categoryName);
        SearchStrategy searchStrategy = SearchFactory.getInstance().getSearchStrategy(searchType);
        List<Document> result = searchStrategy.search(category,pattern);
        DocumentOrderingStrategy documentOrderingStrategy = DocumentOrderingFactory.getInstance().getDocumentOrderingStrategy(resultOrderType);
        documentOrderingStrategy.order(result, sortOrder);
        return result;
    }

}
