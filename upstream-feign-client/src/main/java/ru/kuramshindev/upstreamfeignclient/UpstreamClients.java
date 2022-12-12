package ru.kuramshindev.upstreamfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kuramshin.dto.companies.CompanyDto;
import ru.kuramshin.dto.contractors.ContractorDto;
import ru.kuramshin.dto.projects.ProjectDto;

import java.util.UUID;

@FeignClient(name = "upstreams", url = "${upstreams.base-uri}")
public interface UpstreamClients {

    @RequestMapping(method = RequestMethod.GET, value = "/companies/{uuid}")
    CompanyDto getCompanyById(@PathVariable UUID uuid);

    @RequestMapping(method = RequestMethod.GET, value = "/contractors/{uuid}")
    ContractorDto getContractorById(@PathVariable UUID uuid);

    @RequestMapping(method = RequestMethod.GET, value = "/projects/{uuid}")
    ProjectDto getProjectById(@PathVariable UUID uuid);
}
