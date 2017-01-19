package gov.samhsa.c2s.phr.config;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "c2s.phr")
@Data
public class PhrProperties {

    @NotNull
    @Valid
    private Iexhub iexhub;

    @NotNull
    @Valid
    private Redis redis;

    @NotNull
    @Valid
    private Pagination pagination;

    @NotEmpty
    private String domainId;

    @NotEmpty
    private String assigningAuthority;

    @Data
    public static class Iexhub {
        @NotEmpty
        private String url;

        @NotEmpty
        private String ssoauth;

        @NotEmpty
        private String publishUrl;
    }

    @Data
    public static class Redis {
        @NotNull
        private long defaultExpirationInSeconds;
    }

    @Data
    public static class Pagination {
        @NotNull
        @Min(0)
        private int itemsPerPage;
    }
}