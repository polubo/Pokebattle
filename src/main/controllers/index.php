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
    <title>Login Pokebattle</title>
</head>
<body>
<main id="container">
    <form id="login_form" action="validacao_login.php" method="post">
        <!-- FORM HEADER -->
        <div id="form_header">
            <h1>Login</h1>
            <i id="mode_icon" class="fa-solid fa-moon"></i>
        </div>

        <!-- SOCIAL MEDIA LINKS -->
        <div id="social_media">
            <a href="#">
                <img src="/src/main/assets/imgs/facebook.png" alt="">
            </a>

            <a href="#">
                <img src="/src/main/assets/imgs/google.png" alt="Google logo">
            </a>

            <a href="#">
                <img src="/src/main/assets/imgs/github.png" alt="">
            </a>
        </div>

        <div id="inputs">
            <!-- NoME -->
            <div class="input-box">
                <label for="nome">
                    Nome
                    <div class="input-field">
                        <i class="fa-solid fa-user"></i>
                        <input type="text" id="nome" name="nome" required>
                    </div>
                </label>
            </div>

            <!-- SENHA -->
            <div class="input-box">
                <label for="senha">
                    Senha
                    <div class="input-field">
                        <i class="fa-solid fa-key"></i>
                        <input type="password" id="senha" name="senha" required>
                    </div>
                </label>

                <!--Criar conta-->
                <div class="separator">
                    <p class="change_link">Novo no site?
                        <a href="cadastro.php" class="to_register"> Crie sua conta </a>
                    </p>
                </div>

                <!-- FORGOT PASSWORD -->
                <div id="forgot_password">
                    <a href="#">
                        Esqueceu sua senha?
                    </a>
                </div>
            </div>

        <!-- LOGIN BUTTON -->
        <button type="submit" id="login_button" onclick="">Login</button>
    </form>
</main>

<!-- JAVASCRIPT -->
<script type="text/javascript" src="/src/main/assets/js/script_login.js"></script>
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