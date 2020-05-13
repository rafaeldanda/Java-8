

const teste_database = {};
var cadastro_id = false;




function novoCadastro(nome, idade) {
    
    const pessoa = {
        nome: nome,
        idade: idade,
        ativo: true,
        hora: firebase.database.ServerValue.TIMESTAMP,
    };

    if (!cadastro_id) {
        // cadastro_id = firebase.database().ref().child("pessoas").push().keys();
        cadastro_id = firebase.database().ref().child("pessoas").push().keys;
    }

    let updates = {};
    updates['/pessoas/'+'pessoa'] = pessoa;
    //updates['/pessoas2/'+'pessoa'] = pessoa;
    let pessoa_ref = firebase.database().ref();

    pessoa_ref.update(updates)
            .then(function () {
                return 'a';
            })
            .catch(function () {
                return 'b';
            });


}

function removeCadastro() {
    let pessoa_ref;
    if(!cadastro_id){
        cadastro_id = firebase.database().ref().child("pessoas2").push().keys;
    }
    pessoa_ref = firebase.database().ref('/pessoas2/'+'pessoa');
    pessoa_ref.remove()
            .then(function () {
                return {success: true, message: 'than - deu bom no delete'};
            })
            .catch(function (error) {
                return {success: false, message: 'catch - deu ruim no delete ${error.message}'};
            });
    
    
}

function updateCadastro() {

}

function resetCadastro() {

}

teste_database.new = novoCadastro;
teste_database.remove = removeCadastro;
teste_database.update = updateCadastro;
teste_database.reset = resetCadastro;




