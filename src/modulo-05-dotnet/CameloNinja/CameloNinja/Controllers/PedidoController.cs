using CameloNinja.Dominio;
using CameloNinja.Filters;
using CameloNinja.MVC.Models;
using CameloNinja.Repositorio;
using System;
using System.Web.Mvc;

namespace CameloNinja.MVC.Controllers
{
    [CWIToken]
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        [HttpGet]
        public ActionResult Cadastro()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
                try
                {
                    var pedido = new Pedido(
                    model.DataDesejoEntrega,
                    model.NomeProduto,
                    model.ValorDeVenda,
                    model.TipoDePagamento,
                    model.NomeCliente,
                    model.Cidade,
                    model.Estado
                    );
                    repositorio.IncluirPedido(pedido);
                    ViewBag.MensagemSucesso = "Pedido salvo com sucesso!";
                    return View("Detalhes", pedido);
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
            
            return View("Cadastro", model);
           
        }

        [HttpGet]
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }

        [HttpGet]
        public ActionResult Lista(string cliente, string produto)
        {
            var pedidos = repositorio.ObterPedidosFiltrados(cliente, produto);
            return View(pedidos);
        }

        [HttpGet]
        public ActionResult Remover(int id)
        {
            repositorio.RemoverPedido(id);
            ViewBag.Mensagem = "Pedido excluído com sucesso!";
            return View("Mensagem");
        }
    }
}