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
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
                try
                {
                    Pedido pedido = new Pedido(model.DataDesejoEntrega, model.NomeProduto, model.ValorDeVenda, model.TipoDePagamento, model.NomeCliente, model.Cidade, model.Estado);
                    if (model.NumeroPedido.HasValue)
                    {
                        repositorio.AtualizarPedido(pedido, (int)model.NumeroPedido);
                        return View("Detalhes", pedido);
                    }
                    else
                    {
                        repositorio.IncluirPedido(pedido);
                        return View("Detalhes", pedido);
                    }
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

        [HttpGet]
        public ActionResult Editar(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);
            PedidoModel pedidoModel = new PedidoModel
            {
                NomeCliente = pedido.NomeCliente,
                NomeProduto = pedido.NomeProduto,
                NumeroPedido = pedido.Id,
                Cidade = pedido.Cidade,
                DataDesejoEntrega = pedido.DataEntrega,
                Estado = pedido.Estado,
                TipoDePagamento = pedido.TipoPagamento,
                ValorDeVenda = pedido.Valor
            };
            return View("Cadastro", pedidoModel);
        }
    }
}