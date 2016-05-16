namespace CameloNinja.Dominio
{
    public class Usuario
    {
        public string Email { get; set; }
        public string Senha { get; set; }

        public string Nome { get; set; }

        public string[] Permissoes { get; set; }
    }
}
