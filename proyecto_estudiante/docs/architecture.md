Arquitectura: MVC simple
- Controller: expone endpoints /estudiantes
- Service: lógica de validación simple
- Repo: almacenamiento en memoria (HashMap)
Patrones aplicados:
- Factory: EstudianteFactory (map -> entidad)
- Validaciones: código directo en service (estilo estudiante)
Despliegue: correr mvn spring-boot:run en backend y abrir frontend/index.html
