package forum_hub.api.service;

import forum_hub.api.domain.Curso;
import forum_hub.api.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public Curso criarCurso(Curso curso) {
        // Implementar validações se necessário
        return cursoRepository.save(curso);
    }

    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        Curso curso = buscarCursoPorId(id);
        curso.setNome(cursoAtualizado.getNome());
        curso.setCategoria(cursoAtualizado.getCategoria());
        return cursoRepository.save(curso);
    }

    public void deletarCurso(Long id) {
        Curso curso = buscarCursoPorId(id);
        cursoRepository.delete(curso);
    }
}