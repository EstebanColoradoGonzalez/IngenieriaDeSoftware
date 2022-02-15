package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoPersona;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Persona;
import com.uco.myproject.dominio.servicio.ServicioModificarPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarPersona
{
    private final ServicioModificarPersona servicioModificarPersona;

    public ServicioAplicacionModificarPersona(ServicioModificarPersona servicioModificarPersona)
    {
        this.servicioModificarPersona = servicioModificarPersona;
    }

    public DtoRespuesta<Long> ejecutar(DtoPersona dto, Long codigo)
    {
        Persona persona = Persona.of(dto.getNombre(), dto.getApellido());

        return new DtoRespuesta<>(this.servicioModificarPersona.ejecutar(persona, codigo));
    }
}