package forum_hub.api.service;

import forum_hub.api.domain.Topico;
import forum_hub.api.dto.TopicoResponseDTO;
import forum_hub.api.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public List<Topico> listar() {
        return repository.findAll();
    }
    public Page<TopicoResponseDTO> listarPorCurso(String curso, Pageable pageable) {
        return repository.findByCurso(curso, pageable).map(TopicoResponseDTO::new);
    }

    public Topico buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    public Topico criar(Topico topico) {
        return repository.save(topico);
    }

    public Topico atualizar(Long id, Topico dadosAtualizados) {
        Topico topico = buscarPorId(id);
        topico.setTitulo(dadosAtualizados.getTitulo());
        topico.setMensagem(dadosAtualizados.getMensagem());
        return repository.save(topico);
    }

    public void deletar(Long id) {
        Topico topico = buscarPorId(id);
        repository.delete(topico);
    }
}