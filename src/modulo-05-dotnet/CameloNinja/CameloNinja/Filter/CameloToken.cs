using CameloNinja.Models.Login;
using CameloNinja.Services;
using System;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace CameloNinja.Filters
{
    public class CameloToken : AuthorizeAttribute
    {
        private string[] _permissoesRequeridas = null;

        public CameloToken()
        {
            _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ? null : this.Roles.Split(',');
        }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return ServicoDeSessao.EstaLogado && TemAutorizacao;
        }

        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);
            if (!estaAutenticadoEAutorizado)
            {
                filterContext.Result = new RedirectToRouteResult(
                                   new RouteValueDictionary
                                   {
                                       { "action", "Index" },
                                       { "controller", "Login" }
                                   });
            }
        }

        private bool TemAutorizacao
        {
            get
            {
                UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
                if (this._permissoesRequeridas != null)
                {
                    foreach (string permissao in _permissoesRequeridas)
                    {
                        if (usuarioLogado.TemPermissao(permissao))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }
                return false;
            }
        }
    }
}