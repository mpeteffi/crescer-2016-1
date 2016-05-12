using CameloNinja.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CameloNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Detalhes(PedidoModel model)
        {
            if (ModelState.IsValid)
            {
                return View("Detalhes", model);
            }
            else
            {
                return View("Index", model);
            }
        }
    }
}