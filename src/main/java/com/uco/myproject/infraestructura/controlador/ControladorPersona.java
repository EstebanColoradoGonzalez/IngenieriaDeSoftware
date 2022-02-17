package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.servicio.ServicioAplicacionEliminarPersona;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionGuardarPersona;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionListarPersonas;
import com.uco.myproject.aplicacion.dto.DtoPersona;
import com.uco.myproject.aplicacion.dto.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionModificarPersona;
import com.uco.myproject.dominio.modelo.Persona;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class ControladorPersona
{
    private final ServicioAplicacionListarPersonas servicioListarPersonas;
    private final ServicioAplicacionGuardarPersona servicioGuardarPersona;
    private final ServicioAplicacionModificarPersona servicioModificarPersona;
    private final ServicioAplicacionEliminarPersona servicioEliminarPersona;

    public ControladorPersona(ServicioAplicacionListarPersonas servicioListarPersonas, ServicioAplicacionGuardarPersona servicioGuardarPersona, ServicioAplicacionModificarPersona servicioModificarPersona, ServicioAplicacionEliminarPersona servicioEliminarPersona)
    {
        this.servicioListarPersonas = servicioListarPersonas;
        this.servicioGuardarPersona = servicioGuardarPersona;
        this.servicioModificarPersona = servicioModificarPersona;
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    @GetMapping
    public List<Persona> listar()
    {
        return servicioListarPersonas.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<String> crear(@RequestBody DtoPersona dto)
    {
        return this.servicioGuardarPersona.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<String> modificar(@RequestBody DtoPersona usuario, @PathVariable Long codigo)
    {
        return this.servicioModificarPersona.ejecutar(usuario, codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<String> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarPersona.ejecutar(codigo);
    }
}