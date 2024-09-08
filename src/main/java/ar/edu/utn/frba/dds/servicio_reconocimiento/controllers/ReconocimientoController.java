package ar.edu.utn.frba.dds.servicio_reconocimiento.controllers;

import ar.edu.utn.frba.dds.servicio_reconocimiento.models.Colaborador;
import ar.edu.utn.frba.dds.servicio_reconocimiento.models.Empresa;
import ar.edu.utn.frba.dds.servicio_reconocimiento.services.ReconocimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reconocimientos")
public class ReconocimientoController {

  @Autowired
  private ReconocimientoService reconocimientoService;

  @PostMapping("/recomendar")
  public List<Colaborador> recomendarColaboradores(@RequestBody Empresa empresa) {
    return reconocimientoService.recomendarColaboradores(empresa);
  }
}
