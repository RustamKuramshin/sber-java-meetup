package ru.kuramshindev.apigatewayjava;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.kuramshin.dto.companies.CompanyDto;
import ru.kuramshin.dto.contractors.ContractorDto;
import ru.kuramshin.dto.projects.ProjectDto;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Component
public class UpstreamAsyncClients {

    private final UpstreamClients upstreamClients;

    /**
     * Получение компании по uuid
     */
    @Async
    public CompletableFuture<CompanyDto> getCompanyByIdAsync(UUID uuid) {
        return CompletableFuture.completedFuture(upstreamClients.getCompanyById(uuid));
    }

    /**
     * Получение подрядчика по uuid
     */
    @Async
    public CompletableFuture<ContractorDto> getContractorByIdAsync(UUID uuid) {
        return CompletableFuture.completedFuture(upstreamClients.getContractorById(uuid));
    }

    /**
     * Получение проекта по uuid
     */
    @Async
    public CompletableFuture<ProjectDto> getProjectByIdAsync(UUID uuid) {
        return CompletableFuture.completedFuture(upstreamClients.getProjectById(uuid));
    }
}
