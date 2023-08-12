package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        /* Poluchaem kontekst dlja dostupa k API */
        JAXBContext context = JAXBContext.newInstance(Person.class);
        /* Sozdaem serializator */
        Marshaller marshaller = context.createMarshaller();
        /* Ukazyvaem, chto nam nuzhno formatirovanie */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Serializuem */
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Dlja deserializacii nam nuzhno sozdat' deserializator */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* deserializuem */
            Person result = (Person) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}