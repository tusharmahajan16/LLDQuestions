package searchEngine;

import searchEngine.order_strategies.ResultOrderType;
import searchEngine.order_strategies.SortOrderType;
import searchEngine.search_strategies.SearchType;

public class InMemorySearchEngine {
    public static void main(String[] args) {
        SearchEngine searchEngine = SearchEngine.getInstance();
        String categoryName = "AI/ML Articles";
        searchEngine.createCategory(categoryName);
        searchEngine.addDocumentToCategory(categoryName,"Neural networks","Deep understanding of Neural Networks and Reinforcement Learning","Tushar" );
        searchEngine.addDocumentToCategory(categoryName,"Beginner ML","A Beginner’s Guide to Machine Learning Models","Tushar" );
        searchEngine.addDocumentToCategory(categoryName, "Deep Learning","Deep Learning in Computer Vision: Use Cases and Future","Tushar" );
        searchEngine.addDocumentToCategory(categoryName,"Reinforcement Learning","Exploring Reinforcement Learning with Practical Examples","Tushar" );
        searchEngine.addDocumentToCategory(categoryName,"NN and RL" ,"Reinforcement Learning and applications of Deep Neural Networks in Healthcare","Tushar");

        String pattern = "Deep Learning";
        System.out.println("Unordered Search "+pattern+":");
        searchEngine.search(categoryName,pattern, SearchType.UNORDERED, ResultOrderType.PUBLISHED, SortOrderType.ASCENDING)
                .forEach(doc->System.out.println(doc.getContent()+"-Date :"+doc.getPublishedDate()));

        System.out.println("Ordered Search "+pattern+":");
        searchEngine.search(categoryName,pattern, SearchType.ORDERED, ResultOrderType.PUBLISHED, SortOrderType.DESCENDING)
                .forEach(doc->System.out.println(doc.getContent()+"-Date :"+doc.getPublishedDate()));


        System.out.println("Substring Search "+pattern+":");
        searchEngine.search(categoryName,pattern, SearchType.SUBSTRING, ResultOrderType.PUBLISHED, SortOrderType.ASCENDING)
                .forEach(doc->System.out.println(doc.getContent()+"-Date :"+doc.getPublishedDate()));
    }
}
