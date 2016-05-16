using CameloNinja;
using CameloNinja.Dominio;
using CameloNinja.Filters;
using CameloNinja.Models.Login;
using CameloNinja.MVC.Models;
using CameloNinja.Repositorio;
using CameloNinja.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CameloNinja.MVC.Controllers
{
    public class LoginController : Controller
    {
        private UsuarioServico _usuarioServico;

        [HttpGet]
        public ActionResult Index()
        {
            // Se o usuário está logado, enviamos ele direto para a AreaSecreta, caso contrário, Login.
            if (!ServicoDeSessao.EstaLogado)
            {
                return View("Login");
            }

            return RedirectToAction("AreaSecreta");
        }

        // Utilizados o [HttpPost] para dizer que esta action só pode ser acessada via POST.
        // Sempre que vamos fazer um post de um formulário, devemos utilizar o @Html.AntiForgeryToken.
        // Colocando o [ValidateAntiForgeryToken], estamos dizendo para a action validar esta etapa de segurança para
        // que o form não seja válido caso enviado mais de uma vez (caso alguém intercepte o form e o reenvie).
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                // Buscamos o usuário de nosso "Banco de Dados" por seu login e senha.
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    // É sempre bom criar uma Model só para o usuário logado.
                    // Digamos que você queira utilizar somente a classe Usuário para isso,
                    // então se quisesse guardar coisas que são da sessão e não da classe usuário, como faria?
                    // mudaria a classe Usuario? Não, porque não é de sua responsabilidade os dados de sessão.
                    // mas uma view model pode ser mais flexivel.
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);

                    // Encapsulamos aqui a regra para criar a sessão.
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("AreaSecreta");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }

        [HttpGet]
        [CWIToken]
        public ActionResult AreaSecreta()
        {
            UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            return View();
        }
    }
}