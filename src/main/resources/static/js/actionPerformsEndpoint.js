console.log("putero")

function setAction(){

    let playerId = document.getElementById('id').value; // Obtiene el valor del input playerId
    let formAction = "/admin/users/delete/" + playerId; // Construye la URL con el playerId

    // Establece la acción del formulario con la URL construida
    document.getElementById('deleteUserForm').setAttribute('action', formAction);

    console.log(formAction)

    document.getElementById('deleteUserForm').submit();
}