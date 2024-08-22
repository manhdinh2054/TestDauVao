package org.example.baitapbuoi3.testdauvao1.Repository;

import org.example.baitapbuoi3.testdauvao1.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffInterface extends JpaRepository<Staff, UUID> {

}
