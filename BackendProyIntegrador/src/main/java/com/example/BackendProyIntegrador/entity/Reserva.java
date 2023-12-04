package com.example.BackendProyIntegrador.entity;

import com.example.BackendProyIntegrador.login.AppUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime horaInicioReserva;

    /*@Temporal(TemporalType.TIMESTAMP)*/
    private LocalDate fechaInicioReserva;

    /*@Temporal(TemporalType.TIMESTAMP)*/
    private LocalDate fechafinReserva;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUser;

    public Reserva() {
    }

    public Reserva(LocalTime horaInicioReserva, LocalDate fechaInicioReserva, LocalDate fechafinReserva) {
        this.horaInicioReserva = horaInicioReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechafinReserva = fechafinReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHoraInicioReserva() {
        return horaInicioReserva;
    }

    public void setHoraInicioReserva(LocalTime horaInicioReserva) {
        this.horaInicioReserva = horaInicioReserva;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public LocalDate getFechafinReserva() {
        return fechafinReserva;
    }

    public void setFechafinReserva(LocalDate fechafinReserva) {
        this.fechafinReserva = fechafinReserva;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
