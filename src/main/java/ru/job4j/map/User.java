package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        User userOne = new User("Dima", 3, birthday);
        int hashCodeOne = userOne.hashCode();
        int hashOne = hashCodeOne ^ (hashCodeOne >>> 16);
        int bucketOne = hashOne & 15;
        User userTwo = new User("Dima", 3, birthday);
        int hashCodeTwo = userTwo.hashCode();
        int hashTwo = hashCodeTwo ^ (hashCodeTwo >>> 16);
        int bucketTwo = hashTwo & 15;
        Map<User, Object> map = new HashMap<>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());

        System.out.printf("userOne - хэшкод: %s, хэш: %s, бакет: %s\n",
                hashCodeOne, hashOne, bucketOne);
        System.out.printf("userTwo - хэшкод: %s, хэш: %s, бакет: %s\n",
                hashCodeTwo, hashTwo, bucketTwo);
        System.out.println(map.get(userOne).equals(map.get(userTwo)));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
