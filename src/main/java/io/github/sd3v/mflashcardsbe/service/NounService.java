package io.github.sd3v.mflashcardsbe.service;

import static io.github.sd3v.mflashcardsbe.service.helpers.NounMapper.toDomain;

import io.github.sd3v.mflashcardsbe.domain.CreateNoun;
import io.github.sd3v.mflashcardsbe.domain.Noun;
import io.github.sd3v.mflashcardsbe.repository.NounRepository;
import io.github.sd3v.mflashcardsbe.service.helpers.NounMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NounService {

  private final NounRepository nounRepository;

  public List<Noun> getAll() {
    return nounRepository.findAll().stream().map(NounMapper::toDomain).toList();
  }

  public Optional<Noun> getById(Long id) {
    return nounRepository.findById(id).map(NounMapper::toDomain);
  }

  public Noun create(CreateNoun createNoun) {
    var entity = nounRepository.save(createNoun);
    return toDomain(entity);
  }
}
