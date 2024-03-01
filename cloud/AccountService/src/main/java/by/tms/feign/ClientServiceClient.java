package by.tms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import by.tms.feign.dto.ClientDto;

import java.util.Optional;

@FeignClient(name = "ClientService", fallback = ClientServiceFallback.class)
public interface ClientServiceClient {

    @GetMapping("/get/{id}")
    Optional<ClientDto> findById(@PathVariable Long id);

}
