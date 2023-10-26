window.addEventListener('load', function () {

    (function(){
      //con fetch invocamos a la API de productos con el método GET
      //nos devolverá un JSON con una colección de productos
      const url = '/productos/todos';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         //recorremos la colección de productos del JSON
         for(producto of data){
          //por cada productos armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos
          //el producto

          var table = document.getElementById("productoTable");
          var productoRow =table.insertRow();
          let tr_id = 'tr_' + producto.id;
          productoRow.id = tr_id;


          //por cada producto creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar al producto
           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + producto.id + '\"' +
                                      ' type="button" onclick="deleteBy('+producto.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

           //por cada productos creamos un boton que muestra el id y que al hacerle clic invocará
           //a la función de java script findBy que se encargará de buscar al productos que queremos
           //modificar y mostrar los datos del mismo en un formulario.
          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + producto.id + '\"' +
                                      ' type="button" onclick="findBy('+producto.id+')" class="btn btn-info btn_id">' +
                                      producto.id +
                                      '</button>';


          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del productos
          //como ultima columna el boton eliminar
         productoRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_nombre\">' + producto.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_apellido\">' + producto.descripcion.toUpperCase() + '</td>' +
                              '<td>' + deleteButton + '</td>';

        };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/productoLista.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})