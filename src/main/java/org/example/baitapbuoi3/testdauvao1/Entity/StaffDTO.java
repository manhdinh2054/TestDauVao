package org.example.baitapbuoi3.testdauvao1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StaffDTO {
    @Id
    private UUID id;
    private String staffCode;
    private String name;
    private String accountFpt;
    private String accountFe;
    private Short status;
}
