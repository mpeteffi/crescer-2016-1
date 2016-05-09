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
    public class RushTestes
    {

        [TestMethod]
        public void RushTomaDoisDeDano()
        {
            var rush = new Rush();
            var bot = new Bot();
            bot.Atacar(rush);
            Assert.AreEqual(rush.Vida, 98);
        }

        [TestMethod]
        public void RushCausaQuatroDeDano()
        {
            var rush = new Rush();
            var bot = new Bot();
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 96);
        }

        [TestMethod]
        public void RushToString()
        {
            var rush = new Rush();
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {4}, Defesa: {3}");
        }

    }
}
