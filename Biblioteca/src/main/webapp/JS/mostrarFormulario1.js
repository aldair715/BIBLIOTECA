/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const d=document;
export function llenar()
{
    d.getElementById("seleccionado").innerHTML="";
    let $enFormulario=d.querySelector(".enFormulario");
    let $inputs=`
    <div class="form-group">
                   <label for="usr">PATERNO DEL AUTOR:</label>
                   <input type="text" class="form-control form-control-sm" required name="paterno" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title="COLOQUE UN NOMBRE CORRECTO, SOLO SE PERMITE VALORES ALFABETICOS" placeholder="ESCRIBA EL PATERNO DEL AUTOR" autocomplete="off">
            </div>
            <div class="form-group">
                   <label for="usr">MATERNO DEL AUTOR</label>
                   <input type="text" class="form-control form-control-sm" required name="materno" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title="COLOQUE UN NOMBRE CORRECTO, SOLO SE PERMITE VALORES ALFABETICOS" placeholder="ESCRIBA EL MATERNO DEL AUTOR" autocomplete="off">
                </div>
            <div class="form-group">
                   <label for="usr">NOMBRE DEL AUTOR</label>
                   <input type="text" class="form-control form-control-sm" required name="nombre" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title="COLOQUE UN NOMBRE CORRECTO, SOLO SE PERMITE VALORES ALFABETICOS" placeholder="ESCRIBA EL NOMBRE DEL AUTOR" autocomplete="off">
                </div>
            <div class="form-group">
                   <label for="usr">NACIONALIDAD DEL AUTOR </label>
                   <input type="text" class="form-control form-control-sm" required name="nacionalidad" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title="COLOQUE UN NOMBRE CORRECTO, SOLO SE PERMITE VALORES ALFABETICOS" placeholder="ESCRIBA LA NACIONALIDAD DEL AUTOR" autocomplete="off">
                </div>
               <input type='hidden' name='seleccion'/>
`;
 d.getElementById("seleccionado").innerHTML=$inputs;
 
 $enFormulario.classList.add("enselect");
 $enFormulario.classList.add("btn-danger");
 $enFormulario.textContent="MOSTRAR AUTORES";
 $enFormulario.classList.remove(".enFormulario");
 $enFormulario.classList.remove(".btn-primary");
 
}

