package ru.kuramshindev.apigatewayjava;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kuramshin.dto.companies.CompanyDto;
import ru.kuramshin.dto.contractors.ContractorDto;
import ru.kuramshin.dto.projects.ProjectDto;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Component
public class UpstreamClients {

    private final RestTemplate restTemplate;

    /**
     * Получение компании по uuid
     */
    public CompanyDto getCompanyById(UUID uuid) {
        return restTemplate.getForObject("/companies/{uuid}", CompanyDto.class, uuid);
    }

    /**
     * Получение подрядчика по uuid
     */
    @Async
    public ContractorDto getContractorById(UUID uuid) {
        return restTemplate.getForObject("/contractors/{uuid}", ContractorDto.class, uuid);
    }

    /**
     * Получение проекта по uuid
     */
    @Async
    public ProjectDto getProjectById(UUID uuid) {
        return restTemplate.getForObject("/projects/{uuid}", ProjectDto.class, uuid);
    }
}
