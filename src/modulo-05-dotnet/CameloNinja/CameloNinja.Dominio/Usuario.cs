namespace CameloNinja.Dominio
{
    public class Usuario
    {
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public string Nome { get; private set; }
        public string[] Permissoes { get; set; }
    }
}
