package ru.job4j.ood.dip;
/*
Нарушение DIP, модуль верхнего уровня (DataManager)
зависит от модуля низкого уровня (Database)
 */
class DataManager {
    private Database database;

    public DataManager() {
        this.database = new Database();
    }

    public void save(String data) {
        database.saveData(data);
    }
}

class Database {
    public void saveData(String data) {
        System.out.println("Data saved to database: " + data);
    }
}