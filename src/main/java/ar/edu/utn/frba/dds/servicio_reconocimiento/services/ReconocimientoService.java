package ar.edu.utn.frba.dds.servicio_reconocimiento.services;

import ar.edu.utn.frba.dds.servicio_reconocimiento.models.Colaborador;
import ar.edu.utn.frba.dds.servicio_reconocimiento.models.Empresa;
import ar.edu.utn.frba.dds.servicio_reconocimiento.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReconocimientoService {

  @Autowired
  private ColaboradorRepository colaboradorRepository;

  public List<Colaborador> recomendarColaboradores(Empresa empresa) {
    List<Colaborador> colaboradores = colaboradorRepository.findAll();
    return colaboradores.stream()
        .filter(c -> c.getPuntos() >= empresa.getPuntosMinimos())
        .filter(c -> c.getViandasDonadas() >= empresa.getViandasMinimas())
        .limit(empresa.getMaxColaboradores())
        .collect(Collectors.toList());
  }
}
