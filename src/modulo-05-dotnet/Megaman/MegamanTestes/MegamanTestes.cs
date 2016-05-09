using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMegaman;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace MegamanTestes
{
    [TestClass]
    public class MegamanTestes
    {

        [TestMethod]
        public void MegaManCausaSeisDeDano()
        {
            var bot = new Bot();
            var megaman = new MegaMan();
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 94);
        }

        [TestMethod]
        public void MegaManTomaCincoDeDano()
        {
            var bot = new Bot();
            var megaman = new MegaMan();
            bot.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 95);
        }

        [TestMethod]
        public void MegaManCausaNoveDeDano()
        {
            var bot = new Bot();
            var megaman = new MegaMan();
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 91);
        }


        [TestMethod]
        public void MegaManToString()
        {
            var megaman = new MegaMan();
            Assert.AreEqual(megaman.toString(), "Nome: {Megaman}, Vida: {100}, Ataque: {6}, Defesa: {0}");
        }
    }
}
