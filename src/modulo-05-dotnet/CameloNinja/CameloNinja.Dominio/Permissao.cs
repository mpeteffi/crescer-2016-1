﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CameloNinja.Dominio
{
    public class Permissao
    {
        public Permissao()
        {

        }

        public int Id { get; set; }
        public string Nome { get; set; }
        public IList<Usuario> Usuarios { get; set; }
    }
}
