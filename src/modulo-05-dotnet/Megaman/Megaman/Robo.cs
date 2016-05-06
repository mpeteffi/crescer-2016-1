using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public abstract class Robo
    {
        public string nome;
        protected int vida;
        protected int ataque;
        protected int defesa;

        public Robo()
        {
            vida = 100;
            ataque = 5;
            defesa = 0;
        }



    }
}
