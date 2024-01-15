package com.baar.springbootwithopencsv.service;

import com.baar.springbootwithopencsv.dto.PersonDto;
import com.baar.springbootwithopencsv.exception.DataLoadedException;
import com.baar.springbootwithopencsv.model.Person;

import java.io.FileNotFoundException;
import java.util.List;

public interface PersonService {
    public void loadDataFromCsv() throws DataLoadedException, FileNotFoundException;

    public List<PersonDto> getPersons();
}
