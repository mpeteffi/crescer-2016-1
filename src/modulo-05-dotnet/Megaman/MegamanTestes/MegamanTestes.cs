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
        public void MegamanCausaSeisDeDano()
        {
            var bot = new Bot();
            var megaman = new Megaman();
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 94);
        }

        [TestMethod]
        public void MegamanTomaCincoDeDano()
        {
            var bot = new Bot();
            var megaman = new Megaman();
            bot.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 95);
        }

        [TestMethod]
        public void MegamanCausaNoveDeDano()
        {
            var bot = new Bot();
            var megaman = new Megaman();
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 91);
        }


        [TestMethod]
        public void MegamanToString()
        {
            var megaman = new Megaman();
            Assert.AreEqual(megaman.toString(), "Nome: {Megaman}, Vida: {100}, Ataque: {6}, Defesa: {0}");
        }

        [TestMethod]
        public void MegamanRecebeCanhaoPlasmaAtaqueCausa8Dano()
        {
            var megaman = new Megaman();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            megaman.EquiparUpgrade(canhao);
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 92);
        }

        [TestMethod]
        public void MegamanRecebeEscudoDeEnergiaToma3Dano()
        {
            var megaman = new Megaman();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            megaman.EquiparUpgrade(escudo);
            bot.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 97);
        }

        [TestMethod]
        public void MegamanRecebeLendarioToma4Causa7Dano()
        {
            var megaman = new Megaman();
            var botas = new BotasDeSuperVelocidade();
            var bot = new Bot();
            megaman.EquiparUpgrade(botas);
            megaman.Atacar(bot);
            bot.Atacar(megaman);
            Assert.AreEqual(bot.Vida, 93);
            Assert.AreEqual(megaman.Vida, 96);
        }

        [TestMethod]
        public void MegamanComEquipETrintaDeVida()
        {
            var megaman = new Megaman();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            for (int i = 0; i < 4; i++)
            {
                megaman.EquiparUpgrade(canhao);
            }
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 85);
        }

        [TestMethod]
        public void MegamanEquipaRushCausa9Toma2Dano()
        {
            var megaman = new Megaman();
            var rush = new Rush();
            var botDois = new Bot();
            megaman.EquiparUpgrade(rush);
            megaman.Atacar(botDois);
            Assert.AreEqual(botDois.Vida, 90);
            botDois.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 98);
        }
    }
}
