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
            var pedidoModel = PedidoToPedidoModel(pedido);
            return View("Cadastro", pedidoModel);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
            {
                Pedido pedido = PedidoModelToPedido(model);

                if (model.NumeroPedido.HasValue)
                {
                    repositorio.AtualizarPedido(pedido, (int)model.NumeroPedido);
                    return View("Detalhes", pedido);
                }
                repositorio.IncluirPedido(pedido);
                return View("Detalhes", pedido);
            }
            return View("Cadastro", model);
        }

        private PedidoModel PedidoToPedidoModel(Pedido pedido)
        {
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
            return pedidoModel;
        }

        private Pedido PedidoModelToPedido(PedidoModel pedidoModel)
        {
            Pedido pedido = new Pedido(
                    pedidoModel.DataDesejoEntrega,
                    pedidoModel.NomeProduto,
                    pedidoModel.ValorDeVenda,
                    pedidoModel.TipoDePagamento,
                    pedidoModel.NomeCliente,
                    pedidoModel.Cidade,
                    pedidoModel.Estado);
            return pedido;
        }
    }
}