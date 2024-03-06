package ru.job4j.serialization;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;
    Test test;

    public Contact(int zipCode, String phone, Test test) {
        this.zipCode = zipCode;
        this.phone = phone;
        this.test = test;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + ", test=" + test
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test one = new Test("Red", "24");
        final Contact test = new Contact(123456, "+7 (111) 111-11-11", one);

        File tempFile = Files.createTempFile(null, null).toFile();

        try (FileOutputStream out = new FileOutputStream(tempFile);
             ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            objOut.writeObject(test);
        }

        try (FileInputStream inp = new FileInputStream(tempFile);
             ObjectInputStream objInp = new ObjectInputStream(inp)) {
            Contact concat = (Contact) objInp.readObject();
            System.out.println(concat);
        }
    }
}
