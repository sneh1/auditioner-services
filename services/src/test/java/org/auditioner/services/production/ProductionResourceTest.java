package org.auditioner.services.production;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.auditioner.services.production.Production;
import org.auditioner.services.production.ProductionDAO;
import org.auditioner.services.production.ProductionResource;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.Response;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductionResourceTest extends org.auditioner.services.family.TestResourceBase {

    private static final ProductionDAO productionDAO = mock(ProductionDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = wrapResource(new ProductionResource(productionDAO));

    @Before
    public void setUp() {
        super.setUp(resources);
    }

    @Test
    public void getProductionReturn200(){
        Production production = new Production();
        production.setName("Jane Dane");
        production.setAuditionDate(new Date());
        production.setSeason("Spring 2017");

        when(productionDAO.getProduction()).thenReturn(production);

        Response response = simpleGet("/auditioner/production");

        assertEquals(200,response.getStatus());
    }
}