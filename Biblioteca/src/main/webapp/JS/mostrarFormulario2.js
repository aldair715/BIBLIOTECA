/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const d=document;
export function volverALosSelects()
{
    
  let $enFormulario=d.querySelector(".enselect");
 $enFormulario.classList.add(".enFormulario");
 $enFormulario.classList.add(".btn-primary");
 $enFormulario.textContent="COLOCAR OTRO AUTOR";
 $enFormulario.classList.remove("enselect");
 $enFormulario.classList.remove("btn-danger");window.location.reload();
}

