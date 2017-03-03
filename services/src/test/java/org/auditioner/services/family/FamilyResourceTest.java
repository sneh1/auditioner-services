package org.auditioner.services.family;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;


public class FamilyResourceTest extends TestResourceBase {

    private static final FamilyDAO familyDAO = mock(FamilyDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = wrapResource(new FamilyResource(familyDAO));

    @Before
    public void setUp() {
        super.setUp(resources);

        reset(familyDAO);
    }

    @Test
    public void addFamilyCreatesFamily(){

        when(familyDAO.addFamily(any(Family.class))).thenReturn(14134L);

        Family family = new Family();
        family.setName("MyName");

        Response response = simplePost("/auditioner/family",family);

        assertEquals(201,response.getStatus());
        assertEquals("http://localhost:9998/auditioner/family/14134",response.getLocation().toString());
    }

}