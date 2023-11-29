<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="/src/main/assets/css/style_login.css">
    <title>Cadastro Pokebattle</title>
</head>
<body>
<main id="container">
    <form id="login_form" action="?page=salvar" method="post">
        <input type="hidden" name="acao" value="cadastrar">
        <!-- FORM HEADER -->
        <div id="form_header">
            <h1>Cadastro</h1>
            <i id="mode_icon" class="fa-solid fa-moon"></i>
        </div>

        <!-- SOCIAL MEDIA LINKS -->
        <div id="social_media">
            <!-- FACEBOOK -->
            <a href="#">
                <img src="/src/main/assets/imgs/facebook.png" alt="">
            </a>

            <!-- GOOGLE -->
            <a href="#">
                <img src="/src/main/assets/imgs/google.png" alt="Google logo">
            </a>

            <!-- GITHUB -->
            <a href="#">
                <img src="/src/main/assets/imgs/github.png" alt="">
            </a>
        </div>

        <!-- INPUTS -->
        <div id="inputs">
            <!-- NAME -->
            <div class="input-box">
                <label for="nome">
                    <span>Nome</span>
                    <div class="input-field">
                        <i class="fa-solid fa-user"></i>
                        <input type="text" id="nome" name="nome" required>
                    </div>
                </label>
            </div>

            <!-- EMAIL -->
            <div class="input-box">
                <label for="email">
                    <span>E-mail</span>
                    <div class="input-field">
                        <i class="fa-solid fa-envelope"></i>
                        <input type="email" id="email" name="email" required>
                    </div>
                </label>
            </div>

            <!-- PASSWORD -->
            <div class="input-box">
                <label for="senha">
                    <span>Senha</span>
                    <div class="input-field">
                        <i class="fa-solid fa-key"></i>
                        <input type="password" id="senha" name="senha" required>
                    </div>
                </label>
            </div>

        <!-- LOGIN BUTTON -->
        <button type="submit" id="login_button"  name="login_button">Cadastre-se</button>
    </form>
</main>
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
                        break;
                default:
                    print "<h1>Bem vindos!</h1>";
            }
            ?>
        </div>
    </div>
</div>

<!-- JAVASCRIPT -->
<script type="text/javascript" src="/src/main/assets/js/script_login.js"></script>

</body>
</html>