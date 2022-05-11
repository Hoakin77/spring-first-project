package ru.geekbrains.prisist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.prisist.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
