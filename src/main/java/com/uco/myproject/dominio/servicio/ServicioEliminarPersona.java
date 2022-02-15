package com.uco.myproject.dominio.servicio;

import com.uco.myproject.dominio.modelo.Persona;
import com.uco.myproject.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarPersona
{
    private static final String MENSAJE_NO_EXISTE = "No existe la persona que quieres eliminar";

    private final RepositorioPersona repositorioPersona;

    public ServicioEliminarPersona(RepositorioPersona repositorioPersona)
    {
        this.repositorioPersona = repositorioPersona;
    }

    public Long ejecutar(Long codigo)
    {

        if(this.repositorioPersona.consultarPorId(codigo) == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }

        return this.repositorioPersona.eliminar(codigo);
    }
}
