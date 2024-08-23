package org.example.baitapbuoi3.testdauvao1.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Parent;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
    @Column(name = "status", columnDefinition = "tinyint")
    private Short status;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "last_modified_date")
    private Long lastModifiedDate;

    @Size(max = 255)
    @Nationalized
    @Column(name = "account_fe")
    @NotBlank(message ="không được để trống")
    @Pattern(regexp = ".*@fe\\.edu\\.vn$", message = "Tài khoản FE phải kết thúc bằng @fe.edu.vn")
    private String accountFe;

    @Size(max = 255)
    @Nationalized
    @Column(name = "account_fpt")
    @NotBlank(message ="không được để trống")
    @Pattern(regexp = ".*@fpt\\.edu\\.vn$", message = "Tài khoản FPT phải kết thúc bằng @fpt.edu.vn")
    private String accountFpt;

    @Size(max = 255)
    @Nationalized
    @Column(name = "name")
    @NotBlank(message ="không được để trống")
    private String name;

    @Size(max = 255)
    @Nationalized
    @Column(name = "staff_code")
    @NotBlank(message ="không được để trống")
    private String staffCode;
}