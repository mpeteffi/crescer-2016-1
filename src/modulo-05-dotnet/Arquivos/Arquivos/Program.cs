using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arquivos
{
    class Program
    {
        static void Main(string[] args)
        {

            var arquivo = @"C:\Users\murillo.peteffi\Desktop\arquivo.txt";
            StreamReader stream = null;

            //try
            //{
            //    stream = new StreamReader(arquivo);
            //    string linha;
            //    do
            //    {
            //        linha = stream.ReadLine();
            //    } while (linha != null);
            //    stream.Dispose();
            //}
            //finally
            //{
            //    stream.Dispose();
            //}

            

            using (var stream = new StreamReader(arquivo))
            {
                string linha;
                linha.Append
                linha = stream.ReadLine();
            }




        }
    }
}
