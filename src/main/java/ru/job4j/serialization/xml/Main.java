package ru.job4j.serialization.xml;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static void main(String[] args) throws Exception {
//        Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
//        /* Poluchaem kontekst dlja dostupa k API */
//        JAXBContext context = JAXBContext.newInstance(Person.class);
//        /* Sozdaem serializator */
//        Marshaller marshaller = context.createMarshaller();
//        /* Ukazyvaem, chto nam nuzhno formatirovanie */
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        String xml = "";
//        try (StringWriter writer = new StringWriter()) {
//            /* Serializuem */
//            marshaller.marshal(person, writer);
//            xml = writer.getBuffer().toString();
//            System.out.println(xml);
//        }
//        /* Dlja deserializacii nam nuzhno sozdat' deserializator */
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        try (StringReader reader = new StringReader(xml)) {
//            /* deserializuem */
//            Person result = (Person) unmarshaller.unmarshal(reader);
//            System.out.println(result);
//        }
//
//    }

    public static void main(String[] args) {

        /* JSONObject iz json-stroki stroki */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        /* JSONArray iz ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject naprjamuju metodom put */
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.getSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        /* Vyvedem rezul'tat v konsol' */
        System.out.println(jsonObject.toString());

        /* Preobrazuem ob#ekt person v json-stroku */
        System.out.println(new JSONObject(person).toString());
    }
}