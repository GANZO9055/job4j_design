package ru.job4j.ood.lsp;


/*
Происходит нарушение LSP, т.к. изменяется постусловие,
из-за чего документ не будет соответствовать ожиданиям.
 */
class Document {
    public String getContent() {
        return "Document Content";
    }
}

class EncryptedDocument extends Document {
    @Override
    public String getContent() {
        return encrypt(super.getContent());
    }

    private String encrypt(String content) {
        return "Encrypted Content";
    }
}

class Test {
    public static void main(String[] args) {
        Document encryptedDocument = new EncryptedDocument();
        String content = encryptedDocument.getContent();
        if (!content.equals("Document Content")) {
            throw new RuntimeException(
                    "Происходит нарушение LSP, содержимое документа не соответствует условию");
        }
        System.out.println(content);
    }
}
