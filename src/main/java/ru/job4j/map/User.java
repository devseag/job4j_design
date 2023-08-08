package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

// only equals
// user1 - hashcode: 1922154895, hash: 1922151198 bucket: 14 user2 - hashcode: 883049899, hash: 883046202 bucket: 10
// both equals and hashcode
// user1 - hashcode: -267596601, hash: -267633461 bucket: 11 user2 - hashcode: -267596601, hash: -267633461 bucket: 11
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

// only hashCode
// user1 - hashcode: -268462629, hash: -268469724 bucket: 4 user2 - hashcode: -268462629, hash: -268469724 bucket: 4
// both equals and hashcode
// user1 - hashcode: -267596601, hash: -267633461 bucket: 11 user2 - hashcode: -267596601, hash: -267633461 bucket: 11
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

//    user1 - hashcode: 284720968, hash: 284716976 bucket: 0 user2 - hashcode: 189568618, hash: 189564562 bucket: 2

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("Alex", 21, birthday);
        int hashcode1 = user1.hashCode();
        int hash1 = hashcode1 ^ (hashcode1 >>> 16);
        int bucket1 = hash1 & 15;
        User user2 = new User("Alex", 21, birthday);
        int hashcode2 = user2.hashCode();
        int hash2 = hashcode2 ^ (hashcode1 >>> 16);
        int bucket2 = hash2 & 15;
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.printf("user1 - hashcode: %s, hash: %s bucket: %s ",
                hashcode1, hash1, bucket1);
        System.out.printf("user2 - hashcode: %s, hash: %s bucket: %s ",
                hashcode2, hash2, bucket2);

    }
}
