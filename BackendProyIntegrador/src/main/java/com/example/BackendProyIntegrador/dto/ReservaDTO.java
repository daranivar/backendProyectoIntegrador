package com.example.BackendProyIntegrador.dto;

import com.example.BackendProyIntegrador.login.AppUser;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {

    private Long id;

    private LocalTime horaInicioReserva;

    /*@Temporal(TemporalType.TIMESTAMP)*/
    private LocalDate fechaInicioReserva;

    /*@Temporal(TemporalType.TIMESTAMP)*/
    private LocalDate fechafinReserva;

    private AppUser appUser;

    public ReservaDTO() {
    }

    public ReservaDTO(LocalTime horaInicioReserva, LocalDate fechaInicioReserva, LocalDate fechafinReserva, AppUser appUser) {
        this.horaInicioReserva = horaInicioReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechafinReserva = fechafinReserva;
        this.appUser = appUser;
    }

    public ReservaDTO(Long id, LocalTime horaInicioReserva, LocalDate fechaInicioReserva, LocalDate fechafinReserva, AppUser appUser) {
        this.id = id;
        this.horaInicioReserva = horaInicioReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechafinReserva = fechafinReserva;
        this.appUser = appUser;
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
