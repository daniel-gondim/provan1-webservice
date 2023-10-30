package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TIPO_INVESTIMENTO")
public class TipoInvestimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "TEM_RISCO", nullable = false)
    private boolean temRisco;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

}
