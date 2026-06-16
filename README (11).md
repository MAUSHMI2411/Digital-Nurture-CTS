# Exercise 2: Factory Method Pattern

**Scenario:** A document management system needs to create different types
of documents (Word, PDF, Excel) without the client code knowing the exact
class being instantiated.

## How it works
- `Document` is the common interface implemented by `WordDocument`,
  `PdfDocument`, and `ExcelDocument`.
- `DocumentFactory` is an abstract creator with the factory method
  `createDocument()`.
- Each concrete factory (`WordDocumentFactory`, `PdfDocumentFactory`,
  `ExcelDocumentFactory`) overrides `createDocument()` to return its
  specific document type.

## Run
```bash
cd src
javac *.java
java FactoryMethodTest
```
