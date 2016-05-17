using System.ComponentModel;
using System;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace CameloNinja.MVC.Models
{
    public class LoginModel
    {
        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DisplayName("Senha")]
        [StringLength(100)]
        public string Senha { get; set; }
    }
}