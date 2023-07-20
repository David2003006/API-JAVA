package com.banco.springboot.app.banco.models.entity;

  import java.io.Serializable;
    import java.util.Date;
    
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.Column;
    import javax.persistence.Id;
    import javax.persistence.GenerationType;
    import javax.persistence.Table;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat; 
    
    
    @Entity
    @Table(name= "Cuentas")
    public class Cuenta implements Serializable {
        
        private static final Long serialVersionUID= 2990602998676380780L;
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column
        @NotEmpty
            private String nombre;
    
        @Column
        @NotNull
            private double saldo;
    
        @Column(name= "numero_telefono")
            private String numero_telefono;
    
        @Column(name= "dia_creacion")
        @NotEmpty
        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
            private Date diaCreacion;

        
        public void setId(Long id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public void setNumero_telefono(String numero_telefono) {
            this.numero_telefono = numero_telefono;
        }

        public void setDiaCreacion(Date diaCreacion) {
            this.diaCreacion = diaCreacion;
        }
        public Long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public double getSaldo() {
            return saldo;
        }

        public String getNumero_telefono() {
            return numero_telefono;
        }

        public Date getDiaCreacion() {
            return diaCreacion;
        }

        public static Long getSerialversionuid() {
            return serialVersionUID;
        }
    
        
    }