function eliminar(ID) {
    swal({
        title: "¿Quiere eliminar este elemento?",
        text: "Una vez eliminado no podrá recuperarlo",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((OK) => {
                if (OK) {
                    $.ajax({
                        url: "/eliminar/" + ID,
                        succes: function (res) {
                            console.log(res);
                        }
                    });
                    swal("Se ha eliminado el usuario", {
                        icon: "success",
                    }).then((OK) => {
                        if (OK) {
                            location.href = "/listar";
                        }
                    });
                } else {
                    swal("Se ha cancelado la acción");
                }
            });
}

function eliminarVarios() {
    try {
        var lista = document.getElementsByClassName('form-check-input');

        var listaSalida = [];

        let i;
        for (i = 0; i < lista.length; i++) {
            if (lista[i].checked) {
                listaSalida.push(lista[i].value);
            }
        }

        console.log(listaSalida);

        swal({
            title: "¿Quiere eliminar los elementos seleccionados?",
            text: "Una vez eliminados no podrá recuperarlos",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((OK) => {
                    if (OK) {
                        $.ajax({
                            url: "/eliminarVarios/" + listaSalida,
                            succes: function (res) {
                                console.log(res);
                            }
                        });
                        swal("Se ha eliminado el usuario", {
                            icon: "success",
                        }).then((OK) => {
                            if (OK) {
                                location.href = "/listar";
                            }
                        });
                    } else {
                        swal("Se ha cancelado la acción");
                    }
                });

    } catch (e) {
        alert("No hay elementos que eliminar");
    }

}
