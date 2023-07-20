package com.banco.springboot.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="targetas")
public class Targetas implements Serializable {
    
    private static final Long serialVersionUID= 8540585749809984969L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_targeta" ,nullable= false, length = 16)
    @NotEmpty
    private String numero_targeta;

    @Column(name = "icv" , nullable = false, length = 3)
    @NotEmpty
    private String icv;

    @Column(name= "vencimiento")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date vencimiento;

    @JoinColumn(name = "cuenta", referencedColumnName = "id", nullable = false )
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuenta cuenta;

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_targeta() {
        return numero_targeta;
    }

    public void setNumero_targeta(String numero_targeta) {
        this.numero_targeta = numero_targeta;
    }

    public String getIcv() {
        return icv;
    }

    public void setIcv(String icv) {
        this.icv = icv;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }


}
