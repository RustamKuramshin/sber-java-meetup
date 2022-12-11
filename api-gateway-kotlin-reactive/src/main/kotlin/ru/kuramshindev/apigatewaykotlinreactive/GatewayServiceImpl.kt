package ru.kuramshindev.apigatewaykotlinreactive

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service
import ru.kuramshin.dto.apigateway.ApiGatewayDto
import java.util.*

@Service
class GatewayServiceImpl(
    private val upstreamAsyncClients: UpstreamAsyncClients
) : GatewayService {

    override suspend fun getContractById(uuid: UUID): ApiGatewayDto = coroutineScope {

        val company = async { upstreamAsyncClients.getCompanyByIdAsync(uuid) }
        val contractor = async { upstreamAsyncClients.getContractorByIdAsync(uuid) }
        val project = async { upstreamAsyncClients.getProjectByIdAsync(uuid) }

        ApiGatewayDto.builder()
            .company(company.await())
            .contractor(contractor.await())
            .project(project.await())
            .build()
    }
}