package ru.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.springmvc.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>(Arrays.asList(new Person(++PEOPLE_COUNT, "John"),
                new Person(++PEOPLE_COUNT, "Roma"),
                new Person(++PEOPLE_COUNT, "Gleb")));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id){
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }


}
