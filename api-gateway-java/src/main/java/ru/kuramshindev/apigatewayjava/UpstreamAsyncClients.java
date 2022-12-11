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
public class UpstreamAsyncClients {

    private final RestTemplate restTemplate;

    /**
     * Получение компании по uuid
     * @param uuid
     * @return
     */
    @Async
    public CompletableFuture<CompanyDto> getCompanyById(UUID uuid) {

        CompanyDto company = restTemplate.getForObject("/companies/{uuid}", CompanyDto.class, uuid);

        return CompletableFuture.completedFuture(company);
    }

    /**
     * Получение подрядчика по uuid
     * @param uuid
     * @return
     */
    @Async
    public CompletableFuture<ContractorDto> getContractorById(UUID uuid) {

        ContractorDto contractor = restTemplate.getForObject("/contractors/{uuid}", ContractorDto.class, uuid);

        return CompletableFuture.completedFuture(contractor);
    }

    /**
     * Получение проекта по uuid
     * @param uuid
     * @return
     */
    @Async
    public CompletableFuture<ProjectDto> getProjectById(UUID uuid) {

        ProjectDto project = restTemplate.getForObject("/projects/{uuid}", ProjectDto.class, uuid);

        return CompletableFuture.completedFuture(project);
    }
}
