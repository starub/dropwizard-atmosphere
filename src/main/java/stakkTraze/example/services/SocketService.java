package stakkTraze.example.services;

import javax.servlet.ServletRegistration;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.atmosphere.cpr.AtmosphereServlet;
import stakkTraze.example.configurations.TestConfiguration;
import stakkTraze.example.healthChecks.TestHealth;
import stakkTraze.example.resources.BaseResource;

import com.google.common.collect.ImmutableMap;

public class SocketService extends Application<TestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SocketService().run(args);
    }

    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {

    }

    @Override
    public void run(final TestConfiguration backendConfiguration, final Environment environment) throws Exception {
        AtmosphereServlet atmosphereServlet = new AtmosphereServlet();
        final ServletRegistration.Dynamic websocket = environment.servlets().addServlet("socket", atmosphereServlet);
        websocket.setAsyncSupported(true);
        websocket.addMapping("/socket/*");

        //@formatter:off
        websocket.setInitParameters(ImmutableMap.<String, String> of(
                "com.sun.jersey.config.property.packages","stakkTraze.example.resources.socket, io.dropwizard.jersey"
        ));
        environment.jersey().register(new BaseResource());
        environment.healthChecks().register("TestHealthCheck", new TestHealth());
    }
}
