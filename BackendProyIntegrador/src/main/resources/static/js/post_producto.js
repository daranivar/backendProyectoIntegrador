window.addEventListener('load', function () {

     //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
     //los datos que el usuario cargará del nuevo productos
    const formulario = document.querySelector('#add_new_producto');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {

        //creamos un JSON que tendrá los datos del nuevo productos
        const formData = {
            nombre: document.querySelector('#nombre').value,
            descripcion: document.querySelector('#descripcion').value,
            imagen:document.querySelector('#imagen').value

        };

        //invocamos utilizando la función fetch la API productos con el método POST
        //que guardará al productos que enviaremos en formato JSON
        const url = '/productos/guardar';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
               //Si no hay ningun error se muestra un mensaje diciendo que el productos
               //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Producto agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 //se dejan todos los campos vacíos por si se quiere ingresar otro productos
                 resetUploadForm();

            })
            .catch(error => {
                 //Si hay algun error se muestra un mensaje diciendo que el productos
                 //no se pudo guardar y se intente nuevamente
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";
                   //se dejan todos los campos vacíos por si se quiere ingresar otro productos
                   resetUploadForm();})
    });

    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#descripcion').value = "";
        document.querySelector('#imagen').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/productoLista.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});