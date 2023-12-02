<?php
switch ($_REQUEST["acao"]){
    case 'cadastrar';
    $nome = $_POST["nome"];
    $email = $_POST["email"];
    $senha = $_POST["senha"];
    $nivel = $_POST["nivel"];

    $sql = "INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario, nivel_usuario) VALUES (?, ?, ?, ?)";

    $stmt = $conn->prepare($sql);

    $stmt->bind_param("ssss", $nome, $email, $senha, $nivel);

    $res = $stmt->execute();

        if($res==true){
        print "<script>alert('Cadastro realizado com sucesso')</script>";
        print "<script>location.href='index.php'</script>";
    }else{
        print "<script>alert('Não foi possível cadastrar')</script>";
        print "<script>location.href='?page=listar</script>";
    }
        break;

    case 'editar':
        $nome = $_POST["nome"];
        $email = $_POST["email"];
        $senha = $_POST["senha"];
        $nivel = $_POST["nivel"];
        $id = $_REQUEST["id"];

        $sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario = ?, nivel_usuario = ? WHERE id_usuario = ?";

        $stmt = $conn->prepare($sql);

        $stmt->bind_param("ssssi", $nome, $email, $senha, $nivel, $id);

        $res = $stmt->execute();

        if ($res) {
            print "<script>alert('Informações editadas com sucesso')</script>";
            print "<script>location.href='?page=listar'</script>";
        } else {
            print "<script>alert('Não foi possível editar')</script>";
            print "<script>location.href='?page=listar'</script>";
        }
        break;

    case 'excluir';

    $sql = "DELETE FROM usuario WHERE id_usuario=".$_REQUEST["id"];

        $res = $conn->query($sql);

        if ($res) {
            print "<script>alert('Usuário excluído com sucesso')</script>";
            print "<script>location.href='?page=listar'</script>";
        } else {
            print "<script>alert('Não foi possível excluir')</script>";
            print "<script>location.href='?page=listar'</script>";
        }
        break;
}