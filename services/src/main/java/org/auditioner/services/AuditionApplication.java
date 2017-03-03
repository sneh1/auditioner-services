package org.auditioner.services;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.auditioner.services.family.FamilyDAO;
import org.auditioner.services.family.FamilyResource;
import org.skife.jdbi.v2.DBI;

public class AuditionApplication extends Application<AuditionConfiguration>
{
    @Override
    public void run(AuditionConfiguration configuration, Environment environment) throws Exception {

        DBIFactory dbiFactory = new DBIFactory();

        final DBI jdbi = dbiFactory.build(environment, configuration.getDataSourceFactory(), "auditioner-connection");

        final FamilyDAO familyDAO = jdbi.onDemand(FamilyDAO.class);

        environment.jersey().register(new FamilyResource(familyDAO));
    }
}
