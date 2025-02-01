package dictonaryWithSearch;

import java.util.concurrent.ConcurrentHashMap;

public class DictionarySystem {
    // we can add more functionalities here to search a word without case sensitivity
    // also to support adding text into datasets

    private static DictionarySystem instance;
    ConcurrentHashMap<String, Trie> dataSets;
    private DictionarySystem() {
        dataSets = new ConcurrentHashMap<>();
    }

    public static DictionarySystem getInstance() {
        if (instance == null) {
            synchronized (DictionarySystem.class) {
                if (instance == null) {
                    instance = new DictionarySystem();
                }
            }
        }
        return instance;
    }

    public void addDataSet(String dataSetName) {
        if (dataSets.containsKey(dataSetName)) {
            System.out.println("DataSet already exists");
            return;
        }
        dataSets.put(dataSetName, new Trie());
    }

    public void addWordInDataSet(String dataSetName, String word) {
        if (!dataSets.containsKey(dataSetName)) {
            addDataSet(dataSetName);
        }
        dataSets.get(dataSetName).insert(word);
    }

    public boolean searchInDataSetExactWord(String dataSetName, String word) {
        if (!dataSets.containsKey(dataSetName)) {
            System.out.println("DataSet does not exist");
            return false;
        }
        return dataSets.get(dataSetName).search(word);
    }

    public boolean searchInDataSetWithPrefix(String dataSetName, String word) {
        if (!dataSets.containsKey(dataSetName)) {
            System.out.println("DataSet does not exist");
            return false;
        }
        return dataSets.get(dataSetName).searchPrefix(word);
    }

    public boolean searchInAllDataSetsExactWord(String word) {
        for (Trie trie : dataSets.values()) {
            if (trie.search(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchInAllDataSetsWithPrefix(String word) {
        for (Trie trie : dataSets.values()) {
            if (trie.searchPrefix(word)) {
                return true;
            }
        }
        return false;
    }
}
