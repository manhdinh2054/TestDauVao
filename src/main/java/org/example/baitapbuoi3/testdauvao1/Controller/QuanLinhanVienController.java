package org.example.baitapbuoi3.testdauvao1.Controller;

import lombok.RequiredArgsConstructor;

import org.example.baitapbuoi3.testdauvao1.Entity.Staff;
import org.example.baitapbuoi3.testdauvao1.Entity.StaffDTO;
import org.example.baitapbuoi3.testdauvao1.Repository.StaffDTOInterface;
import org.example.baitapbuoi3.testdauvao1.Repository.StaffInterface;
import org.example.baitapbuoi3.testdauvao1.Services.StaffDTOServices;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trangchu")
public class QuanLinhanVienController {
    final StaffDTOServices sts;
    final StaffInterface sti;
    final StaffDTOInterface stdtoi;
    @GetMapping("/staff")
    public String trangchu(Model model, @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5")int size){
        Page<StaffDTO> pagelst = sts.getAllNhanVienPage(page,size);
        model.addAttribute("staffPage",pagelst);
        return "trangchu.html";
    }
    @PostMapping("/staff-add")
    public String staffAdd(@ModelAttribute Staff staff){
        sti.save(staff);
        return "redirect:/trangchu/staff";
    }
    @GetMapping("/staff-detail/{id}")
    public String staffDetail(Model model, @PathVariable("id") UUID id,Model model1){
        Optional<Staff> staffdetail = sti.findById(id);
        model1.addAttribute("staff",staffdetail);

        return "trangchudetail.html";
    }
    @DeleteMapping("/staff-delete/{id}")
    public String staffDelete(Model model, @PathVariable("id") UUID id){
        sti.deleteById(id);
        return "redirect:/trangchu/staff";
    }
}
