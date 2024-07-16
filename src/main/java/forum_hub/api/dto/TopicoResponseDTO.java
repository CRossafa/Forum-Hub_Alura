package forum_hub.api.dto;

import forum_hub.api.domain.Topico;

import java.time.LocalDateTime;

public class TopicoResponseDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;
    private String autor;
    private String curso;

    public TopicoResponseDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = topico.getStatus().name();
        this.autor = topico.getAutor().getNome();
        this.curso = String.valueOf(topico.getCurso());
    }
}
