package softuni.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.users.entities.Album;
import softuni.users.repositories.AlbumRepository;
import softuni.users.services.api.AlbumService;

/**
 * Created by Venelin on 25.7.2017 г..
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void persist(Album album) {
        this.albumRepository.save(album);
    }
}
