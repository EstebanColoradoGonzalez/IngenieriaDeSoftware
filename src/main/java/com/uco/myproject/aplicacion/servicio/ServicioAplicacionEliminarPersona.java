package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.ServicioEliminarPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarPersona
{
    private final ServicioEliminarPersona servicioEliminarPersona;

    public ServicioAplicacionEliminarPersona(ServicioEliminarPersona servicioEliminarPersona)
    {
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    public DtoRespuesta<Long> ejecutar(Long codigo)
    {
        return new DtoRespuesta<>(this.servicioEliminarPersona.ejecutar(codigo));
    }
}
