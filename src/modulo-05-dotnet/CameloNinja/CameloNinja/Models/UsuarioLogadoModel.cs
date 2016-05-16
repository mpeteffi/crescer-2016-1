﻿using CameloNinja.Dominio;
using System.Linq;

namespace CameloNinja.Models.Login
{
    // Criamos essa model para nos ajudar a encapsular os dados do Usuário Logado.
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(Usuario usuario)
        {
            this.Email = usuario.Email;
            this.Nome = usuario.Nome;
            this.Permissoes = usuario.Permissoes;
        }

        public string Email { get; private set; }
        public string Nome { get; private set; }
        public string[] Permissoes { get; private set; }

        public bool TemPermissao(string permissao)
        {
            return Permissoes != null
                   && Permissoes.Any(p => p.Equals(permissao));
        }
    }
}