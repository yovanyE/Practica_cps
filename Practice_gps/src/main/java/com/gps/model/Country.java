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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tpais")
public class Country implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPais")
	private Long codCountry;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "tarifas")
    private Double rates;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRegion")
    private Region region;
    
    @OneToMany(mappedBy = "countryDestination", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Order> order;
    
    public Country() {
    }

    public Country(Long codCountry, String description, Double rates, Region region) {
        this.codCountry = codCountry;
        this.description = description;
        this.rates = rates;
        this.region = region;
    }

    public Long getCodCountry() {
        return codCountry;
    }

    public void setCodCountry(Long codCountry) {
        this.codCountry = codCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRates() {
        return rates;
    }

    public void setRates(Double rates) {
        this.rates = rates;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

     public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
    
}
