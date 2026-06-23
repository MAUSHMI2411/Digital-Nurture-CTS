public class Test {
    public static void main(String[] args) {
        DocFactory factory;

        factory = new WordDocFactory();
        Document doc1 = factory.createDocument();
        doc1.open();

        factory = new PdfDocFactory();
        Document doc2 = factory.createDocument();
        doc2.open();

        factory = new ExcelDocFactory();
        Document doc3 = factory.createDocument();
        doc3.open();
    }
}
