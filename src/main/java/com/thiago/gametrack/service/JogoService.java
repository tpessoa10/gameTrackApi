package com.thiago.gametrack.service;


import com.thiago.gametrack.client.JogoApiClient;
import com.thiago.gametrack.dto.JogoApiResponse;
import com.thiago.gametrack.entity.Jogo;
import com.thiago.gametrack.projection.JogoProjection;
import com.thiago.gametrack.repository.JogoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogoService {

    private final JogoApiClient jogoApiClient;
    private final JogoRepository jogoRepository;

public Page<JogoProjection> buscarTodos(Pageable pageable){
    return jogoRepository.findAllPageable(pageable);
}

    @Transactional
    public void sincronizarJogos(int pagina) {

        List<JogoApiResponse> jogosApi = jogoApiClient.buscarJogos(pagina);

        for (JogoApiResponse jogoApi : jogosApi) {

            String externalId = jogoApi.getId().toString();

            Optional<Jogo> jogoExistente =
                    jogoRepository.findByExternalId(externalId);

            if (jogoExistente.isEmpty()) {

                Jogo jogo = new Jogo();

                jogo.setExternalId(externalId);
                jogo.setNome(jogoApi.getName());
                jogo.setDescricao(jogoApi.getDescription());
                jogo.setCapa(jogoApi.getBackground_image());

                jogoRepository.save(jogo);
            }
        }
    }

    public Jogo buscarPorId(Long id) {
        return jogoRepository.findById(id).orElse(null);
    }
}