package ru.kuramshindev.apigatewayjava;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kuramshin.dto.apigateway.ApiGatewayDto;
import ru.kuramshin.dto.companies.CompanyDto;
import ru.kuramshin.dto.contractors.ContractorDto;
import ru.kuramshin.dto.projects.ProjectDto;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Service
public class GatewayServiceImpl implements GatewayService {

    private final UpstreamClients upstreamClients;

    @Override
    public ApiGatewayDto getContractById(UUID uuid) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        CompletableFuture<CompanyDto> companyCf = upstreamClients.getCompanyById(uuid);
        CompletableFuture<ContractorDto> contractorCf = upstreamClients.getContractorById(uuid);
        CompletableFuture<ProjectDto> projectCf = upstreamClients.getProjectById(uuid);

        CompletableFuture.allOf(companyCf, contractorCf, projectCf).join();

        log.info("Elapsed time: " + (System.currentTimeMillis() - start));

        return ApiGatewayDto.builder()
                .company(companyCf.get())
                .contractor(contractorCf.get())
                .project(projectCf.get())
                .build();
    }
}
