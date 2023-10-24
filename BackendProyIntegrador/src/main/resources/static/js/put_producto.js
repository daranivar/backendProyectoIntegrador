window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del odontologo
    const formulario = document.querySelector('#update_producto_form');
    formulario.addEventListener('submit', function (event) {
        let studentId = document.querySelector('#producto_id').value;

        //creamos un JSON que tendrá los datos del odontologo
        //a diferencia de un odontologo nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#producto_id').value,
            nombre: document.querySelector('#nombre').value,
            descripcion: document.querySelector('#descripcion').value

        };

        //invocamos utilizando la función fetch la API odontologos con el método PUT
        //que modificará al odontologo que enviaremos en formato JSON
        const url = '/productos/actualizar';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un odontologo del listado
    //se encarga de llenar el formulario con los datos del odontologo
    //que se desea modificar
    function findBy(id) {
          const url = '/productos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let producto = data;
              document.querySelector('#producto_id').value = producto.id;
              document.querySelector('#nombre').value = producto.nombre;
              document.querySelector('#descripcion').value = producto.descripcion;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_producto_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }