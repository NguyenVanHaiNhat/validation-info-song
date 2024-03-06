package org.example.validationinfosong.repository;

import org.example.validationinfosong.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface ISongRepository extends CrudRepository<Song, Long> {
}
