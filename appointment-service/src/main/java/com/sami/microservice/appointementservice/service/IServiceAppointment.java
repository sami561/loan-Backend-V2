package com.sami.microservice.appointementservice.service;


import com.sami.microservice.appointementservice.entities.Appointment;

import java.util.List;

public interface IServiceAppointment {
    public Appointment createAppointment(Appointment p);
    public  Appointment findAppointmentById(int id);
    public List<Appointment> findAllAppointment();
    public Appointment updateAppointment(Appointment a);
    public void deleteAppointment(int id);
}
