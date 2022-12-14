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
@Service("gatewayServiceAsyncImpl")
public class GatewayServiceAsyncImpl implements GatewayService {

    private final UpstreamAsyncClients upstreamAsyncClients;

    @Override
    public ApiGatewayDto getContractById(UUID uuid) throws ExecutionException, InterruptedException {

        //        var apiGatewayDtoBuilder = ApiGatewayDto.builder();
        //
        //        // Получение компании
        //        var resp  = upstreamAsyncClients.getCompanyByIdAsync(uuid)
        //                .thenCompose(company -> {
        //                    apiGatewayDtoBuilder.company(company);
        //                    // Получение подрядчика
        //                    return upstreamAsyncClients.getContractorByIdAsync(uuid);
        //                })
        //                .thenCompose(contractor -> {
        //                    apiGatewayDtoBuilder.contractor(contractor);
        //                    // Получение проекта
        //                    return upstreamAsyncClients.getProjectByIdAsync(uuid);
        //                })
        //                .thenCompose(project -> {
        //                    apiGatewayDtoBuilder.project(project);
        //                    // Собираем ответ
        //                    return CompletableFuture.supplyAsync(apiGatewayDtoBuilder::build);
        //                });
        //        return resp.get();

        // Получение компании
        CompletableFuture<CompanyDto> companyCf = upstreamAsyncClients.getCompanyByIdAsync(uuid);

        // Получение подрядчика
        CompletableFuture<ContractorDto> contractorCf = upstreamAsyncClients.getContractorByIdAsync(uuid);

        // Получение проекта
        CompletableFuture<ProjectDto> projectCf = upstreamAsyncClients.getProjectByIdAsync(uuid);

        // Ждем завершения всех запросов
        CompletableFuture.allOf(companyCf, contractorCf, projectCf).join();

        // Собираем ответ
        return ApiGatewayDto.builder()
                .company(companyCf.get())
                .contractor(contractorCf.get())
                .project(projectCf.get())
                .build();
    }
}
