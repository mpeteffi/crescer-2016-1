using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC.Models
{
    public class SobreMimModel
    {
        public String Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public int AlturaCm { get; set; }        
        public int Peso { get; set; }
        public String TipoSanguineo { get; set; }
        public String Gosta { get; set; }
        public String Desgosta { get; set; }    
        public String Origem { get; set; }
        public String SlackNickname { get; set; }
        public String FacebookPage { get; set; }
        public String Email { get; set; }
        public String ImgUrl { get; set; }
    }
}