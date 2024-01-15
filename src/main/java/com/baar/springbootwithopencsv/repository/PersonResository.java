package com.baar.springbootwithopencsv.repository;

import com.baar.springbootwithopencsv.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonResository extends JpaRepository<Person,Integer> {
}
