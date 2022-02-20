package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.dominio.servicio.ServicioEliminarPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarPersona
{
    private static final String MENSAJE_NO_ELIMINO = "No se pudo eliminar la persona";
    private final ServicioEliminarPersona servicioEliminarPersona;

    public ServicioAplicacionEliminarPersona(ServicioEliminarPersona servicioEliminarPersona)
    {
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    public DtoRespuesta<Long> ejecutar(Long codigo)
    {
        if(this.servicioEliminarPersona.ejecutar(codigo) <= 0)
        {
            throw new IllegalStateException(MENSAJE_NO_ELIMINO);
        }

        return new DtoRespuesta<>(this.servicioEliminarPersona.ejecutar(codigo));
    }
}