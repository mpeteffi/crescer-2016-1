using CameloNinja.Dominio;
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

        public void Cadastrar(Usuario usuario)
        {
            var connectionString = ConfigurationManager.ConnectionStrings["BancoNinja"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                string sqlUsuario = String.Format("INSERT INTO Usuario (nome, email, senha) VALUES (@p_nome, @p_email, @p_senha)",
                    usuario.Nome, usuario.Email, usuario.Senha);
                var comandoUsuario = new SqlCommand(sqlUsuario, conexao);

                comandoUsuario.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                comandoUsuario.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                comandoUsuario.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                conexao.Open();
                comandoUsuario.ExecuteNonQuery();

                usuario.ID = this.BuscarIdDeUsuario(usuario);

                string sqlUsuarioPorPermissao = String.Format("INSERT INTO UsuarioPermissao (UsuarioId, PermissaoId) VALUES "
                   + "(@p_idUsuario, @p_idPermissao)");
                var comandoUsuarioPorPermissao = new SqlCommand(sqlUsuarioPorPermissao, conexao);

                comandoUsuarioPorPermissao.Parameters.Add(new SqlParameter("p_idUsuario", usuario.ID));
                comandoUsuarioPorPermissao.Parameters.Add(new SqlParameter("p_idPermissao", 1));

                comandoUsuarioPorPermissao.ExecuteNonQuery();

            }
        }

        private int BuscarIdDeUsuario(Usuario usuario)
        {
            var connectionString = ConfigurationManager.ConnectionStrings["BancoNinja"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                int id = 0;
                string sql = String.Format("SELECT Usuarioid FROM Usuario WHERE email=@p_email and senha=@p_senha", usuario.Email, usuario.Senha);
                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                comando.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                conexao.Open();
                SqlDataReader leitor = comando.ExecuteReader();

                if (leitor.Read())
                {
                    id = Convert.ToInt32(leitor["UsuarioId"]);
                }
                return id;
            }
        }
    }
}
