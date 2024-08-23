package org.example.baitapbuoi3.testdauvao1.Repository;

import org.example.baitapbuoi3.testdauvao1.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StaffInterface extends JpaRepository<Staff, UUID> {
    @Query(value = "SELECT s.id,f.name AS facility_name, " +
            "d.name AS department_name, " +
            "m.name AS major_name " +
            "FROM staff s " +
            "JOIN staff_major_facility smf ON s.id = smf.id_staff " +
            "JOIN major_facility mf ON smf.id_major_facility = mf.id " +
            "JOIN major m ON mf.id_major = m.id " +
            "JOIN department_facility df ON mf.id_department_facility = df.id " +
            "JOIN department d ON df.id_department = d.id " +
            "JOIN facility f ON df.id_facility = f.id  where s.id = :id " +
            "ORDER BY facility_name, department_name, major_name",
            nativeQuery = true)
    List<Object[]> findFacilityDepartmentMajor(@Param("id")UUID id);
}
