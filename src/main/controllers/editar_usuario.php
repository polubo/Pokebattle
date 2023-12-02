<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuário</title>
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
          crossorigin="anonymous"></head>
<body>
<div class="container mt-5">
    <h2>Editar Usuário</h2>
    <?php
    $sql = "SELECT * FROM usuario WHERE id_usuario=".$_REQUEST["id"];
    $res = $conn->query($sql);
    $row = $res->fetch_object();
    ?>
    <form action="?page=salvar" method="POST">
        <input type="hidden" name="acao" value="editar">
        <input type="hidden" name="id" value="<?php print $row->id_usuario;?>>">
        <div class="form-group mt-3">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" value="<?php print $row->nome_usuario;?>" placeholder="Digite seu novo nome" required>
        </div>
        <div class="form-group mt-3">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" id="email" name="email" value="<?php print $row->email_usuario;?>" placeholder="Digite seu novo email" required>
        </div>
        <div class="form-group mt-3">
            <label for="email">Nivel:</label>
            <input type="number" class="form-control" id="nivel" name="nivel" value="<?php print $row->nivel_usuario;?>" placeholder="Digite seu novo nivel" required>
        </div>
<!--        <div class="form-group">-->
<!--            <label for="email">Loja:</label>-->
<!--            <input type="text" class="form-control" id="loja" name="loja" value="--><?php //print $row->id_loja;?><!--" placeholder="Digite sua nova loja" required>-->
<!--        </div>-->
<!--        <div class="form-group">-->
<!--            <label for="email">Deck:</label>-->
<!--            <input type="text" class="form-control" id="deck" name="deck" value="--><?php //print $row->id_deck;?><!--" placeholder="Digite seu novo deck" required>-->
<!--        </div>-->
        <div class="form-group mt-3">
            <label for="senha">Senha:</label>
            <div class="input-group">
                <input type="password" class="form-control" id="senha" name="senha" value="<?php print $row->senha_usuario;?>" placeholder="Digite sua nova senha" required>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="toggleSenha">
                        <i class="fas fa-eye" id="eye-icon"></i>
                    </button>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary mt-3">Salvar alterações</button>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    document.getElementById('toggleSenha').addEventListener('click', function() {
        const senhaInput = document.getElementById('senha');
        const eyeIcon = document.getElementById('eye-icon');

        if (senhaInput.type === 'password') {
            senhaInput.type = 'text';
            eyeIcon.classList.remove('fa-eye');
            eyeIcon.classList.add('fa-eye-slash');
        } else {
            senhaInput.type = 'password';
            eyeIcon.classList.remove('fa-eye-slash');
            eyeIcon.classList.add('fa-eye');
        }
    });
</script>
</body>
</html>
