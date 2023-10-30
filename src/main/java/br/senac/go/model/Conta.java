package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data //fazer o get,set,hascode, equals - Lombok
@Entity //ORM controle o estado do objeto
@Table(name = "CONTA")
public class Conta {

    @Id //indica chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) //indica a foma de gerar a chave primária
    private Integer id;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

    @Column(name = "LIMITE_CONTA")
    private BigDecimal limiteConta;

    @ManyToOne(fetch = FetchType.LAZY) // lazy loading, o que significa que os dados associados não são carregados do banco de dados até que sejam explicitamente solicitados
    @JoinColumn(name = "TIPO_CONTA_ID")
    private TipoConta tipoConta;
}
