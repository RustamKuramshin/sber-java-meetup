package ru.kuramshindev.apigatewayjavareactive;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.kuramshin.dto.apigateway.ApiGatewayDto;
import ru.kuramshin.dto.companies.CompanyDto;
import ru.kuramshin.dto.contractors.ContractorDto;
import ru.kuramshin.dto.projects.ProjectDto;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class GatewayServiceAsyncImpl implements GatewayService {

    private final UpstreamAsyncClients upstreamAsyncClients;

    @Override
    public Mono<ApiGatewayDto> getContractById(UUID uuid) {

        Mono<CompanyDto> company = upstreamAsyncClients.getCompanyByIdAsync(uuid);

        Mono<ContractorDto> contractor = upstreamAsyncClients.getContractorByIdAsync(uuid);

        Mono<ProjectDto> project = upstreamAsyncClients.getProjectByIdAsync(uuid);

        return Mono.zip(company, contractor, project).map(r -> ApiGatewayDto.builder()
                .company(r.getT1())
                .contractor(r.getT2())
                .project(r.getT3())
                .build());
    }
}
