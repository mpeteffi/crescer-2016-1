using CameloNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CameloNinja.Repositorio
{
    public class RepositorioVendas
    {
        private static readonly object objetoLock = new object();
        private const string PATH_ARQUIVO = @"C:\Users\murillo.peteffi\Documents\crescer-2016-1\src\modulo-05-dotnet\CameloNinja\CameloNinja.Repositorio\vendas.txt";
        //private const string PATH_ARQUIVO = @"C:\Users\Murillo\Documents\crescer-2016-1\src\modulo-05-dotnet\CameloNinja\CameloNinja.Repositorio\vendas.txt";

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterPedidos().Max(x => x.Id);
                var idGerado = utlimoId + 1;
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado);
                File.AppendAllText(PATH_ARQUIVO, novaLinha);
                pedido.AtualizarId(idGerado);
            }
        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId)
        {
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy HH:mm"),
                                pedido.DataEntrega.ToString("dd/MM/yyyy HH:mm"),
                                pedido.NomeProduto,
                                pedido.Valor,
                                pedido.TipoPagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.PedidoUrgente);
        }

        public void AtualizarPedido(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public List<Pedido> ObterPedidosFiltrados(string cliente, string produto)
        {
            var pedidos = this.ObterPedidos().Where(p =>
                  ((cliente == null || cliente == "") || p.NomeCliente.ToLower() == cliente.ToLower())
                  && ((produto == null || produto == "") || p.NomeProduto.ToLower() == produto.ToLower())).ToList();
            return pedidos;
        }

        public void RemoverPedido(int id)
        {
            var pedidos = ObterPedidos();
            var pedidosNovos = pedidos.Where(pedido => pedido.Id != id);
            File.WriteAllText(PATH_ARQUIVO, "Número Pedido;Data Pedido;Data Desejo Entrega;Nome Produto;Valor Venda;Tipo Pagamento;Nome Cliente;Cidade;Estado;Urgente");
            foreach (var linha in pedidosNovos)
            {
                File.AppendAllText(PATH_ARQUIVO, ConvertePedidoEmLinhaCSV(linha, linha.Id));
            }
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();
            linhasArquivo.RemoveAt(0);
            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }
            return listaPedidos;
        }
    }
}
