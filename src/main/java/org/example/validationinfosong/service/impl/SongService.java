package org.example.validationinfosong.service.impl;

import org.example.validationinfosong.model.Song;
import org.example.validationinfosong.repository.ISongRepository;
import org.example.validationinfosong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }
}
