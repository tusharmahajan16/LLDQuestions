package searchEngine.order_strategies;

import searchEngine.Document;

import java.util.List;

public interface DocumentOrderingStrategy {
    void order(List<Document> documents, SortOrderType sortOrderType);
}
