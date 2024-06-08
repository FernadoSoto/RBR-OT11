package pe.edu.vg.app.model;


import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Data
@Entity
@Table(name = "MenuCategory")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Long categoryID;

    @Column(name = "CategoryName", length = 50)
    private String categoryName;

    @Column(name = "Status", length = 8, columnDefinition = "NVARCHAR2(8) DEFAULT 'active'")
    private String status;
}

