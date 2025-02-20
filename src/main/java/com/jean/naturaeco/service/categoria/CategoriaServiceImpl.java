package com.jean.naturaeco.service.categoria;

import com.jean.naturaeco.dto.request.CategoriaPostRequest;
import com.jean.naturaeco.dto.request.CategoriaPutRequest;
import com.jean.naturaeco.dto.response.CategoriaResponse;
import com.jean.naturaeco.exception.NotFoundException;
import com.jean.naturaeco.exception.ValidationErrorException;
import com.jean.naturaeco.mapper.CategoriaMapper;
import com.jean.naturaeco.repo.CategoriaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    private final CategoriaRepo repo;

    public CategoriaServiceImpl(CategoriaRepo repo) {
        this.repo = repo;
    }


    @Override
    public CategoriaResponse create(CategoriaPostRequest request) {

        var categoria = CategoriaMapper.toCategoria(request);
        checkCategoria(categoria.getNome());
        categoria = repo.save(categoria);

        return CategoriaMapper.toCategoriaResponse(categoria);
    }

    @Override
    public CategoriaResponse update(CategoriaPutRequest request) {
        repo.findById(request.id()).orElseThrow(() -> new NotFoundException("Não enctrado"));
        checkCategoria(request.nome(), request.id());

        var categoria = CategoriaMapper.toCategoria(request);
        categoria = repo.save(categoria);
        return CategoriaMapper.toCategoriaResponse(categoria);
    }

    @Override
    public void delete(Integer idCategoria) {
        var categoria = repo.findById(idCategoria).orElseThrow(() -> new NotFoundException("Não enctrado"));
        repo.delete(categoria);
    }

    @Override
    public List<CategoriaResponse> findAll() {
        var res = repo.findAll();
        return CategoriaMapper.toListCategoriaResponse(res);
    }

    @Override
    public CategoriaResponse findById(Integer idCategoria) {
        var categoria = repo.findById(idCategoria).orElseThrow(() -> new NotFoundException("Não enctrado"));
        return CategoriaMapper.toCategoriaResponse(categoria);
    }

    private void checkCategoria(String name){
        var res = repo.findByNome(name);
        if (res.isPresent()) throw new ValidationErrorException("Nome ja existe");
    }

    private void checkCategoria(String name, Integer idCategoria){
        var res = repo.findByNome(name);
        if (res.isPresent() && !res.get().getId().equals(idCategoria)){
            throw new ValidationErrorException("Nome ja existe");
        }
    }
}
