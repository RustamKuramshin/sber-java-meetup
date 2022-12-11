package ru.kuramshindev.apigatewayjavareactive;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.kuramshin.dto.companies.CompanyDto;
import ru.kuramshin.dto.contractors.ContractorDto;
import ru.kuramshin.dto.projects.ProjectDto;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class UpstreamAsyncClients {

    private final WebClient webClient;

    public Mono<CompanyDto> getCompanyByIdAsync(UUID uuid) {
        return webClient.get().uri("/companies/{uuid}", uuid).retrieve().bodyToMono(CompanyDto.class);
    }

    public Mono<ContractorDto> getContractorByIdAsync(UUID uuid) {
        return webClient.get().uri("/contractors/{uuid}", uuid).retrieve().bodyToMono(ContractorDto.class);
    }

    public Mono<ProjectDto> getProjectByIdAsync(UUID uuid) {
        return webClient.get().uri("/projects/{uuid}", uuid).retrieve().bodyToMono(ProjectDto.class);
    }
}
