package com.formula.bet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Formula 1 Bet Service API")
                        .description("Documentation of formula Bet service endpoints")
                        .version("0.0.1")
                        .license(new License().name("Antonyo Nunes - open source")
                                .url("https://github.com/Doug-Nunes/ts-formula-1-bets")));
    }

}
