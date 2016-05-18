namespace CameloNinja.Dominio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioPorAutenticacao(string email, string senha);
        void Cadastrar(Usuario usuario);
    }
}
