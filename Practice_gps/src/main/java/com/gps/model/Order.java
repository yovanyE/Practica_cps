package com.gps.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tpedido")
public class Order implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
	private Long codOrder;
    @Column(name = "peso")
	private Double weight;
    @Column(name="ancho")
    private Double width;
    @Column(name = "alto")
    private Double tall;
    @Column(name="largo")
    private Double longg;
    @Column(name = "tarifa")
    private Double rate;
    @Column(name="cotizacion")
    private Double quotation;
    @Column(name = "paisOrigen")
    private String originCountry;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaisDestino")
    private Country countryDestination;

    public Order() {
    }

    public Order(Long codOrder, Double weight, Double width, Double tall, Double longg, Double rate, Double quotation,
            String originCountry, Country countryDestination) {
        this.codOrder = codOrder;
        this.weight = weight;
        this.width = width;
        this.tall = tall;
        this.longg = longg;
        this.rate = rate;
        this.quotation = quotation;
        this.originCountry = originCountry;
        this.countryDestination = countryDestination;
    }

    public Long getCodOrder() {
        return codOrder;
    }

    public void setCodOrder(Long codOrder) {
        this.codOrder = codOrder;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getTall() {
        return tall;
    }

    public void setTall(Double tall) {
        this.tall = tall;
    }

    public Double getLongg() {
        return longg;
    }

    public void setLongg(Double longg) {
        this.longg = longg;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getQuotation() {
        return quotation;
    }

    public void setQuotation(Double quotation) {
        this.quotation = quotation;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Country getCountryDestination() {
        return countryDestination;
    }

    public void setCountryDestination(Country countryDestination) {
        this.countryDestination = countryDestination;
    }
    
}
