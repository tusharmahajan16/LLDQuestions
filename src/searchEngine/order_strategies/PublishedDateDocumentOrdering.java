package searchEngine.order_strategies;

import searchEngine.Document;

import java.util.Comparator;
import java.util.List;

public class PublishedDateDocumentOrdering implements DocumentOrderingStrategy {
    @Override
    public void order(List<Document> documents, SortOrderType sortOrderType) {
        if (sortOrderType.equals(SortOrderType.ASCENDING)) {
            documents.sort(Comparator.comparing(Document::getPublishedDate));
        } else {
            documents.sort((d1, d2) -> d2.getPublishedDate().compareTo(d1.getPublishedDate()));
        }
    }
}
