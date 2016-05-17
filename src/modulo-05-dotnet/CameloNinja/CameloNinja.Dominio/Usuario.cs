using System.Collections.Generic;

namespace CameloNinja.Dominio
{
    public class Usuario
    {
        public int ID { get; set; }
        public string Nome { get; set; }
        
        public string Email { get; set; }
        public string Senha { get; set; }
        public IList<Permissao> Permissoes { get; set; }
    }
}
