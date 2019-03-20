package ru.milandr.courses.rjdb.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.User;

@Repository

public interface UserDao extends CrudRepository<User, Long> {

}

