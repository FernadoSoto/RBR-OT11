package pe.edu.vg.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personID;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Last_Name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "Document_Type", nullable = false, length = 3)
    private String documentType;

    @Column(name = "Document_Number", nullable = false, length = 20)
    private String documentNumber;

    @Column(name = "Phone", length = 9)
    private String phone;

    @Column(name = "Status", nullable = false, length = 8)
    private String status = "activo";

    @Column(name = "Role", nullable = false, length = 10)
    private String role;
}