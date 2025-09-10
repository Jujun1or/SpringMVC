package ru.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.springmvc.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }

}
