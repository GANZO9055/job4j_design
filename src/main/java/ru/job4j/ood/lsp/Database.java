package ru.job4j.ood.lsp;

/*
Происходит нарушение LSP, т.к. метод joinTable может подходить
для MySQLDatabase (реляционная база), но не для MongoDatabase (неряционная база),
из-за чего мы получаем ошибку.
 */
public class Database {
    void connect() {
    }
    void read() {
    }
    void write() {
    }
    void joinTable() {
    }
}

class MySQLDatabase extends Database {
    @Override
    void connect() {
        super.connect();
    }
    @Override
    void read() {
        super.read();
    }
    @Override
    void write() {
        super.write();
    }
    @Override
    void joinTable() {
        super.joinTable();
    }
}

class MongoDatabase extends Database {
    @Override
    void connect() {
        super.connect();
    }
    @Override
    void read() {
        super.read();
    }
    @Override
    void write() {
        super.write();
    }
    @Override
    void joinTable() {
        throw new RuntimeException("У монго БД нет таблиц");
    }
}
