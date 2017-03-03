package org.auditioner.services;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.auditioner.services.family.FamilyResource;

public class AuditionApplication extends Application<Configuration>
{
    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

        environment.jersey().register(new FamilyResource());
    }
}
