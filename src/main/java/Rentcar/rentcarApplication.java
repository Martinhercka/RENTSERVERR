package Rentcar;

import Rentcar.resources.Car;
import Rentcar.resources.Login;
import Rentcar.resources.Order2;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;


import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class rentcarApplication extends Application<rentcarConfiguration> {

    public static void main(final String[] args) throws Exception {
        new rentcarApplication().run(args);
    }

    @Override
    public String getName() {
        return "rentcar";
    }

    @Override
    public void initialize(final Bootstrap<rentcarConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final rentcarConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new Car());
        environment.jersey().register(new Order2());
        environment.jersey().register(new Login());

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
// Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());


    }
}