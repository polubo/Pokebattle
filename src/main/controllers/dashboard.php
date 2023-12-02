<?php
session_start();
if(empty($_SESSION)){
    print "<script>location.href='index.php'</script>";
}
?>
<!DOCTYPE html>
<html lang="pt-BR" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title> Tela inicial | Pokebattle </title>
    <link rel="stylesheet" href="../assets/css/dashboard.css">
    <!-- Boxiocns CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="sidebar close">
    <div class="logo-details">
        <i class='bx bxl-product-hunt'></i>
        <span class="logo_name">Pokebattle</span>
    </div>
    <ul class="nav-links">
        <li>
            <a href="dashboard.php">
                <i class='bx bx-grid-alt' ></i>
                <span class="link_name">Dashboard</span>
            </a>
            <ul class="sub-menu blank">
                <li><a class="link_name" href="#">Meu perfil</a></li>
            </ul>
        </li>
        <li>
            <div class="iocn-link">
                <a href="#">
                    <i class='bx bx-user' ></i>
                    <span class="link_name">Meu perfil</span>
                </a>
                <i class='bx bxs-chevron-down arrow' ></i>
            </div>
            <ul class="sub-menu">
                <li><a class="link_name" href="#">Meu perfil</a></li>
                <li><a href="?page=listar">Editar Perfil</a></li>
                <li><a href="cadastro.php">Novo Perfil</a></li>
            </ul>
        </li>
        <li>
            <div class="iocn-link">
                <a href="#">
                    <i class='bx bx-library' ></i>
                    <span class="link_name">Deck</span>
                </a>
                <i class='bx bxs-chevron-down arrow' ></i>
            </div>
            <ul class="sub-menu">
                <li><a class="link_name" href="#">Deck</a></li>
                <li><a href="#">Meu deck</a></li>
                <li><a href="#">Editar deck</a></li>
            </ul>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-store'></i>
                <span class="link_name">Loja</span>
            </a>
            <ul class="sub-menu blank">
                <li><a class="link_name" href="#">Loja</a></li>
            </ul>
        </li>
        <li>
            <a href="../views/pokedex.html">
                <i class='bx bx-compass' ></i>
                <span class="link_name">Pokedex</span>
            </a>
            <ul class="sub-menu blank">
                <li><a class="link_name" href="#">Pokedex</a></li>
            </ul>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-history'></i>
                <span class="link_name">Batalhas</span>
            </a>
            <ul class="sub-menu blank">
                <li><a class="link_name" href="#">Batalhas</a></li>
            </ul>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-cog' ></i>
                <span class="link_name">Configurações</span>
            </a>
            <ul class="sub-menu blank">
                <li><a class="link_name" href="#">Configurações</a></li>
            </ul>
        </li>
        <li>
            <div class="profile-details">
                <div class="profile-content">
                    <img src="https://cdn-icons-png.flaticon.com/512/287/287226.png" alt="profileImg">
                </div>
                <div class="name-job">
                    <div class="profile_name"><?php print $_SESSION["nome"];?></div>
                    <div class="job">Jogador</div>
                </div>
                <a href="logout.php">
                    <i class='bx bx-log-out'></i>
                </a>
            </div>
        </li>
    </ul>
</div>
<section class="home-section">
    <div class="home-content">
        <i class='bx bx-menu' ></i>
        <span class="text">Sidebar</span>
    </div>
<script>
    let arrow = document.querySelectorAll(".arrow");
    for (var i = 0; i < arrow.length; i++) {
        arrow[i].addEventListener("click", (e)=>{
            let arrowParent = e.target.parentElement.parentElement;
            arrowParent.classList.toggle("showMenu");
        });
    }
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".bx-menu");
    console.log(sidebarBtn);
    sidebarBtn.addEventListener("click", ()=>{
        sidebar.classList.toggle("close");
    });
</script>
<div class="container">
    <div class="row">
        <div class="col mt-5">
            <?php
            include ("config.php");
            switch (@$_REQUEST["page"]){
                case "novo":
                    include ("cadastro.php");
                    break;
                case "listar":
                    include("listar_usuario.php");
                    break;
                case "salvar";
                    include("UsuarioDAO.php");
                    break;
                case "editar";
                    include("editar_usuario.php");
                default:
                    print "<h1></h1>";
            }
            ?>
        </div>
    </div>
</div>
</body>
</html>