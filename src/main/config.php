<?php
// Conexão com o banco de dados
$dbHost = "LocalHost";
$username = "root";
$password = "lucasgremio";
$dbname = "pokemonbd";

// Criando a conexão
$conexao = new mysqli($dbHost, $username, $password, $dbname);

// Verificando a conexão
if ($conexao->connect_error) {
    die("Erro na conexão com o banco de dados: " . $conexao->connect_error);
}

// Recebendo os dados do formulário
$nome = $_POST['nome'];
$email = $_POST['email'];
$senha = $_POST['senha'];

// Preparando e executando a query para inserir os dados
$sql = "INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario) VALUES ('$nome', '$email', '$senha')";

if ($conexao->query($sql) === TRUE) {
    echo "Dados inseridos com sucesso!";
} else {
    echo "Erro ao inserir dados: " . $conexao->error;
}

$conexao->close();
?>