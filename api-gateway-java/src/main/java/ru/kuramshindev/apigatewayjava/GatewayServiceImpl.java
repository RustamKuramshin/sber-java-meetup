package ru.kuramshindev.apigatewayjava;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kuramshin.dto.apigateway.ApiGatewayDto;
import ru.kuramshin.dto.companies.CompanyDto;
import ru.kuramshin.dto.contractors.ContractorDto;
import ru.kuramshin.dto.projects.ProjectDto;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Service("gatewayServiceImpl")
public class GatewayServiceImpl implements GatewayService {

    private final UpstreamClients upstreamClients;

    @Override
    public ApiGatewayDto getContractById(UUID uuid) {

        // Получение компании
        CompanyDto company = upstreamClients.getCompanyById(uuid);

        // Получение подрядчика
        ContractorDto contractor = upstreamClients.getContractorById(uuid);

        // Получение проекта
        ProjectDto project = upstreamClients.getProjectById(uuid);

        // Собираем ответ
        return ApiGatewayDto.builder()
                .company(company)
                .contractor(contractor)
                .project(project)
                .build();
    }
}
