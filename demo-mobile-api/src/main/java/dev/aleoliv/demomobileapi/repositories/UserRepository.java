package dev.aleoliv.demomobileapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleoliv.demomobileapi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
