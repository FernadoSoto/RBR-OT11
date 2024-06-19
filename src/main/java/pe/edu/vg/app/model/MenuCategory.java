package pe.edu.vg.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "Menu_Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Long categoryID;

    @Column(name = "Category_Name", nullable = false, length = 50)
    private String categoryName;

    @Column(name = "Status", nullable = false, length = 8)
    private String status = "activo";

}