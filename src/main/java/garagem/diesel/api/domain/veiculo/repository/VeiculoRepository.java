package garagem.diesel.api.domain.veiculo.repository;

import garagem.diesel.api.domain.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
