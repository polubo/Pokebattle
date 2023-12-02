<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<h1>Lista de Usuários</h1>
    <?php
    $sql = "SELECT * FROM usuario";

    $res = $conn->query($sql);

    $qtd = $res->num_rows;

    if ($qtd > 0) {
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
        while ($row = $res->fetch_object()) {
            print "<tr>";
            print "<td>" . $row->id_usuario . "</td>";
            print "<td>" . $row->nome_usuario . "</td>";
            print "<td>" . $row->email_usuario . "</td>";
            print "<td>" . $row->senha_usuario . "</td>";
            print "<td>" . $row->nivel_usuario . "</td>";
            print "<td>" . $row->id_loja . "</td>";
            print "<td>" . $row->id_deck . "</td>";
            print "<td>   
                <button onclick=\"location.href='?page=editar&id=" . $row->id_usuario . "';\"class='btn 
                btn-success'>Editar</button>
              
                <button onclick=\"if(confirm('Tem certeza que deseja excluir?')){
                 location.href='?page=salvar&acao=excluir&id=" . $row->id_usuario . "';}else{false;}\"
                 class='btn btn-danger'>
                 Excluir</button>    
                </td>";
            print "</tr>";
        }
        print "</table>";
    } else {
        print "<p class='alert alert-danger'>Não encontrou resultados!</p>";
    }
    ?>