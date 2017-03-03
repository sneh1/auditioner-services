package org.auditioner.services.family;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface FamilyDAO {

    @SqlUpdate("INSERT INTO Family (Name) "
            + " VALUES (:family.name)")
    @GetGeneratedKeys
    long addFamily(@BindBean("family") Family family);

    @SqlUpdate("DELETE FROM Family "
             + "WHERE id=:id")
    void deleteFamily(@Bind("id") long familyId);

    @SqlUpdate("UPDATE Family " +
               "  SET Name=:family.name " +
               "WHERE id=:id")
    void updateFamily(@Bind("id") long familyId,@BindBean("family") Family family);

    @SqlQuery("SELECT Id,Name " +
              "FROM Family")
    @Mapper(FamilyResultSetMapper.class)
    List<Family> getFamilies();

    @SqlQuery("SELECT Id,Name " +
              "FROM Family " +
              "WHERE id=:id")
    @Mapper(FamilyResultSetMapper.class)
    Family getFamily(@Bind("id") long familyId);
}

