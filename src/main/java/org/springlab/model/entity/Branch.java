package org.springlab.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "branch_name")
    private String branchName;

    // Constructors
    public Branch() {
    }

    public Branch(Integer id, String branchName) {
        this.id = id;
        this.branchName = branchName;
    }

    // Getters & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryName() {
        return this.branchName;
    }

    public void setIndustryName(String branchName) {
        this.branchName = branchName;
    }
}
