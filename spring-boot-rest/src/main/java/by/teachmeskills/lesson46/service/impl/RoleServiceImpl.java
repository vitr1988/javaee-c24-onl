package by.teachmeskills.lesson46.service.impl;

import by.teachmeskills.lesson46.entity.Role;
import by.teachmeskills.lesson46.repository.RoleRepository;
import by.teachmeskills.lesson46.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
