using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace CameloNinja.Dominio
{
    public class Pedido
    {
        public Pedido()
        {

        }

        public Pedido(DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado)
        {
            DataEntrega = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = DateTime.Today;
            var diasRestantesParaConcluirEntrega = (dataEntregaDesejada - DataPedido).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);
        }

        public Pedido(int id, DateTime dataPedido, DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, bool pedidoUrgente)
        {
            Id = id;
            DataEntrega = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = dataPedido;
            PedidoUrgente = pedidoUrgente;
        }

        [DisplayName("ID do Pedido")]
        public int Id { get; set; }

        [DisplayName("Data do Pedido")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}", ApplyFormatInEditMode = true)]
        public DateTime DataPedido { get; private set; }

        [DisplayName("Data de Entrega")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataEntrega { get; private set; }
        
        [DisplayName("Nome do Produto")]
        public string NomeProduto { get; private set; }

        [DisplayName("Valor de Venda")]
        [DisplayFormat(DataFormatString = "{0:c}", ApplyFormatInEditMode = true)]
        public decimal Valor { get; private set; }

        [DisplayName("Tipo de Pagamento")]
        public TipoPagamento TipoPagamento { get; private set; }

        [DisplayName("Nome do Cliente")]
        public string NomeCliente { get; private set; }

        [DisplayName("Cidade")]
        public string Cidade { get; private set; }

        [DisplayName("Estado")]
        public string Estado { get; private set; }

        public bool PedidoUrgente { get; private set; }

        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega desejada deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private void DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            PedidoUrgente = diasRestantesParaConcluirEntrega < 7;
        }

        public void AtualizarId(int id)
        {
            if (Id != 0)
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");
            Id = id;
        }
    }
}
