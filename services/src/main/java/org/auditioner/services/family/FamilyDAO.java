package org.auditioner.services.family;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface FamilyDAO {

    @SqlUpdate("INSERT INTO Family (Name) "
            + " VALUES (:family.name)")
    @GetGeneratedKeys
    long addFamily(@BindBean("family") Family family);
}

