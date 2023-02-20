package com.valhallacore.config;

import com.valhallacore.dto.paypal.Client;
import com.valhallacore.dto.paypal.Urls;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "paypal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayPalConfig {
    private String mode;
    private Client client;
    private Urls urls;
}


