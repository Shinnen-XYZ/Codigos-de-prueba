const API = 'http://localhost:8080/estudiantes';
async function cargar(){
  let res = await fetch(API);
  let data = await res.json();
  let tbody = document.querySelector('#tabla tbody'); tbody.innerHTML='';
  data.forEach(s=>{
    let tr=document.createElement('tr');
    tr.innerHTML=`<td>${s.id||''}</td><td>${s.nombre||''}</td><td>${s.correo||''}</td><td>${s.telefono||''}</td><td>${s.idioma||''}</td>
    <td><button onclick="borrar(${s.id})">X</button></td>`;
    tbody.appendChild(tr);
  });
}
async function crear(){
  let dto = {nombre:document.getElementById('nombre').value, correo:document.getElementById('correo').value, telefono:document.getElementById('telefono').value, idioma:document.getElementById('idioma').value};
  let r = await fetch(API,{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(dto)});
  if(!r.ok){ alert('Error al crear'); return; }
  cargar();
}
async function borrar(id){ if(!confirm('Eliminar?')) return; await fetch(API+'/'+id,{method:'DELETE'}); cargar(); }
document.getElementById('btnCrear').addEventListener('click',crear);
window.onload=cargar;
