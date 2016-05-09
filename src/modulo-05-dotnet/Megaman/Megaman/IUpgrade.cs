using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public interface IUpgrade
    {
        String TipoUpgrade { get; }
        int BonusAtaque { get; }
        int BonusDefesa { get; }
    }
}