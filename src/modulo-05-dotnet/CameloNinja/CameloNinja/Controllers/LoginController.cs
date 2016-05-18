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







        [HttpGet]
        public ActionResult CadastroUsuario()
        {
            return View("CadastroUsuario");
        }

        [HttpPost]
        public ActionResult SucessoCadastroUsuario(UsuarioModel usuarioModel)
        {

            if (usuarioModel.Senha != usuarioModel.RepitaASenha)
            {
                ModelState.AddModelError("INVALID_PASSWORD", "Senhas não condizem.");
                return RedirectToAction("CadastroUsuario", usuarioModel);
            }
            else if (usuarioModel.Senha.Length < 8)
            {
                ModelState.AddModelError("INVALID_PASSWORD", "Senha deve possuir pelo menos 8 caracteres");
                return RedirectToAction("CadastroUsuario", usuarioModel);
            }
            else
            {
                _usuarioServico.Cadastrar(usuarioModel.Nome, usuarioModel.Email, usuarioModel.Senha);
                ViewBag.MensagemCadastroSucesso = "Cadastrado com sucesso!";
                return View("SucessoCadastroUsuario");
            }
        }
    }
}