package forum_hub.api.service;

import forum_hub.api.domain.Role;
import forum_hub.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role criarRole(Role role) {
        // Implementar validações se necessário
        return roleRepository.save(role);
    }

    // Outros métodos conforme necessário
}