package ru.kuramshindev.apigatewaykotlinreactive

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import ru.kuramshin.dto.companies.CompanyDto
import ru.kuramshin.dto.contractors.ContractorDto
import ru.kuramshin.dto.projects.ProjectDto
import java.util.*

@Component
class UpstreamAsyncClients(
    private val webClient: WebClient
) {
    suspend fun getCompanyByIdAsync(uuid: UUID): CompanyDto =
        webClient.get().uri("/companies/${uuid}").retrieve().awaitBody()

    suspend fun getContractorByIdAsync(uuid: UUID): ContractorDto =
        webClient.get().uri("/contractors/${uuid}").retrieve().awaitBody()

    suspend fun getProjectByIdAsync(uuid: UUID): ProjectDto =
        webClient.get().uri("/projects/${uuid}").retrieve().awaitBody()
}