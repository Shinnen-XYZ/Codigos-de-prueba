package Proyecto;

import Proyecto.repo.EstudianteRepo;
import Proyecto.service.EstudianteService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class EstudianteServiceTest {
  @Mock EstudianteRepo repo;
  EstudianteService svc;

  @Before public void init() {
    MockitoAnnotations.openMocks(this);
    svc = new EstudianteService(repo);
  }

  @Test public void crear_ok() {
    Map<String,Object> m = new HashMap<>();
    m.put("nombre","Pedro");
    m.put("correo","pedro@gmail.com");
    m.put("telefono","12345678");
    m.put("idioma","español");
    when(repo.findByCorreo("pedro@example.com")).thenReturn(Optional.empty());
    when(repo.save(any())).thenAnswer(i->{ Object o=i.getArgument(0); return o; });
    Object r = svc.create(m);
    assertNotNull(r);
  }

  @Test(expected = IllegalArgumentException.class)
  public void crear_duplicateEmail() {
    Map<String,Object> m = new HashMap<>();
    m.put("nombre","Ana");
    m.put("correo","ana@gmail.com");
    m.put("telefono","12345678");
    m.put("idioma","inglés");
    when(repo.findByCorreo("ana@x.com")).thenReturn(Optional.of(new Object()));
    svc.create(m);
  }
}
