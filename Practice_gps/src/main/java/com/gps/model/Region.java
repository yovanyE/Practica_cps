package com.gps.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tregion")
public class Region implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegion")
	private Long codeRegion;
	@Column(name = "descripcion")
	private String description;

    @OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Country> country;
    public Region() {
    }
    public Region(Long codeRegion, String description) {
        this.codeRegion = codeRegion;
        this.description = description;
    }
    public Long getCodeRegion() {
        return codeRegion;
    }
    public void setCodeRegion(Long codeRegion) {
        this.codeRegion = codeRegion;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<Country> getCountry() {
        return country;
    }
    public void setCountry(Set<Country> country) {
        this.country = country;
    }
       

}
