package org.example;

import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.ByteArrayInputStream;
import java.util.logging.Logger;

@WebListener
public class ContextListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(ContextListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("Initializing keycloak deployment");
        KeycloakDeployment deployment = KeycloakDeploymentBuilder.build(KeycloakDeploymentBuilder.loadAdapterConfig(new ByteArrayInputStream(CONFIG.getBytes())));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private static final String CONFIG = "{\n" +
            "    \"realm\": \"demo\",\n" +
            "    \"resource\": \"customer-portal\",\n" +
            "    \"auth-server-url\": \"http://127.0.0.1\",\n" +
            "    \"realm-public-key\": \"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrVrCuTtArbgaZzL1hvh0xtL5mc7o0NqPVnYXkLvgcwiC3BjLGw1tGEGoJaXDuSaRllobm53JBhjx33UNv+5z/UMG4kytBWxheNVKnL6GgqlNabMaFfPLPCF8kAgKnsi79NMo+n6KnSY8YeUmec/p2vjO2NjsSAVcWEQMVhJ31LwIDAQAB\"\n" +
            "   }";
}
