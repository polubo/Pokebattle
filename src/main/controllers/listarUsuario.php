<h1>Listar Usuários</h1>
<?php
$sql = "SELECT * FROM usuario";

$res = $conn->query($sql);

$qtd = $res->num_rows;

if($qtd > 0){
    print "<table class='table table-hover table-striped table-bordered'>";
    print "<tr>";
    print "<th>#</th>";
    print "<th>Nome</th>";
    print "<th>E-mail</th>";
    print "<th>Senha</th>";
    print "<th>Nível de usuário</th>";
    print "<th>Loja</th>";
    print "<th>Deck</th>";
    print "<th>Ações</th>";
    print "</tr>";
    while($row = $res->fetch_object()){
        print "<tr>";
        print "<td>".$row->id_usuario."</td>";
        print "<td>".$row->nome_usuario."</td>";
        print "<td>".$row->email_usuario."</td>";
        print "<td>".$row->senha_usuario."</td>";
        print "<td>".$row->nivel_usuario."</td>";
        print "<td>".$row->id_loja."</td>";
        print "<td>".$row->id_deck."</td>";
        print "<td>   
                <button onclick=\"location.href'?page=editar&id=".$row-> id_usuario. "';\" class='btn btn-success'>Editar</button>
                <button class='btn btn-danger'>Excluir</button>
                </td>";
        print "</tr>";
    }
    print "</table>";
}else{
    print "<p class='alert alert-danger'>Não encontrou resultados!</p>";
}
?>

