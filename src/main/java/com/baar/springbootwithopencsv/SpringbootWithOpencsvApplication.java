package com.baar.springbootwithopencsv;

import com.baar.springbootwithopencsv.model.Person;
import com.baar.springbootwithopencsv.model.PersonHeader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootWithOpencsvApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringbootWithOpencsvApplication.class, args);

        List<Person> persons = new ArrayList<>();


        String filePath = "src/main/resources/data/MOCK_DATA.csv";


        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(PersonHeader.class)
                .setSkipHeaderRecord(true)
                .build();
        FileReader in = new FileReader(filePath);
        Iterable<CSVRecord> csvRecords = csvFormat.parse(in);
        csvRecords.forEach(csvRecord -> {

            String firstName = csvRecord.get(PersonHeader.firstName);
            String id = csvRecord.get(PersonHeader.id);

            Person person = new Person();
            person.setId(Integer.valueOf(id));
            person.setFirstName(firstName);
            person.setLastName(csvRecord.get(PersonHeader.lastName));
            person.setEmail(csvRecord.get(PersonHeader.email));
            person.setGender(csvRecord.get(PersonHeader.gender));
            person.setIpAddress(csvRecord.get(PersonHeader.ipAddress));
            persons.add(person);

        });


        persons.forEach(System.out::println);


    }

}
