function setAction(){

    let playerId = document.getElementById('id').value;
    let formAction = "/admin/users/delete/" + playerId; // Builds the URL including the playerId

    // Sets the action of the form with the constructed URL
    document.getElementById('deleteUserForm').setAttribute('action', formAction);

    console.log(formAction)

    document.getElementById('deleteUserForm').submit();
}