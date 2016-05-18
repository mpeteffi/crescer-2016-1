using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace CameloNinja.MVC.Models
{
    public class UsuarioModel
    {
        [DisplayName("Nome")]
        [StringLength(100)]
        public string Nome { get; set; }

        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DisplayName("Senha")]
        public string Senha { get; set; }

        [DisplayName("Repita a senha")]
        public string RepitaASenha { get; set; }
    }
}