package leapwise.dmx.bankingsystem.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("default")
				.packagesToScan("leapwise.dmx.bankingsystem.controller")
				.build();
	}
}
