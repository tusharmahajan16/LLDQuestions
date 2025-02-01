package searchEngine.order_strategies;

public class DocumentOrderingFactory {
    private static DocumentOrderingFactory instance;

    private DocumentOrderingFactory() {

    }

    public static DocumentOrderingFactory getInstance() {
        if (instance == null) {
            synchronized (DocumentOrderingFactory.class) {
                if (instance == null) {
                    instance = new DocumentOrderingFactory();
                }
            }
        }
        return instance;
    }

    public DocumentOrderingStrategy getDocumentOrderingStrategy(ResultOrderType resultOrderType) {
        return switch (resultOrderType) {
            case ResultOrderType.PUBLISHED -> new PublishedDateDocumentOrdering();
            case UPDATED, SEARCHED, AUTHOR -> null;
        };
    }
}
