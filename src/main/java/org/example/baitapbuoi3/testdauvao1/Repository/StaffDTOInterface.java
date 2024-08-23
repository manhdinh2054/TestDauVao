package org.example.baitapbuoi3.testdauvao1.Repository;

import org.example.baitapbuoi3.testdauvao1.Entity.Staff;
import org.example.baitapbuoi3.testdauvao1.Entity.StaffDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StaffDTOInterface extends JpaRepository<StaffDTO, UUID> {
    @Query(value = "select staff_code as staffCode,name,account_fpt as accountFpt,account_fe as accountFe,status from staff",nativeQuery = true)
    List<StaffDTO> getAllNhanVien();

    @Query(value = "select id, staff_code as staffCode,name,account_fpt as accountFpt,account_fe as accountFe,status from staff",nativeQuery = true)
    Page<StaffDTO> getAllNhanVienpage(Pageable pageable);
}
