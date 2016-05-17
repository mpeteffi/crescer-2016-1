﻿using CameloNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace CameloNinja.Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["BancoNinja"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM Usuario WHERE email=@p_email and senha=@p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                Usuario novoUsuario = null;

                if (leitor.Read())
                {
                    novoUsuario = new Usuario();
                    novoUsuario.Nome = leitor["nome"].ToString();
                    novoUsuario.Email = leitor["email"].ToString();
                }

                conexao.Close();

                return novoUsuario;
            }
        }
    }
}
