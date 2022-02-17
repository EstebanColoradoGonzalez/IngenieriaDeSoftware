package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoPersona;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Persona;
import com.uco.myproject.dominio.servicio.ServicioGuardarPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarPersona
{
    private final ServicioGuardarPersona servicioGuardarPersona;

    public ServicioAplicacionGuardarPersona(ServicioGuardarPersona servicioGuardarPersona)
    {
        this.servicioGuardarPersona = servicioGuardarPersona;
    }

    public DtoRespuesta<String> ejecutar(DtoPersona dto)
    {
        Persona persona = Persona.of(dto.getNombre(), dto.getApellido());

        return new DtoRespuesta<>("Se creo la persona correctamente, con el codigo de identificación " + this.servicioGuardarPersona.ejecutar(persona));
    }
}