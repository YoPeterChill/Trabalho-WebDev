document.getElementById("login-form").addEventListener("submit", function (event) {
    event.preventDefault();

    // Lógica de autenticação (substitua com sua própria lógica)
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Exemplo de verificação de usuário e senha (substitua com sua própria lógica)
    if (username === "pedro" && password === "123") {
        // Redirecionar para a página de Studios após o login
        window.location.href = "studios.html";
    } else {
        alert("Credenciais inválidas. Tente novamente.");
    }
});
