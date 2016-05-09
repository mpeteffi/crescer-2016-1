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
        public class BotTestes
        {
            [TestMethod]
            public void BotTomaCincoDeDano()
            {
                var bot = new Bot();
                var botDois = new Bot();
                botDois.Atacar(bot);
                Assert.AreEqual(bot.Vida, 95);
            }

            [TestMethod]
            public void BotCausaCincoDeDano()
            {
                var bot = new Bot();
                var botDois = new Bot();
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 95);
            }

            [TestMethod]
            public void BotToString()
            {
                var bot = new Bot();
                Assert.AreEqual(bot.toString(), "Nome: {Bot}, Vida: {100}, Ataque: {5}, Defesa: {0}");
            }
        }
}
