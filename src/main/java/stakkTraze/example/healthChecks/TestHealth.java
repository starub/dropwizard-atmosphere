package stakkTraze.example.healthChecks;

import com.codahale.metrics.health.HealthCheck;

/**
 * Dummy test class
 * 
 * @author tweber
 * 
 */
public class TestHealth extends HealthCheck {

    @Override
    protected Result check() throws Exception {

        return Result.healthy();
    }

}
