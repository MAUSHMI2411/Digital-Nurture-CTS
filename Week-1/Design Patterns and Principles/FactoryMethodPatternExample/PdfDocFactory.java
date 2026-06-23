public class PdfDocFactory extends DocFactory {
    public Document createDocument() {
        return new PdfDoc();
    }
}
