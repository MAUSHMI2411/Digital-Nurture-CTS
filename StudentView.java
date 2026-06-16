/**
 * Demonstrates creating different document types using the factory method.
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.openNewDocument();
        wordDoc.save();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.openNewDocument();
        pdfDoc.save();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.openNewDocument();
        excelDoc.save();
    }
}
