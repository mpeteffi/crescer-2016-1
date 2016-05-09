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

        [TestMethod]
        public void BotRecebeCanhaoPlasmaAtaqueCausa7Dano()
        {
            var bot = new Bot();
            var canhao = new CanhaoDePlasma();
            var botDois = new Bot();
            bot.EquiparUpgrade(canhao);
            bot.Atacar(botDois);
            Assert.AreEqual(botDois.Vida, 93);
        }

        [TestMethod]
        public void BotRecebeEscudoDeEnergiaToma3Dano()
        {
            var bot = new Bot();
            var escudo = new EscudoDeEnergia();
            var botDois = new Bot();
            botDois.EquiparUpgrade(escudo);
            bot.Atacar(botDois);
            Assert.AreEqual(botDois.Vida, 97);
        }

        [TestMethod]
        public void BotRecebeLendarioToma4Causa6Dano()
        {
            var bot = new Bot();
            var botas = new BotasDeSuperVelocidade();
            var botDois = new Bot();
            bot.EquiparUpgrade(botas);
            bot.Atacar(botDois);
            botDois.Atacar(bot);
            Assert.AreEqual(botDois.Vida, 94);
            Assert.AreEqual(bot.Vida, 96);
        }

        [TestMethod]
        public void BotEquipaRushCausa9Toma2Dano()
        {
            var bot = new Bot();
            var rush = new Rush();
            var botDois = new Bot();
            bot.EquiparUpgrade(rush);
            bot.Atacar(botDois);
            Assert.AreEqual(botDois.Vida, 91);
            botDois.Atacar(bot);
            Assert.AreEqual(bot.Vida, 98);
        }
    }
}
