using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult SobreMim()
        {
            var data = new DateTime(1992, 08, 06).ToShortDateString();
            var sobre = new SobreMimModel()
            {
                Nome = "Murillo Peteffi",
                DataNascimento = new DateTime(1992, 08, 06),
                AlturaCm = 170,
                Peso = 65,
                TipoSanguineo = "A+",
                Gosta = "IPA, APA, Saison, Bitter, Belgian Blond Ale, Weizen, Dubbel, Tripel",
                Desgosta = "Stout, Dunkel, Bock, Rauchbier",
                Origem = "Brasil",
                SlackNickname = "mpeteffi",
                FacebookPage = "facebook.com/mpeteffi",
                Email = "murillo.peteffi@cwi.com.br",
                ImgUrl = "https://cloud.githubusercontent.com/assets/18291019/15033434/13d1ab3e-1241-11e6-9050-28b25e8e8d3f.png"
            };
            return View(sobre);
        }
    }
}