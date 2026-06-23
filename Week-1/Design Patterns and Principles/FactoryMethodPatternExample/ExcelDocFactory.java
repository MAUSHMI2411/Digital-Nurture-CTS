public class ExcelDocFactory extends DocFactory {
    public Document createDocument() {
        return new ExcelDoc();
    }
}
