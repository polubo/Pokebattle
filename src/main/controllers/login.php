<?php
session_start();

if(empty($_POST) or (empty($_POST["nome"]) or (empty($_POST["senha"])))){
    print "<script>location.href='index.php';</script>";
}

include ('config.php');

$nome = $_POST["nome"];
$senha = $_POST["senha"];

$sql = "SELECT * FROM usuario
        WHERE nome_usuario = '{$nome}'
        AND senha_usuario = '{$senha}'";

$res = $conn->query($sql) or die($conn->error);

$row = $res->fetch_object();

$qtd = $res->num_rows;

if($qtd > 0) {
    $_SESSION["nome"] = $nome;
    print"<script>location.href='dashboard.php'</script>";
}else{
    print"<script>alert('Usuário e/ou senha incorreto(s)'</script>";
    print"<script>location.href='index.php'</script>";
}