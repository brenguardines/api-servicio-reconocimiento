package ar.edu.utn.frba.dds.servicio_reconocimiento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")
public class Empresa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "puntosMinimos")
  private int puntosMinimos;

  @Column(name = "viandasMinimas")
  private int viandasMinimas;

  @Column(name = "maxColaboradores")
  private int maxColaboradores;
}
