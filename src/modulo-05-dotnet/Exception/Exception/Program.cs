using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exception
{
    class Program
    {
        static void Main(string[] args)
        {



            try
            {
                Console.WriteLine("Digite um número: ");
                var numero = Console.ReadLine();
                var numeroConvertido = Convert.ToInt32(numero);
                if (numeroConvertido == 13) throw new ArgumentException("Você digitou o numero do azar.");
                Console.WriteLine("O número convertido é: " + numeroConvertido);
            }
            catch (FormatException)
            {
                Console.WriteLine("Você deve digitar apenas números!");
            }
            catch (OverflowException)
            {
                Console.WriteLine("O numero deve estar entre -2147483648 e 2147483648.");
            }
            catch (System.Exception ex)
            {
                Console.WriteLine(ex.Message);

            }























        }
    }
}
