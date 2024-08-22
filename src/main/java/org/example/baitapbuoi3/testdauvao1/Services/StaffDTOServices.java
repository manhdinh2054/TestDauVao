package org.example.baitapbuoi3.testdauvao1.Services;

import org.example.baitapbuoi3.testdauvao1.Entity.Staff;
import org.example.baitapbuoi3.testdauvao1.Entity.StaffDTO;
import org.example.baitapbuoi3.testdauvao1.Repository.StaffDTOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StaffDTOServices {
    @Autowired
    StaffDTOInterface stdtoi;

    public Page<StaffDTO> getAllNhanVienPage(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return stdtoi.getAllNhanVienpage(pageable);
    }
}
