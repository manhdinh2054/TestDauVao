package org.example.baitapbuoi3.testdauvao1.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.testdauvao1.Entity.Staff;
import org.example.baitapbuoi3.testdauvao1.Repository.StaffDTOInterface;
import org.example.baitapbuoi3.testdauvao1.Repository.StaffInterface;
import org.example.baitapbuoi3.testdauvao1.Services.StaffDTOServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Controller
@RequiredArgsConstructor
@RequestMapping("/trangchu")
public class QuanliNhanVienEditController {
    final StaffDTOServices sts;
    final StaffInterface sti;
    final StaffDTOInterface stdtoi;
    @GetMapping("/staffedit/{id}")
    public String staffEdit(Model model, @PathVariable("id") UUID id) {
        Optional<Staff> staffdetail = sti.findById(id);
        model.addAttribute("staffedit1", staffdetail.get());
        return "trangchudetail.html";
    }
    @PostMapping("/staff-edit/{id}")
    public String staffEdit(@PathVariable("id") UUID id, @Valid @ModelAttribute("staff") Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<FieldError> lsterrors = result.getFieldErrors();
            Map<String, String> errors = new HashMap<String, String>();
            for (FieldError e : lsterrors) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "trangchudetail.html";
        } else {
            Staff staffToUpdate = sti.findById(id).get();
            staffToUpdate.setStaffCode(staff.getStaffCode());
            staffToUpdate.setName(staff.getName());
            staffToUpdate.setAccountFe(staff.getAccountFe());
            staffToUpdate.setAccountFpt(staff.getAccountFpt());
            staffToUpdate.setStatus(staff.getStatus());
            sti.save(staffToUpdate);
        }
        return "redirect:/trangchu/staff";
    }
}
