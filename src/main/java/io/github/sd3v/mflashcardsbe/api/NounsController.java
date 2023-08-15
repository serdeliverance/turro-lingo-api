package io.github.sd3v.mflashcardsbe.api;

import static io.github.sd3v.mflashcardsbe.api.helpers.NounsMapper.toDomain;

import io.github.sd3v.mflashcardsbe.api.dto.CreateNounDto;
import io.github.sd3v.mflashcardsbe.api.dto.NounDto;
import io.github.sd3v.mflashcardsbe.api.exceptions.EntityNotFoundException;
import io.github.sd3v.mflashcardsbe.api.helpers.NounsMapper;
import io.github.sd3v.mflashcardsbe.service.NounService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nouns")
@RequiredArgsConstructor
public class NounsController {

  private final NounService nounService;

  @GetMapping("/{id}")
  public NounDto getById(@PathVariable Long id) {
    return nounService
        .getById(id)
        .map(NounsMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("noun", "id", id.toString()));
  }

  @GetMapping("/byName/{name}")
  public NounDto getByName(@PathVariable String name) {
    // TODO implement
    return null;
  }

  @GetMapping
  public List<NounDto> search(@RequestParam(required = false) String tag) {
    // TODO implement
    return List.of();
  }

  @PostMapping
  public NounDto create(@RequestBody CreateNounDto createNounDto) {
    var createdNoun = nounService.create(toDomain(createNounDto));
    return NounsMapper.toDto(createdNoun);
  }
}
