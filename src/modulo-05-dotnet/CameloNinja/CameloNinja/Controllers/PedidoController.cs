using CameloNinja.Dominio;
using CameloNinja.MVC.Models;
using CameloNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CameloNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        public ActionResult Cadastro()
        {
            return View();
        }

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

        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }

        public ActionResult Lista()
        {
            var pedidos = repositorio.ObterPedidos();

            return View(pedidos);
        }

        public ActionResult Remover(int id)
        {
            repositorio.RemoverPedido(id);
            var pedidos = repositorio.ObterPedidos();
            return View("Lista", pedidos);
        }
    }
}