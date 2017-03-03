package org.auditioner.services.production;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.auditioner.services.production.Production;
import org.auditioner.services.production.ProductionDAO;
import org.auditioner.services.production.ProductionResource;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

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
        Response response = simplePost("/auditioner/production", production);
        assertEquals(200,response.getStatus());
    }
}