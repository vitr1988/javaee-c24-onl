package by.tms.service;

import by.tms.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Long createClient(String name);

    List<ClientDto> findAll();

    Optional<ClientDto> findById(Long id);

    void deleteById(Long id);

    void update(Long id, String name);
}
