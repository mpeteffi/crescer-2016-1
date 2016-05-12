using CameloNinja.Dominio;
using CameloNinja.MVC.Models;
using CameloNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
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
                return View("Detalhes", pedido);
            }
            else
            {
                return View("Cadastro", model);
            }
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
    }
}