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
    public class ProtomanTestes
    {
        [TestMethod]
        public void ProtomanCausaCincoDeDano()
        {
            var bot = new Bot();
            var protoman = new ProtoMan();
            protoman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 95);
        }

        [TestMethod]
        public void ProtomanTomaTresDano()
        {
            var bot = new Bot();
            var protoman = new ProtoMan();
            bot.Atacar(protoman);
            Assert.AreEqual(protoman.Vida, 97);
        }

        [TestMethod]
        public void ProtomanMorreEReviveCom20DeVida()
        {
            var bot = new Bot();
            var protoman = new ProtoMan();
            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman);
            }
            Assert.AreEqual(protoman.Vida, 20);
        }

        [TestMethod]
        public void ProtomanMorreNaoReviveDuasVezes()
        {
            var bot = new Bot();
            var protoman = new ProtoMan();
            for (int i = 0; i < 41; i++)
            {
                bot.Atacar(protoman);
            }
            Assert.AreEqual(protoman.Vida, -1);
        }

        [TestMethod]
        public void ProtomanCausaSeteDeDano()
        {
            var bot = new Bot();
            var protoman = new ProtoMan();
            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman);
            }
            protoman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 93);
        }


        [TestMethod]
        public void ProtomanToString()
        {
            var protoman = new ProtoMan();
            Assert.AreEqual(protoman.toString(), "Nome: {Protoman}, Vida: {100}, Ataque: {5}, Defesa: {2}");
        }

    }
}
