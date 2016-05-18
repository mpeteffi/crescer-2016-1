using System.Security.Cryptography;
using System.Text;

namespace CameloNinja.Dominio
{
    public class UsuarioServico
    {
        private IUsuarioRepositorio _usuarioRepositorio;

        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio)
        {
            _usuarioRepositorio = usuarioRepositorio;
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string senhaCriptografada = Criptografar(senha);
            Usuario usuarioEncontrado = _usuarioRepositorio.BuscarUsuarioPorAutenticacao(email, senhaCriptografada);
            return usuarioEncontrado;
        }

        public void Cadastrar(string nome, string email, string senha)
        {
            var senhaCriptografada = this.Criptografar(senha);
            Usuario usuario = new Usuario(nome, email, senhaCriptografada);
            _usuarioRepositorio.Cadastrar(usuario);

        }

        private string Criptografar(string texto)
        {
            using (MD5 md5Hash = MD5.Create())
            {
                byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));
                StringBuilder sBuilder = new StringBuilder();
                for (int i = 0; i < data.Length; i++)
                {
                    sBuilder.Append(data[i].ToString("x2"));
                }
                return sBuilder.ToString();
            }
        }
    }
}
