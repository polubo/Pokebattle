<?php
define('HOST', 'localhost');
define('USER', 'root');
define('PASS', 'lucasgremio');
define('BASE', 'pokemonbd');

$conn = new MySQLi(HOST, USER, PASS, BASE);

// Verifica a conexão
if ($conn->connect_error) {
    die("Conexão com o banco falhou: " . $conn->connect_error);
}
?>