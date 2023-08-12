package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Person {

    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
    }

//    <?xml version="1.1" encoding="UTF-8" ?>
//<person sex="false" age="30">
//    <contact phone="11-111"/>
//    <statuses>
//        <status>Worker</status>
//        <status>Married</status>
//    </statuses>
//</person>

//    <?xml version="1.1" encoding="UTF-8" ?>
//<animal isPet="true" age="5" nickName="Nick">
//    <pet paws="4"/>
//    <habits>
//        <habit>swim</habit>
//        <habit>run</habit>
//        <habit>eat</habit>
//    </habits>
//</animal>


}