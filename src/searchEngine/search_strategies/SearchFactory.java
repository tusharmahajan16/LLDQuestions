package searchEngine.search_strategies;

public class SearchFactory {
    private static SearchFactory instance;
    private SearchFactory() {}
    public static SearchFactory getInstance() {
        if (instance == null) {
            synchronized (SearchFactory.class) {
                if (instance == null) {
                    instance = new SearchFactory();
                }
            }
        }
        return instance;
    }

    public SearchStrategy getSearchStrategy(SearchType searchType) {
        return switch (searchType) {
            case SearchType.ORDERED -> new OrderedSearch();
            case SearchType.UNORDERED -> new UnorderedSearch();
            case SearchType.SUBSTRING -> new SubstringSearch();
            default -> null;
        };
    }
}
