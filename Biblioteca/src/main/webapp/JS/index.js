/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import {llenar} from "./mostrarFormulario1.js";
import {volverALosSelects} from "./mostrarFormulario2.js";
const d=document;

d.addEventListener("click",e=>{
    if(e.target.matches(".enselect"))
    {
        volverALosSelects();
    }
    if(e.target.matches(".enFormulario"))
    {
        llenar();
    }
    
})

