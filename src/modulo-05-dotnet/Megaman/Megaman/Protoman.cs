using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class ProtoMan : Robo
    {
        public override string Nome
        {
            get
            {
                return "Protoman";
            }
        }

        private bool morto = false;
        private bool Morto
        {
            get
            {
                return morto;
            }
            set
            {
                morto = value;
            }
        }

        protected override int Ataque
        {
            get
            {
                if (Morto) { return 7 + BonusEquipAtaque; }
                return 5 + BonusEquipAtaque;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 2 + BonusEquipDefesa;
            }
        }

        public override void RecebeDano(int dano)
        {
            Vida -= (dano - Defesa);
            if (!morto && Vida <= 0)
            {
                Vida = 20;
                Morto = true;
            }
        }
    }
}