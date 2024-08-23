package org.example.baitapbuoi3.testdauvao1.Controller;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.testdauvao1.Entity.Staff;
import org.example.baitapbuoi3.testdauvao1.Entity.StaffDTO;
import org.example.baitapbuoi3.testdauvao1.Repository.StaffDTOInterface;
import org.example.baitapbuoi3.testdauvao1.Repository.StaffInterface;
import org.example.baitapbuoi3.testdauvao1.Services.StaffDTOServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/head-office")
public class QuanLiBoMonController {
    final StaffDTOServices sts;
    final StaffInterface sti;
    final StaffDTOInterface stdtoi;

    @GetMapping("/staff/{id}")
    public String headOffice(Model model, @PathVariable("id") UUID id) {
        Optional<Staff> lst = sti.findById(id);
        List<Object[]> lstbomon = sti.findFacilityDepartmentMajor(id);
        model.addAttribute("staffbomon", lstbomon);
        if(lst.isPresent()){
            model.addAttribute("staff", lst.get());

        }else {
            model.addAttribute("staff", new Staff());
        }
        return "trangchuheadoffice";
    }
}
