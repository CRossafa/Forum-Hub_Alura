package forum_hub.api.controller;

import forum_hub.api.domain.Topico;
import forum_hub.api.dto.TopicoDTO;
import forum_hub.api.repository.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> criarTopico(@Valid @RequestBody TopicoDTO topicoDTO) {
        if (topicoRepository.existsByTituloAndMensagem(topicoDTO.getTitulo(), topicoDTO.getMensagem())) {
            return ResponseEntity.badRequest().build();
        }

        Topico topico = new Topico(topicoDTO);
        topicoRepository.save(topico);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalharTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizarTopico(@PathVariable Long id, @Valid @RequestBody TopicoDTO topicoDTO) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();
            topico.setTitulo(topicoDTO.getTitulo());
            topico.setMensagem(topicoDTO.getMensagem());
            topicoRepository.save(topico);
            return ResponseEntity.ok(topico);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}