package org.meghraj.docker.samples.config;

import com.google.common.base.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

  /**
   * Constructing @{@link Docket} instance with @{@link ApiInfo} and @{@link Predicate} paths for
   * the Swagger UI, and api-docs
   *
   * @return  {@link Docket} definition for Swagger configuration
   */
  @Bean
  public Docket docket() {

    // add correlation header to Swagger documentaton
    ParameterBuilder apiParameterBuilder = new ParameterBuilder();
    apiParameterBuilder
        .name("samples")
        .modelRef(new ModelRef("string"))
        .parameterType("header").required(false).build();

    return new Docket(DocumentationType.SWAGGER_2)
        .globalOperationParameters(Arrays.asList(apiParameterBuilder.build()))
        .groupName("sample-account-api")
        .apiInfo(apiInfo())
        .select()
        .paths(paths())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Sample Account API ")
        .description("Demonstrating the docker with micro services and service discovery  ")
        .contact(new Contact("samples",null,"vmeghraj@yahoo.com"))
        .build();
  }

  private Predicate<String> paths() {
    return (s) -> StringUtils.containsIgnoreCase(s, "admin") || StringUtils.contains(s, "api");
  }
}
