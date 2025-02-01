package searchEngine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {
    Map<String, Set<Document>> invertedIndex;

    public InvertedIndex() {
        invertedIndex = new HashMap<>();
    }

    public void addDocument(Document document) {
        String[] words = document.getContent().toLowerCase().split("\\W+");
        for (String word : words) {
            if (!invertedIndex.containsKey(word)) {
                invertedIndex.put(word, new HashSet<>());
            }
            invertedIndex.get(word).add(document);
        }
    }

    public Set<Document> getDocumentsForWord(String word) {
        return invertedIndex.get(word);
    }
}
