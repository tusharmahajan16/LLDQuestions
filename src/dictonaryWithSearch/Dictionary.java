package dictonaryWithSearch;

public class Dictionary {
    public static void main(String[] args) {
        DictionarySystem dictionarySystem = DictionarySystem.getInstance();
        dictionarySystem.addWordInDataSet("Dataset1","Engineer");
        dictionarySystem.addWordInDataSet("Dataset2","Tushar");
        System.out.println(dictionarySystem.searchInDataSetWithPrefix("Dataset2","Tush"));//true
        System.out.println(dictionarySystem.searchInDataSetExactWord("Dataset1","Tushar"));//false
    }
}
