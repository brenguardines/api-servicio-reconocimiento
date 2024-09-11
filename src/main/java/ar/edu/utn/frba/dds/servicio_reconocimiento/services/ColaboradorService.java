package ar.edu.utn.frba.dds.servicio_reconocimiento.services;

import ar.edu.utn.frba.dds.servicio_reconocimiento.models.Colaborador;
import ar.edu.utn.frba.dds.servicio_reconocimiento.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ColaboradorService {
  @Autowired
  private ColaboradorRepository colaboradorRepository;

  public List<Colaborador> obtenerTodosLosColaboradores() {
    return colaboradorRepository.findAll();
  }

  public Colaborador crearColaborador(Colaborador colaborador) {
    return colaboradorRepository.save(colaborador);
  }

  public Colaborador obtenerColaboradorPorId(Long colaboradorId) {
    return colaboradorRepository.findById(colaboradorId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El colaborador con id %d no existe", colaboradorId)));
  }
}
