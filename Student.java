/**
 * Abstract creator. Subclasses decide which concrete Document to instantiate.
 */
public abstract class DocumentFactory {

    public abstract Document createDocument();

    // Template method that uses the factory method.
    public Document openNewDocument() {
        Document document = createDocument();
        document.open();
        return document;
    }
}
