package ar.edu.utn.frba.dds.servicio_reconocimiento.controllers;

import ar.edu.utn.frba.dds.servicio_reconocimiento.models.Colaborador;
import ar.edu.utn.frba.dds.servicio_reconocimiento.repositories.ColaboradorRepository;
import ar.edu.utn.frba.dds.servicio_reconocimiento.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {
  @Autowired
  private ColaboradorService colaboradorService;

  @GetMapping("/todos")
  public List<Colaborador> obtenerTodosLosColaboradores() {
    return colaboradorService.obtenerTodosLosColaboradores();
  }

  @PostMapping("/crear")
  public Colaborador crearColaborador(@RequestBody Colaborador colaborador) {
    return colaboradorService.crearColaborador(colaborador);
  }

  @GetMapping("/{id}")
  public Colaborador obtenerColaboradorPorId(@PathVariable("id") Long id) {
    return colaboradorService.obtenerColaboradorPorId(id);
  }
}
