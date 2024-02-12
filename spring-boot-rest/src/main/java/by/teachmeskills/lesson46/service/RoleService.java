package by.teachmeskills.lesson46.service;

import by.teachmeskills.lesson46.entity.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(String name);
}
