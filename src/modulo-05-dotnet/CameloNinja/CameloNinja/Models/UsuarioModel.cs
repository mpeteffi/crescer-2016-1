using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace CameloNinja.MVC.Models
{
    public class UsuarioModel
    {
        [Required(ErrorMessage = "Você deve informar um nome.")]
        [DisplayName("Nome")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "Você deve informar um email")]
        [DisplayName("Email")]
        [EmailAddress]
        public string Email { get; set; }

        [Required(ErrorMessage = "Você deve informar uma senha")]
        [RegularExpression(@"^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$",
            ErrorMessage = "A senha deve conter no mínimo 8 caracteres tendo que ter uma letra minúscula e uma maiúscula.")]
        [DisplayName("Senha")]
        public string Senha { get; set; }

        [Required(ErrorMessage = "Você deve informar uma confirmação para a senha")]
        [DisplayName("Confirmar senha")]
        public string ConfirmaSenha { get; set; }
    }
}