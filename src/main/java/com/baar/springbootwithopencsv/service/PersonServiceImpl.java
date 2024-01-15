package com.baar.springbootwithopencsv.service;

import com.baar.springbootwithopencsv.dto.PersonDto;
import com.baar.springbootwithopencsv.exception.DataLoadedException;
import com.baar.springbootwithopencsv.model.Person;
import com.baar.springbootwithopencsv.repository.PersonResository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service(value = "personService")
@Slf4j
public class PersonServiceImpl implements PersonService {
    private final ModelMapper modelMapper;

    private final PersonResository personResository;

    public PersonServiceImpl(PersonResository personResository,
                             ModelMapper modelMapper) {
        this.personResository = personResository;

        this.modelMapper = modelMapper;
    }


    /*
     * To load data into database with @PostConstruct immediately after starting the application.
     * */
    @Override
//    @PostConstruct
    public void loadDataFromCsv() throws DataLoadedException, FileNotFoundException {

        List<Person> savedDataList = personResository.findAll();
        String filePath = "src/main/resources/data/MOCK_DATA.csv";
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        List<Person> personList = new CsvToBeanBuilder<Person>(csvReader).withType(Person.class).build().parse();
        if ((savedDataList.isEmpty())) {
            personList.forEach(personResository::save);
            log.info("Saved data successfully!");

        } else {
            throw new DataLoadedException("Data already loaded!");
        }

    }

    @Override
    public List<PersonDto> getPersons() {
        return personResository.findAll().stream().map(data -> modelMapper.map(data, PersonDto.class)).toList();
    }
}
