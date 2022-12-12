package ru.kuramshindev.apigatewaykotlinreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication(exclude = [
	DataSourceAutoConfiguration::class,
	DataSourceTransactionManagerAutoConfiguration::class,
	HibernateJpaAutoConfiguration::class
])
@EnableFeignClients(basePackages = ["ru.kuramshindev"])
class ApiGatewayKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<ApiGatewayKotlinReactiveApplication>(*args)
}
