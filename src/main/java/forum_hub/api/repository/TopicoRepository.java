package forum_hub.api.repository;

import forum_hub.api.domain.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    Page<Topico> findByCurso(String curso, Pageable pageable);

    @Query("SELECT t FROM Topico t WHERE t.autor.id = :autorId")
    List<Topico> findByAutorId(Long autorId);

}


