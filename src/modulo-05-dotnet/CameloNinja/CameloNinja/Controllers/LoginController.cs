using CameloNinja.Dominio;
using CameloNinja.Models.Login;
using CameloNinja.MVC.Models;
using CameloNinja.Repositorio;
using CameloNinja.Services;
using System.Web.Mvc;

namespace CameloNinja.MVC.Controllers
{
    public class LoginController : Controller
    {
        private UsuarioServico _usuarioServico;
        
        public LoginController()
        {
            _usuarioServico = new UsuarioServico(new UsuarioRepositorioADO());
        }

        [HttpGet]
        public ActionResult Index()
        {
            if (!ServicoDeSessao.EstaLogado)
            {
                return View("Login");
            }
            return RedirectToAction("Lista","Pedido");
        }

        [HttpGet]
        public ActionResult Sair()
        {
            ServicoDeSessao.Deslogar();
            return View("Login");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginModel loginModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(loginModel.Email, loginModel.Senha);
                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    Session["BemVindo"] = "Olá, " + usuarioLogadoModel.Nome.Split(' ')[0];
                    return RedirectToAction("Lista","Pedido");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }
            return View("Login", loginModel);
        }
    }
}